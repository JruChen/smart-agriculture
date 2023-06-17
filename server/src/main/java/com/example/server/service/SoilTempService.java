package com.example.server.service;

import com.example.server.Listener.SoilTempListener;
import com.example.server.dao.SoilTempDao;
import com.example.server.dao.bo.SoilTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoilTempService {

    private SoilTempDao soilTempDao;

    private SoilTempListener soilTempListener;

    @Autowired
    public SoilTempService(SoilTempDao soilTempDao){
        this.soilTempDao = soilTempDao;
        this.soilTempListener = new SoilTempListener(soilTempDao);
    }

    public void insert(SoilTemp soilTemp){
        this.soilTempDao.insert(soilTemp);
    }

    public SoilTemp findLatest(){
        SoilTemp bo=null;
        try{
            bo=this.soilTempDao.findLatest();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bo;
    }

    public List<SoilTemp> retrieveAll() {
        return this.soilTempDao.retrieveAll();
    }
}
