package com.gabrielqueiroz.payment_api.web.dtos.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferResponse {

    private UUID transactionId;
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
    private String status;

}

