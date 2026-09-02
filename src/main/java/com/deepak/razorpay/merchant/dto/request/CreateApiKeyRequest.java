package com.deepak.razorpay.merchant.dto.request;

import com.deepak.razorpay.common.enums.Environment;

public record CreateApiKeyRequest(
        Environment environment
) {
}
