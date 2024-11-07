package com.practice.invoicedeliveryservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
@RequestMapping("api")
public class InvoiceDeliveryController {
    @PostMapping("invoice-delivery")
    public ResponseEntity<String> deliverInvoice(@RequestBody Object payload) {
        log.info("Invoice payload from invoice service : {}", payload);
        var randomInt = new Random().nextInt(3);
        var response = switch (randomInt) {
            case 0 -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.");
            case 1 -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access.");
            default -> ResponseEntity.ok("Invoice delivered successfully.");
        };
        log.info("Invoice delivery service API response : {}", response);
        return response;
    }
}
