package com.example.server.service;

import com.example.server.dao.SoilHumidityDao;
import com.example.server.dao.bo.SoilHumidity;
import com.example.server.mapper.po.SoilHumidityPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoilHumidityService {

    private SoilHumidityDao soilHumidityDao;

    @Autowired
    public SoilHumidityService(SoilHumidityDao soilHumidityDao){
        this.soilHumidityDao = soilHumidityDao;
    }

    public void insert(SoilHumidity soilHumidity){
        this.soilHumidityDao.insert(soilHumidity);
    }

    public SoilHumidity findLatest(){
        SoilHumidity bo=null;
        try {
            bo=this.soilHumidityDao.findLatest();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bo;
    }

    public List<SoilHumidity> retrieveAll() {
        return this.soilHumidityDao.retrieveAll();
    }
}
