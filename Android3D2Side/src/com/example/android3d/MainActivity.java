package com.example.android3d;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Gallery.LayoutParams;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	private LinearLayout ll_left,ll_right; 
	private int count;
	private int index = 5;
	
	CoverFlow cf2,cf;
	Timer timer;
	TimerTask timerTask;
	
	
	 public void onCreate(Bundle savedInstanceState) {
		 
	        super.onCreate(savedInstanceState);
	        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//锁定横屏
			requestWindowFeature(Window.FEATURE_NO_TITLE);//设置无标题
			        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
	        setContentView(R.layout.activity_main);
	        InitView();
	    }
	 public void InitView()
	 {
		 
		 	ll_left = (LinearLayout)findViewById(R.id.ll_left);
		 	ll_right = (LinearLayout)findViewById(R.id.ll_right);
		 	
		 	cf = new CoverFlow(this);
	        //cf.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.bg));//背景
		 	cf.setLayoutParams(new CoverFlow.LayoutParams(LayoutParams.FILL_PARENT,
		 			LayoutParams.FILL_PARENT));
		 	
		 	cf.setAdapter(new ImageAdapter(this));
//	        ImageAdapter imageAdapter = new ImageAdapter(this);
//	        cf.setAdapter(imageAdapter);
	 
	        cf.setSelection(5, true);
	        cf.setAnimationDuration(1000);
	        ll_left.addView(cf);
	        
	        //////////////
	        cf2 = new CoverFlow(this);
	        cf2.setLayoutParams(new CoverFlow.LayoutParams(LayoutParams.FILL_PARENT,
		 			LayoutParams.FILL_PARENT));
		 	
	        cf2.setAdapter(new ImageAdapter(this));
//	        ImageAdapter imageAdapter2 = new ImageAdapter(this);
//	        cf2.setAdapter(imageAdapter2);
	        cf2.setSelection(5, true);
	        cf2.setAnimationDuration(1000);
	        ll_right.addView(cf2);
	        
	        timer = new Timer();
	        /////////////////////////////
	        timer.schedule(new TimerTask() {
		        @Override
		        public void run() {
		            Message message = new Message();
		            message.what = 2;
		            index = cf.getSelectedItemPosition();
		            index++;
		           
		            handler.sendMessage(message);
		        }
	        }, 500, 3000);
	 }
	    private Handler handler = new Handler() {
	        @Override
	        public void handleMessage(Message msg) {
	            super.handleMessage(msg);
	            switch (msg.what) {
	            case 2:
//	            	cf.setSelection(index);
//	            	cf2.setSelection(index);
	            	cf.onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT,null);
	            	cf2.onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT,null);
	            	if(index==10)
	            	{
	            		cf.setSelection(0);
		            	cf2.setSelection(0);
		            	index=5;
	            	}
	                break;
	            default:
	                break;
	            }
	        }
	    };

	 
	 
}
