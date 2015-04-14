package com.example.senor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
/**
 * 功能：获取手机的方向
 * 描述：使用官方推荐的方法getOrientation(x,x)代替,getDefaultSensor(Sensor.TYPE_ORIENTATION)
 * 		 通过加磁力计magnetometer和加速度传感器accelerometer的值计算出方向值
 * 		 具体参考http://blog.csdn.net/android_qhdxuan/article/details/7454313
 * @author EPICVIEW
 *
 */
public class MainActivity extends Activity {
	
    /** Called when the activity is first created. */
	TextView tv1,tv2,tv3;
	private SensorManager sm=null;
	private Sensor aSensor=null;
	private Sensor mSensor=null;
	 
	float[] accelerometerValues=new float[3];
	float[] magneticFieldValues=new float[3];
	float[] values=new float[3];
	float[] rotate=new float[9];
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.t1);
        tv2=(TextView)findViewById(R.id.t2);
        tv3=(TextView)findViewById(R.id.t3);
        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        aSensor=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensor=sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sm.registerListener(myListener, aSensor, SensorManager.SENSOR_DELAY_GAME);
        sm.registerListener(myListener, mSensor, SensorManager.SENSOR_DELAY_GAME);
        
        
    }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		sm.unregisterListener(myListener);
	}
	final SensorEventListener myListener=new SensorEventListener(){

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSensorChanged(SensorEvent event) {
			// TODO Auto-generated method stub
			if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
				accelerometerValues=event.values;
			}
			if(event.sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD){
				magneticFieldValues=event.values;
			}
			
			SensorManager.getRotationMatrix(rotate, null, accelerometerValues, magneticFieldValues);
			SensorManager.getOrientation(rotate, values);
			//经过SensorManager.getOrientation(rotate, values);得到的values值为弧度
			//转换为角度
			values[0]=(float)Math.toDegrees(values[0]);
			values[1]=(float)Math.toDegrees(values[1]);
			values[2]=(float)Math.toDegrees(values[2]);
			tv1.setText("x="+(int )values[0]);
			tv2.setText("y="+(int )values[1]);
			tv3.setText("z="+(int )values[2]);
		}};
		
	
    
}