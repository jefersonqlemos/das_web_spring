package com.das_web.das_web_spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.das_web.das_web_spring.Model.CartProducts;
import com.das_web.das_web_spring.Model.Carts;
import com.das_web.das_web_spring.Repository.CartsRepository;
import com.das_web.das_web_spring.Repository.CartProductsRepository;

@RestController
public class CartController {
    @Autowired
    CartsRepository cartsRepository;

    @Autowired
    CartProductsRepository cartProductsRepository;

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
            this.cartProductsRepository.save(cartProduct);
        }else{
            cartProductClient.setQuantity(cartProductClient.getQuantity() + cartProduct.getQuantity());
            this.cartProductsRepository.save(cartProductClient);
        }
        
        return "OK";
    }
}
