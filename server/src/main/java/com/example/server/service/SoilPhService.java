package com.example.server.service;

import com.example.server.Listener.SoilPhListener;
import com.example.server.dao.SoilPhDao;
import com.example.server.dao.bo.SoilPh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoilPhService {

    private SoilPhDao soilPhDao;

    private SoilPhListener soilPhListener;

    @Autowired
    public SoilPhService(SoilPhDao soilPhDao){
        this.soilPhDao = soilPhDao;
        this.soilPhListener = new SoilPhListener(soilPhDao);
    }

    public void insert(SoilPh soilPh){
        this.soilPhDao.insert(soilPh);
    }

    public SoilPh findLatest(){
        SoilPh bo=null;
        try {
            bo=this.soilPhDao.findLatest();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bo;
    }

    public List<SoilPh> retrieveAll(){
        return this.soilPhDao.retrieveAll();
    }
}
