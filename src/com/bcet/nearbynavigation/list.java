package com.bcet.nearbynavigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class list extends Activity{
	
	ListView lst;
	String type;
	double lat,lon;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
Intent in= getIntent();
	lat = in.getDoubleExtra("lat", 0.0);
		lon = in.getDoubleExtra("lon",0.0);
		type = getIntent().getStringExtra("name");
		lst = (ListView)  findViewById(R.id.listView);
		Toast.makeText(getApplicationContext(), lat+"", 1000).show();
	new searchNearbyContent(list.this,lst,type,lat,lon).execute();
	
	lst.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			
			Intent in = new Intent(list.this,DetailActivity.class);
			in.putExtra("detail", arg2);
			startActivity(in);
			
			
			
		}
	});
	}

}
