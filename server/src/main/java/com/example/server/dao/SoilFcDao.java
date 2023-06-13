package com.example.server.dao;

import com.example.server.dao.bo.SoilFc;
import com.example.server.mapper.SoilFcPoMapper;
import com.example.server.mapper.po.SoilFcPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SoilFcDao {
    private SoilFcPoMapper soilFcPoMapper;

    @Autowired
    public SoilFcDao(SoilFcPoMapper soilFcPoMapper){
        this.soilFcPoMapper = soilFcPoMapper;
    }

    public void insert(SoilFc soilFc){
        SoilFcPo soilFcPo=SoilFcPo.builder().id(soilFc.getId()).value(soilFc.getValue()).time(soilFc.getTime()).build();
        this.soilFcPoMapper.save(soilFcPo);
    }

    public SoilFc findLatest() throws Exception{
        SoilFc bo=this.retrieveAll().stream().reduce((first,second)->second).orElse(null);
        if(null==bo){
            throw new Exception(SoilFc.class+"找不到最后一个元素");
        }else {
            return bo;
        }
    }

    public List<SoilFc> retrieveAll(){
        List<SoilFcPo> soilFcPos=this.soilFcPoMapper.findAll();
        List<SoilFc> boList=soilFcPos.stream().map(po->SoilFc.builder().id(po.getId()).value(po.getValue()).time(po.getTime()).build()).collect(Collectors.toList());
        return boList;
    }
}
