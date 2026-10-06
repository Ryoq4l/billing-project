package com.adelok.billing_service.service;

import com.adelok.billing_service.dto.CreateInvoiceRequest;
import com.adelok.billing_service.dto.CreateInvoiceRequest;
import com.adelok.billing_service.dto.InvoiceResponse;
import com.adelok.billing_service.entity.Invoice;
import com.adelok.billing_service.entity.InvoiceStatus;
import com.adelok.billing_service.mapper.ResponseMapper;
import com.adelok.billing_service.repository.InvoiceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final ResponseMapper responseMapper;

    @Transactional
public InvoiceResponse create(CreateInvoiceRequest request){
        Invoice invoice = Invoice.builder()
                .customerId(request.customerId())
                .amount(request.amount())
                .currency(request.currency())
                .dueDate(request.dueDate())
                .status(InvoiceStatus.DRAFT)
                .build();
        Invoice saved = invoiceRepository.saveAndFlush(invoice);
        return responseMapper.toResponse(saved);
    }

}
