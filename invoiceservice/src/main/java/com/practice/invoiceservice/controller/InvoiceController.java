package com.practice.invoiceservice.controller;

import com.practice.invoiceservice.dto.InvoiceDTO;
import com.practice.invoiceservice.service.InvoiceDeliveryService;
import com.practice.invoiceservice.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class InvoiceController {
    InvoiceService invoiceService;
    InvoiceDeliveryService invoiceDeliveryService;

    @PostMapping("invoice")
    public String createInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        var invoice = invoiceService.createInvoice(invoiceDTO.createEntity());
        return invoiceDeliveryService.sendInvoice(invoice);
    }

    @GetMapping("invoice")
    public String getInvoice() {
        return "This is new invoice";
    }
}
