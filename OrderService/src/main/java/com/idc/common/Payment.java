package com.idc.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Payment {
	
	private int paymentId;
	private String paymentStatus;
	private String transactionId;
	private int order_id;
	private double amount;
	

}
