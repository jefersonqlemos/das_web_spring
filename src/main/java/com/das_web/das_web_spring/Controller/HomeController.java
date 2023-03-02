package com.das_web.das_web_spring.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "ok";
    }
}
