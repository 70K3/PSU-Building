package com.theproject.a70k3.psupkbuilding.Events;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.theproject.a70k3.psupkbuilding.Events.state.BundleSavedState;
import com.theproject.a70k3.psupkbuilding.R;


public class PhotoListView extends BaseCustomViewGroup {

    TextView tvName;
    TextView tvTime;
    TextView tvPlace;
    ImageView ivImg;

    public PhotoListView(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public PhotoListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public PhotoListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public PhotoListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.list_view_photo, this);
    }

    private void initInstances() {
        tvName = findViewById(R.id.tvName);
        tvTime = findViewById(R.id.tvTime);
        tvPlace = findViewById(R.id.tvPlace);
        ivImg = findViewById(R.id.ivImg);
    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        /*TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.StyleableName,
                defStyleAttr, defStyleRes);
        try {
        } finally {
            a.recycle();
        }*/
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();
        // Restore State from bundle here
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = width*2/3;
        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
                height
                ,MeasureSpec.EXACTLY
        );
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
        setMeasuredDimension(width,height);
    }

    public void setTvName (String text){
        tvName.setText(text);
    }
    public  void setTvTime (String text){
        tvTime.setText(text);
    }
    public void setTvPlace (String text){
        tvPlace.setText(text);
    }
    public void setIvImg (String url){
        Glide.with(getContext())
                .load("http://student.coe.phuket.psu.ac.th/~s5535512074/TheEvent/Picture/"+url)
                .into(ivImg);
    }
}
