package com.intuit.paymentservice.repository;

import com.intuit.paymentservice.repository.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<PaymentEntity,Integer> {
}
