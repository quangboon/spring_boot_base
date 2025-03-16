package com.example.phong.demo.service.impl;
import com.example.phong.demo.service.TestService;
import org.springframework.stereotype.Service;




@Service
public class TestServiceImpl implements TestService {

    @Override
    public String getTestMessage() {
        return "Hello from TestService!";
    }
}