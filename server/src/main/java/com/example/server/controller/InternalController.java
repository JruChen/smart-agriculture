package com.example.server.controller;

import com.example.server.dao.bo.BasicInfo;
import com.example.server.service.BasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class InternalController {

    private BasicInfoService basicInfoService;

    @Autowired
    public InternalController(BasicInfoService basicInfoService){
        this.basicInfoService = basicInfoService;
    }

    @PostMapping("/speciesAreaYield")
    public List<BasicInfo> retrieveBasicInfo(){
        return this.basicInfoService.retrieveAll();
    }

}
