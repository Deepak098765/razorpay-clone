package com.deepak.razorpay.payment.processor.dto;

import com.deepak.razorpay.common.entity.Money;
import com.deepak.razorpay.common.enums.PaymentMethod;

import java.util.Map;

public record PaymentProcessorRequest(
        PaymentMethod method,
        Money amount,
        Map<String, Object> methodDetails
) {
}
