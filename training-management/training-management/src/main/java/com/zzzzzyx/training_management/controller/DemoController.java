package com.zzzzzyx.training_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping("index.do")
    public String index(){
    	System.out.println("demo.jsp");
        return "demo";
    }
}