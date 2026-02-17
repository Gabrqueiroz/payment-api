package com.gabrielqueiroz.payment_api.messaging.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID transactionId;
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
}
