package com.deepak.razorpay.merchant.mapper;

import com.deepak.razorpay.merchant.dto.request.MerchantSignUpRequest;
import com.deepak.razorpay.merchant.dto.response.MerchantResponse;
import com.deepak.razorpay.merchant.entity.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MerchantMapper {

    Merchant toEntityFromSignUpRequest(MerchantSignUpRequest request);

    MerchantResponse toResponse(Merchant merchant);
}
