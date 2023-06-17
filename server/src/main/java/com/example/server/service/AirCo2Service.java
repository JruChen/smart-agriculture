package com.example.server.service;

import com.example.server.Listener.AirCo2Listener;
import com.example.server.dao.AirCo2Dao;
import com.example.server.dao.bo.AirCo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirCo2Service {

    private AirCo2Dao airCo2Dao;
    private AirCo2Listener airCo2Listener;

    @Autowired
    public AirCo2Service(AirCo2Dao airCo2Dao){
        this.airCo2Dao = airCo2Dao;
        this.airCo2Listener = new AirCo2Listener(airCo2Dao);
    }

    public void insert(AirCo2 airCo2){
        this.airCo2Dao.insert(airCo2);
    }

    public AirCo2 findLatest(){
        AirCo2 bo=null;
        try{
            bo=this.airCo2Dao.findLatest();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bo;
    }

    public List<AirCo2> retrieveAll() {
        return this.airCo2Dao.retrieveAll();
    }
}
