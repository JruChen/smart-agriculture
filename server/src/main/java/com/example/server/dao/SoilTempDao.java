package com.example.server.dao;

import com.example.server.dao.bo.SoilTemp;
import com.example.server.mapper.SoilTempPoMapper;
import com.example.server.mapper.po.SoilTempPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SoilTempDao {
    private SoilTempPoMapper soilTempPoMapper;

    @Autowired
    public SoilTempDao(SoilTempPoMapper soilTempPoMapper){
        this.soilTempPoMapper = soilTempPoMapper;
    }

    public void insert(SoilTemp soilTemp){
        SoilTempPo soilTempPo=SoilTempPo.builder().id(soilTemp.getId()).value(soilTemp.getValue()).time(soilTemp.getTime()).build();
        this.soilTempPoMapper.save(soilTempPo);
    }

    public SoilTemp findLatest() throws Exception{
        SoilTemp bo=this.retrieveAll().stream().reduce((first,second)->second).orElse(null);
        if(null==bo){
            throw new Exception(SoilTemp.class+"找不到最后一个元素");
        }else {
            return bo;
        }
    }

    public List<SoilTemp> retrieveAll(){
        List<SoilTempPo> soilTempPos=this.soilTempPoMapper.findAll();
        List<SoilTemp> boList=soilTempPos.stream().map(po->SoilTemp.builder().id(po.getId()).value(po.getValue()).time(po.getTime()).build()).collect(Collectors.toList());
        return boList;
    }
}
