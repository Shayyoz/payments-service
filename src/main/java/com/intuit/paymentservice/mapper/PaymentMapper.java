package com.intuit.paymentservice.mapper;

import com.intuit.paymentservice.model.domain.PaymentRequest;
import com.intuit.paymentservice.repository.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    PaymentEntity dmnToEntityMapper(PaymentRequest paymentRequest);
    PaymentRequest entityToDmnMapper(PaymentEntity paymentRequest);

}
