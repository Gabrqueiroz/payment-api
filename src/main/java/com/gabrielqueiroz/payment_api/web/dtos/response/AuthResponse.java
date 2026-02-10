package com.gabrielqueiroz.payment_api.web.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse {
    private UUID userId;
    private String fullName;
    private String email;
    private String token;
    private LocalDateTime createdAt;

}
