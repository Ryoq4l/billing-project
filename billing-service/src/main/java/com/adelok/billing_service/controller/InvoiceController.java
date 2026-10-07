package com.adelok.billing_service.controller;

import com.adelok.billing_service.dto.CreateInvoiceRequest;
import com.adelok.billing_service.dto.InvoiceResponse;
import com.adelok.billing_service.entity.Currency;
import com.adelok.billing_service.entity.InvoiceStatus;
import com.adelok.billing_service.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/invoices")
@RequiredArgsConstructor

public class InvoiceController {
    private final InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceResponse> create(@RequestBody CreateInvoiceRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(invoiceService.getById(id));
    }
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<InvoiceResponse>> getByCustomerId(@PathVariable UUID customerId) {
        return ResponseEntity.ok(invoiceService.getByCustomer(customerId));
    }
    @GetMapping("/currency/{currency}")
    public ResponseEntity<List<InvoiceResponse>> getByCurrency(@PathVariable Currency currency) {
        return ResponseEntity.ok(invoiceService.getByCurrency(currency));
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<List<InvoiceResponse>> getByStatus(@PathVariable InvoiceStatus status) {
        return ResponseEntity.ok(invoiceService.getByStatus(status));
    }

}
