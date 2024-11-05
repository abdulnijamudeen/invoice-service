package com.practice.invoiceservice.service;

import com.practice.invoiceservice.model.Invoice;

public interface InvoiceDeliveryService {
    String sendInvoice(Invoice invoice);
}
