package com.das_web.das_web_spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.das_web.das_web_spring.Repository.OrderProductsRepository;
import com.das_web.das_web_spring.Repository.OrdersRepository;

@RestController
public class OrderController {
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrderProductsRepository orderProductsRepository;
}
