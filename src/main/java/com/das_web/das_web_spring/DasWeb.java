package com.das_web.das_web_spring;

import org.springframework.web.bind.annotation.*;

@RestController
public class DasWeb {

    @RequestMapping("/")
    public String home(){
        return "ok";
    }
}
