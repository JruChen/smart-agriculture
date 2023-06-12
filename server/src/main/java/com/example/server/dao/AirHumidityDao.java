package com.example.server.dao;

import com.example.server.mapper.AirHumidityPoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AirHumidityDao {
    private AirHumidityPoMapper airHumidityPoMapper;

    @Autowired
    public AirHumidityDao(AirHumidityPoMapper airHumidityPoMapper){
        this.airHumidityPoMapper = airHumidityPoMapper;
    }


}
