package com.das_web.das_web_spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.das_web.das_web_spring.Repository.CartsRepository;

@RestController
public class CartController {
    @Autowired
    CartsRepository cartsRepository;

    
}
