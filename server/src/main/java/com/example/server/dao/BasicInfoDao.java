package com.example.server.dao;

import com.example.server.dao.bo.BasicInfo;
import com.example.server.mapper.BasicInfoPoMapper;
import com.example.server.mapper.po.BasicInfoPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BasicInfoDao {
    private BasicInfoPoMapper basicInfoPoMapper;

    @Autowired
    public BasicInfoDao(BasicInfoPoMapper basicInfoPoMapper){
        this.basicInfoPoMapper = basicInfoPoMapper;
    }

    public void insert(BasicInfo basicInfo){
        BasicInfoPo basicInfoPo = BasicInfoPo.builder().id(basicInfo.getId()).name(basicInfo.getName())
                .yield(basicInfo.getYield()).area(basicInfo.getArea()).dan(basicInfo.getDan())
                .lin(basicInfo.getLin()).jia(basicInfo.getJia()).build();
        this.basicInfoPoMapper.save(basicInfoPo);
    }

    public BasicInfo findById(Long id) throws Exception {
        Optional<BasicInfoPo> po = this.basicInfoPoMapper.findById(id);
        if(po.isPresent()){
            BasicInfoPo basicInfoPo = po.get();
            BasicInfo bo = BasicInfo.builder().id(basicInfoPo.getId()).name(basicInfoPo.getName()).yield(basicInfoPo.getYield())
                    .area(basicInfoPo.getArea()).dan(basicInfoPo.getDan()).lin(basicInfoPo.getLin()).jia(basicInfoPo.getJia()).build();
            return bo;
        }
        else {
            throw new Exception();
        }
    }

    public BasicInfo findLatest() throws Exception {
        BasicInfo bo = this.retrieveAll().stream().reduce((first, second)->second).orElse(null);
        if( null == bo){
            throw new Exception( BasicInfo.class +"找不到最后一个元素");
        }else{
            return bo;
        }
    }

    public List<BasicInfo> retrieveAll(){
        List<BasicInfoPo> basicInfos = this.basicInfoPoMapper.findAll();
        List<BasicInfo> boList = basicInfos.stream().map(po->BasicInfo.builder().id(po.getId()).name(po.getName())
                .yield(po.getYield()).area(po.getArea()).dan(po.getDan()).lin(po.getLin())
                .jia(po.getJia()).build()).collect(Collectors.toList());
        return boList;
    }
}
