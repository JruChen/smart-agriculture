package com.example.sensor;

import com.example.sensor.service.SensorMonitor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.jms.JMSException;

@SpringBootApplication
public class SensorApplication {

    public static void main(String[] args) throws JMSException, InterruptedException {
        SensorMonitor sensorMonitor = new SensorMonitor();
        sensorMonitor.sendData();
        SpringApplication.run(SensorApplication.class, args
        );
    }

}
