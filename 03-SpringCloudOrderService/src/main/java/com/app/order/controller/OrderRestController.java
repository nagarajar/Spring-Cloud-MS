package com.app.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.order.model.Cart;
import com.app.order.consumer.CartConsumer;
import com.app.order.consumer.CartConsumer2;
import com.app.order.consumer.CartConsumerFeign;

@RestController
@RequestMapping("/order")
public class OrderRestController {
	@Autowired
	private CartConsumerFeign consumer;
	
	@GetMapping("/place")
	public ResponseEntity<String> placeOrder() {
		String cartResp = consumer.showMessage().getBody();
		return ResponseEntity.ok("ORDER PLACED WITH => " + cartResp);
	}
	
	@GetMapping("/show")
	public ResponseEntity<String> OrderMessage() {
		return ResponseEntity.ok("Welcome to Order Service..! ");
	}
	
	//Getting response from Cart Service
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Cart> fetchOrderWithCart(@PathVariable Integer id){
		Cart cart = consumer.getCartById(id).getBody();
		return ResponseEntity.ok(cart);
	}
	
	@PostMapping("/addToCart")
	public ResponseEntity<String> addToCart(@RequestBody Cart cart){
		String cartResp = consumer.addToCart(cart).getBody();
		return ResponseEntity.ok(cartResp);
	}
}
