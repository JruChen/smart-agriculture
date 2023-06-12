package com.example.server.dao;

import com.example.server.mapper.SoilPhPoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Repository;

@Repository
public class SoilPhDao {
    private SoilPhPoMapper soilPhPoMapper;

    @Autowired
    public SoilPhDao(SoilPhPoMapper soilPhPoMapper){
        this.soilPhPoMapper = soilPhPoMapper;
    }


}
