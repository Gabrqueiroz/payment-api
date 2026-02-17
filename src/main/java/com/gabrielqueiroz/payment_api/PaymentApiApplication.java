package com.gabrielqueiroz.payment_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.gabrielqueiroz.payment_api")
public class PaymentApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApiApplication.class, args);
    }
}
