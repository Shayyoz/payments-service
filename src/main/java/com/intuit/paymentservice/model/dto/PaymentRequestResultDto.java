package com.intuit.paymentservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentRequestResultDto {
    private String payeeId;
    private String userId;
    private String currency;
    private Double amount;
    private String paymentMethodId;
    private boolean isApproved;
}
