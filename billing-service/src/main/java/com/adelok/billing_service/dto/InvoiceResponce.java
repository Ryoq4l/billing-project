package com.adelok.billing_service.dto;

import com.adelok.billing_service.entity.Currency;
import com.adelok.billing_service.entity.InvoiceStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record InvoiceResponce(
        UUID id,
        BigDecimal amount,
        UUID customerId,
        Currency currency,
        InvoiceStatus status,
        LocalDate dueDate,
        LocalDateTime createdAt
) {
}
