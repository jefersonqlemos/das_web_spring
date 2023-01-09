package com.das_web.das_web_spring.Repository;

import org.springframework.data.repository.CrudRepository;

import com.das_web.das_web_spring.Model.CartProducts;

import java.util.List;

public interface CartProductsRepository extends CrudRepository<CartProducts, Integer>{
    List<CartProducts> findAll();
    CartProducts findById(int id);
    CartProducts findByProductIdAndCartId(int productId, int cartId);
    CartProducts save(CartProducts cartProducts);
    CartProducts deleteById(int id);
}
