package com.example.server.dao;

import com.example.server.dao.bo.AirTemp;
import com.example.server.mapper.AirTempPoMapper;
import com.example.server.mapper.po.AirTempPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AirTempDao {
    private AirTempPoMapper airTempPoMapper;

    @Autowired
    public AirTempDao(AirTempPoMapper airTempPoMapper){
        this.airTempPoMapper = airTempPoMapper;
    }

    public void insert(AirTemp airTemp){
        AirTempPo airTempPo=AirTempPo.builder().id(airTemp.getId()).value(airTemp.getValue()).time(airTemp.getTime()).build();
        this.airTempPoMapper.save(airTempPo);
    }

    public AirTemp findLatest() throws Exception{
        AirTemp bo=this.retrieveAll().stream().reduce((first,second)->second).orElse(null);
        if(null==bo){
            throw new Exception(AirTemp.class+"找不到最后一个元素");
        }else {
            return bo;
        }
    }

    public List<AirTemp> retrieveAll(){
        List<AirTempPo> airTempPos=this.airTempPoMapper.findAll();
        List<AirTemp> boList=airTempPos.stream().map(po->AirTemp.builder().id(po.getId()).value(po.getValue()).time(po.getTime()).build()).collect(Collectors.toList());
        return boList;
    }
}
