package com.practice.invoiceservice.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {
    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return flyway -> {
            // Uncomment flyway.clean() to recreate schema
//            flyway.clean();
            flyway.migrate();
            flyway.validate();
        };
    }
}
