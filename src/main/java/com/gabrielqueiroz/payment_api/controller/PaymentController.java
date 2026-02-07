package com.gabrielqueiroz.payment_api.controller;

import com.gabrielqueiroz.payment_api.services.PaymentService;
import com.gabrielqueiroz.payment_api.web.dtos.request.CreateAccountRequest;
import com.gabrielqueiroz.payment_api.web.dtos.request.CreateUserRequest;
import com.gabrielqueiroz.payment_api.web.dtos.request.TransferRequest;
import com.gabrielqueiroz.payment_api.web.dtos.response.AccountResponse;
import com.gabrielqueiroz.payment_api.web.dtos.response.TransferResponse;
import com.gabrielqueiroz.payment_api.web.dtos.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.status(201).body(paymentService.createUser(request));
    }

    @PostMapping("/accounts")
    public ResponseEntity<AccountResponse> createAccount(@RequestBody CreateAccountRequest request) {
        return ResponseEntity.status(201).body(paymentService.createAccount(request));
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransferResponse> transfer(@RequestBody TransferRequest request) {
        return ResponseEntity.ok(paymentService.transfer(request));
    }

}




