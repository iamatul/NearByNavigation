package com.bcet.nearbynavigation;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class home_page extends Activity {
ImageView logo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage_layout);
		logo = (ImageView) findViewById(R.id.splashImage);
		Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.scalelogo);
		logo.setAnimation(anim);
		
		Thread t1=new Thread()
		{
			public void run()
			{
				try{
					Thread.sleep(2000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				finally
				{
				Intent in=new Intent("com.bcet.nearbynavigation.MainActivity");
				startActivity(in);
				}
			}
		};
		t1.start();
	
}
}
		


