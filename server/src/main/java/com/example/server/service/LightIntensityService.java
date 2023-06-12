package com.example.server.service;

import com.example.server.dao.LightIntensityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LightIntensityService {

    private LightIntensityDao lightIntensityDao;

    @Autowired
    public LightIntensityService(LightIntensityDao lightIntensityDao){
        this.lightIntensityDao = lightIntensityDao;
    }
}
