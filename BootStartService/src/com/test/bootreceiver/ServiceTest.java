package com.test.bootreceiver;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class ServiceTest extends Service{
	
	private Timer timer;
	 private static final String TAG = "LocalService"; 
	    private IBinder binder=new ServiceTest.LocalBinder();
	    
	    @Override
	    public IBinder onBind(Intent intent) {
	         
	        return binder;
	    }
	    @Override 
	    public void onCreate() { 
	            Log.i(TAG, "onCreate"); 
	            //这里可以启动媒体播放器
	           // if(mediaPlayer==null)
	           //     mediaPlayer=MediaPlayer.create(this, uri);
	           System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>Service3 start");
	           timer =new  Timer();
	           timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>Service3 run");
					
				}
			},3000, 3000);
	            super.onCreate(); 
	    } 

	    @Override 
	    public void onStart(Intent intent, int startId) { 
	            Log.i(TAG, "onStart"); 
	            super.onStart(intent, startId); 
	            
	    } 

	    @Override 
	    public int onStartCommand(Intent intent, int flags, int startId) { 
	          Log.i(TAG, "onStartCommand"); 
	        return START_STICKY;
	    }

	    
	    
	    @Override 
	    public void onDestroy() { 
	            Log.i(TAG, "onDestroy"); 
	            super.onDestroy(); 
	    } 

	    
	    //定义内容类继承Binder
	    public class LocalBinder extends Binder{
	        //返回本地服务
	    	ServiceTest getService(){
	            return ServiceTest.this;
	        }
	    }
	    

}
