package com.example.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // 标注该类为Controller，SpringBoot会自动扫描该类
public class testController {
    @RequestMapping("/test")  // 处理请求路径为/test的请求
    public String test(){
        return "测试成功";
    }
}
