package com.practice.invoicedeliveryservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("api")
public class InvoiceDeliveryController {
    @PostMapping("invoice-delivery")
    public ResponseEntity<String> deliverInvoice() {
        var randomInt = new Random().nextInt(3);
        var r = switch (randomInt) {
            case 0 -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.");
            case 1 -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access.");
            default -> ResponseEntity.ok("Invoice delivered successfully.");
        };
        System.out.println(r);
        return r;
    }
}
