package com.example.server.service;

import com.example.server.dao.AirCo2Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirCo2Service {

    private AirCo2Dao airCo2Dao;

    @Autowired
    public AirCo2Service(AirCo2Dao airCo2Dao){
        this.airCo2Dao = airCo2Dao;
    }

}
