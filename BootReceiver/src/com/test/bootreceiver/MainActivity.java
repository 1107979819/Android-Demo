package com.test.bootreceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
/**
 * �����������Գ���
 * 
 * 
 * ��Ҫ����:
 * 1����Ӽ̳�BroadcastReceiver���ࣨ ����ĿΪBootBroadcastReceiver����
 *    �ڸ�����onReceive��������ӿ�����ɺ�Ҫִ�е�����(�����ڿ���ʱ������������Ӧ�û��߷���)
 *
 * 2������AndroidManifest.xml:
 *    a����� <receiver>��ǩ������Ϊ��һ�������BroadcastReceiver�����࣬��������
 *      <receiver android:name="BootBroadcastReceiver">  
 *              <intent-filter>  
 *                  <action android:name="android.intent.action.BOOT_COMPLETED"></action>  
 *                  <category android:name="android.intent.category.LAUNCHER" />  
 *              </intent-filter>  
 *          </receiver>
 *            
 *    b�����Ȩ��<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" /> 
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
