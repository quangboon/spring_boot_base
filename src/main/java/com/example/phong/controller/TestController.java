package com.example.phong.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class TestController {
    
    @GetMapping("/index")
    public String index(){
          return LocalDate.now().toString(); 
    }
    
}
