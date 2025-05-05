package com.jvictornascimento.urlshortene.repositories;

import com.jvictornascimento.urlshortene.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
