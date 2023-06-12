package com.example.server.dao;

import com.example.server.mapper.SoilHumidityPoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SoilHumidityDao {
    private SoilHumidityPoMapper soilHumidityPoMapper;

    @Autowired
    public SoilHumidityDao(SoilHumidityPoMapper soilHumidityPoMapper){
        this.soilHumidityPoMapper = soilHumidityPoMapper;
    }


}
