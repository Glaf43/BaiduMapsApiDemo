package baidumapsdk.demo.sparkDemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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

public class SearchActivity extends Activity {
    //private static final String LTAG = MapFragmentDemo.class.getSimpleName();
    SupportMapFragment map;

    private MapView mMapView;
    private BaiduMap mBaiduMap;

    private Marker mMarkerA;
    private Marker mMarkerB;
    private Marker mMarkerC;
    private Marker mMarkerD;

    private Button button0;
    private Button button5;
    private Button button10;
    private Button button15;


    final LatLng point1 = new LatLng(24.45643, 118.086922);
    final LatLng point2 = new LatLng(24.455612, 118.085655);
    final LatLng point3 = new LatLng(24.455739, 118.085516);
    final LatLng point4 = new LatLng(24.458634, 118.088444);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        button0=(Button) findViewById(R.id.zero);
        button5=(Button) findViewById(R.id.five);
        button10=(Button) findViewById(R.id.ten);
        button15=(Button) findViewById(R.id.fifteen);

        mMapView = (MapView) findViewById(R.id.bmapView);
        MapStatus ms = new MapStatus.Builder().overlook(-20).zoom(15).build();

        mBaiduMap = mMapView.getMap();

        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            public boolean onMarkerClick(final Marker marker) {
                if (marker == mMarkerA) {
                    Toast.makeText(getApplicationContext(), Double.toString(point1.latitude) + "   " + Double.toString(point1.longitude),
                            Toast.LENGTH_LONG).show();
                    enableRewardButton();
                } else if (marker == mMarkerB) {
                    Toast.makeText(getApplicationContext(), Double.toString(point2.latitude) + "   " + Double.toString(point2.longitude),
                            Toast.LENGTH_LONG).show();
                    enableRewardButton();
                } else if (marker == mMarkerC) {
                    Toast.makeText(getApplicationContext(), Double.toString(point3.latitude) + "   " + Double.toString(point3.longitude),
                            Toast.LENGTH_LONG).show();
                    enableRewardButton();
                } else {
                    Toast.makeText(getApplicationContext(), Double.toString(point4.latitude) + "   " + Double.toString(point4.longitude),
                            Toast.LENGTH_LONG).show();
                    enableRewardButton();
                }
                return true;
            }
        });

            //zoom
            MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(18.0f);
            mBaiduMap.setMapStatus(msu);

        }

    public void enableRewardButton(){
        button0.setVisibility(View.VISIBLE);
        button0.setEnabled(true);
        button0.setClickable(true);
        button0.setBackgroundColor(Color.BLACK);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, CommunicationChannelTesting.class);
                startActivity(intent);
            }
        });

        button5.setVisibility(View.VISIBLE);
        button5.setEnabled(true);
        button5.setClickable(true);
        button5.setBackgroundColor(Color.BLACK);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, CommunicationChannelTesting.class);
                startActivity(intent);
            }
        });

        button10.setVisibility(View.VISIBLE);
        button10.setEnabled(true);
        button10.setClickable(true);
        button10.setBackgroundColor(Color.BLACK);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, CommunicationChannelTesting.class);
                startActivity(intent);
            }
        });

        button15.setVisibility(View.VISIBLE);
        button15.setEnabled(true);
        button15.setClickable(true);
        button15.setBackgroundColor(Color.BLACK);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, CommunicationChannelTesting.class);
                startActivity(intent);
            }
        });
    }

    public void unEnableRewardButton(){
        button0.setVisibility(View.INVISIBLE);
        button0.setEnabled(false);
        button0.setClickable(false);


        button5.setVisibility(View.INVISIBLE);
        button5.setEnabled(false);
        button5.setClickable(false);


        button10.setVisibility(View.INVISIBLE);
        button10.setEnabled(false);
        button10.setClickable(false);


        button15.setVisibility(View.INVISIBLE);
        button15.setEnabled(false);
        button15.setClickable(false);

    }

    public void initialMarker(){
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

    public void Cancel(View view){
        mMarkerA.remove();
        mMarkerB.remove();
        mMarkerC.remove();
        mMarkerD.remove();
        //mBaiduMap.set
        unEnableRewardButton();

    }
    public void Search(View view){
        initialMarker();
    }
}
