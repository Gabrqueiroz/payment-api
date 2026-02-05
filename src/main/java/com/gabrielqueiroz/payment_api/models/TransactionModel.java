package com.gabrielqueiroz.payment_api.models;
import com.gabrielqueiroz.payment_api.enums.TransactionStatus;
import com.gabrielqueiroz.payment_api.enums.TransactionType;
import jakarta.persistence.*;
        import lombok.*;

        import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sb_transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionModel {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "from_account_id", nullable = false)
    private AccountModel fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_account_id", nullable = false)
    private AccountModel toAccount;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime processedAt;

    private String description;
}
