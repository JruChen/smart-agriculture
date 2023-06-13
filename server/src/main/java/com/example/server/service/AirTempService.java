package com.example.server.service;

import com.example.server.dao.AirTempDao;
import com.example.server.dao.bo.AirTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirTempService {

    private AirTempDao airTempDao;

    @Autowired
    public AirTempService(AirTempDao airTempDao){
        this.airTempDao = airTempDao;
    }

    public void insert(AirTemp airTemp) {
        this.airTempDao.insert(airTemp);
    }

    public AirTemp findLatest(){
        AirTemp bo=null;
        try {
            bo=this.airTempDao.findLatest();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bo;
    }

    public List<AirTemp> retrieveAll() {
        return this.airTempDao.retrieveAll();
    }
}
