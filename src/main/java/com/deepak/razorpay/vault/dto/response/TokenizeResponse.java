package com.deepak.razorpay.vault.dto.response;

import com.deepak.razorpay.common.enums.CardBrand;

public record TokenizeResponse(

        String token,
        String lastFour,
        CardBrand brand,
        Integer expiryMonth,
        Integer expiryYear
) {
}
