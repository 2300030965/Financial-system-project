package com.klef.fsad.service.customer;

import com.klef.fsad.entity.Wallet;

public interface CustomerWalletService {

    Wallet getWallet(String email);

    Wallet addMoney(String email, double amount);

    Wallet withdrawMoney(String email, double amount);
}