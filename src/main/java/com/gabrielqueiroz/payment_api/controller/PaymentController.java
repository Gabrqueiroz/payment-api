package com.gabrielqueiroz.payment_api.controller;

import com.gabrielqueiroz.payment_api.services.PaymentService;
import com.gabrielqueiroz.payment_api.web.dtos.request.CreateAccountRequest;
import com.gabrielqueiroz.payment_api.web.dtos.request.CreateUserRequest;
import com.gabrielqueiroz.payment_api.web.dtos.request.TransferRequest;
import com.gabrielqueiroz.payment_api.web.dtos.response.AccountResponse;
import com.gabrielqueiroz.payment_api.web.dtos.response.TransferResponse;
import com.gabrielqueiroz.payment_api.web.dtos.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Pagamentos", description = "Endpoints para gestão de usuários, contas e transferências")
public class PaymentController {

    private final PaymentService paymentService;

    @Operation(summary = "Cria um novo usuário", description = "Cadastra um cliente no sistema de pagamentos para que ele possa possuir uma conta.")
    @PostMapping("/user")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.status(201).body(paymentService.createUser(request));
    }

    @Operation(summary = "Cria uma nova conta", description = "Cria uma conta bancária/digital vinculada a um usuário existente.")
    @PostMapping("/account")
    public ResponseEntity<AccountResponse> createAccount(@RequestBody CreateAccountRequest request) {
        return ResponseEntity.status(201).body(paymentService.createAccount(request));
    }

    @Operation(summary = "Realiza uma transferência", description = "Movimenta saldo entre duas contas cadastradas no sistema.")
    @PostMapping("/transfer")
    public ResponseEntity<TransferResponse> transfer(@RequestBody TransferRequest request) {
        return ResponseEntity.ok(paymentService.transfer(request));
    }

}




