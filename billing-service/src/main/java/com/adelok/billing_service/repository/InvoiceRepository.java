package com.adelok.billing_service.repository;

import com.adelok.billing_service.entity.Currency;
import com.adelok.billing_service.entity.Invoice;
import com.adelok.billing_service.entity.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {
    List<Invoice> findByCustomerId(UUID customerId);

    List<Invoice> findByCurrency(Currency currency);

    List<Invoice> findByStatus(InvoiceStatus status);
}
