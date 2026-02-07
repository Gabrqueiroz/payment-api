package com.gabrielqueiroz.payment_api.repositorys;

import com.gabrielqueiroz.payment_api.models.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountModel, UUID> {
    Optional<AccountModel> findByNumberAccount(String numberAccount);

}
