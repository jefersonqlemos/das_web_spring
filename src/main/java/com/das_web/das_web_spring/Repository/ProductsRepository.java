package com.das_web.das_web_spring.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.das_web.das_web_spring.Model.Products;

public interface ProductsRepository extends CrudRepository<Products, Integer>{
    List<Products> findAll();
    Products findById(int id);
    Products save(Products product);
    Products deleteById(int id);
}
