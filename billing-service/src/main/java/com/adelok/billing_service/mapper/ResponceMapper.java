package com.adelok.billing_service.mapper;

import com.adelok.billing_service.dto.InvoiceResponce;
import com.adelok.billing_service.entity.Invoice;
import org.springframework.stereotype.Component;

@Component
public class ResponceMapper {
    public InvoiceResponce toResponce(Invoice invoice) {
        if (invoice == null) return null;
        return InvoiceResponce.builder()
                .id(invoice.getId())
                .amount(invoice.getAmount())
                .customerId(invoice.getCustomerId())
                .currency(invoice.getCurrency())
                .status(invoice.getStatus())
                .dueDate(invoice.getDueDate())
                .createdAt(invoice.getCreatedAt())
                .build();
    }
}
