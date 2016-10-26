package com.bcet.nearbynavigation;

import java.util.ArrayList;

import com.bcet.nearbynavigation.CustomAdapter.Holder;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{

	Context mc;
	ArrayList< GetterSetter> aa;
	ArrayList< String> img;
	
	private static LayoutInflater inflater = null;
	public MyAdapter(Context c,ArrayList<GetterSetter> al,ArrayList< String> img) {
		// TODO Auto-generated constructor stub
		this.img = img;
		mc = c;
		aa= al;
		inflater = (LayoutInflater) mc	.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return aa.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	class ViewHolder{
		TextView txt1,txt2;
		ImageView img;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		 ViewHolder holder = new  ViewHolder();
		View rowView;

		rowView = inflater.inflate(R.layout.list2, null);
		holder.txt1 = (TextView) rowView.findViewById(R.id.textView11);
		holder.txt2 = (TextView) rowView.findViewById(R.id.textView21);
		holder.img = (ImageView) rowView.findViewById(R.id.imageView11);

		holder.txt1.setText(aa.get(position).getName());
		holder.txt2.setText(aa.get(position).getAddress());
		
		//holder.img.setImageResource(imageId[position]);
		Picasso.with(mc).load(img.get(position)).into(holder.img);
		return rowView;
	}
	
}