package com.practice.invoiceservice.service;

import com.practice.invoiceservice.model.BillingHeader;
import com.practice.invoiceservice.model.Invoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@SpringBootTest
public class InvoiceDeliveryServiceImplTest {
    @Autowired
    private InvoiceDeliveryServiceImpl invoiceDeliveryServiceImpl;

    @Autowired
    private RestTemplate restTemplate;

    private MockRestServiceServer mockServer;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }


    @Test
    void sendInvoice_Success_Test() {
        var expectedResult = "Invoice delivered successfully.";
        var invoice = Invoice.builder()
                .billingHeader(BillingHeader.builder()
                        .billingId("ABCD")
                        .totalInvoiceAmount(new BigDecimal("70.0"))
                        .build())
                .build();

        mockServer.expect(requestTo("http://localhost:8081/api/invoice-delivery"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(expectedResult));

        var actualResult = invoiceDeliveryServiceImpl.sendInvoice(invoice);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
