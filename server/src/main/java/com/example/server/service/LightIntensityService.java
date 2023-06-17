package com.example.server.service;

import com.example.server.Listener.LightIntensityListener;
import com.example.server.dao.LightIntensityDao;
import com.example.server.dao.WarningDao;
import com.example.server.dao.bo.LightIntensity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LightIntensityService {

    private LightIntensityDao lightIntensityDao;

    private LightIntensityListener lightIntensityListener;

    private WarningDao warningDao;
    @Autowired
    public LightIntensityService(LightIntensityDao lightIntensityDao, WarningDao warningDao){
        this.lightIntensityDao = lightIntensityDao;
        this.warningDao = warningDao;
        this.lightIntensityListener = new LightIntensityListener(lightIntensityDao, warningDao);
    }

    public void insert(LightIntensity lightIntensity){
        this.lightIntensityDao.insert(lightIntensity);
    }

    public LightIntensity findLatest(){
        LightIntensity bo=null;
        try {
            bo=this.lightIntensityDao.findLatest();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bo;
    }

    public List<LightIntensity> retrieveAll() {
        return this.lightIntensityDao.retrieveAll();
    }
}
