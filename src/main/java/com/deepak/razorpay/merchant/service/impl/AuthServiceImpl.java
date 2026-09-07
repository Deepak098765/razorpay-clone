package com.deepak.razorpay.merchant.service.impl;

import com.deepak.razorpay.common.enums.MerchantStatus;
import com.deepak.razorpay.common.enums.UserRole;
import com.deepak.razorpay.common.exception.DuplicateResourceException;
import com.deepak.razorpay.merchant.dto.request.MerchantSignUpRequest;
import com.deepak.razorpay.merchant.dto.response.MerchantResponse;
import com.deepak.razorpay.merchant.entity.AppUser;
import com.deepak.razorpay.merchant.entity.Merchant;
import com.deepak.razorpay.merchant.mapper.MerchantMapper;
import com.deepak.razorpay.merchant.repository.AppUserRepository;
import com.deepak.razorpay.merchant.repository.MerchantRepository;
import com.deepak.razorpay.merchant.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository appUserRepository;
    private final MerchantRepository merchantRepository;
    private final MerchantMapper merchantMapper;

    @Override
    @Transactional
    public MerchantResponse signup(MerchantSignUpRequest request) {
        if(merchantRepository.existsByEmail(request.email())) {
            throw new DuplicateResourceException("DUPLICATE_MERCHANT_EMAIL",
                    "Merchant with email already exists: " +request.email());
        }

        Merchant merchant = merchantMapper.toEntityFromSignUpRequest(request);
        merchant.setStatus(MerchantStatus.PENDING_KYC);

        merchantRepository.save(merchant);

        AppUser appUser = AppUser.builder()
                .merchant(merchant)
                .email(request.email())
                .passwordHash(request.password()) // TODO: encrypt using Bcrypt
                .role(UserRole.OWNER)
                .build();

        appUserRepository.save(appUser);
        return merchantMapper.toResponse(merchant);
    }
}
