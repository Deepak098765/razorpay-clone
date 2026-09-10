package com.deepak.razorpay.payment.service;

import com.deepak.razorpay.payment.dto.request.PaymentInitRequest;
import com.deepak.razorpay.payment.dto.response.PaymentResponse;

import java.util.UUID;

public interface PaymentService {

    PaymentResponse initiate(UUID merchantId, PaymentInitRequest request);
}
