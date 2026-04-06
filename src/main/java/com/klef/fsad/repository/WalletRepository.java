package com.klef.fsad.repository;

import com.klef.fsad.entity.User;
import com.klef.fsad.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Optional<Wallet> findByUser(User user);
}