package com.example.sensor.service.entity;


import com.example.model.SensorType;

import java.util.Random;

public class AirCo2Sensor extends Sensor{
    public AirCo2Sensor(SensorType sensorType, long intervalTime) {
        super(sensorType, intervalTime);
    }

    @Override
    public String generateData() {
        String msg;
        Random random = new Random();
        double d = 500 + random.nextDouble() * 500;        //生成[500,1000]之间的小数
        msg = String.valueOf(d);
        return msg;
    }
}
