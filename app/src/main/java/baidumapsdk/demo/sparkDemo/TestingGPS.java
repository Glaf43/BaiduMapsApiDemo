package baidumapsdk.demo.sparkDemo;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.SupportMapFragment;
import com.baidu.mapapi.model.LatLng;

import baidumapsdk.demo.GPSTracker;
import baidumapsdk.demo.R;

public class TestingGPS extends Activity {
    //private static final String LTAG = MapFragmentDemo.class.getSimpleName();
    SupportMapFragment map;

    private MapView mMapView;
    private BaiduMap mBaiduMap;

    double latitude;
    double longitude ;
    public Double Lng = null;
    GPSTracker gps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        //39.035689, -94.588440

        //-Log.d("myTag", "TestingGPS");

        LatLng point = new LatLng(39.035689, -94.588440);

          //GPS TestingGPS
        gps = new GPSTracker(TestingGPS.this);
        if(gps.canGetLocation()) {
             latitude = gps.getLatitude();
             longitude = gps.getLongitude();
            Toast.makeText(getApplicationContext(), Double.toString(point.latitude)+"     "+Double.toString(point.longitude),
                    Toast.LENGTH_LONG).show();
        }
        else{
            Log.d("myTag", "This is my message");;
        }

        System.out.println(Double.toString(point.latitude));
        System.out.println(Double.toString(point.longitude));

        System.out.println("TestingGPS");


        mMapView = (MapView) findViewById(R.id.bmapView);
        MapStatus ms = new MapStatus.Builder().overlook(-20).zoom(15).build();

        mBaiduMap = mMapView.getMap();

        mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(point));

        //zoom
        MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(15.0f);
        mBaiduMap.setMapStatus(msu);

    }

    private void perfomZoom() {
        EditText t = (EditText) findViewById(R.id.zoomlevel);
        try {
            float zoomLevel = Float.parseFloat(t.getText().toString());
            MapStatusUpdate u = MapStatusUpdateFactory.zoomTo(zoomLevel);
            mBaiduMap.animateMapStatus(u);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "??????????", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
