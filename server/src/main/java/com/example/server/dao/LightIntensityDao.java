package com.example.server.dao;

import com.example.server.dao.bo.LightIntensity;
import com.example.server.mapper.LightIntensityPoMapper;
import com.example.server.mapper.po.LightIntensityPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LightIntensityDao {
    private LightIntensityPoMapper lightIntensityPoMapper;

    @Autowired
    public LightIntensityDao(LightIntensityPoMapper lightIntensityPoMapper){
        this.lightIntensityPoMapper = lightIntensityPoMapper;
    }

    public void insert(LightIntensity lightIntensity){
        LightIntensityPo lightIntensityPo=LightIntensityPo.builder().id(lightIntensity.getId()).value(lightIntensity.getValue()).time(lightIntensity.getTime()).build();
        this.lightIntensityPoMapper.save(lightIntensityPo);
    }

    public LightIntensity findLatest() throws Exception {
        LightIntensity bo=this.retrieveAll().stream().reduce((first,second)->second).orElse(null);
        if(null==bo){
            throw new Exception(LightIntensity.class+"找不到最后一个元素");
        }else {
            return bo;
        }
    }

    public List<LightIntensity> retrieveAll(){
        List<LightIntensityPo> lightIntensityPos=this.lightIntensityPoMapper.findAll();
        List<LightIntensity> boList=lightIntensityPos.stream().map(po->LightIntensity.builder().id(po.getId()).value(po.getValue()).time(po.getTime()).build()).collect(Collectors.toList());
        return boList;
    }
}
