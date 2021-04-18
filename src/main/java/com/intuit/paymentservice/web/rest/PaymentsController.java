package com.intuit.paymentservice.web.rest;

import com.intuit.paymentservice.model.domain.PaymentRequest;
import com.intuit.paymentservice.repository.entity.PaymentStatus;
import com.intuit.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PaymentsController {
    private final PaymentService paymentService;

    @PostMapping(value = "/createPayment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentRequest> saveTournamentResults(@RequestBody PaymentRequest request){

        return  ResponseEntity.ok(paymentService.createPayment(request));
    }
}
