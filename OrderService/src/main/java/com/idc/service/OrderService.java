package com.idc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.idc.common.Payment;
import com.idc.common.TransactionRequest;
import com.idc.common.TransactionResponse;
import com.idc.entity.Order;
import com.idc.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
//	public Order saveOrder(Order order) {
//		
//		return orderRepository.save(order);
//	}
	
	public TransactionResponse saveOrder(TransactionRequest transactionRequest) {
		String response="";   //no response
		Order order = transactionRequest.getOrder();
		Payment payment =  transactionRequest.getPayment();
		orderRepository.save(order);
		payment.setOrder_id(order.getOrder_id());   // mapping order_id to payment
		payment.setAmount(order.getPrice());     
		// communication has to be done using RestTemplate-call rest
		
		Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment",payment,Payment.class);
		response = paymentResponse.getPaymentStatus().equals("Success")?"Payment processing success and order placed":
																"There is a failure in a payment api,order added to cart";
		orderRepository.save(order); 
		return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(),response);
		
		
		
		
	}

}
