package com.gabrielqueiroz.payment_api.services;
import com.gabrielqueiroz.payment_api.models.AccountModel;
import com.gabrielqueiroz.payment_api.models.UserModel;
import com.gabrielqueiroz.payment_api.repositorys.AccountRepository;
import com.gabrielqueiroz.payment_api.repositorys.TransactionRepository;
import com.gabrielqueiroz.payment_api.repositorys.UserRepository;
import com.gabrielqueiroz.payment_api.web.dtos.request.CreateAccountRequest;
import com.gabrielqueiroz.payment_api.web.dtos.request.CreateUserRequest;
import com.gabrielqueiroz.payment_api.web.dtos.response.AccountResponse;
import com.gabrielqueiroz.payment_api.web.dtos.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j

public class PaymentService {

    private final  UserRepository userRepository;
    private  final AccountRepository accountRepository;
    private  final TransactionRepository transactionRepository;

    public UserResponse createUser(CreateUserRequest request) {
        try {
            UserModel user = UserModel.builder()
                    .fullName(request.getFullName())
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .createdAt(LocalDateTime.now())
                    .build();

            userRepository.save(user);

            return UserResponse.builder()
                    .id(user.getId())
                    .fullName(user.getFullName())
                    .email(user.getEmail())
                    .createdAt(user.getCreatedAt())
                    .build();

        } catch (Exception e) {
            log.error("Error creating user with email: {}", request.getEmail(), e);
            throw new RuntimeException("Error creating user");
        }
    }

    public AccountResponse createAccount (CreateAccountRequest request){
        try{
                UserModel user = userRepository.findById(request.getUserId())
                        .orElseThrow(() -> new RuntimeException("User not found"));

                String generatedAccountNumber = String.valueOf(
                        (long) (Math.random() * 900000) + 100000
                );
                BigDecimal initialBalance = request.getInitialDeposit() != null
                        ? request.getInitialDeposit()
                        : BigDecimal.ZERO;

                AccountModel account = AccountModel.builder()
                        .numberAccount(generatedAccountNumber)
                        .agency(request.getAgency())
                        .balance(initialBalance)
                        .createdAt(LocalDateTime.now())
                        .user(user)
                        .build();

                accountRepository.save(account);

                return AccountResponse.builder()
                        .accountId(account.getId())
                        .numberAccount(account.getNumberAccount())
                        .agency(account.getAgency())
                        .balance(account.getBalance())
                        .createdAt(account.getCreatedAt())
                        .userId(user.getId())
                        .build();

        } catch (Exception e) {
            log.error("Error creating user with email: {}", request.getUserId(), e);
            throw new RuntimeException("Error creating user");

        }
    }
    /* criaar
    public TransactionResponse transfer(TransferRequest request) {
        try {
            if (request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
                throw new RuntimeException("Invalid transfer amount");
            }

            AccountModel fromAccount = accountRepository.findByNumberAccount(request.getFromAccountNumber())
                    .orElseThrow(() -> new RuntimeException("Source account not found"));

            AccountModel toAccount = accountRepository.findByNumberAccount(request.getToAccountNumber())
                    .orElseThrow(() -> new RuntimeException("Destination account not found"));

            if (fromAccount.getBalance().compareTo(request.getAmount()) < 0) {
                throw new RuntimeException("Insufficient balance");
            }

            // 💸 Atualiza saldos
            fromAccount.setBalance(fromAccount.getBalance().subtract(request.getAmount()));
            toAccount.setBalance(toAccount.getBalance().add(request.getAmount()));

            accountRepository.save(fromAccount);
            accountRepository.save(toAccount);

            // 🧾 Salva transação
            TransactionModel transaction = TransactionModel.builder()
                    .fromAccount(fromAccount)
                    .toAccount(toAccount)
                    .amount(request.getAmount())
                    .description(request.getDescription())
                    .createdAt(LocalDateTime.now())
                    .build();

            transactionRepository.save(transaction);

            return TransactionResponse.builder()
                    .transactionId(transaction.getId())
                    .fromAccount(fromAccount.getNumberAccount())
                    .toAccount(toAccount.getNumberAccount())
                    .amount(transaction.getAmount())
                    .createdAt(transaction.getCreatedAt())
                    .status("SUCCESS")
                    .build();

        } catch (Exception e) {
            log.error("Error during transfer", e);
            throw new RuntimeException("Transfer failed: " + e.getMessage());
        }
    } */

}
