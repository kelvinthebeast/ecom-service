package com.nhanthanhle.ecom.ecomservice;

import jakarta.persistence.EntityListeners;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EcomServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcomServiceApplication.class, args);
    }

}
