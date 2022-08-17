package com.idc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="order_det")
public class Order {
	
	@Id
	@GeneratedValue
	private int order_id;
	private String name;
	private int quantity;
	private double price;
	

}
