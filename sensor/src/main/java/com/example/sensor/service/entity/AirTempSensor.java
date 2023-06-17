package com.example.sensor.service.entity;


import com.example.model.SensorType;

import java.util.Random;

public class AirTempSensor extends Sensor{
    public AirTempSensor(SensorType sensorType, long intervalTime) {
        super(sensorType, intervalTime);
    }

    @Override
    public String generateData() {
        String msg;
        Random random = new Random();
        int d = 12 + random.nextInt(22);        //生成[12,34]之间
        msg = String.valueOf(d);
        return msg;
    }
}
