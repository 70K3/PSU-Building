package com.theproject.a70k3.psupkbuilding.Maps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.theproject.a70k3.psupkbuilding.R;
import com.theproject.a70k3.psupkbuilding.Utils.GPSTracker;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng b1 = new LatLng(7.894793, 98.351971);
    private LatLng b2 = new LatLng(7.893228, 98.352108);
    private LatLng b3 = new LatLng(7.893700, 98.352983);
    private LatLng b4 = new LatLng(7.894094, 98.351933);
    private LatLng b5 = new LatLng(7.894537, 98.353079);

    private LatLng b6 = new LatLng(7.893966, 98.352661);
    private LatLng b7 = new LatLng(7.893228, 98.352108);
    private LatLng b8 = new LatLng(7.893890, 98.353493);
    private LatLng b9 = new LatLng(7.895991, 98.352561);
    private LatLng b10 = new LatLng(7.892377, 98.352016);

    private LatLng b11 = new LatLng(7.892433, 98.352633);
    private LatLng b12 = new LatLng(7.895147, 98.353863);
    private LatLng b13 = new LatLng(7.896766, 98.352745);
    private LatLng b14 = new LatLng(7.895991, 98.352561);
    private LatLng b15 = new LatLng(7.894473, 98.354270);

    private LatLng b16 = new LatLng(7.892846, 98.353797);
    private LatLng b17 = new LatLng(7.892702, 98.354787);
    private LatLng b18 = new LatLng(7.893459, 98.354499);
    private LatLng b19 = new LatLng(7.892340, 98.355286);
    private LatLng b20 = new LatLng(7.891519, 98.350724);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        registerForContextMenu(fab);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu_button, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (mMap != null) {
            mMap.clear();
        }

        switch (item.getItemId()) {
            case R.id.bi1:
                MarkerOptions B1 = new MarkerOptions();
                B1.position(b1).title(getString(R.string.build1)).snippet(getString(R.string.dbuild1));
                B1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                mMap.addMarker(B1).showInfoWindow();

                return true;
            case R.id.bi2:
                MarkerOptions B2 = new MarkerOptions();
                B2.position(b2).title(getString(R.string.build6)).snippet(getString(R.string.dbuild6));
                B2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                mMap.addMarker(B2).showInfoWindow();
                return true;
            case R.id.bi3:
                MarkerOptions B3 = new MarkerOptions();
                B3.position(b3).title(getString(R.string.build3)).snippet(getString(R.string.dbuild3));
                B3.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                mMap.addMarker(B3).showInfoWindow();
                return true;
            case R.id.bi4:
                MarkerOptions B4 = new MarkerOptions();
                B4.position(b4).title(getString(R.string.build2)).snippet(getString(R.string.dbuild2));
                B4.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                mMap.addMarker(B4).showInfoWindow();
                return true;
            case R.id.bi5:
                MarkerOptions B5 = new MarkerOptions();
                B5.position(b5).title(getString(R.string.build7)).snippet(getString(R.string.dbuild7));
                B5.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                mMap.addMarker(B5).showInfoWindow();
                return true;
            case R.id.bi6:
                MarkerOptions B6 = new MarkerOptions();
                B6.position(b6).title(getString(R.string.build3)).snippet(getString(R.string.dbuild31));
                B6.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                mMap.addMarker(B6).showInfoWindow();
                return true;
            case R.id.bi7:
                MarkerOptions B7 = new MarkerOptions();
                B7.position(b7).title(getString(R.string.build6)).snippet(getString(R.string.dbuild61));
                B7.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                mMap.addMarker(B7).showInfoWindow();
                return true;
            case R.id.bi8:
                MarkerOptions B8 = new MarkerOptions();
                B8.position(b8).title(getString(R.string.build5)).snippet(getString(R.string.dbuild51));
                B8.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                mMap.addMarker(B8).showInfoWindow();
                return true;
            case R.id.bi9:
                MarkerOptions B9 = new MarkerOptions();
                B9.position(b9).title(getString(R.string.build5)).snippet(getString(R.string.dbuild5));
                B9.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                mMap.addMarker(B9).showInfoWindow();
                return true;
            case R.id.bi10:
                MarkerOptions B10 = new MarkerOptions();
                B10.position(b10).title(getString(R.string.build8)).snippet(getString(R.string.dbuild8));
                B10.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                mMap.addMarker(B10).showInfoWindow();
                return true;
            case R.id.bi11:
                MarkerOptions B11 = new MarkerOptions();
                B11.position(b11).title(getString(R.string.build9)).snippet(getString(R.string.dbuild9));
                B11.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                mMap.addMarker(B11).showInfoWindow();
                return true;
            case R.id.bi12:
                MarkerOptions B12 = new MarkerOptions();
                B12.position(b12).title(getString(R.string.build10)).snippet(getString(R.string.dbuild10));
                B12.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                mMap.addMarker(B12).showInfoWindow();
                return true;
            case R.id.bi13:
                MarkerOptions B13 = new MarkerOptions();
                B13.position(b13).title(getString(R.string.build11)).snippet(getString(R.string.dbuild11));
                B13.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                mMap.addMarker(B13).showInfoWindow();
                return true;
            case R.id.bi14:
                MarkerOptions B14 = new MarkerOptions();
                B14.position(b14).title(getString(R.string.build12));
                B14.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                mMap.addMarker(B14).showInfoWindow();
                return true;
            case R.id.bi15:
                MarkerOptions B15 = new MarkerOptions();
                B15.position(b15).title(getString(R.string.build13));
                B15.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                mMap.addMarker(B15).showInfoWindow();
                return true;
            case R.id.bi16:
                MarkerOptions B16 = new MarkerOptions();
                B16.position(b16).title(getString(R.string.build14));
                B16.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                mMap.addMarker(B16).showInfoWindow();
                return true;
            case R.id.bi17:
                MarkerOptions B17 = new MarkerOptions();
                B17.position(b17).title(getString(R.string.build15)).snippet(getString(R.string.dbuild15));
                B17.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                mMap.addMarker(B17).showInfoWindow();
                return true;
            case R.id.bi18:
                MarkerOptions B18 = new MarkerOptions();
                B18.position(b18).title(getString(R.string.build15)).snippet(getString(R.string.dbuild151));
                B18.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                mMap.addMarker(B18).showInfoWindow();
                return true;
            case R.id.bi19:
                MarkerOptions B19 = new MarkerOptions();
                B19.position(b19).title(getString(R.string.build15)).snippet(getString(R.string.dbuild152));
                B19.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                mMap.addMarker(B19).showInfoWindow();
                return true;
            case R.id.bi20:
                MarkerOptions B20 = new MarkerOptions();
                B20.position(b20).title(getString(R.string.build16));
                B20.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                mMap.addMarker(B20).showInfoWindow();
                return true;

            default:
                return super.onContextItemSelected(item);
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

//        GPSTracker mHere = new GPSTracker(MapsActivity.this); //request gps
//        LatLng m = new LatLng(mHere.getsLatitude(), mHere.getsLongitude());
//        //Position Current
//        MarkerOptions M = new MarkerOptions();
//        M.position(m).title("ตำแหน่งของคุณ");
//        M.icon(BitmapDescriptorFactory.fromResource(R.drawable.cr_ic));
//        mMap.addMarker(M);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(b3, 10));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo((float) 16.25), 2000, null);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        googleMap.setMyLocationEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setScrollGesturesEnabled(false);
        googleMap.getUiSettings().setZoomGesturesEnabled(false);
        googleMap.getUiSettings().setCompassEnabled(true);


    }
}
