package com.example.server.dao;

import com.example.server.mapper.SoilTempPoMapper;
import com.example.server.mapper.po.SoilTempPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SoilTempDao {
    private SoilTempPoMapper soilTempPoMapper;

    @Autowired
    public SoilTempDao(SoilTempPoMapper soilTempPoMapper){
        this.soilTempPoMapper = soilTempPoMapper;
    }


}
