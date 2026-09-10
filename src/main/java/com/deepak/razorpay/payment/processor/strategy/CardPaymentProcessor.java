package com.deepak.razorpay.payment.processor.strategy;

import com.deepak.razorpay.payment.processor.PaymentProcessor;
import com.deepak.razorpay.payment.processor.dto.PaymentProcessorRequest;
import com.deepak.razorpay.payment.processor.dto.PaymentProcessorResponse;

public class CardPaymentProcessor implements PaymentProcessor {
    @Override
    public PaymentProcessorResponse charge(PaymentProcessorRequest request) {
        return null;
    }
}
