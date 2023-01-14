package com.das_web.das_web_spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.das_web.das_web_spring.Model.CartProducts;
import com.das_web.das_web_spring.Model.Carts;
import com.das_web.das_web_spring.Repository.CartsRepository;
import com.das_web.das_web_spring.Repository.ProductsRepository;
import com.das_web.das_web_spring.Repository.CartProductsRepository;

@RestController
public class CartController {
    @Autowired
    CartsRepository cartsRepository;

    @Autowired
    CartProductsRepository cartProductsRepository;

    @Autowired
    ProductsRepository productsRepository;

    @PostMapping("/cart")
    public @ResponseBody Carts postCart(@RequestBody Carts cart){
        
        Carts cartClient = this.cartsRepository.findByClientId(cart.getClientId());
        
        if(cartClient == null){
            cartsRepository.save(cart);
            cartClient = this.cartsRepository.findByClientId(cart.getClientId());
        }
        
        //System.out.println(cart);

        return cartClient;
    }

    @PostMapping("/cart_product")
    public @ResponseBody String postCartProduct(@RequestBody CartProducts cartProduct){
        
        CartProducts cartProductClient = this.cartProductsRepository.findByProductIdAndCartId(cartProduct.getProductId(), cartProduct.getCartId());

        if(cartProductClient == null){
            cartProduct.setValue(productsRepository.findById(cartProduct.getProductId()).getValue());
            this.cartProductsRepository.save(cartProduct);
        }else{
            cartProductClient.setQuantity(cartProduct.getQuantity());
            this.cartProductsRepository.save(cartProductClient);
        }
        
        return "OK";
    }

    @GetMapping("/cart")
    public @ResponseBody  List<Carts> getCart(){
        return cartsRepository.findAll();
    }

    @GetMapping("/cart_product/{id}")
    public @ResponseBody  List<CartProducts> getCartProduct(@PathVariable int id){
        return cartProductsRepository.findByCartId(id);
    }

    @DeleteMapping("/cart/{id}")
    public @ResponseBody String deleteCart(@PathVariable int id){
        cartsRepository.deleteById(id);
        cartProductsRepository.deleteByCartId(id);
        return "OK";
    }

    @DeleteMapping("/cart_product/{id}")
    public @ResponseBody  String deleteCartProduct(@PathVariable int id){
        cartProductsRepository.deleteById(id);
        return "OK";
    }
}
