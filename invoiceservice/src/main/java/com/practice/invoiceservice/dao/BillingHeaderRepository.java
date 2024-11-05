package com.practice.invoiceservice.dao;

import com.practice.invoiceservice.model.BillingHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingHeaderRepository extends JpaRepository<BillingHeader, Long> {
}
