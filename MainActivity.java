package com.example.motionsensors;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
     private Accelorometer accelorometer;
     private Gyroscope gyroscope;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accelorometer= new Accelerometer(context: this);
        gyroscope = new Gyroscope(context: this);

        accelorometer.setListener(new Accelerometer.listener){
            @Override
                    public void onTranslation(float tx, float ty, float tz){
            if(tx> 1.0f){
                getWindow().getDecorView().setBackgroundColor(Color.RED);
            }
            else if(tx< -1.0f){
                getWindow().getDecorView().setBackgroundColor(Color.BLUE);
            }
            }
        };
        gyroscope.setListener( new Gyroscope.Listener){
            @Override
                    public void onRotation(float rx,float ry, float rz){
               if(rx > 1.0f){
                   getWindow().getDecorView().setBackgroundColor(Colour.GREEN);
               }
               else if(rx< -1.0f){

                   getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
               }
            }
        };
    }

    @Override
    protected void onResume(){
        super.onResume();

        accelerometer.register();
        gyroscope.register();
    }

    @Override
    protected void onPause(){
        super.onPause();
        accelerometr.unregister();
        gyroscope.unregister();
    }
}