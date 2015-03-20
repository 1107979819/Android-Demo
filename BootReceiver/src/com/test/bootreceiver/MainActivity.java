package com.test.bootreceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
/**
 * 开机启动测试程序
 * 
 * 
 * 主要步骤:
 * 1、添加继承BroadcastReceiver的类（ 本项目为BootBroadcastReceiver），
 *    在该类中onReceive方法中添加开机完成后要执行的命令(可用于开机时启动自身、其他应用或者服务)
 *
 * 2、配置AndroidManifest.xml:
 *    a、添加 <receiver>标签，名称为上一步定义的BroadcastReceiver的子类，内容如下
 *      <receiver android:name="BootBroadcastReceiver">  
 *              <intent-filter>  
 *                  <action android:name="android.intent.action.BOOT_COMPLETED"></action>  
 *                  <category android:name="android.intent.category.LAUNCHER" />  
 *              </intent-filter>  
 *          </receiver>
 *            
 *    b、添加权限<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" /> 
 *          
 * @author WYL
 * 
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println(">>>>>>>>>>>>BootReceiver Test");
	}

}
