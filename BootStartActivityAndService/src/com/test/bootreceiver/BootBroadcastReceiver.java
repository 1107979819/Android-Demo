package com.test.bootreceiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		//下面添加 接收到开机完成广播后的要执行的代码
		System.out.println(">>>>>>>>>>>>Boot");
		//开机启动Activity
		Intent it =context.getPackageManager().getLaunchIntentForPackage("com.test.bootreceiver"); 
		context.startActivity(it ); 
		//开机启动Service
		Intent service = new Intent(context,ServiceTest.class);  
        context.startService(service);  
		
	}  
   
  
} 