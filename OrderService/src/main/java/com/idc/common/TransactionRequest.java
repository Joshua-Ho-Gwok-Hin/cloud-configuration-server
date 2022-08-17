package com.idc.common;

import com.idc.entity.Order;

import lombok.Data;


@Data

public class TransactionRequest {
	
	private Order order;
	
	private Payment payment;

//	public Order getOrder() {
//		
//		return order;
//	}
//
//	public Payment getPayment() {
//		
//		return null;
//	}

}
