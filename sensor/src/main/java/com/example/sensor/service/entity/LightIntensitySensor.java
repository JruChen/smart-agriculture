package com.example.sensor.service.entity;


import com.example.model.SensorType;

import java.util.Random;

public class LightIntensitySensor extends Sensor{
    public LightIntensitySensor(SensorType sensorType, long intervalTime) {
        super(sensorType, intervalTime);
    }

    @Override
    public String generateData() {
        String msg;
        Random random = new Random();
        double d = 40 + random.nextDouble() * 40;        //生成[40,80]之间
        msg = String.valueOf(d);
        return msg;
    }
}
