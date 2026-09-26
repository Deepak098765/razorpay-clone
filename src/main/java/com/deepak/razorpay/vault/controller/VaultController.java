package com.deepak.razorpay.vault.controller;


import com.deepak.razorpay.vault.dto.request.TokenizeRequest;
import com.deepak.razorpay.vault.dto.response.TokenizeResponse;
import com.deepak.razorpay.vault.service.VaultService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/vault")
@RequiredArgsConstructor
public class VaultController {

    private final VaultService vaultService;
    UUID merchantId = UUID.fromString("f1fdb323-d0de-4937-8500-0c29b00d3a87"); // TODO: replace it with MerchantContext

    @PostMapping("/tokenize")
    public ResponseEntity<TokenizeResponse> tokenize(@RequestBody @Valid TokenizeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vaultService.tokenize(request, merchantId));

    }
}
