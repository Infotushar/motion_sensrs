package com.example;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class accelometer {
    public interface Listner {
        void ontranslation(float tx, float ty, float tz);
    }
    private Listner listner;
    public void setListner(Listner l) {
        listner = l;
    }
    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;


    {
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onsensorChanged(SensorEvent sensorEvent){
                if (listner != null)
                {
                    listner.ontranslation(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
                }
        }
        @Override
        public void onAccuracyChanged (Sensor sensor,int i){

        }
    };
}
public void register()
{
   sensorManager.registerListener(sensorEventListener, sensor, SensorManager. SENSOR_DELAY_NORMAL);
}
public void unregister()
{
 sensorManager.unregisterListener(sensorEventListener);
}
}