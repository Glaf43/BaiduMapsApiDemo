package baidumapsdk.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMapOptions;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;

/**
 * 演示MapView的基本用法
 */
public class BaseMapDemo extends Activity {
	@SuppressWarnings("unused")
	private static final String LTAG = BaseMapDemo.class.getSimpleName();
	private MapView mMapView;
	private BaiduMap mBaiduMap;

	private static final LatLng GEO_BEIJING = new LatLng(24.45643, 118.086922);
	private static final LatLng GEO_SHANGHAI = new LatLng(24.455612, 118.085655);
	private static final LatLng GEO_GUANGZHOU = new LatLng(24.455739, 118.085516);
	private static final LatLng GEO_SHENGZHENG = new LatLng(24.458634, 118.088444);



	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Intent intent = getIntent();
		//Bundle b = intent.getExtras();
		LatLng point = new LatLng(24.45643, 118.086922);
		mMapView = new MapView(this,
				new BaiduMapOptions().mapStatus(new MapStatus.Builder()
					.target(point).build()));

		MapStatus ms = new MapStatus.Builder().overlook(-20).zoom(15).build();


		mBaiduMap = mMapView.getMap();
		BitmapDescriptor bitmap = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_marka);

		//构建MarkerOption，用于在地图上添加Marker

		LatLng point2 = new LatLng(24.455612, 118.085655);
		LatLng point3 = new LatLng(24.455739, 118.085516);
		LatLng point4 = new LatLng(24.458634, 118.088444);

		OverlayOptions option = new MarkerOptions()
				.position(point)
				.icon(bitmap);

		OverlayOptions option2 = new MarkerOptions()
				.position(point2)
				.icon(bitmap);
		OverlayOptions option3 = new MarkerOptions()
				.position(point3)
				.icon(bitmap);
		OverlayOptions option4 = new MarkerOptions()
				.position(point4)
				.icon(bitmap);
		//在地图上添加Marker，并显示
		mBaiduMap.addOverlay(option);
		mBaiduMap.addOverlay(option2);
		mBaiduMap.addOverlay(option3);
		mBaiduMap.addOverlay(option4);


		setContentView(mMapView);

	}

	@Override
	protected void onPause() {
		super.onPause();
		// activity 暂停时同时暂停地图控件
		mMapView.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		// activity 恢复时同时恢复地图控件
		mMapView.onResume();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// activity 销毁时同时销毁地图控件
		mMapView.onDestroy();
	}

}
