package com.bcet.nearbynavigation;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.bcet.nearbynavigation.HttpService;
import com.bcet.nearbynavigation.GetterSetter;
import com.google.android.gms.maps.model.LatLng;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

public class searchNearbyContent extends AsyncTask<Void, Void, Void> {

	Context con;
	String response_location, url_location, types;
	double current_lat , current_log;
	//LatLng coods = new LatLng(30.7144606, 76.6922064);
	ProgressDialog progressDialog;
	ArrayList<GetterSetter> al = new ArrayList<GetterSetter>();
	ArrayList<String> img = new ArrayList<String>();
	ListView list;

	/*
	 * public searchNearbyContent(ListView list,double current_lat,double
	 * current_log,String type,Context con) { // TODO Auto-generated constructor
	 * stub this.type=type; this.current_lat=current_lat;
	 * this.current_log=current_log; this.con=con; this.list=list;
	 * 
	 * }
	 */
	public searchNearbyContent(list list2, ListView lst, String type,double lat,double lon) {
		// TODO Auto-generated constructor stub
		con = list2;
		list = lst;
		this.types = type;
		current_lat = lat;
		current_log = lon;

	}

	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub

		
		  url_location =
		  "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="
		  + current_lat + "" + "," + current_log + "" + "&radius=2000&types=" +
		  types + "&sensor=true&key=AIzaSyDVXQ7fN3GMEAluY42aQrXKSwxMyz_eL_U";
		// url_location = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=30.7190335,76.7072591&radius=5000&types=atm&sensor=true&key=AIzaSyDVXQ7fN3GMEAluY42aQrXKSwxMyz_eL_U";

		HttpService hs = new HttpService(url_location);
		response_location = hs.getResponse();
		if (response_location != null) {

			try {
				JSONObject mainObj = new JSONObject(response_location);
				JSONArray array = mainObj.getJSONArray("results");

				for (int i = 0; i < array.length(); i++) {

					JSONObject infoObj = array.optJSONObject(i);

					GetterSetter gs = new GetterSetter();
					gs.setName(infoObj.getString("name"));
					gs.setAddress(infoObj.getString("vicinity"));
					String image = infoObj.getString("icon");
					img.add(image);
					
					JSONObject geoObj = infoObj.getJSONObject("geometry");
					JSONObject locObj = geoObj.getJSONObject("location");

					gs.setLat(locObj.getDouble("lat"));
					gs.setLog(locObj.getDouble("lng"));

					al.add(gs);

				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Log.e("All places ", al.toString());
		return null;
	}

	@Override
	protected void onPreExecute() {

		
		super.onPreExecute();
		progressDialog = ProgressDialog.show(con, types.toUpperCase()+"","Uploading Status...", true);

	}

	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		//Toast.makeText(con, "" + response_location, 1000).show();
		list.setAdapter(new MyAdapter(con,al,img));
		progressDialog.dismiss();
	}
}
