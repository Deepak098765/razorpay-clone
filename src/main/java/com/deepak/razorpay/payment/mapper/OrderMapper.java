package com.deepak.razorpay.payment.mapper;

import com.deepak.razorpay.payment.dto.response.OrderResponse;
import com.deepak.razorpay.payment.entity.OrderRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    OrderResponse toResponse(OrderRecord orderRecord);
}
