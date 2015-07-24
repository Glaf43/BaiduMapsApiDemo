package baidumapsdk.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMapOptions;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;

/**
 * 演示MapView的基本用法
 */
public class BaseMapDemo extends Activity {
	//@SuppressWarnings("unused")
	//private static final String LTAG = BaseMapDemo.class.getSimpleName();
	private MapView mMapView;
	private BaiduMap mBaiduMap;

	private Marker mMarkerA;
	private Marker mMarkerB;
	private Marker mMarkerC;
	private Marker mMarkerD;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Intent intent = getIntent();
		//Bundle b = intent.getExtras();
		final LatLng point1 = new LatLng(24.45643, 118.086922);
		final LatLng point2 = new LatLng(24.455612, 118.085655);
		final LatLng point3 = new LatLng(24.455739, 118.085516);
		final LatLng point4 = new LatLng(24.458634, 118.088444);

		System.out.println(Double.toString(point1.latitude));
		System.out.println(Double.toString(point1.latitude));

		System.out.println("BaseMapDemo");

		mMapView = new MapView(this,
				new BaiduMapOptions().mapStatus(new MapStatus.Builder()
					.target(point1).build()));

		MapStatus ms = new MapStatus.Builder().overlook(-20).zoom(15).build();


		mBaiduMap = mMapView.getMap();

		MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(18.0f);
		mBaiduMap.setMapStatus(msu);

		BitmapDescriptor bitmapA = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_marka);
		BitmapDescriptor bitmapB = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_markb);
		BitmapDescriptor bitmapC = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_markc);
		BitmapDescriptor bitmapD = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_markd);

		//构建MarkerOption，用于在地图上添加Marker



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
					System.out.println(point1.latitude);
					System.out.println(point1.longitude);
				} else if (marker == mMarkerB) {
					System.out.println(point2.latitude);
					System.out.println(point2.longitude);
				} else if (marker == mMarkerC) {
					System.out.println(point3.latitude);
					System.out.println(point3.longitude);
				}
				else {
					System.out.println(point4.latitude);
					System.out.println(point4.longitude);
				}
				return true;
			}
		});

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
