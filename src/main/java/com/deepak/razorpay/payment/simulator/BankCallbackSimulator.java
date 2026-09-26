package com.deepak.razorpay.payment.simulator;

import com.deepak.razorpay.common.enums.PaymentStatus;
import com.deepak.razorpay.payment.entity.Payment;
import com.deepak.razorpay.payment.repository.PaymentRepository;
import com.deepak.razorpay.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class BankCallbackSimulator {
    private final PaymentRepository paymentRepository;
    private final PaymentService paymentService;
    private final SimulatorConfig simulatorConfig;

    @Scheduled(fixedDelayString = "${payment.simulator.poll-interval-ms:5000}")
    public void processCallbacks() {
        LocalDateTime globalWindow = LocalDateTime.now().minusSeconds(1);

        List<Payment> candidates = paymentRepository
                .findByStatusAndCreatedAtBefore(PaymentStatus.AUTHORIZING, globalWindow);

        if(candidates.isEmpty()) return;

        for(Payment payment: candidates) {
            simulateCallback(payment);
        }
    }

    private void simulateCallback(Payment payment) {
    }
}
