package com.example.sensor.service.entity;

import com.example.model.SensorType;

import java.util.Random;

public class SoilTempSensor extends Sensor{
    public SoilTempSensor(SensorType sensorType, long intervalTime) {
        super(sensorType, intervalTime);
    }

    @Override
    public String generateData() {
        String msg;
        Random random = new Random();
        int d = 15 + random.nextInt(10);        //生成[15,25]之间
        msg = String.valueOf(d);
        return msg;
    }
}
