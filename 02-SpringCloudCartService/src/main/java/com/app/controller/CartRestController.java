package com.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Cart;

@RestController
@RequestMapping("/cart")
public class CartRestController 
{
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/info")
	public ResponseEntity<String> showMessage(){
		return ResponseEntity.ok("Welcome to Cart Service...! => "+port );
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable Integer id){
		Cart cart = new Cart();
		cart.setCartId(id);
		cart.setCartCode("TEST");
		cart.setCartCost(2399.00);
		
		return ResponseEntity.ok(cart);	
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> addToCart(@RequestBody Cart cart){
		return ResponseEntity.ok("Cart Added Successfully"+ cart);
	}
	
}
