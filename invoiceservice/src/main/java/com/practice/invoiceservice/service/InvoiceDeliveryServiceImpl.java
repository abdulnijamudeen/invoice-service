package com.practice.invoiceservice.service;

import com.practice.invoiceservice.model.Invoice;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.text.MessageFormat;

import static com.practice.invoiceservice.config.ResilienceConfig.INVOICE_DELIVERY_SERVICE;

@Service
@AllArgsConstructor
@Slf4j
public class InvoiceDeliveryServiceImpl implements InvoiceDeliveryService {
    private RestClient restClient;

    @Override
    @CircuitBreaker(name = INVOICE_DELIVERY_SERVICE, fallbackMethod = "sendInvoiceFallback")
    public String sendInvoice(Invoice invoice) {
        log.error("Service Invoice delivery service.");
        ResponseEntity<String> responseEntity = restClient
                .post()
                .uri("/api/invoice-delivery")
                .contentType(MediaType.APPLICATION_JSON)
                .body(invoice)
                .retrieve()
                .toEntity(String.class);
        return responseEntity.getBody();
    }

    public String sendInvoiceFallback(Exception ex) {
        log.error("Failed to access Invoice delivery service.", ex);
        return MessageFormat.format("Failed to access Invoice delivery service : {0}", ex.getMessage());
    }
}
