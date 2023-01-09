package com.das_web.das_web_spring.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.das_web.das_web_spring.Model.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer>{
    List<Orders> findAll();
    Orders findById(int id);
    Orders save(Orders order);
    Orders deleteById(int id);
}
