package com.gabrielqueiroz.payment_api.web.dtos.request;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferRequest {

    private String fromAccountNumber;
    private String toAccountNumber;
    private BigDecimal value;
    private String typeTransaction;
}

