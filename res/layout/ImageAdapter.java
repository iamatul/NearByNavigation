package com.grid;



import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ImageAdapter extends BaseAdapter {

	public static int[] images={
		R.drawable.airplane,
		R.drawable.atmcard,
		R.drawable.banks,
		R.drawable.bed,
		R.drawable.beer,
		R.drawable.bus,
		R.drawable.doctormale,
		R.drawable.gaspump,
		R.drawable.police,
		R.drawable.hospitalbuliding
		};

	private Context context;
	public ImageAdapter(Context applicationContext)
	{
		context=applicationContext;
	}
	public int getCount() {
		// TODO Auto-generated method stub
		return images.length;
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

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView iv;
		if(convertView!=null)
		{
			iv=(ImageView)convertView;
		}
		else
		{
			iv=new ImageView(context);
			iv.setLayoutParams(new GridView.LayoutParams(80,80));
		iv.setScaleType(ScaleType.CENTER_CROP);
		iv.setPadding(8, 8, 8, 8);
		}
		iv.setImageResource(images[position]);
		return iv;
	}

}
