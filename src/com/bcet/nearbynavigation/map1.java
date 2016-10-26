package com.bcet.nearbynavigation;

import java.util.ArrayList;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;


public class map1 extends FragmentActivity {
	private GoogleMap googleMap;
	String smry,start_address,end_address,duration,distance;
TextView durtn,dis,from,to,summary;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map1_layout);
		googleMap = ((SupportMapFragment) (getSupportFragmentManager()
				.findFragmentById(R.id.map))).getMap();
		LatLng coods = new LatLng(30.7144606, 76.6922064);
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		googleMap.getUiSettings().setCompassEnabled(true);
		googleMap.getUiSettings().setZoomControlsEnabled(true);
		googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coods, 10));
		googleMap.getUiSettings().setMyLocationButtonEnabled(true);

		Intent in = getIntent();

		 smry = in.getStringExtra("summary");

		 start_address = in.getStringExtra("straddress");
		 end_address = in.getStringExtra("enaddress");
		 duration = in.getStringExtra("dur");
		 distance = in.getStringExtra("dist");

		String mainslat = in.getStringExtra("mstrlat");
		String mainslon = in.getStringExtra("mstrlon");
		String mainelat = in.getStringExtra("mendlat");
		String mainelon = in.getStringExtra("mendlon");

		addMarkerOnMap(
				new LatLng(Double.parseDouble(mainslat),
						Double.parseDouble(mainslon)), "From", start_address,
				BitmapDescriptorFactory.HUE_BLUE);
		addMarkerOnMap(
				new LatLng(Double.parseDouble(mainelat),
						Double.parseDouble(mainelon)), "To", end_address,
				BitmapDescriptorFactory.HUE_BLUE);

		ArrayList<String> end_latitude = in.getStringArrayListExtra("endlat");
		ArrayList<String> end_longitude = in.getStringArrayListExtra("endlong");
		ArrayList<String> start_latitude = in
				.getStringArrayListExtra("latitude");
		ArrayList<String> start_longitude = in
				.getStringArrayListExtra("strtlong");

		for (int i = 0; i < start_latitude.size(); i++) {
			addMarkerOnMap(
					new LatLng(Double.parseDouble(start_latitude.get(i)),
							Double.parseDouble(start_longitude.get(i))),
					"Pass", "Way to" + end_address,
					BitmapDescriptorFactory.HUE_GREEN);
		}
            setIds();
//			addMarkerOnMap(new LatLng(Double.parseDouble(end_latitude.get(i)),
//					Double.parseDouble(end_longitude.get(i))), "Pass", "Way to"
//					+ end_address, BitmapDescriptorFactory.HUE_GREEN);

		}

		

	public void addMarkerOnMap(LatLng position, String title, String snippet,
			Float mark){ 

		MarkerOptions mm = new MarkerOptions();
		mm.position(position);
		mm.title(title);
		mm.snippet(snippet);
		mm.icon(BitmapDescriptorFactory.defaultMarker(mark));
		googleMap.addMarker(mm);
	}

	public void setIds() {
		durtn=(TextView) findViewById(R.id.tvDur);
		dis=(TextView) findViewById(R.id.tvDis);
		from=(TextView) findViewById(R.id.tvFrom);
		to=(TextView) findViewById(R.id.tvTo);
		summary=(TextView) findViewById(R.id.tvSum);
       
        durtn.setText(duration);
        dis.setText(distance);
        from.setText(start_address);
        to.setText(end_address);
        summary.setText(smry);
      
        
	}
}
