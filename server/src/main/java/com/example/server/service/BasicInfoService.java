package com.example.server.service;

import com.example.server.dao.BasicInfoDao;
import com.example.server.dao.bo.BasicInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicInfoService {

    private BasicInfoDao basicInfoDao;

    @Autowired
    public BasicInfoService(BasicInfoDao basicInfoDao){
        this.basicInfoDao = basicInfoDao;
    }

    public void insert(BasicInfo basicInfo){
        this.basicInfoDao.insert(basicInfo);
    }

    public BasicInfo findLatest(){
        BasicInfo bo = null;
        try {
            bo = this.basicInfoDao.findLatest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bo;
    }

    public List<BasicInfo> retrieveAll(){
        return this.basicInfoDao.retrieveAll();
    }

}
