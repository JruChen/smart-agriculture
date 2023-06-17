package com.example.sensor.service.entity;


import com.example.model.SensorType;

import java.util.Random;

public class AirHumiditySensor extends Sensor{
    public AirHumiditySensor(SensorType sensorType, long intervalTime) {
        super(sensorType, intervalTime);
    }

    @Override
    public String generateData() {
        String msg;
        Random random = new Random();
        int d = 50 + random.nextInt(40);        //生成[50,90]之间
        msg = String.valueOf(d);
        return msg;
    }
}
