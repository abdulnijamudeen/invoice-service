package com.practice.invoiceservice.service;

import com.practice.invoiceservice.dao.InvoiceRepository;
import com.practice.invoiceservice.model.BillingHeader;
import com.practice.invoiceservice.model.Invoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class InvoiceServiceImplTest {
    @Autowired
    private InvoiceServiceImpl invoiceServiceImpl;

    @Mock
    private InvoiceRepository invoiceRepository;

    @Test
    void createInvoice_Success_Test() {
        var invoice = Invoice.builder()
                .billingHeader(BillingHeader.builder()
                        .billingId("ABCD")
                        .totalInvoiceAmount(new BigDecimal("70.0"))
                        .build())
                .build();

        var expectedInvoice = Invoice.builder().id(1L).build();
        when(invoiceRepository.save(any(Invoice.class))).thenReturn(expectedInvoice);

        var actualInvoice = invoiceServiceImpl.createInvoice(invoice);
        Assertions.assertEquals(expectedInvoice.getId(), actualInvoice.getId());
    }
}
