package com.bcet.nearbynavigation;

import com.bcet.nearbynavigation.CustomAdapter;
import com.bcet.nearbynavigation.R;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.view.Menu;
import android.view.View;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class SearchByLocation extends Activity {

	GridView gv;
	Context context;

	public static String[] prgmNameList = { "Restaurants", "Cafe", "Bar",
			"Clubs", "ATM", "Cinema", "Petrol_Pump","Bank" };
	String types[]={"restaurant","cafe","bar","night_club","atm","movie_theater","gas_station","bank"};
	int image[] = { R.drawable.resturant, R.drawable.teacup, R.drawable.beer,
			R.drawable.hotel, R.drawable.atmcard,R.drawable.clapstick,R.drawable.gaspump,R.drawable.banks };
	double lat,lon;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_layout);
		
		Intent in= getIntent();
		lat = in.getDoubleExtra("key1", 0.0);
		lon = in.getDoubleExtra("key2",0.0);
		
		gv = (GridView) findViewById(R.id.gridview);
		gv.setAdapter(new CustomAdapter(SearchByLocation.this, prgmNameList, image));
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				Intent in=new Intent(SearchByLocation.this,list.class);
				in.putExtra("name",types[arg2]);
				in.putExtra("lat",lat);
				in.putExtra("lon",lon);
				startActivity(in);
				
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;

	}
}
