package com.das_web.das_web_spring.Repository;

import org.springframework.data.repository.CrudRepository;

import com.das_web.das_web_spring.Model.OrderProducts;

import java.util.List;

public interface OrderProductsRepository extends CrudRepository<OrderProducts, Integer>{
    List<OrderProducts> findAll();
    OrderProducts findById(int id);
    OrderProducts save(OrderProducts orderProducts);
    List<OrderProducts> findByOrderId(int id);
}
