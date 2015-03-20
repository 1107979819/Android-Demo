package com.example.screenshot;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btn1;
	private String fileName;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1 = (Button)findViewById(R.id.button1);
		btn1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				GetandSaveCurrentImage() ;
			}
		});
	}

/**
     * 获取和保存当前屏幕的截图
     */
    private void GetandSaveCurrentImage()  
    {  
        //1.构建Bitmap  
        WindowManager windowManager = getWindowManager();  
        Display display = windowManager.getDefaultDisplay();  
        int w = display.getWidth();  
        int h = display.getHeight();  

        Bitmap Bmp = Bitmap.createBitmap( w, h, Config.ARGB_8888 );      

        //2.获取屏幕  
        View decorview = this.getWindow().getDecorView();   
        decorview.setDrawingCacheEnabled(true);   
        Bmp = decorview.getDrawingCache();   

        String SavePath = getSDCardPath()+"/ScreenImage";

        //3.保存Bitmap   
        try {  
            File path = new File(SavePath);  
            //文件  
            fileName  =new  java.text.SimpleDateFormat("yyyyMMddhhmmss").format(new java.util.Date());
            String filepath = SavePath + "/"+fileName+".png";  
            File file = new File(filepath);  
            if(!path.exists()){  
                path.mkdirs();  
            }  
            if (!file.exists()) {  
                file.createNewFile();  
            }  

            FileOutputStream fos = null;  
            fos = new FileOutputStream(file);  
            if (null != fos) {  
                Bmp.compress(Bitmap.CompressFormat.PNG, 90, fos);  
                fos.flush();  
                fos.close();    
                Toast.makeText(this, "截屏文件已保存至SDCard/ScreenImage/"+fileName+".png", Toast.LENGTH_LONG).show();  
            }  

        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  

    /**
     * 获取SDCard的目录路径功能
     * @return
     */
    private String getSDCardPath(){
        File sdcardDir = null;
        //判断SDCard是否存在
        boolean sdcardExist = Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
        if(sdcardExist){
            sdcardDir = Environment.getExternalStorageDirectory();
        }
        return sdcardDir.toString();
    }

}
