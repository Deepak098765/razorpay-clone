package com.deepak.razorpay.payment.statemachine;

import com.deepak.razorpay.common.enums.PaymentActor;
import com.deepak.razorpay.common.enums.PaymentEvent;
import com.deepak.razorpay.common.enums.PaymentStatus;
import com.deepak.razorpay.payment.entity.Payment;
import com.deepak.razorpay.payment.entity.PaymentTransitionLog;
import com.deepak.razorpay.payment.repository.PaymentTransitionLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentTransitionService {

    private final PaymentTransitionLogRepository paymentTransitionLogRepository;
    private final PaymentStateMachine paymentStateMachine;

    public PaymentStatus apply(Payment payment, PaymentEvent event) {
        PaymentStatus fromStatus = payment.getStatus();
        PaymentStatus next = paymentStateMachine.transition(fromStatus, event);
        payment.setStatus(next);
        PaymentTransitionLog log = PaymentTransitionLog.builder()
                .payment(payment)
                .fromStatus(fromStatus)
                .event(event)
                .toStatus(next)
                .actor(PaymentActor.SYSTEM) // TODO: fetch merchant context to identify actor
                .occurredAt(LocalDateTime.now())
                .build();

        paymentTransitionLogRepository.save(log);
        return next;
    }
}
