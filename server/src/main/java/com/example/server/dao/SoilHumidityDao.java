package com.example.server.dao;

import com.example.server.dao.bo.SoilHumidity;
import com.example.server.mapper.SoilHumidityPoMapper;
import com.example.server.mapper.po.SoilHumidityPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SoilHumidityDao {
    private SoilHumidityPoMapper soilHumidityPoMapper;

    @Autowired
    public SoilHumidityDao(SoilHumidityPoMapper soilHumidityPoMapper){
        this.soilHumidityPoMapper = soilHumidityPoMapper;
    }

    public void insert(SoilHumidity soilHumidity){
        SoilHumidityPo soilHumidityPo=SoilHumidityPo.builder().id(soilHumidity.getId()).value(soilHumidity.getValue()).time(soilHumidity.getTime()).build();
        this.soilHumidityPoMapper.save(soilHumidityPo);
    }

    public SoilHumidity findLatest() throws Exception {
        SoilHumidity bo=this.retrieveAll().stream().reduce((first,second)->second).orElse(null);
        if(null==bo){
            throw new Exception(SoilHumidity.class+"找不到最后一个元素");
        }else {
            return bo;
        }
    }

    public List<SoilHumidity> retrieveAll(){
        List<SoilHumidityPo> soilHumidityPos=this.soilHumidityPoMapper.findAll();
        List<SoilHumidity> boList=soilHumidityPos.stream().map(po->SoilHumidity.builder().id(po.getId()).value(po.getValue()).time(po.getTime()).build()).collect(Collectors.toList());
        return boList;
    }

}
