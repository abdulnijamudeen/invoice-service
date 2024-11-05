package com.practice.invoiceservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SupplierPartyDTO(@JsonProperty("travel_office_name") String travelOfficeName,
                               @JsonProperty("travel_office_address") AddressDTO travelOfficeAddressDTO) {
}
