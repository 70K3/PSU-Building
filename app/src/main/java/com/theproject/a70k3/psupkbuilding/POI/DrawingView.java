package com.theproject.a70k3.psupkbuilding.POI;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.theproject.a70k3.psupkbuilding.R;
import com.theproject.a70k3.psupkbuilding.Utils.DpiUtils;
import com.theproject.a70k3.psupkbuilding.Utils.GPSTracker;
import com.theproject.a70k3.psupkbuilding.Utils.MathUtils;
import com.theproject.a70k3.psupkbuilding.Utils.Point;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class DrawingView extends View {

   //Get user's current location
//   GPSTracker gps = new GPSTracker((Activity)getContext());
//   Point me = new Point(gps.getsLatitude(), gps.getsLongitude(), "Me");

    GPSTracker gps;
    Point me;

    Paint mPaint = new Paint();
    Paint mMeter = new Paint();
    Paint mFar = new Paint();
    Paint mMeter2 = new Paint();
    Paint mMed = new Paint();
    Paint mMeter3 = new Paint();

    private double OFFSET = 0d;
    private double screenWidth, screenHeight = 0d;
    private Bitmap[] mSpots, mSpots2 , mSpots3 ,mBlips;
    private Bitmap mRadar;

    //Set position building location
    public static ArrayList<Point> props = new ArrayList<Point>();
    static {
        props.add(new Point(7.895991, 98.352561,"สนามฟุตบอล"));
        props.add(new Point(7.896766, 98.352745,"Sports Complex"));
        props.add(new Point(7.895147, 98.353863,"โรงยิม"));
        props.add(new Point(7.894473, 98.354270,"สนามเทนนิส"));

        props.add(new Point(7.894793, 98.351971,"คณะเทคโนโลยีและสิ่งแวดล้อม")); //4
        props.add(new Point(7.894537, 98.353079,"สำนักงานอธิการบดี(อาคาร7)"));
        props.add(new Point(7.893890, 98.353493,"อาคารวิทยบริการ(อาคาร5)"));
        props.add(new Point(7.892846, 98.353797,"ลานกีฬาอเนกประสงค์"));

        props.add(new Point(7.894094, 98.351933,"คณะการบริการและการท่องเที่ยว")); //8
        props.add(new Point(7.893700, 98.352983,"คณะวิเทศศึกษา")); //9
        props.add(new Point(7.893966, 98.352661,"ห้องประชุมอนุภาษฯ"));
        props.add(new Point(7.893615, 98.353479,"ห้องสมุด"));

        props.add(new Point(7.892433, 98.352633,"แคนทีมใหม่"));
        props.add(new Point(7.893228, 98.352108, "อาคารเรียนรวม(อาคาร6)")); //13
		props.add(new Point(7.892377, 98.352016,"แคนทีน"));
        props.add(new Point(7.893768, 98.351760,"PSU Lodge"));

        props.add(new Point(7.893459, 98.354499,"หอพักในกำกับ 1-2"));
        props.add(new Point(7.892702, 98.354787,"หอพักนักศึกษาชาย"));
        props.add(new Point(7.892340, 98.355286,"หอพักในกำกับ 3"));
        props.add(new Point(7.891519, 98.350724,"หอพักบุคคลากร"));

    }

    public DrawingView(final Context context, AttributeSet set ) {
        super(context, set);

        mPaint.setColor(Color.BLACK);   //set text name
        mPaint.setTextSize(50);
        mPaint.setStrokeWidth(DpiUtils.getPxFromDpi(getContext(), 3));
        mPaint.setAntiAlias(true);

        mMeter.setColor(Color.BLUE);     //set text distance
        mMeter.setTextSize(40);
        mMeter.setStrokeWidth(DpiUtils.getPxFromDpi(getContext(), 10));
        mMeter.setAntiAlias(true);

        mMed.setColor(Color.BLACK); //set text medium name
        mMed.setTextSize(40);
        mMed.setStrokeWidth(DpiUtils.getPxFromDpi(getContext(),3));
        mMed.setAntiAlias(true);

        mMeter3.setColor(Color.BLUE); //set text medium distance
        mMeter3.setTextSize(30);
        mMeter3.setStrokeWidth(DpiUtils.getPxFromDpi(getContext(),10));
        mMeter3.setAntiAlias(true);

        mFar.setColor(Color.BLACK); //set text mini name
        mFar.setTextSize(30);
        mFar.setStrokeWidth(DpiUtils.getPxFromDpi(getContext(),3));
        mFar.setAntiAlias(true);

        mMeter2.setColor(Color.BLUE); //set text mini distance
        mMeter2.setTextSize(20);
        mMeter2.setStrokeWidth(DpiUtils.getPxFromDpi(getContext(),10));
        mMeter2.setAntiAlias(true);

        mRadar = BitmapFactory.decodeResource(context.getResources(), R.drawable.radar_pb_mn);

        mSpots = new Bitmap[props.size()]; // box normal
        mSpots3 = new Bitmap[props.size()]; // box medium
        mSpots2 = new Bitmap[props.size()]; // box mini
        for (int i = 0; i < mSpots.length; i++) {
            mSpots[i] = BitmapFactory.decodeResource(context.getResources(), R.drawable.rec_bb);
            mSpots3[i] = BitmapFactory.decodeResource(context.getResources(),R.drawable.rec_bm);
            mSpots2[i] = BitmapFactory.decodeResource(context.getResources(),R.drawable.rec_bs);
        }

        mBlips = new Bitmap[props.size()]; //dot on radar
        for (int i = 0; i < mBlips.length; i++)
            mBlips[i] = BitmapFactory.decodeResource(context.getResources(), R.drawable.blip_8);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenWidth = (double) w;
        screenHeight = (double) h;
    }

    @Override
    protected void onDraw(final Canvas canvas ) {

            gps = new GPSTracker(getContext());
            me = new Point(gps.getsLatitude(), gps.getsLongitude(), "Me");

            canvas.drawBitmap(mRadar, 0, 0, mPaint);
            int radarCentreX = mRadar.getWidth() / 2;
            int radarCentreY = mRadar.getHeight() / 2;

            for (int i = 0; i < mBlips.length; i++) {
                Bitmap blip = mBlips[i];
                Bitmap spot = mSpots[i];
                Bitmap spot2 = mSpots2[i];
                Bitmap spot3 = mSpots3[i];

                Point u = props.get(i);
                double dist = MathUtils.distInMetres(me, u);
                double xDist = dist;
                DecimalFormat df = new DecimalFormat();
                df.applyPattern("0.00");

                if (blip == null || spot == null)
                    continue;
                if (dist > 90)
                    dist = 90; //we have set points very far away for demonstration

                double angle = MathUtils.bearing(me.latitude, me.longitude, u.latitude, u.longitude) - OFFSET;
                double xPos, yPos;

                if (angle < 0)
                    angle = (angle + 360) % 360;

                xPos = Math.sin(Math.toRadians(angle)) * dist;
                yPos = Math.sqrt(Math.pow(dist, 2) - Math.pow(xPos, 2));

                if (angle > 90 && angle < 270)
                    yPos *= -1;

                double posInPx = angle * (screenWidth / 90d);
                int blipCentreX = blip.getWidth() / 2;
                int blipCentreY = blip.getHeight() / 2;
                xPos = xPos - blipCentreX;
                yPos = yPos + blipCentreY;

                if (xDist < 70 && xDist >= 20) {
                    canvas.drawBitmap(blip, (radarCentreX + (int) xPos),
                            (radarCentreY - (int) yPos), mPaint); //radar blip
                }

                int spotCentreX = spot.getWidth() / 2;
                int spotCentreY = spot.getHeight() / 2;
                xPos = posInPx - spotCentreX;

                if (angle <= 45)
                    u.x = (float) ((screenWidth / 2) + xPos);
                else if (angle >= 315)
                    u.x = (float) ((screenWidth / 2) - ((screenWidth * 4) - xPos));
                else
                    u.x = (float) (float) (screenWidth * 9); //somewhere off the screen

                u.y = (float) screenHeight / 2 + spotCentreY;

                if (xDist >= 20 && xDist <= 30)
                    u.y += 100;
                else if (xDist >= 31 && xDist <= 41)
                    u.y += 0;
                else if(xDist >= 42 && xDist <= 62)
                    u.y -= 300;
                else if (xDist >= 63 && xDist <= 73)
                    u.y -= 400;
                else if (xDist >= 74 && xDist < 100)
                    u.y -= 500;


                if (xDist <= 41 && xDist >= 20) { //mini
                    canvas.drawBitmap(spot, u.x - 20, u.y, mPaint); //box
                    canvas.drawText(u.description, u.x , u.y + 135, mPaint); //text
                    canvas.drawText(df.format(xDist) + " เมตร", u.x +60, u.y + 65, mMeter); //distance
                }
                else if (xDist <= 73 && xDist >= 42) { //medium
                    canvas.drawBitmap(spot3, u.x - 20, u.y, mPaint); //box
                    canvas.drawText(u.description, u.x, u.y + 120, mMed); //text
                    canvas.drawText(df.format(xDist) + " เมตร", u.x+65, u.y + 55, mMeter3); //distance
                }
                else if (xDist <= 100 && xDist >= 74) { //big
                    canvas.drawBitmap(spot2, u.x - 20, u.y, mPaint); //box
                    canvas.drawText(u.description, u.x, u.y + 95, mFar); //text
                    canvas.drawText(df.format(xDist) + " เมตร", u.x+50, u.y + 45, mMeter2); //distance
                }

            }
    }

    public void setOffset(float offset) {
        this.OFFSET = offset;
    }


}
