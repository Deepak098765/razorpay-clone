package com.deepak.razorpay.payment.processor.strategy;

import com.deepak.razorpay.common.util.RandomizerUtil;
import com.deepak.razorpay.payment.processor.PaymentProcessor;
import com.deepak.razorpay.payment.processor.dto.PaymentProcessorRequest;
import com.deepak.razorpay.payment.processor.dto.PaymentProcessorResponse;

public class NetBankingPaymentProcessor implements PaymentProcessor {
    @Override
    public PaymentProcessorResponse charge(PaymentProcessorRequest request) {

        final String BANK_CODE_FAIL = "BANK_CODE_FAIL";

        String bankCode = request.methodDetails() != null ?
                request.methodDetails().get("BANK").toString() : null;

        //simulation
        if(BANK_CODE_FAIL.equals(bankCode)) {
            return new PaymentProcessorResponse.Failure("BANK_REJECTED",
                    "Banked rejected the transaction registration");
        }

        String processorRef = "NBK_PROCESSOR" + RandomizerUtil.randomBase64(16);

        String redirectRef = "http://REDIRECT_BANk.com" + processorRef;
        return new PaymentProcessorResponse.Success(processorRef, redirectRef);
    }
}
