package com.example.server.dao;

import com.example.server.dao.bo.AirHumidity;
import com.example.server.mapper.AirHumidityPoMapper;
import com.example.server.mapper.po.AirHumidityPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AirHumidityDao {
    private AirHumidityPoMapper airHumidityPoMapper;

    @Autowired
    public AirHumidityDao(AirHumidityPoMapper airHumidityPoMapper){
        this.airHumidityPoMapper = airHumidityPoMapper;
    }

    public void insert(AirHumidity airHumidity){
        AirHumidityPo airHumidityPo=AirHumidityPo.builder().id(airHumidity.getId()).value(airHumidity.getValue()).time(airHumidity.getTime()).build();
        this.airHumidityPoMapper.save(airHumidityPo);
    }

    public AirHumidity findLatest() throws Exception{
        AirHumidity bo=this.retrieveAll().stream().reduce((first,second)->second).orElse(null);
        if(null==bo){
            throw new Exception(AirHumidity.class+"找不到最后一个元素");
        }else {
            return bo;
        }
    }

    public List<AirHumidity> retrieveAll(){
        List<AirHumidityPo> airHumidityPos=this.airHumidityPoMapper.findAll();
        List<AirHumidity> boList=airHumidityPos.stream().map(po->AirHumidity.builder().id(po.getId()).value(po.getValue()).time(po.getTime()).build()).collect(Collectors.toList());
        return boList;
    }


}
