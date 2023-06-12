package com.example.server.service;

import com.example.server.dao.SoilHumidityDao;
import com.example.server.mapper.po.SoilHumidityPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoilHumidityService {

    private SoilHumidityDao soilHumidityDao;

    @Autowired
    public SoilHumidityService(SoilHumidityDao soilHumidityDao){
        this.soilHumidityDao = soilHumidityDao;
    }

}
