package com.deepak.razorpay.payment.processor;

import com.deepak.razorpay.payment.processor.dto.PaymentProcessorRequest;
import com.deepak.razorpay.payment.processor.dto.PaymentProcessorResponse;

public interface PaymentProcessor {

    PaymentProcessorResponse charge(PaymentProcessorRequest request);
}
