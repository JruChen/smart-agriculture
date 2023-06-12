package com.example.server.dao;

import com.example.server.mapper.AirCo2PoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AirCo2Dao {
    private AirCo2PoMapper airCo2PoMapper;

    @Autowired
    public AirCo2Dao(AirCo2PoMapper airCo2PoMapper){
        this.airCo2PoMapper = airCo2PoMapper;
    }
}
