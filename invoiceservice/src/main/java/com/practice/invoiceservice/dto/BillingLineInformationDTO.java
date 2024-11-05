package com.practice.invoiceservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BillingLineInformationDTO(@JsonProperty("product_type") String productType,
                                        @JsonProperty("line_type") String lineType) {
}
