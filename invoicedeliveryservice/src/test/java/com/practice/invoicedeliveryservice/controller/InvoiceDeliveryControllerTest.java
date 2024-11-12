package com.practice.invoicedeliveryservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(InvoiceDeliveryController.class)
public class InvoiceDeliveryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deliverInvoice() throws Exception {

        ResultActions response = mockMvc.perform(post("/api/invoice-delivery")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString("payload")));

        response.andDo(print());
    }
}
