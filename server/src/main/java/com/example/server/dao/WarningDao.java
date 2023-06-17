package com.example.server.dao;

import com.example.server.dao.bo.SoilFc;
import com.example.server.dao.bo.Warning;
import com.example.server.mapper.SoilFcPoMapper;
import com.example.server.mapper.WarningPoMapper;
import com.example.server.mapper.po.SoilFcPo;
import com.example.server.mapper.po.WarningPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class WarningDao {

    private WarningPoMapper warningPoMapper;

    @Autowired
    public WarningDao(WarningPoMapper warningPoMapper){
        this.warningPoMapper = warningPoMapper;
    }

    public void insert(Warning warning){
        WarningPo warningPo=WarningPo.builder().id(warning.getId()).type(warning.getType()).value(warning.getValue()).time(warning.getTime()).build();
        this.warningPoMapper.save(warningPo);
    }

    public Warning findLatest() throws Exception{
        Warning bo=this.retrieveAll().stream().reduce((first,second)->second).orElse(null);
        if(null==bo){
            throw new Exception(SoilFc.class+"找不到最后一个元素");
        }else {
            return bo;
        }
    }

    public List<Warning> retrieveAll(){
        List<WarningPo> warningPos=this.warningPoMapper.findAll();
        List<Warning> boList=warningPos.stream().map(po->Warning.builder().id(po.getId()).type(po.getType()).value(po.getValue()).time(po.getTime()).build()).collect(Collectors.toList());
        return boList;
    }
}
