package com.example.server.service;

import com.example.server.dao.SoilFcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoilFcService {

    private SoilFcDao soilFcDao;

    @Autowired
    public SoilFcService(SoilFcDao soilFcDao){
        this.soilFcDao = soilFcDao;
    }

}
