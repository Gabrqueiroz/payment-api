package com.gabrielqueiroz.payment_api.repositorys;

import com.gabrielqueiroz.payment_api.models.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountModel, UUID> {
}
