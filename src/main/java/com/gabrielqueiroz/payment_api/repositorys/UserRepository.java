package com.gabrielqueiroz.payment_api.repositorys;

import com.gabrielqueiroz.payment_api.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}