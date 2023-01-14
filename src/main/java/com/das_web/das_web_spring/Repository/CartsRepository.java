package com.das_web.das_web_spring.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.das_web.das_web_spring.Model.Carts;

public interface CartsRepository extends CrudRepository<Carts, Integer>{

    List<Carts> findAll();
    Carts save(Carts cart);
    Carts deleteById(int id);
    Carts findById(int id);
    Carts findByClientId(int clientId);
    
}
