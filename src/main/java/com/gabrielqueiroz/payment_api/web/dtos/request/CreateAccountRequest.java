package com.gabrielqueiroz.payment_api.web.dtos.request;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAccountRequest {
    private UUID userId;
    private String agency;
    private String accountType; // CHECKING ou SAVINGS
    private BigDecimal initialDeposit;

}
