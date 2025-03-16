package com.example.phong.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.phong.demo.service.TestService;



@RestController
public class TestController {

    @Autowired
    private TestService testService;
    
    @RequestMapping(value = "/v1/api/echo", method = RequestMethod.GET)
    public String index() {
        return testService.getTestMessage();
    }
}