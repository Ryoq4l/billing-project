package com.adelok.billing_service.dto;

import com.adelok.billing_service.entity.Currency;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CreateInvoiceRequest(
        UUID customerId,
        BigDecimal amount,
        Currency currency,
        LocalDate dueDate
) {
}
