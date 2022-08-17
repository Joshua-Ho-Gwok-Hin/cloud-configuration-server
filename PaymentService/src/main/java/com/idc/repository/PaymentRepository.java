package com.idc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idc.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
