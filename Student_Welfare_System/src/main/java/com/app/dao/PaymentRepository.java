package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.PaymentPojo;

public interface PaymentRepository extends JpaRepository<PaymentPojo,Long>{

}
