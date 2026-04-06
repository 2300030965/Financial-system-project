package com.klef.fsad.service.customer;

import com.klef.fsad.entity.User;
import com.klef.fsad.entity.Wallet;
import com.klef.fsad.repository.UserRepository;
import com.klef.fsad.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CustomerWalletServiceImpl implements CustomerWalletService {

    private final WalletRepository walletRepository;
    private final UserRepository userRepository;

    public CustomerWalletServiceImpl(WalletRepository walletRepository,
                                     UserRepository userRepository) {
        this.walletRepository = walletRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Wallet getWallet(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return walletRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
    }

    @Override
    public Wallet addMoney(String email, double amount) {
        Wallet wallet = getWallet(email);

        wallet.setBalance(wallet.getBalance().add(BigDecimal.valueOf(amount)));

        return walletRepository.save(wallet);
    }

    @Override
    public Wallet withdrawMoney(String email, double amount) {
        Wallet wallet = getWallet(email);

        if (wallet.getBalance().doubleValue() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        wallet.setBalance(wallet.getBalance().subtract(BigDecimal.valueOf(amount)));

        return walletRepository.save(wallet);
    }
}