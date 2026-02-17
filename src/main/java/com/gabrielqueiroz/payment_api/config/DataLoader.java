package com.gabrielqueiroz.payment_api.config;

import com.gabrielqueiroz.payment_api.models.AccountModel;
import com.gabrielqueiroz.payment_api.models.UserModel;
import com.gabrielqueiroz.payment_api.repositorys.AccountRepository;
import com.gabrielqueiroz.payment_api.repositorys.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Component
@RequiredArgsConstructor
    public class DataLoader implements CommandLineRunner {

        private final UserRepository userRepository;
        private final AccountRepository accountRepository;
        private final PasswordEncoder passwordEncoder;

        @Override
        public void run(String... args) {

            if (userRepository.count() > 0) return;

            UserModel user1 = UserModel.builder()
                    .fullName("João Silva")
                    .email("joao@mock.com")
                    .password(passwordEncoder.encode("123456"))
                    .createdAt(LocalDateTime.now())
                    .build();

            userRepository.save(user1);

            AccountModel acc1 = AccountModel.builder()
                    .numberAccount("000123-1")
                    .agency("0001")
                    .balance(new BigDecimal("1500.00"))
                    .createdAt(LocalDateTime.now())
                    .user(user1)
                    .build();

            accountRepository.save(acc1);

            UserModel user2 = UserModel.builder()
                    .fullName("Maria Souza")
                    .email("maria@mock.com")
                    .password(passwordEncoder.encode("123456"))
                    .createdAt(LocalDateTime.now())
                    .build();

            userRepository.save(user2);

            AccountModel acc2 = AccountModel.builder()
                    .numberAccount("000124-1")
                    .agency("0001")
                    .balance(new BigDecimal("3200.00"))
                    .createdAt(LocalDateTime.now())
                    .user(user2)
                    .build();

            accountRepository.save(acc2);

            System.out.println("🚀 Dados mock criados!");
        }
    }


