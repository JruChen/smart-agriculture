package com.example.server.service;

import com.example.server.Listener.SoilFcListener;
import com.example.server.dao.SoilFcDao;
import com.example.server.dao.WarningDao;
import com.example.server.dao.bo.SoilFc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoilFcService {

    private SoilFcDao soilFcDao;
    private WarningDao warningDao;

    private SoilFcListener soilFcListener;

    @Autowired
    public SoilFcService(SoilFcDao soilFcDao, WarningDao warningDao){
        this.soilFcDao = soilFcDao;
        this.warningDao = warningDao;
        this.soilFcListener = new SoilFcListener(soilFcDao, warningDao);
    }

    public void insert(SoilFc soilFc){
        this.soilFcDao.insert(soilFc);
    }

    public SoilFc findLatest(){
        SoilFc bo=null;
        try {
            bo=this.soilFcDao.findLatest();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bo;
    }

    public List<SoilFc> retrieveAll() {
        return this.soilFcDao.retrieveAll();
    }
}
