package com.grallery3d;
import java.util.Timer;
import java.util.TimerTask;

import com.mythou.grallery3d.R;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

public class Grallery3DActivity extends Activity {

	private TextView tvTitle_left,tvTitle_right; 	
	private GalleryView gallery_left,gallery_right; 	
	private ImageAdapter adapter;
	Timer timer;
	TimerTask timerTask;
	private boolean isRight = true;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//锁定横屏
		requestWindowFeature(Window.FEATURE_NO_TITLE);//设置无标题
		        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grallery_layout);
		initRes_left();
		initRes_right();
		 timer = new Timer();
	        /////////////////////////////
	        timer.schedule(new TimerTask() {
		        @Override
		        public void run() {
		            Message message = new Message();
		            message.what = 0;
		           int i= gallery_left.getSelectedItemPosition();
		           if(i==4)
		           {
		        	   isRight = false;
		           }
		           if(i==0)
		           {
		        	   isRight = true;
		           }
		           if(isRight)
		           {
		        	   message.what = 2;
		           }
		           else
		           {
		        	   message.what = 1;
		           }
		            handler.sendMessage(message);
		        }
	        }, 500, 3000);
		
	}
	  private Handler handler = new Handler() {
	        @Override
	        public void handleMessage(Message msg) {
	            super.handleMessage(msg);
	            switch (msg.what) {
	            case 1:
	            	left();
	            	break;
	            case 2:	
	            	right();
	                break;
	            default:
	                break;
	            }
	        }
	    };
	public void right()
	{
		gallery_left.onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT,null);
		gallery_right.onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT,null);
	}
	public void left()
	{
		gallery_left.onKeyDown(KeyEvent.KEYCODE_DPAD_LEFT,null);
		gallery_right.onKeyDown(KeyEvent.KEYCODE_DPAD_LEFT,null);
	}
	private void initRes_right(){
		tvTitle_left = (TextView) findViewById(R.id.tvTitle_right);
		gallery_left = (GalleryView) findViewById(R.id.gallery_right);

		adapter = new ImageAdapter(this); 	
		adapter.createReflectedImages();
		gallery_left.setAdapter(adapter);
		
		gallery_left.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				tvTitle_left.setText(adapter.titles[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		gallery_left.setOnItemClickListener(new OnItemClickListener() {			// 设置点击事件监听
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(Grallery3DActivity.this, "img " + (position+1) + " selected", Toast.LENGTH_SHORT).show();
			}
		});
	}
	private void initRes_left(){
		tvTitle_right = (TextView) findViewById(R.id.tvTitle_left);
		gallery_right = (GalleryView) findViewById(R.id.gallery_left);

		adapter = new ImageAdapter(this); 	
		adapter.createReflectedImages();
		gallery_right.setAdapter(adapter);
		
		gallery_right.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				tvTitle_right.setText(adapter.titles[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		gallery_right.setOnItemClickListener(new OnItemClickListener() {			// 设置点击事件监听
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(Grallery3DActivity.this, "img " + (position+1) + " selected", Toast.LENGTH_SHORT).show();
			}
		});
	}
}