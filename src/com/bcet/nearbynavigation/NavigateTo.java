package com.bcet.nearbynavigation;

import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NavigateTo extends Activity {
	EditText lcation, endpoint;
	Button btn;
	String s = " ";
	String e = " ";

	ArrayList<String> start_lat;

	ArrayList<String> start_lon;

	ArrayList<String> end_lat;

	ArrayList<String> end_lon;

	String sumy, status;
	String start_address, end_address, duration, distence, main_start_lat,
			main_start_lon, main_end_lat, main_end_lon;

	public class Abc extends AsyncTask<String, String, String> {

		private String result;

		@Override
		protected String doInBackground(String... params) {
			DefaultHttpClient dhttp = new DefaultHttpClient();
			String url = "https://maps.googleapis.com/maps/api/directions/json?origin="
					+ s
					+ "&destination="
					+ e
					+ "+India&sensor=false&key=AIzaSyDMReLo6EY8_QfMnRKR2F9nYF6RdNqiJ_c";
			HttpGet httpget = new HttpGet(url);
			try {
				HttpResponse httpres = dhttp.execute(httpget);
				HttpEntity httpE = httpres.getEntity();
				if (httpE != null) {
					result = EntityUtils.toString(httpE);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				JSONObject main_obj = new JSONObject(result);
				JSONArray arr = main_obj.getJSONArray("routes");

				JSONObject o1 = arr.getJSONObject(0);
				JSONArray arr1 = o1.getJSONArray("legs");
				JSONObject o2 = arr1.getJSONObject(0);

				JSONObject dis_obj = o2.getJSONObject("distance");
				distence = dis_obj.getString("text");
				JSONObject dur_obj = o2.getJSONObject("duration");
				duration = dur_obj.getString("text");

				end_address = o2.getString("end_address");
				JSONObject endl_obj = o2.getJSONObject("end_location");
				main_end_lat = endl_obj.getString("lat");
				main_end_lon = endl_obj.getString("lng");

				start_address = o2.getString("start_address");
				JSONObject stl_obj = o2.getJSONObject("start_location");
				main_start_lat = stl_obj.getString("lat");
				main_start_lon = stl_obj.getString("lng");

				JSONArray arr2 = o2.getJSONArray("steps");

				for (int i = 0; i < arr2.length(); i++) {
					JSONObject o3 = arr2.getJSONObject(i);

					JSONObject stl = o3.getJSONObject("start_location");
					start_lat.add(stl.getString("lat"));
					start_lon.add(stl.getString("lng"));

					JSONObject endl1 = o3.getJSONObject("end_location");
					end_lat.add(endl1.getString("lat"));
					end_lon.add(endl1.getString("lng"));

				}

				// JSONObject dis_obj1 = o3.getJSONObject("distance");
				// txt = dis_obj1.getString("text");
				// val = dis_obj1.getString("value");
				// JSONObject dur_obj1 = o3.getJSONObject("duration");
				// txt = dur_obj1.getString("text");
				// val = dur_obj1.getString("value");

				// html = o3.getString("html_instructions");
				// JSONObject poly = o3.getJSONObject("polyline");
				// pts = poly.getString("points");

				// tvm = o3.getString("travel_mode");
				// JSONObject o4 = arr2.getJSONObject(1);
				// JSONObject dis_obj2 = o4.getJSONObject("distance");
				// txt = dis_obj2.getString("text");
				// val = dis_obj2.getString("value");
				// JSONObject dur_obj2 = o4.getJSONObject("duration");
				// txt = dur_obj2.getString("text");
				// val = dur_obj2.getString("value");
				// JSONObject endl2 = o4.getJSONObject("end_location");
				// lt = endl2.getString("lat");
				// ln = endl2.getString("lng");
				// htmins = o4.getString("html_instructions");
				// man = o4.getString("maneuver");
				// JSONObject poly1 = o4.getJSONObject("polyline");
				// pts = poly1.getString("points");
				// JSONObject stl1 = o4.getJSONObject("start_location");
				// lt = stl1.getString("lat");
				// ln = stl1.getString("lng");
				// tvm = o4.getString("travel_mode");
				// JSONObject o5 = arr2.getJSONObject(2);
				// JSONObject dis_obj3 = o5.getJSONObject("distance");
				// txt = dis_obj3.getString("text");
				// val = dis_obj3.getString("value");
				// JSONObject dur_obj3 = o5.getJSONObject("duration");
				// txt = dur_obj3.getString("text");
				// val = dur_obj3.getString("value");
				// JSONObject endl3 = o5.getJSONObject("end_location");
				// lt = endl3.getString("lat");
				// ln = endl3.getString("lng");
				// htmins = o5.getString("html_instructions");
				// man = o5.getString("maneuver");
				// JSONObject poly2 = o5.getJSONObject("polyline");
				// pts = poly2.getString("points");
				// JSONObject stl2 = o5.getJSONObject("start_location");
				// lt = stl2.getString("lat");
				// ln = stl2.getString("lng");
				// tvm = o5.getString("travel_mode");
				// JSONObject o6 = arr2.getJSONObject(3);
				// JSONObject dis_obj4 = o6.getJSONObject("distance");
				// txt = dis_obj4.getString("text");
				// val = dis_obj4.getString("value");
				// JSONObject dur_obj4 = o6.getJSONObject("duration");
				// txt = dur_obj4.getString("text");
				// val = dur_obj4.getString("value");
				// JSONObject endl4 = o6.getJSONObject("end_location");
				// lt = endl4.getString("lat");
				// ln = endl4.getString("lng");
				// htmins = o6.getString("html_instructions");
				// man = o6.getString("maneuver");
				// JSONObject poly3 = o6.getJSONObject("polyline");
				// pts = poly3.getString("points");
				// JSONObject stl3 = o6.getJSONObject("start_location");
				// lt = stl3.getString("lat");
				// ln = stl3.getString("lng");
				// tvm = o6.getString("travel_mode");
				// JSONObject o7 = arr2.getJSONObject(4);
				// JSONObject dis_obj5 = o7.getJSONObject("distance");
				// txt = dis_obj5.getString("text");
				// val = dis_obj5.getString("value");
				// JSONObject dur_obj5 = o7.getJSONObject("duration");
				// txt = dur_obj5.getString("text");
				// val = dur_obj5.getString("value");
				// JSONObject endl5 = o7.getJSONObject("end_location");
				// lt = endl5.getString("lat");
				// ln = endl5.getString("lng");
				// htmins = o7.getString("html_instructions");
				// man = o7.getString("maneuver");
				// JSONObject poly4 = o7.getJSONObject("polyline");
				// pts = poly4.getString("points");
				// JSONObject stl4 = o7.getJSONObject("start_location");
				// lt = stl4.getString("lat");
				// ln = stl4.getString("lng");
				// tvm = o7.getString("travel_mode");
				// JSONObject o8 = arr2.getJSONObject(5);
				// JSONObject dis_obj6 = o8.getJSONObject("distance");
				// txt = dis_obj6.getString("text");
				// val = dis_obj6.getString("value");
				// JSONObject dur_obj6 = o8.getJSONObject("duration");
				// txt = dur_obj6.getString("text");
				// val = dur_obj6.getString("value");
				// JSONObject endl6 = o8.getJSONObject("end_location");
				// lt = endl6.getString("lat");
				// ln = endl6.getString("lng");
				// htmins = o8.getString("html_instructions");
				// man = o8.getString("maneuver");
				// JSONObject poly5 = o8.getJSONObject("polyline");
				// pts = poly5.getString("points");
				// JSONObject stl5 = o8.getJSONObject("start_location");
				// lt = stl5.getString("lat");
				// ln = stl5.getString("lng");
				// tvm = o8.getString("travel_mode");
				// JSONObject o9 = arr2.getJSONObject(6);
				// JSONObject dis_obj7 = o9.getJSONObject("distance");
				// txt = dis_obj7.getString("text");
				// val = dis_obj7.getString("value");
				// JSONObject dur_obj7 = o9.getJSONObject("duration");
				// txt = dur_obj7.getString("text");
				// val = dur_obj7.getString("value");
				// JSONObject endl7 = o9.getJSONObject("end_location");
				// lt = endl7.getString("lat");
				// ln = endl7.getString("lng");
				// htmins = o9.getString("html_instructions");
				// man = o9.getString("maneuver");
				// JSONObject poly6 = o9.getJSONObject("polyline");
				// pts = poly6.getString("points");
				// JSONObject stl6 = o9.getJSONObject("start_location");
				// lt = stl6.getString("lat");
				// ln = stl6.getString("lng");
				// tvm = o9.getString("travel_mode");
				//
				// JSONObject o10 = arr2.getJSONObject(7);
				// JSONObject dis_obj8 = o10.getJSONObject("distance");
				// txt = dis_obj8.getString("text");
				// val = dis_obj8.getString("value");
				// JSONObject dur_obj8 = o10.getJSONObject("duration");
				// txt = dur_obj8.getString("text");
				// val = dur_obj8.getString("value");
				// JSONObject endl8 = o10.getJSONObject("end_location");
				// lt = endl8.getString("lat");
				// ln = endl8.getString("lng");
				// htmins = o10.getString("html_instructions");
				// man = o10.getString("maneuver");
				// JSONObject poly7 = o10.getJSONObject("polyline");
				// pts = poly7.getString("points");
				// JSONObject stl7 = o10.getJSONObject("start_location");
				// lt = stl7.getString("lat");
				// ln = stl7.getString("lng");
				// tvm = o10.getString("travel_mode");
				// JSONObject o11 = arr2.getJSONObject(8);
				// JSONObject dis_obj9 = o11.getJSONObject("distance");
				// txt = dis_obj9.getString("text");
				// val = dis_obj9.getString("value");
				// JSONObject dur_obj9 = o11.getJSONObject("duration");
				// txt = dur_obj9.getString("text");
				// val = dur_obj9.getString("value");
				// JSONObject endl9 = o11.getJSONObject("end_location");
				// lt = endl9.getString("lat");
				// ln = endl9.getString("lng");
				// htmins = o11.getString("html_instructions");
				// man = o11.getString("maneuver");
				// JSONObject poly8 = o11.getJSONObject("polyline");
				// pts = poly8.getString("points");
				// JSONObject stl8 = o11.getJSONObject("start_location");
				// lt = stl8.getString("lat");
				// ln = stl8.getString("lng");
				// tvm = o11.getString("travel_mode");
				//
				// JSONObject o12 = arr2.getJSONObject(9);
				// JSONObject dis_obj10 = o12.getJSONObject("distance");
				// txt = dis_obj10.getString("text");
				// val = dis_obj10.getString("value");
				// JSONObject dur_obj10 = o12.getJSONObject("duration");
				// txt = dur_obj10.getString("text");
				// val = dur_obj10.getString("value");
				// JSONObject endl10 = o12.getJSONObject("end_location");
				// lt = endl10.getString("lat");
				// ln = endl10.getString("lng");
				// htmins = o12.getString("html_instructions");
				// man = o12.getString("maneuver");
				// JSONObject poly9 = o12.getJSONObject("polyline");
				// pts = poly9.getString("points");
				// JSONObject stl9 = o12.getJSONObject("start_location");
				// lt = stl9.getString("lat");
				// ln = stl9.getString("lng");
				// tvm = o12.getString("travel_mode");

				sumy = o1.getString("summary");
				status = main_obj.getString("status");

			} catch (JSONException e) {
				e.printStackTrace();
			}
			return null;

		}

		@Override
		protected void onPostExecute(String r) {
			Intent in=new Intent(NavigateTo.this,map1.class);
			in.putStringArrayListExtra("latitude",start_lat);
			in.putStringArrayListExtra("strtlong", start_lon);
			
			in.putStringArrayListExtra("endlat", end_lat);
			in.putStringArrayListExtra("endlong", end_lon);
			in.putExtra("summary", sumy);
			in.putExtra("straddress",start_address);
			in.putExtra("enaddress", end_address);
			in.putExtra("dur", duration);
			in.putExtra("dist", distence);
			in.putExtra("mstrlat", main_start_lat);
			in.putExtra("mstrlon", main_start_lon);
			in.putExtra("mendlat", main_end_lat);
			in.putExtra("mendlon", main_end_lon);
			startActivity(in);
			
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.navigateto);
		lcation = (EditText) findViewById(R.id.edmy);
		endpoint = (EditText) findViewById(R.id.edend);
		btn = (Button) findViewById(R.id.button1);

		start_lat = new ArrayList<String>();
		start_lon = new ArrayList<String>();

		end_lat = new ArrayList<String>();
		end_lon = new ArrayList<String>();

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				s = lcation.getText().toString();
				e = endpoint.getText().toString();
				Abc a = new Abc();
				a.execute();
				
				
				
				// sum
				// start_address
				// end_address
				// duration
				// distence
				// main_start_lat
				// main_start_lon
				// main_end_lat
				// main_end_lon;
				
				
			}
		});
	}
}
