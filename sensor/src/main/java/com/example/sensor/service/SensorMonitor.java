package com.example.sensor.service;


import com.example.model.SensorType;
import com.example.sensor.service.entity.*;

import javax.jms.JMSException;
import java.util.ArrayList;
import java.util.List;

public class SensorMonitor {

    private List<Sensor> sensorList = new ArrayList<>();
    private long intervalTime = 5000;   //每5秒发送一次

    public SensorMonitor(){
        sensorList.add(new AirCo2Sensor(SensorType.AIRCO2, intervalTime));
        sensorList.add(new AirHumiditySensor(SensorType.AIRHUMIDITY, intervalTime));
        sensorList.add(new AirTempSensor(SensorType.AIRTEMP, intervalTime));
        sensorList.add(new LightIntensitySensor(SensorType.LIGHTINTENSITY, intervalTime));
        sensorList.add(new SoilFcSensor(SensorType.SOILFC, intervalTime));
        sensorList.add(new SoilHumiditySensor(SensorType.SOILHUMIDITY, intervalTime));
        sensorList.add(new SoilPhSensor(SensorType.SOILPH, intervalTime));
        sensorList.add(new SoilTempSensor(SensorType.SOILTEMP, intervalTime));
    }

    public void sendData() throws JMSException, InterruptedException {
        for(Sensor sensor: sensorList){
            sensor.sendData();
        }
    }

}
