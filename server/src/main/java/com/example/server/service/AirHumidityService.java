package com.example.server.service;

import com.example.server.dao.AirHumidityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirHumidityService {

    private AirHumidityDao airHumidityDao;

    @Autowired
    public AirHumidityService(AirHumidityDao airHumidityDao){
        this.airHumidityDao = airHumidityDao;
    }
}
