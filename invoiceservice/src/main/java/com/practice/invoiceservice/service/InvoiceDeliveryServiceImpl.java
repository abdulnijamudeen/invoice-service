package com.practice.invoiceservice.service;

import com.practice.invoiceservice.model.Invoice;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import static com.practice.invoiceservice.config.ResilienceConfig.INVOICE_DELIVERY_SERVICE;

@Service
@AllArgsConstructor
public class InvoiceDeliveryServiceImpl implements InvoiceDeliveryService {
    private RestClient restClient;

    @Override
    @CircuitBreaker(name = INVOICE_DELIVERY_SERVICE, fallbackMethod = "sendInvoiceFallback")
    public String sendInvoice(Invoice invoice) {
        ResponseEntity<String> responseEntity = restClient
                .post()
                .uri("/api/invoice-delivery")
                .contentType(MediaType.APPLICATION_JSON).body(invoice)
                .retrieve()
                .toEntity(String.class);
        return responseEntity.getBody();
    }

    public String sendInvoiceFallback(Exception ex) {
        System.out.println(ex.getMessage());
        return "Failed";
    }
}
