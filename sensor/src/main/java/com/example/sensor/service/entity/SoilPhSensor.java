package com.example.sensor.service.entity;


import com.example.model.SensorType;

import java.util.Random;

public class SoilPhSensor extends Sensor{
    public SoilPhSensor(SensorType sensorType, long intervalTime) {
        super(sensorType, intervalTime);
    }

    @Override
    public String generateData() {
        String msg;
        Random random = new Random();
        double d = 5.5 + random.nextDouble() * 1.5;        //生成[5.5,7.0]之间
        msg = String.valueOf(d);
        return msg;
    }
}
