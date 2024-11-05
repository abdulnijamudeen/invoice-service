package com.practice.invoiceservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BuyerPartyDTO(@JsonProperty("client_identifier") String clientIdentifier,
                            @JsonProperty("buyer_address") AddressDTO buyerAddressDTO) {
}
