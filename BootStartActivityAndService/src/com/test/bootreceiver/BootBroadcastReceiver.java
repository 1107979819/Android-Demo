package com.test.bootreceiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		//������� ���յ�������ɹ㲥���Ҫִ�еĴ���
		System.out.println(">>>>>>>>>>>>Boot");
		//��������Activity
		Intent it =context.getPackageManager().getLaunchIntentForPackage("com.test.bootreceiver"); 
		context.startActivity(it ); 
		//��������Service
		Intent service = new Intent(context,ServiceTest.class);  
        context.startService(service);  
		
	}  
   
  
} 