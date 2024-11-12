package com.practice.invoiceservice.service;

import com.practice.invoiceservice.model.Invoice;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

import static com.practice.invoiceservice.config.ResilienceConfig.INVOICE_DELIVERY_SERVICE;

@Service
@AllArgsConstructor
@Slf4j
public class InvoiceDeliveryServiceImpl implements InvoiceDeliveryService {
    private RestTemplate restTemplate;

    @Override
    @CircuitBreaker(name = INVOICE_DELIVERY_SERVICE, fallbackMethod = "sendInvoiceFallback")
    public String sendInvoice(Invoice invoice) {
        log.error("Service Invoice delivery service.");
        var response = restTemplate.postForEntity("http://localhost:8081/api/invoice-delivery", new HttpEntity<>(invoice), String.class);
        return response.getBody();
    }

    public String sendInvoiceFallback(Exception ex) {
        log.error("Failed to access Invoice delivery service.", ex);
        return MessageFormat.format("Failed to access Invoice delivery service : {0}", ex.getMessage());
    }
}
