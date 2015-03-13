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

		String str = getText();// ����native����

		textView.setText(str + "\n" + getText2() + "\n" + getText3() + "\n"
				+ AddInt(1, 2) + "\n" + getInt() + "\n" + calc());
	}

	static {
		System.loadLibrary("mylib");// �������ӿ�
	}

	public native String getText();// ����native����

	public native String getText2();// ����native����

	public native String getText3();// ����native����

	public native int getInt();

	public native int AddInt(int a, int b);// ����native����

	public native int calc();
}
