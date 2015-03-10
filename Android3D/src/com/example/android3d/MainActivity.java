package com.example.android3d;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

public class MainActivity extends Activity {

	 public void onCreate(Bundle savedInstanceState) {
		 
	        super.onCreate(savedInstanceState);
	 
	        CoverFlow cf = new CoverFlow(this);
	 
	 
	        //cf.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.bg));//±³¾°
	 
	        cf.setAdapter(new ImageAdapter(this));
	 
	        ImageAdapter imageAdapter = new ImageAdapter(this);
	 
	        cf.setAdapter(imageAdapter);
	 
	        cf.setSelection(2, true);
	 
	        cf.setAnimationDuration(1000);
	 
	        setContentView(cf);
	 
	    }

}
