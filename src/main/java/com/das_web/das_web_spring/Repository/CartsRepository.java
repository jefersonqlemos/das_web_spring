package com.das_web.das_web_spring.Repository;

import org.springframework.data.repository.CrudRepository;

import com.das_web.das_web_spring.Model.Carts;

public interface CartsRepository extends CrudRepository<Carts, Integer>{

    Carts save(Carts cart);
    Carts deleteById(int id);
    
}
