package com.example.server.service;

import com.example.server.dao.AirTempDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirTempService {

    private AirTempDao airTempDao;

    @Autowired
    public AirTempService(AirTempDao airTempDao){
        this.airTempDao = airTempDao;
    }
}
