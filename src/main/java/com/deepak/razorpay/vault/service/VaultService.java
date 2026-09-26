package com.deepak.razorpay.vault.service;

import com.deepak.razorpay.common.entity.Money;
import com.deepak.razorpay.payment.processor.dto.PaymentProcessorResponse;
import com.deepak.razorpay.vault.dto.request.TokenizeRequest;
import com.deepak.razorpay.vault.dto.response.TokenizeResponse;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

import java.util.Map;
import java.util.UUID;

public interface VaultService {

    TokenizeResponse tokenize(TokenizeRequest request, UUID merchantId);

    PaymentProcessorResponse charge(UUID paymentId, String token, Money amount, Map<String, Object> methodDetails);
}
