package com.practice.invoiceservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.practice.invoiceservice.model.BillingHeader;
import com.practice.invoiceservice.model.BillingLineInformation;
import com.practice.invoiceservice.model.Invoice;

import java.util.List;

public record InvoiceDTO(@JsonProperty("billing_header") BillingHeaderDTO billingHeaderDTO,
                         @JsonProperty("billing_lines") List<BillingLineDTO> billingLineDTOS) {
    public Invoice createEntity() {
        return mapBillingLines(Invoice
                .builder()
                .billingHeader(BillingHeader
                        .builder()
                        .billingId(this.billingHeaderDTO.billingId())
                        .totalInvoiceAmount(this.billingHeaderDTO.totalInvoiceAmount())
                        .build())
                .build());
    }

    private Invoice mapBillingLines(Invoice invoice) {
        invoice.setBillingLines(this.billingLineDTOS.stream()
                .map(bl -> BillingLineInformation
                        .builder()
                        .invoice(invoice)
                        .productType(bl.billingLineInformationDTO().productType())
                        .lineType(bl.billingLineInformationDTO().lineType())
                        .build()).toList());
        return invoice;
    }
}