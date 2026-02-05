package com.gabrielqueiroz.payment_api.models;

import jakarta.persistence.*;
        import lombok.*;

        import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}

