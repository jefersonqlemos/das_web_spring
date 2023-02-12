package com.das_web.das_web_spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.das_web.das_web_spring.Model.CartProducts;
import com.das_web.das_web_spring.Model.Carts;
import com.das_web.das_web_spring.Model.OrderProducts;
import com.das_web.das_web_spring.Model.Orders;
import com.das_web.das_web_spring.Repository.CartProductsRepository;
import com.das_web.das_web_spring.Repository.CartsRepository;
import com.das_web.das_web_spring.Repository.OrderProductsRepository;
import com.das_web.das_web_spring.Repository.OrdersRepository;

@RestController
public class OrderController {
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    CartsRepository cartsRepository;

    @Autowired
    CartProductsRepository cartProductsRepository;

    @Autowired
    OrderProductsRepository orderProductsRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/order/{id}")
    public @ResponseBody String postOrder(@PathVariable int id){
            
        Carts cartClient = this.cartsRepository.findById(id);

        Orders orderClient = new Orders();

        orderClient.setId(cartClient.getId());
        orderClient.setClientId(cartClient.getClientId());
        orderClient.setTotalValue(cartClient.getTotalValue());

        ordersRepository.save(orderClient);

        List<CartProducts> cartProducts = cartProductsRepository.findByCartId(id);
            
        OrderProducts orderProducts = null; 

        for (CartProducts cartProduct : cartProducts) {
            orderProducts.setOrderId(cartProduct.getId());
            orderProducts.setProductId(cartProduct.getProductId());
            orderProducts.setQuantity(cartProduct.getQuantity());
            orderProducts.setValue(cartProduct.getValue());
            orderProductsRepository.save(orderProducts);
            cartProductsRepository.deleteById(cartProduct.getId());
        }

        cartsRepository.deleteById(id);
            
        //System.out.println(cart);

        return "OK";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list-orders")
    public @ResponseBody  List<Orders> getOrder(){
        return ordersRepository.findAll();
    }

    @GetMapping("/order_product/{id}")
    public @ResponseBody  List<OrderProducts> getOrderProduct(@PathVariable int id){
        return orderProductsRepository.findByOrderId(id);
    }
}