package com.gabrielqueiroz.payment_api.web.dtos.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountResponse {
    private UUID accountId;
    private String numberAccount;
    private String agency;
    private BigDecimal balance;
    private LocalDateTime createdAt;
    private UUID userId;

}
