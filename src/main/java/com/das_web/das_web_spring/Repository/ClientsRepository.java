package com.das_web.das_web_spring.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.das_web.das_web_spring.Model.Clients;

public interface ClientsRepository extends CrudRepository<Clients, Integer>{
    List<Clients> findAll();
    Clients findById(int id);
    Clients save(Clients client);
    Clients deleteById(int id);
}
