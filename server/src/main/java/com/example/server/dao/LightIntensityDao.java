package com.example.server.dao;

import com.example.server.mapper.LightIntensityPoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LightIntensityDao {
    private LightIntensityPoMapper lightIntensityPoMapper;

    @Autowired
    public LightIntensityDao(LightIntensityPoMapper lightIntensityPoMapper){
        this.lightIntensityPoMapper = lightIntensityPoMapper;
    }
}
