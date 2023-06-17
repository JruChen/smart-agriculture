package com.example.server.controller;

import com.example.server.dao.bo.BasicInfo;
import com.example.server.service.BasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
//@RequestMapping(produces = "application/json;charset=UTF-8")
@Controller
public class InternalController {

    private BasicInfoService basicInfoService;

    @Autowired
    public InternalController(BasicInfoService basicInfoService){
        this.basicInfoService = basicInfoService;
    }

    @PostMapping("/speciesAreaYield")
    @ResponseBody
    public List<Map<String, Object>> retrieveBasicInfo(){
        List<BasicInfo> basicInfos = this.basicInfoService.retrieveAll();
        List<Map<String, Object>> result = new ArrayList<>();

        for(BasicInfo basicInfo: basicInfos){
            Map<String, Object> data = new HashMap<>();
            data.put("name", basicInfo.getName());
            data.put("area", basicInfo.getArea());
            data.put("yield", basicInfo.getYield());
            result.add(data);
        }
        return result;
    }

}
