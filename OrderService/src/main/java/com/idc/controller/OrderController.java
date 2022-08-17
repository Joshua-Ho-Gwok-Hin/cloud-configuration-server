package com.idc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idc.common.TransactionRequest;
import com.idc.common.TransactionResponse;
import com.idc.entity.Order;
import com.idc.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	//@PostMapping("/bookOrder")
//	public Order bookOrder(@RequestBody Order order) {
//		return orderService.saveOrder(order);
//	}


	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest  transactionRequest) {
		return orderService.saveOrder(transactionRequest);
	}

}
