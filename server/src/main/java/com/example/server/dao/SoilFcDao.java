package com.example.server.dao;

import com.example.server.mapper.SoilFcPoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SoilFcDao {
    private SoilFcPoMapper soilFcPoMapper;

    @Autowired
    public SoilFcDao(SoilFcPoMapper soilFcPoMapper){
        this.soilFcPoMapper = soilFcPoMapper;
    }
}
