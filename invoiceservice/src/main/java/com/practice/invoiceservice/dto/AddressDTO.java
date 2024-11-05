package com.practice.invoiceservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AddressDTO(@JsonProperty("address1") String address1, @JsonProperty("postal_code") String postalCode,
                         @JsonProperty("postal_district") String postalDistrict,
                         @JsonProperty("country_code") String countryCode, @JsonProperty("country_name") String countryName

) {
}
