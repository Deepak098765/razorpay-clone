package com.deepak.razorpay.payment.service;

import com.deepak.razorpay.payment.dto.request.CreateOrderRequest;
import com.deepak.razorpay.payment.dto.response.OrderResponse;

import java.util.UUID;

public interface OrderService {
    OrderResponse create(UUID merchantId, CreateOrderRequest request);
}
