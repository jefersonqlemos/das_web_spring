package com.das_web.das_web_spring;

import org.springframework.web.bind.annotation.*;

@RestController
public class Home {

    @RequestMapping("/")
    public String home(){
        return "ok";
    }
}
