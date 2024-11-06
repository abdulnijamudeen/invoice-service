package com.practice.invoiceservice.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class ResilienceConfig {
    public static final String INVOICE_DELIVERY_SERVICE = "invoiceDeliveryService";

    @Bean
    public CircuitBreakerConfigCustomizer circuitBreakerConfigCustomizer() {
        return CircuitBreakerConfigCustomizer.of(INVOICE_DELIVERY_SERVICE, builder -> builder
                .slidingWindowSize(10)
                .minimumNumberOfCalls(4)
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofSeconds(10))
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.TIME_BASED));
    }
}
