package com.grid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageDetail extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_detail);
        Intent i=getIntent();
        int position =(Integer)i.getExtras().get("id");
        ImageView iv=(ImageView)findViewById(R.id.imageView);
        iv.setImageResource(ImageAdapter.images[position]);
	}
}