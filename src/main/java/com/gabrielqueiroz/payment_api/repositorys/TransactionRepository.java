package com.gabrielqueiroz.payment_api.repositorys;

import com.gabrielqueiroz.payment_api.models.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionModel, UUID> {
    List<TransactionModel> findByFromAccount_NumberAccount(String numberAccount);

    List<TransactionModel> findByToAccount_NumberAccount(String numberAccount);
}

