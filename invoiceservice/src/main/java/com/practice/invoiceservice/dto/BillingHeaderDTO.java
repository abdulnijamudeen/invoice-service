package com.practice.invoiceservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties({"document_type", "currency_code", "invoice_date"})
public record BillingHeaderDTO(@JsonProperty("billing_id") String billingId,
                               @JsonProperty("document_type") String documentType,
                               @JsonProperty("currency_code") String currencyCode,
                               @JsonProperty("invoice_date") String invoiceDate,
                               @JsonProperty("total_invoice_amount") BigDecimal totalInvoiceAmount) {
}