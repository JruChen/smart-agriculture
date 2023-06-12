package com.example.server.service;

import com.example.server.dao.SoilPhDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoilPhService {

    private SoilPhDao soilPhDao;

    @Autowired
    public SoilPhService(SoilPhDao soilPhDao){
        this.soilPhDao = soilPhDao;
    }

}
