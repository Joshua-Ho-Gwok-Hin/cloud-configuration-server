package com.idc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idc.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
