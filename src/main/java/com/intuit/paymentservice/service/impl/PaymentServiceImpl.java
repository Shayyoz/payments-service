package com.intuit.paymentservice.service.impl;

import com.intuit.paymentservice.config.MQPaymentsConfig;
import com.intuit.paymentservice.mapper.PaymentMapper;
import com.intuit.paymentservice.model.domain.PaymentRequest;
import com.intuit.paymentservice.repository.PaymentsRepository;
import com.intuit.paymentservice.repository.entity.PaymentEntity;
import com.intuit.paymentservice.repository.entity.PaymentStatus;
import com.intuit.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private RabbitTemplate template;
    private final PaymentsRepository paymentsRepository;
    private final PaymentMapper paymentMapper = PaymentMapper.INSTANCE;


    @Override
    public PaymentRequest createPayment(PaymentRequest paymentRequest) {
        template.convertAndSend(MQPaymentsConfig.NEW_PAYMENTS_EXCHANGE,
                MQPaymentsConfig.NEW_PAYMENT_ROUTING_KEY,paymentRequest);

        PaymentEntity paymentEntity = paymentMapper.dmnToEntityMapper(paymentRequest);
        paymentEntity.setStatus(PaymentStatus.PLACED);

        return paymentMapper.entityToDmnMapper(paymentsRepository.save(paymentEntity));
    }

}
