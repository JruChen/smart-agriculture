package com.example.server.service;

import com.example.server.dao.AirHumidityDao;
import com.example.server.dao.bo.AirHumidity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirHumidityService {

    private AirHumidityDao airHumidityDao;

    @Autowired
    public AirHumidityService(AirHumidityDao airHumidityDao){
        this.airHumidityDao = airHumidityDao;
    }

    public void insert(AirHumidity airHumidity) {
        this.airHumidityDao.insert(airHumidity);
    }

    public AirHumidity findLatest(){
        AirHumidity bo=null;
        try {
            bo=this.airHumidityDao.findLatest();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bo;
    }

    public List<AirHumidity> retrieveAll() {
        return this.airHumidityDao.retrieveAll();
    }
}
