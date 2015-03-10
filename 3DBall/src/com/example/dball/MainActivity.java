package com.example.dball;
 
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;
 
public class MainActivity extends Activity {
    MySurfaceView msv;
    RatingBar rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        msv = new MySurfaceView(this);
        setContentView(R.layout.activity_main);
        rb = (RatingBar) findViewById(R.id.RatingBar01);
        msv.requestFocus();
        msv.setFocusableInTouchMode(true);
        LinearLayout lla = (LinearLayout) findViewById(R.id.lla);
        lla.addView(msv);
         
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
             
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                    boolean fromUser) {
                // TODO Auto-generated method stub
                if (rating >= 0 && rating <= 1) {
                    msv.openLightNum = 1;
                } else if(rating > 1 && rating <= 2){
                    msv.openLightNum = 2;
                }else if(rating > 2 && rating <= 3){
                    msv.openLightNum = 3;
                }else if(rating > 3 && rating <= 4){
                    msv.openLightNum = 4;
                }else if(rating > 4 && rating <= 5){
                    msv.openLightNum = 5;
                }
                Toast.makeText(MainActivity.this, "¿ªÆôÁË" + msv.openLightNum + "ÕµµÆ", Toast.LENGTH_SHORT).show();
            }
        });
    }
     
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        msv.onPause();
    }
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        msv.onResume();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}