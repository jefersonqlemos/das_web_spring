package com.das_web.das_web_spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.das_web.das_web_spring.Model.Products;
import com.das_web.das_web_spring.Repository.ProductsRepository;

@RestController
public class ProductController {
    @Autowired
    ProductsRepository productsRepository;

    @RequestMapping("/list-products")
    public @ResponseBody List<Products> listClients(){
        System.out.println(productsRepository.findAll());
        return productsRepository.findAll();
    }

    @RequestMapping("/product/{id}")
    public @ResponseBody Products getClient(@PathVariable int id){
        System.out.println(productsRepository.findById(id));
        return productsRepository.findById(id);
    }

    @PostMapping("/product")
    public @ResponseBody String postClient(@RequestBody Products product){
        System.out.println(product);
        productsRepository.save(product);
        return "OK";
    }

    @PutMapping("/product")
    public @ResponseBody String putClient(@RequestBody Products product){
        System.out.println(product);
        productsRepository.save(product);
        return "OK";
    }

    @DeleteMapping("/product/{id}")
    public @ResponseBody String deleteClient(@PathVariable int id){
        System.out.println(id);
        productsRepository.deleteById(id);
        return "OK";
    }
}
