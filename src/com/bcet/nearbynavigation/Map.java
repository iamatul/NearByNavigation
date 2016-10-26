package com.bcet.nearbynavigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends FragmentActivity implements OnMapClickListener {
	private GoogleMap googleMap; 
	Double lati, longi;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.map_layout);
			
			Intent in= getIntent();
		
			
			lati = in.getDoubleExtra("key1", 0.0);
			longi = in.getDoubleExtra("key2",0.0);
			
			googleMap = ((SupportMapFragment) (getSupportFragmentManager().findFragmentById(R.id.map))).getMap();
			LatLng coods = new LatLng(lati,longi);
			googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			googleMap.getUiSettings().setCompassEnabled(true);
			googleMap.getUiSettings().setZoomControlsEnabled(true);
			googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coods, 10));
			googleMap.getUiSettings().setMyLocationButtonEnabled(true);
			MarkerOptions mark = new MarkerOptions();
			
			Toast.makeText(getApplicationContext(),""+lati,Toast.LENGTH_LONG).show();
		
			
			
			mark.position(coods);
			mark.title("My Spot");
			mark.snippet("This is my spot");
			mark.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
			googleMap.addMarker(mark);
			googleMap.setOnMapClickListener(this);
			SharedPreferences preferences = getSharedPreferences("abc", 0);
	        String count = preferences.getString("count", "no");

			if (count.equals("no")) {

			}
			else {
				int a = Integer.parseInt(count);
				for (int k = 0; k < a; k++) {
					// MarkerOptions mark1=new MarkerOptions();
					String s_coods = preferences.getString("key" + k, "");
					Toast.makeText(getApplicationContext(),s_coods,Toast.LENGTH_LONG).show();
}
			}
		}

	@Override
	public void onMapClick(LatLng arg0) {
		MarkerOptions mm=new MarkerOptions();
		mm.position(arg0);
		mm.title("My Spot");
		mm.snippet("This is my spot");
		mm.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
		googleMap.addMarker(mm);
		
		
	}
}