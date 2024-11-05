package com.practice.invoiceservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BillingLineDTO(@JsonProperty("billing_line_information") BillingLineInformationDTO billingLineInformationDTO) {
}
