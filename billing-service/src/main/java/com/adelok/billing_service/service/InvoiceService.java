package com.adelok.billing_service.service;

import com.adelok.billing_service.dto.CreateInvoiceRequest;
import com.adelok.billing_service.dto.CreateInvoiceRequest;
import com.adelok.billing_service.dto.InvoiceResponse;
import com.adelok.billing_service.entity.Currency;
import com.adelok.billing_service.entity.Invoice;
import com.adelok.billing_service.entity.InvoiceStatus;
import com.adelok.billing_service.mapper.ResponseMapper;
import com.adelok.billing_service.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

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
    @Transactional(readOnly = true)
    public InvoiceResponse getById(UUID id){
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found with id " +id ));
        return responseMapper.toResponse(invoice);
    }
    @Transactional(readOnly = true)
    public List<InvoiceResponse> getByCustomer(UUID customerId){
        return invoiceRepository.findByCustomerId(customerId)
                .stream()
                .map(responseMapper::toResponse)
                .toList();

    }
    @Transactional(readOnly = true)
    public List<InvoiceResponse> getByCurrency(Currency currency){
        return invoiceRepository.findByCurrency(currency)
                .stream()
                .map(responseMapper::toResponse)
                .toList();
    }
}
