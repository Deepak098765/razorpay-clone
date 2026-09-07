package com.deepak.razorpay.payment.repository;

import com.deepak.razorpay.payment.dto.response.OrderResponse;
import com.deepak.razorpay.payment.entity.OrderRecord;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderRecord, UUID> {
    boolean existsByMerchantIdAndReceipt(UUID merchantId, @Size(max = 100) String receipt);

    Optional<OrderRecord> findByIdAndMerchantId(UUID orderId, UUID merchantId);
}
