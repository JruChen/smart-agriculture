package com.example.server.dao;

import com.example.server.dao.bo.SoilPh;
import com.example.server.mapper.SoilPhPoMapper;
import com.example.server.mapper.po.SoilPhPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SoilPhDao {
    private SoilPhPoMapper soilPhPoMapper;

    @Autowired
    public SoilPhDao(SoilPhPoMapper soilPhPoMapper){
        this.soilPhPoMapper = soilPhPoMapper;
    }

    public void insert(SoilPh soilPh){
        SoilPhPo soilPhPo=SoilPhPo.builder().id(soilPh.getId()).value(soilPh.getValue()).time(soilPh.getTime()).build();
        this.soilPhPoMapper.save(soilPhPo);
    }

    public SoilPh findLatest() throws Exception{
        SoilPh bo=this.retrieveAll().stream().reduce((first,second)->second).orElse(null);
        if(null==bo){
            throw new Exception(SoilPh.class+"找不到最后一个元素");
        }else {
            return bo;
        }
    }

    public List<SoilPh> retrieveAll(){
        List<SoilPhPo> soilPhPos=this.soilPhPoMapper.findAll();
        List<SoilPh> boList=soilPhPos.stream().map(po->SoilPh.builder().id(po.getId()).value(po.getValue()).time(po.getTime()).build()).collect(Collectors.toList());
        return boList;
    }

}
