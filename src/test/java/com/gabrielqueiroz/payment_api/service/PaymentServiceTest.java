package com.gabrielqueiroz.payment_api.service;

import com.gabrielqueiroz.payment_api.messaging.config.RabbitConfig;
import com.gabrielqueiroz.payment_api.messaging.event.TransferMessage;
import com.gabrielqueiroz.payment_api.models.AccountModel;
import com.gabrielqueiroz.payment_api.models.TransactionModel;
import com.gabrielqueiroz.payment_api.repositorys.AccountRepository;
import com.gabrielqueiroz.payment_api.repositorys.TransactionRepository;
import com.gabrielqueiroz.payment_api.repositorys.UserRepository;
import com.gabrielqueiroz.payment_api.services.PaymentService;
import com.gabrielqueiroz.payment_api.web.dtos.request.TransferRequest;
import com.gabrielqueiroz.payment_api.web.dtos.response.TransferResponse;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {
    @Mock
    private RabbitTemplate rabbitTemplate;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository ;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private PaymentService paymentService;


    @Test
    void shouldTransferSuccessfully() {

        BigDecimal amount = new BigDecimal("100");

        TransferRequest request = new TransferRequest();
        request.setFromAccountNumber("123");
        request.setToAccountNumber("456");
        request.setValue(amount);

        AccountModel fromAccount = AccountModel.builder()
                .numberAccount("123")
                .balance(new BigDecimal("500"))
                .build();

        AccountModel toAccount = AccountModel.builder()
                .numberAccount("456")
                .balance(new BigDecimal("200"))
                .build();

        when(accountRepository.findByNumberAccount("123"))
                .thenReturn(Optional.of(fromAccount));

        when(accountRepository.findByNumberAccount("456"))
                .thenReturn(Optional.of(toAccount));

        when(transactionRepository.save(any()))
                .thenAnswer(invocation -> {
                    TransactionModel tx = invocation.getArgument(0);
                    tx.setId(UUID.randomUUID());
                    return tx;
                });

        TransferResponse response = paymentService.transfer(request);

        // valida saldo atualizado
        assertEquals(new BigDecimal("400"), fromAccount.getBalance());
        assertEquals(new BigDecimal("300"), toAccount.getBalance());

        // valida que salvou
        verify(accountRepository).save(fromAccount);
        verify(accountRepository).save(toAccount);
        verify(transactionRepository).save(any());

        verify(rabbitTemplate).convertAndSend(
                eq(RabbitConfig.TRANSFER_EXCHANGE),
                eq(RabbitConfig.TRANSFER_ROUTING_KEY),
                any(TransferMessage.class)
        );
        assertNotNull(response.getTransactionId());
    }
}