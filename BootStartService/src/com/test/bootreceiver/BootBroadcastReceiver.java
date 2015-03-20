package com.test.bootreceiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/**
 * 开机启动测试程序,开机启动后台Service
 * @author WYL
 *
 */
public class BootBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		//下面添加 接收到开机完成广播后的要执行的代码
		System.out.println(">>>>>>>>>>>>Boot");
		Intent service = new Intent(context,ServiceTest.class);  
        context.startService(service);  
		
	}  
   
  
} 