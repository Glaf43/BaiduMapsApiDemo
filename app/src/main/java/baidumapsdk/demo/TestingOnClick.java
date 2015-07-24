package baidumapsdk.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.SupportMapFragment;
import com.baidu.mapapi.model.LatLng;

import baidumapsdk.demo.R;

public class TestingOnClick extends Activity {
    //private static final String LTAG = MapFragmentDemo.class.getSimpleName();
    SupportMapFragment map;

    private MapView mMapView;
    private BaiduMap mBaiduMap;

    private Marker mMarkerA;
    private Marker mMarkerB;
    private Marker mMarkerC;
    private Marker mMarkerD;

    double latitude;
    double longitude ;
    public Double Lng = null;
    GPSTracker gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_testing_on_click);

            final LatLng point1 = new LatLng(24.45643, 118.086922);
            final LatLng point2 = new LatLng(24.455612, 118.085655);
            final LatLng point3 = new LatLng(24.455739, 118.085516);
            final LatLng point4 = new LatLng(24.458634, 118.088444);

            System.out.println(Double.toString(point1.latitude));
            System.out.println(Double.toString(point1.latitude));

            mMapView = (MapView) findViewById(R.id.bmapView);
            MapStatus ms = new MapStatus.Builder().overlook(-20).zoom(15).build();

            mBaiduMap = mMapView.getMap();

            mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(point1));
            BitmapDescriptor bitmapA = BitmapDescriptorFactory
                    .fromResource(R.drawable.icon_marka);
            BitmapDescriptor bitmapB = BitmapDescriptorFactory
                    .fromResource(R.drawable.icon_markb);
            BitmapDescriptor bitmapC = BitmapDescriptorFactory
                    .fromResource(R.drawable.icon_markc);
            BitmapDescriptor bitmapD = BitmapDescriptorFactory
                    .fromResource(R.drawable.icon_markd);

            OverlayOptions option1 = new MarkerOptions()
                    .position(point1)
                    .icon(bitmapA);
            OverlayOptions option2 = new MarkerOptions()
                    .position(point2)
                    .icon(bitmapB);
            OverlayOptions option3 = new MarkerOptions()
                    .position(point3)
                    .icon(bitmapC);
            OverlayOptions option4 = new MarkerOptions()
                    .position(point4)
                    .icon(bitmapD);
            //在地图上添加Marker，并显示
            mMarkerA = (Marker) (mBaiduMap.addOverlay(option1));
            mMarkerB = (Marker) (mBaiduMap.addOverlay(option2));
            mMarkerC = (Marker) (mBaiduMap.addOverlay(option3));
            mMarkerD = (Marker) (mBaiduMap.addOverlay(option4));

            mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
                public boolean onMarkerClick(final Marker marker) {
                    if (marker == mMarkerA) {
                        Toast.makeText(getApplicationContext(), Double.toString(point1.latitude)+" "+Double.toString(point1.longitude),
                                Toast.LENGTH_LONG).show();
                    } else if (marker == mMarkerB) {
                        Toast.makeText(getApplicationContext(), Double.toString(point2.latitude)+" "+Double.toString(point2.longitude),
                                Toast.LENGTH_LONG).show();
                        System.out.println(point2.latitude);
                        System.out.println(point2.longitude);
                    } else if (marker == mMarkerC) {
                        Toast.makeText(getApplicationContext(), Double.toString(point3.latitude)+" "+Double.toString(point3.longitude),
                                Toast.LENGTH_LONG).show();
                        System.out.println(point3.latitude);
                        System.out.println(point3.longitude);
                    } else {
                        Toast.makeText(getApplicationContext(), Double.toString(point4.latitude)+" "+Double.toString(point4.longitude),
                                Toast.LENGTH_LONG).show();
                        System.out.println(point4.latitude);
                        System.out.println(point4.longitude);
                    }
                    return true;
                }
            });

            //zoom
            MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(18.0f);
            mBaiduMap.setMapStatus(msu);

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_testing_on_click, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
