package com.bcet.nearbynavigation;


import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;
import com.google.android.gms.location.LocationClient; 
import com.google.android.gms.common.ConnectionResult; 


@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
	TabHost tabh;
	protected String msg;
	LocationClient mLocationClient;
	double latitude, longitude;
	AppLocationService appLocationService;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// displayCurrentLocation();
		appLocationService = new AppLocationService(
				MainActivity.this);
		Location nwLocation = appLocationService
				.getLocation(LocationManager.NETWORK_PROVIDER);

		if (nwLocation != null) {
			 latitude = nwLocation.getLatitude();
			 longitude = nwLocation.getLongitude();
			Toast.makeText(
					getApplicationContext(),
					"Mobile Location (NW): \nLatitude: " + latitude
							+ "\nLongitude: " + longitude,
					Toast.LENGTH_LONG).show();
		} else {
			//showSettingsAlert("NETWORK");
		}

	

		
		tabh = (TabHost) findViewById(android.R.id.tabhost);
	
		TabSpec tabs1 = tabh.newTabSpec("map");
		tabs1.setIndicator("GMap");
		Intent i1 = new Intent(MainActivity.this, Map.class);
		i1.putExtra("key1", latitude);
		i1.putExtra("key2", longitude);
		tabs1.setContent(i1);
		tabh.addTab(tabs1);

		TabSpec tabs2 = tabh.newTabSpec("Navigate To");
		tabs2.setIndicator("Navigate To");
		Intent i2 = new Intent(MainActivity.this, NavigateTo.class);
		
		tabs2.setContent(i2);
		tabh.addTab(tabs2);

		TabSpec tabs3 = tabh.newTabSpec("search");
		tabs3.setIndicator("Search Nearby");
		Intent i3 = new Intent(MainActivity.this, SearchByLocation.class);
		i3.putExtra("key1", latitude);
		i3.putExtra("key2", longitude);
		tabs3.setContent(i3);
		tabh.addTab(tabs3);
	}
}