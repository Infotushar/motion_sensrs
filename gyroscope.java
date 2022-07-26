package com;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class gyroscope {
    public interface Listener
    {
        void onRotation(float rx, float ry, float rz);
    }
    private Listener listener;
    public void  setListener(Listener l)
    {
        listener = 1;
    }
    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;

    gyroscope(Context context)
    sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
    sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent){
            if (listner != null)
            {
                listner.onrotation(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
            }
        }
        @Override
        public void onAccuracyChanged (Sensor sensor,int i){

        }
    };
}
