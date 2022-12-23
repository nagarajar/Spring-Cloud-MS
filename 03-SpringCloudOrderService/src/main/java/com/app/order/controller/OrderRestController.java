package com.app.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.order.consumer.CartConsumer;
import com.app.order.consumer.CartConsumer2;

@RestController
@RequestMapping("/order")
public class OrderRestController {
	@Autowired
	private CartConsumer2 consumer;
	
	@GetMapping("/place")
	public ResponseEntity<String> placeOrder() {
		String cartResp = consumer.getCartResponse();
		return ResponseEntity.ok("ORDER PLACED WITH => " + cartResp);
	}
	
	@GetMapping("/info")
	public ResponseEntity<String> OrderMessage() {
		return ResponseEntity.ok("Welcome to Order Service..! ");
	}
}
