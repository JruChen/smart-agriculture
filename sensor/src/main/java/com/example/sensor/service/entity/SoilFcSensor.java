package com.example.sensor.service.entity;


import com.example.model.SensorType;

import java.util.Random;

public class SoilFcSensor extends Sensor{
    public SoilFcSensor(SensorType sensorType, long intervalTime) {
        super(sensorType, intervalTime);
    }

    @Override
    public String generateData() {
        String msg;
        Random random = new Random();
        double d = 50 + random.nextDouble() * 20;        //生成[50,70]之间
        msg = String.valueOf(d);
        return msg;
    }
}
