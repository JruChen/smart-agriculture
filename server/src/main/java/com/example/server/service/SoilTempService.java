package com.example.server.service;

import com.example.server.dao.SoilTempDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoilTempService {

    private SoilTempDao soilTempDao;

    @Autowired
    public SoilTempService(SoilTempDao soilTempDao){
        this.soilTempDao = soilTempDao;
    }

}
