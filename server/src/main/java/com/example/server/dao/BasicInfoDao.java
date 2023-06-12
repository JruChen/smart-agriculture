package com.example.server.dao;

import com.example.server.dao.bo.BasicInfo;
import com.example.server.mapper.BasicInfoPoMapper;
import com.example.server.mapper.po.BasicInfoPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BasicInfoDao {
    private BasicInfoPoMapper basicInfoPoMapper;

    @Autowired
    public BasicInfoDao(BasicInfoPoMapper basicInfoPoMapper){
        this.basicInfoPoMapper = basicInfoPoMapper;
    }

    public void insert(BasicInfo basicInfo){

    }
}
