package com.practice.invoiceservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "billing_header_id", referencedColumnName = "id")
    private BillingHeader billingHeader;
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.PERSIST)
    private List<BillingLineInformation> billingLines;
}
