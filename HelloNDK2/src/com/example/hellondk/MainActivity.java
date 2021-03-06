package com.example.hellondk;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView textView;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.tv);

		String str = getText();// 调用native方法

		textView.setText(str + "\n" + getText2() + "\n" + getText3() + "\n"
				+ AddInt(1, 2) + "\n" + getInt() + "\n" + calc());
	}

	static {
		System.loadLibrary("mylib");// 导入链接库
	}

	public native String getText();// 声明native方法

	public native String getText2();// 声明native方法

	public native String getText3();// 声明native方法

	public native int getInt();

	public native int AddInt(int a, int b);// 声明native方法

	public native int calc();
}
