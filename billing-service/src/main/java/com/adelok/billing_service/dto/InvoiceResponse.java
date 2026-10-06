package com.adelok.billing_service.dto;

import com.adelok.billing_service.entity.Currency;
import com.adelok.billing_service.entity.InvoiceStatus;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record InvoiceResponse(
        UUID id,
        BigDecimal amount,
        UUID customerId,
        Currency currency,
        InvoiceStatus status,
        LocalDate dueDate,
        LocalDateTime createdAt
) {
}
