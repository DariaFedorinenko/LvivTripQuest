package com.example.android.ltq;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;

import java.io.IOException;
import java.util.List;

import com.google.android.gms.maps.UiSettings;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import android.graphics.Color;

import static com.google.android.gms.maps.model.JointType.BEVEL;

import android.content.Context;

public class QuestScreen extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener {

    private BottomSheetBehavior mBottomSheetBehavior1;
    private GoogleMap mMap;
    private LocationManager locationManager;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private boolean mPermissionDenied = false;
    private boolean CameraOnMyPosition = true;
    private LatLngBounds.Builder builder = new LatLngBounds.Builder();
    private LatLng latLng;

    private static final LatLng point1 = new LatLng(49.84392, 24.02659);
    private static final LatLng point2 = new LatLng(49.8431, 24.03162);
    private static final LatLng point3 = new LatLng(49.84295, 24.03192);
    private static final LatLng point4 = new LatLng(49.8417, 24.03275);
    private static final LatLng point5 = new LatLng(49.841123, 24.033096);
    private static final LatLng point6 = new LatLng(49.84097, 24.03318);
    private static final LatLng point7 = new LatLng(49.84095, 24.03453);
    private static final LatLng point8 = new LatLng(49.84113, 24.03451);
    private static final LatLng point9 = new LatLng(49.84152, 24.03523);
    private static final LatLng point10 = new LatLng(49.84129, 24.03227);
    private static final LatLng point11 = new LatLng(49.83994, 24.0294);
    private static final LatLng point12 = new LatLng(49.840585, 24.025972);
    private static final LatLng point13 = new LatLng(49.83918, 24.02515);
    private Marker marker1;
    private Marker marker2;
    private Marker marker3;
    private Marker marker4;
    private Marker marker5;
    private Marker marker6;
    private Marker marker7;
    private Marker marker8;
    private Marker marker9;
    private Marker marker10;
    private Marker marker11;
    private Marker marker12;
    private Marker marker13;

    private static final LatLng line1ToMarker2 = new LatLng(49.843791, 24.026820);
    private static final LatLng line2ToMarker2 = new LatLng(49.843828, 24.028347);
    private static final LatLng line3ToMarker2 = new LatLng(49.842950, 24.028705);
    private static final LatLng line4ToMarker2 = new LatLng(49.843149, 24.031523);
    private static final LatLng line1ToMarker3 = new LatLng(49.843166, 24.031690);
    private static final LatLng line2ToMarker3 = new LatLng(49.843199, 24.032020);
    private static final LatLng line3ToMarker3 = new LatLng(49.843054, 24.032079);
    private static final LatLng line1ToMarker4 = new LatLng(49.842937, 24.032126);
    private static final LatLng line2ToMarker4 = new LatLng(49.842491, 24.032265);
    private static final LatLng line3ToMarker4 = new LatLng(49.841746, 24.032627);
    private static final LatLng line1ToMarker5 = new LatLng(49.841140, 24.033022);
    private static final LatLng line1ToMarker6 = new LatLng(49.841094, 24.033048);
    private static final LatLng line2ToMarker6 = new LatLng(49.840989, 24.033104);
    private static final LatLng line1ToMarker7 = new LatLng(49.840941, 24.033128);
    private static final LatLng line2ToMarker7 = new LatLng(49.840770, 24.033220);
    private static final LatLng line3ToMarker7 = new LatLng(49.841035, 24.034407);
    private static final LatLng line1ToMarker9 = new LatLng(49.841101, 24.034635);
    private static final LatLng line2ToMarker9 = new LatLng(49.841229, 24.035122);
    private static final LatLng line3ToMarker9 = new LatLng(49.841559, 24.034921);
    private static final LatLng line4ToMarker9 = new LatLng(49.841579, 24.035101);
    private static final LatLng line1ToMarker10 = new LatLng(49.841979, 24.035057);
    private static final LatLng line2ToMarker10 = new LatLng(49.841460, 24.032308);
    private static final LatLng line1ToMarker11 = new LatLng(49.841411, 24.032025);
    private static final LatLng line2ToMarker11 = new LatLng(49.840889, 24.029860);
    private static final LatLng line3ToMarker11 = new LatLng(49.840063, 24.030180);
    private static final LatLng line4ToMarker11 = new LatLng(49.839807, 24.030012);
    private static final LatLng line5ToMarker11 = new LatLng(49.839765, 24.029501);
    private static final LatLng line1ToMarker12 = new LatLng(49.840662, 24.028726);
    private static final LatLng line2ToMarker12 = new LatLng(49.840444, 24.027704);
    private static final LatLng line3ToMarker12 = new LatLng(49.840040, 24.026830);
    private static final LatLng line4ToMarker12 = new LatLng(49.840576, 24.026121);
    private static final LatLng line1ToMarker13 = new LatLng(49.839197, 24.025300);
    private static final LatLng secretPlace1 = new LatLng(49.844136, 24.024739);
    private static final LatLng secretPlace2 = new LatLng(49.839874, 24.037288);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quest_screen);
        final View bottomSheet1 = findViewById(R.id.bottom_sheet1);
        mBottomSheetBehavior1 = BottomSheetBehavior.from(bottomSheet1);
        mBottomSheetBehavior1.setHideable(true);
        mBottomSheetBehavior1.setPeekHeight(300);
        mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_HIDDEN);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        return;
        }
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    latLng = new LatLng(latitude, longitude);
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                        String str = addressList.get(0).getLocality() + ",";
                        str += addressList.get(0).getCountryName();
                        IncludeMarkersToCamera(builder);
                        LatLngBounds bounds = builder.build();
                        int width = getResources().getDisplayMetrics().widthPixels;
                        int height = getResources().getDisplayMetrics().heightPixels;
                        int padding = (int) (width * 0.10);
                        if (CameraOnMyPosition) {
                            mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding));
                            CameraOnMyPosition = false;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }
            });
        } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    LatLng latLng = new LatLng(latitude, longitude);
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                        String str = addressList.get(0).getLocality() + ",";
                        str += addressList.get(0).getCountryName();
                        IncludeMarkersToCamera(builder);
                        LatLngBounds bounds = builder.build();
                        int width = getResources().getDisplayMetrics().widthPixels;
                        int height = getResources().getDisplayMetrics().heightPixels;
                        int padding = (int) (width * 0.10);
                        if (CameraOnMyPosition) {
                            mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding));
                            CameraOnMyPosition = false;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }
            });
            return;
        }
    }



    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;
        try {
            boolean success = map.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.silver_style_maps));
        } catch (Resources.NotFoundException e) {
        }
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);
        UiSettings uiSettings = map.getUiSettings();
        uiSettings.setMapToolbarEnabled(false);
        drawMarkers();
        drawLines();

    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError();
            mPermissionDenied = false;
        }
    }

    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
    }

    public void drawMarkers() {

        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.marker, null);
        View test = inflater.inflate(R.layout.secret_marker, null);
        TextView numberOfPoint = (TextView) v.findViewById(R.id.number_text_view);
        TextView distanceBetweenPoint = (TextView) v.findViewById(R.id.text_text_view);


        mMap.addGroundOverlay(new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromBitmap(getBitmapFromView(test)))
                .position(secretPlace1, 340f, 340f));

        mMap.addGroundOverlay(new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromBitmap(getBitmapFromView(test)))
                .position(secretPlace2, 340f, 340f));

        marker1 = mMap.addMarker(new MarkerOptions()
                .position(point1)
                .anchor(0.5f, 0.5f)
                .title("point1")
                .icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromView(v))));
        numberOfPoint.setText("" + 2);
        distanceBetweenPoint.setText("445m");
        marker2 = mMap.addMarker(new MarkerOptions()
                .position(point2)
                .anchor(0.5f, 0.5f)
                .title("point2")
                .icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromView(v))));
        numberOfPoint.setText("" + 3);
        distanceBetweenPoint.setText("55m");
        marker3 = mMap.addMarker(new MarkerOptions()
                .position(point3)
                .anchor(0.5f, 0.5f)
                .title("point3")
                .icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromView(v))));
        numberOfPoint.setText("" + 4);
        distanceBetweenPoint.setText("150m");
        marker4 = mMap.addMarker(new MarkerOptions()
                .position(point4)
                .anchor(0.5f, 0.5f)
                .title("point4")
                .icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromView(v))));
        numberOfPoint.setText("" + 5);
        distanceBetweenPoint.setText("80m");
        marker5 = mMap.addMarker(new MarkerOptions()
                .position(point5)
                .anchor(0.5f, 0.5f)
                .title("point5")
                .icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromView(v))));
        numberOfPoint.setText("" + 6);
        distanceBetweenPoint.setText("20m");
        marker6 = mMap.addMarker(new MarkerOptions()
                .position(point6)
                .anchor(0.5f, 0.5f)
                .title("point6")
                .icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromView(v))));
        numberOfPoint.setText("" + 7);
        distanceBetweenPoint.setText("120m");
        marker7 = mMap.addMarker(new MarkerOptions()
                .position(point7)
                .anchor(0.5f, 0.5f)
                .title("point7")
                .icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromView(v))));
        numberOfPoint.setText("" + 8);
        distanceBetweenPoint.setText("5m");
        marker8 = mMap.addMarker(new MarkerOptions()
                .position(point8)
                .anchor(0.5f, 0.5f)
                .title("point8")
                .icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromView(v))));
        numberOfPoint.setText("" + 9);
        distanceBetweenPoint.setText("90m");
        marker9 = mMap.addMarker(new MarkerOptions()
                .position(point9)
                .anchor(0.5f, 0.5f)
                .title("point9")
                .icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromView(v))));
        numberOfPoint.setText("" + 10);
        distanceBetweenPoint.setText("290m");
        marker10 = mMap.addMarker(new MarkerOptions()
                .position(point10)
                .anchor(0.5f, 0.5f)
                .title("point10")
                .icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromView(v))));
        numberOfPoint.setText("" + 11);
        distanceBetweenPoint.setText("425m");
        marker11 = mMap.addMarker(new MarkerOptions()
                .position(point11)
                .anchor(0.5f, 0.5f)
                .title("point11")
                .icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromView(v))));
        numberOfPoint.setText("" + 12);
        distanceBetweenPoint.setText("320m");
        marker12 = mMap.addMarker(new MarkerOptions()
                .position(point12)
                .anchor(0.5f, 0.5f)
                .title("point12")
                .icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromView(v))));
        numberOfPoint.setText("" + 13);
        distanceBetweenPoint.setText("220m");
        marker13 = mMap.addMarker(new MarkerOptions()
                .position(point13)
                .anchor(0.5f, 0.5f)
                .title("point13")
                .icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromView(v))));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker marker) {

                final View bottomSheet1 = findViewById(R.id.bottom_sheet1);
                mBottomSheetBehavior1 = BottomSheetBehavior.from(bottomSheet1);
                mBottomSheetBehavior1.setHideable(true);
                mBottomSheetBehavior1.setPeekHeight(384);
                mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_HIDDEN);



                String title = marker.getTitle();
                if ("point1".equals(title)) {
                    if(mBottomSheetBehavior1.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                        mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_HIDDEN);

                    }
                    else if(mBottomSheetBehavior1.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                        mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_EXPANDED);

                    }
                    else if(mBottomSheetBehavior1.getState() == BottomSheetBehavior.STATE_HIDDEN) {
                        mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    }
                } else if ("point2".equals(title)) {
                    startActivity(new Intent(QuestScreen.this, Balance.class));
                } else if("point3".equals(title)){
                    // do thing for nearby places
                } else if ("point4".equals(title)) {
                    // do thing for events
                } else if("point5".equals(title)){
                    // do thing for nearby places
                }else if ("point6".equals(title)) {
                    // do thing for events
                } else if("point7".equals(title)){
                    // do thing for nearby places
                }else if ("point8".equals(title)) {
                    // do thing for events
                } else if("point9".equals(title)){
                    // do thing for nearby places
                }else if ("point10".equals(title)) {
                    // do thing for events
                } else if("point11".equals(title)){
                    // do thing for nearby places
                }else if ("point13".equals(title)) {
                    // do thing for events
                } else {
                    return false;
                }
                return false;
            }
        });
    }

    public static Bitmap getBitmapFromView(View view) {
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.draw(canvas);
        return bitmap;
    }

    public void drawLines() {
        Polyline toMarker2 = mMap.addPolyline(new PolylineOptions()
                .add(point1, line1ToMarker2, line2ToMarker2, line3ToMarker2, line4ToMarker2, point2)
                .width(11)
                .jointType(BEVEL)
                .color(Color.rgb(145, 121, 241)));
        Polyline toMarker3 = mMap.addPolyline(new PolylineOptions()
                .add(point2, line1ToMarker3, line2ToMarker3, line3ToMarker3, point3)
                .width(11)
                .jointType(BEVEL)
                .color(Color.rgb(145, 121, 241)));
        Polyline toMarker4 = mMap.addPolyline(new PolylineOptions()
                .add(point3, line1ToMarker4, line2ToMarker4, line3ToMarker4, point4)
                .width(11)
                .jointType(BEVEL)
                .color(Color.rgb(145, 121, 241)));
        Polyline toMarker5 = mMap.addPolyline(new PolylineOptions()
                .add(point4, line1ToMarker5, point5)
                .width(11)
                .jointType(BEVEL)
                .color(Color.rgb(145, 121, 241)));
        Polyline toMarker6 = mMap.addPolyline(new PolylineOptions()
                .add(point5, line1ToMarker6, line2ToMarker6, point6)
                .width(11)
                .jointType(BEVEL)
                .color(Color.rgb(145, 121, 241)));
        Polyline toMarker7 = mMap.addPolyline(new PolylineOptions()
                .add(point6, line1ToMarker7, line2ToMarker7, line3ToMarker7, point7)
                .width(11)
                .jointType(BEVEL)
                .color(Color.rgb(145, 121, 241)));
        Polyline toMarker8 = mMap.addPolyline(new PolylineOptions()
                .add(point7, point8)
                .width(11)
                .jointType(BEVEL)
                .color(Color.rgb(145, 121, 241)));
        Polyline toMarker9 = mMap.addPolyline(new PolylineOptions()
                .add(point8, line1ToMarker9, line2ToMarker9, line3ToMarker9, line4ToMarker9, point9)
                .width(11)
                .jointType(BEVEL)
                .color(Color.rgb(145, 121, 241)));
        Polyline toMarker10 = mMap.addPolyline(new PolylineOptions()
                .add(point9, line1ToMarker10, line2ToMarker10, point10)
                .width(11)
                .jointType(BEVEL)
                .color(Color.rgb(145, 121, 241)));
        Polyline toMarker11 = mMap.addPolyline(new PolylineOptions()
                .add(point10, line1ToMarker11, line2ToMarker11, line3ToMarker11, line4ToMarker11, line5ToMarker11, point11)
                .width(11)
                .jointType(BEVEL)
                .color(Color.rgb(145, 121, 241)));
        Polyline toMarker12 = mMap.addPolyline(new PolylineOptions()
                .add(point11, line1ToMarker12, line2ToMarker12, line3ToMarker12, line4ToMarker12, point12)
                .width(11)
                .jointType(BEVEL)
                .color(Color.rgb(145, 121, 241)));
        Polyline toMarker13 = mMap.addPolyline(new PolylineOptions()
                .add(line3ToMarker12, line1ToMarker13, point13)
                .width(11)
                .jointType(BEVEL)
                .color(Color.rgb(145, 121, 241)));
    }

    public LatLngBounds.Builder IncludeMarkersToCamera(LatLngBounds.Builder builder)
    {
        builder.include(marker1.getPosition());
        builder.include(marker2.getPosition());
        builder.include(marker3.getPosition());
        builder.include(marker4.getPosition());
        builder.include(marker5.getPosition());
        builder.include(marker6.getPosition());
        builder.include(marker7.getPosition());
        builder.include(marker8.getPosition());
        builder.include(marker9.getPosition());
        builder.include(marker10.getPosition());
        builder.include(marker11.getPosition());
        builder.include(marker12.getPosition());
        builder.include(marker13.getPosition());
        builder.include(latLng);

        return builder;
    }

}