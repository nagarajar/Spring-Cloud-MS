package com.app.order.model;

import lombok.Data;

@Data
public class Cart {
	private Integer cartId;
	private String cartCode;
	private Double cartCost;
}
