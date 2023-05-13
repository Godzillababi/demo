package com.example.demo.jcy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringbootController {

    @Value("${school.name}")
    private String schoolName;

    @Value("${school.web}")
    private String web;

    @RequestMapping(value = "/hello")
    public  String say() {
        return schoolName + "------" + web;
    }

}
