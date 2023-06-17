package com.example.sensor.service.entity;


import com.example.model.SensorType;

import java.util.Random;

public class SoilHumiditySensor extends Sensor{
    public SoilHumiditySensor(SensorType sensorType, long intervalTime) {
        super(sensorType, intervalTime);
    }

    @Override
    public String generateData() {
        String msg;
        Random random = new Random();
        int d = 70 + random.nextInt(10);        //生成[70,80]之间
        msg = String.valueOf(d);
        return msg;
    }
}
