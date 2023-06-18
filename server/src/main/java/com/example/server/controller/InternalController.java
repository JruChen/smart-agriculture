package com.example.server.controller;

import com.example.server.dao.bo.*;
import com.example.server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
//@RequestMapping(produces = "application/json;charset=UTF-8")
@Controller
public class InternalController {

    private BasicInfoService basicInfoService;
    private AirCo2Service airCo2Service;
    private AirHumidityService airHumidityService;
    private AirTempService airTempService;
    private LightIntensityService lightIntensityService;
    private SoilFcService soilFcService;
    private SoilHumidityService soilHumidityService;
    private SoilPhService soilPhService;
    private SoilTempService soilTempService;
    private WarningService warningService;

    @Autowired
    public InternalController(BasicInfoService basicInfoService, AirCo2Service airCo2Service, AirHumidityService airHumidityService,
                              AirTempService airTempService, LightIntensityService lightIntensityService, SoilFcService soilFcService,
                              SoilHumidityService soilHumidityService, SoilPhService soilPhService, SoilTempService soilTempService,
                              WarningService warningService){
        this.basicInfoService = basicInfoService;
        this.airCo2Service = airCo2Service;
        this.airHumidityService = airHumidityService;
        this.airTempService = airTempService;
        this.lightIntensityService = lightIntensityService;
        this.soilFcService = soilFcService;
        this.soilHumidityService = soilHumidityService;
        this.soilPhService = soilPhService;
        this.soilTempService = soilTempService;
        this.warningService = warningService;
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

    @PostMapping("/plantYield")
    @ResponseBody
    public List<Map<String,Object>> plantYield() {
        List<BasicInfo> basicInfoList=this.basicInfoService.retrieveAll();
        //找到list中每个BasicInfo对象的name和yield属性，分别对应ydata中的name和value
        List<Map<String,Object>> result=new ArrayList<>();

        for(BasicInfo basicInfo:basicInfoList) {
            Map<String, Object> data = new HashMap<>();
            data.put("name", basicInfo.getName());
            data.put("value", basicInfo.getYield());
            result.add(data);
        }
        return result;
    }

    @PostMapping("/plantSoil")
    @ResponseBody
    public List<Map<String,Object>> plantSoil(){
        List<BasicInfo> basicInfoList=this.basicInfoService.retrieveAll();
        //找到list中每个BasicInfo对象的name和dan lin jia属性，分别对应text name value(每种作物按顺序)
        List<Map<String,Object>> result=new ArrayList<>();
        for(BasicInfo basicInfo:basicInfoList){
            Map<String,Object> data=new HashMap<>();
            data.put("name",basicInfo.getName());
            data.put("danValue",basicInfo.getDan());
            data.put("linValue",basicInfo.getLin());
            data.put("jiaValue",basicInfo.getJia());
            result.add(data);
        }
        return result;
    }

    @PostMapping("/airAndSoilTemp")
    @ResponseBody
    public List<Map<String,Object>> airAndSoilTemp(){
        List<SoilTemp> soilTempList=this.soilTempService.retrieveAll();
        List<AirTemp> airTempList=this.airTempService.retrieveAll();
        //遍历两个list，如果时间戳相同，就记录时间戳，放入time中，并分别将值放入soilTempValue和soilHumidityValue中
        List<Map<String,Object>> result=new ArrayList<>();

        // 遍历两个list，如果两个list对象中对应的时间戳相同，就记录时间戳，放入time中，并分别将值放入soilTempValue和soilHumidityValue中
        for (AirTemp airTemp : airTempList) {
            for (SoilTemp soilTemp : soilTempList) {
                if (airTemp.getTime().equals(soilTemp.getTime())) {
                    Map<String, Object> data = new HashMap<>();
                    data.put("time", airTemp.getTime());
                    data.put("airTempValue", airTemp.getValue());
                    data.put("soilTempValue", soilTemp.getValue());
                    result.add(data);
                    break;
                }
            }
        }

        return result;
    }

    @PostMapping("/lightIntensity")
    @ResponseBody
    public List<Map<String,Object>> lightIntensity(){
        List<LightIntensity> lightIntensityList=this.lightIntensityService.retrieveAll();
        List<Map<String,Object>> result=new ArrayList<>();
        for(LightIntensity lightIntensity:lightIntensityList){
            Map<String, Object> data = new HashMap<>();
            data.put("time",lightIntensity.getTime());
            data.put("lightIntensity",lightIntensity.getValue());
            result.add(data);
        }
        return result;
    }

    @PostMapping("/soilPH")
    @ResponseBody
    public List<Map<String,Object>> soilPH(){
        List<SoilPh> soilPhList=this.soilPhService.retrieveAll();
        List<Map<String,Object>> result=new ArrayList<>();
        for(SoilPh soilPh:soilPhList){
            Map<String, Object> data = new HashMap<>();
            data.put("time",soilPh.getTime());
            data.put("soilPH",soilPh.getValue());
            result.add(data);
        }
        return result;
    }

    //空气和土壤湿度
    @PostMapping("/airAndSoilHumidity")
    @ResponseBody
    public List<Map<String,Object>> airAndSoilHumidity(){
        List<AirHumidity> airHumidityList=this.airHumidityService.retrieveAll();
        List<SoilHumidity> soilHumidityList=this.soilHumidityService.retrieveAll();
        //遍历两个list，如果时间戳相同，就记录时间戳，放入time中，并分别将值放入soilTempValue和soilHumidityValue中
        List<Map<String,Object>> result=new ArrayList<>();

        // 遍历两个list，如果两个list对象中对应的时间戳相同，就记录时间戳，放入time中，并分别将值放入soilTempValue和soilHumidityValue中
        for (AirHumidity airHumidity :airHumidityList) {
            for (SoilHumidity soilHumidity: soilHumidityList) {
                if (airHumidity.getTime().equals(soilHumidity.getTime())) {
                    Map<String, Object> data = new HashMap<>();
                    data.put("time", airHumidity.getTime());
                    data.put("airHumidityValue", airHumidity.getValue());
                    data.put("soilHumidityValue", soilHumidity.getValue());
                    result.add(data);
                    break;
                }
            }
        }
        return result;
    }

    //二氧化碳浓度
    @PostMapping("/airCo2")
    @ResponseBody
    public List<Map<String,Object>> airCo2(){
        List<AirCo2> airCo2List=this.airCo2Service.retrieveAll();
        List<Map<String,Object>> result=new ArrayList<>();
        for(AirCo2 airCo2:airCo2List){
            Map<String, Object> data = new HashMap<>();
            data.put("time",airCo2.getTime());
            data.put("airCo2",airCo2.getValue());
            result.add(data);
        }
        return result;
    }

    //土壤FC值
    @PostMapping("/soilFC")
    @ResponseBody
    public List<Map<String,Object>> soilFC(){
        List<SoilFc> soilFcList=this.soilFcService.retrieveAll();
        List<Map<String,Object>> result=new ArrayList<>();
        for(SoilFc soilFc:soilFcList){
            Map<String, Object> data = new HashMap<>();
            data.put("time",soilFc.getTime());
            data.put("soilFC",soilFc.getValue());
            result.add(data);
        }
        return result;
    }

    @PostMapping("/parameters")
    @ResponseBody
    public List<Double> parameters() {
        List<Double> parameters = new ArrayList<>();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        AirTemp airTemp = this.airTempService.findLatest();
        parameters.add(Double.parseDouble(decimalFormat.format(airTemp.getValue())));

        AirHumidity airHumidity = this.airHumidityService.findLatest();
        parameters.add(Double.parseDouble(decimalFormat.format(airHumidity.getValue())));

        LightIntensity lightIntensity = this.lightIntensityService.findLatest();
        parameters.add(Double.parseDouble(decimalFormat.format(lightIntensity.getValue())));

        AirCo2 airCo2 = this.airCo2Service.findLatest();
        parameters.add(Double.parseDouble(decimalFormat.format(airCo2.getValue())));

        SoilTemp soilTemp = this.soilTempService.findLatest();
        parameters.add(Double.parseDouble(decimalFormat.format(soilTemp.getValue())));

        SoilHumidity soilHumidity = this.soilHumidityService.findLatest();
        parameters.add(Double.parseDouble(decimalFormat.format(soilHumidity.getValue())));

        SoilPh soilPh = this.soilPhService.findLatest();
        parameters.add(Double.parseDouble(decimalFormat.format(soilPh.getValue())));

        SoilFc soilFc = this.soilFcService.findLatest();
        parameters.add(Double.parseDouble(decimalFormat.format(soilFc.getValue())));

        return parameters;
    }


    //警报信息
    @PostMapping("/warnMessages")
    @ResponseBody
    public List<String> warnMessages(){
        List<Warning> warningList=this.warningService.retrieveAllWarnings();
        List<String> messages = new ArrayList<>();
        //遍历list，将对象的time type 和value值进行拼接，拼接为String，最后返回
        for (Warning warning : warningList) {
            String message = warning.getTime() + " " + warning.getType() + ": " + warning.getValue();
            messages.add(message);
        }
        return messages;
    }
}
