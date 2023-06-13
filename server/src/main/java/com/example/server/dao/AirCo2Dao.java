package com.example.server.dao;

import com.example.server.dao.bo.AirCo2;
import com.example.server.mapper.AirCo2PoMapper;
import com.example.server.mapper.po.AirCo2Po;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AirCo2Dao {
    private AirCo2PoMapper airCo2PoMapper;

    @Autowired
    public AirCo2Dao(AirCo2PoMapper airCo2PoMapper){
        this.airCo2PoMapper = airCo2PoMapper;
    }

    public void insert(AirCo2 airCo2){
        AirCo2Po airCo2Po=AirCo2Po.builder().id(airCo2.getId()).value(airCo2.getValue()).time(airCo2.getTime()).build();
        this.airCo2PoMapper.save(airCo2Po);
    }

    public AirCo2 findLatest() throws Exception {
        AirCo2 bo=this.retrieveAll().stream().reduce((first,second)->second).orElse(null);
        if(null==bo){
            throw new Exception(AirCo2.class+"找不到最后一个元素");
        }else {
            return bo;
        }
    }

    public List<AirCo2> retrieveAll(){
        List<AirCo2Po> airCo2Pos=this.airCo2PoMapper.findAll();
        List<AirCo2> boList=airCo2Pos.stream().map(po->AirCo2.builder().id(po.getId()).value(po.getValue()).time(po.getTime()).build()).collect(Collectors.toList());
        return boList;
    }
}
