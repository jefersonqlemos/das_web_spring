package com.das_web.das_web_spring.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.das_web.das_web_spring.Model.Clientes;

public interface ClientesRepository extends CrudRepository<Clientes, Integer>{
    List<Clientes> findAll();
}
