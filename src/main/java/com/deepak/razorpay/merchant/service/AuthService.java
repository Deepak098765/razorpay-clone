package com.deepak.razorpay.merchant.service;

import com.deepak.razorpay.merchant.dto.request.MerchantSignUpRequest;
import com.deepak.razorpay.merchant.dto.response.MerchantResponse;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

public interface AuthService {
     MerchantResponse signup(MerchantSignUpRequest request);
}
