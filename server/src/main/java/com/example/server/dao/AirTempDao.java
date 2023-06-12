package com.example.server.dao;

import com.example.server.mapper.AirTempPoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AirTempDao {
    private AirTempPoMapper airTempPoMapper;

    @Autowired
    public AirTempDao(AirTempPoMapper airTempPoMapper){
        this.airTempPoMapper = airTempPoMapper;
    }
}
