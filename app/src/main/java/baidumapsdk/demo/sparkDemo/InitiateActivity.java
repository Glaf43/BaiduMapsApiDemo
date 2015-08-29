package baidumapsdk.demo.sparkDemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapView;

import baidumapsdk.demo.R;

public class InitiateActivity extends Activity {

    private MapView mMapView;
    private BaiduMap mBaiduMap;

    private Button searchParkingLot;
    private Button shareParkingLot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initiate);

        mMapView = (MapView) findViewById(R.id.bmapView);
        MapStatus ms = new MapStatus.Builder().overlook(-20).zoom(15).build();

        mBaiduMap = mMapView.getMap();

        searchParkingLot= (Button)findViewById(R.id.searchParkingLot);
        shareParkingLot=(Button)findViewById(R.id.shareParkingLot);

        searchParkingLot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(InitiateActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        shareParkingLot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(InitiateActivity.this, ShareActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_initiate, menu);
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
