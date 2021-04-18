package com.intuit.paymentservice.service;

import com.intuit.paymentservice.model.domain.PaymentRequest;

public interface PaymentService {
    PaymentRequest createPayment(PaymentRequest paymentRequest);
}
