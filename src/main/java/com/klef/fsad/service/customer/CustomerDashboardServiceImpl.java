package com.klef.fsad.service.customer;

import com.klef.fsad.entity.User;
import com.klef.fsad.entity.Wallet;
import com.klef.fsad.repository.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerDashboardServiceImpl implements CustomerDashboardService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final LoanRepository loanRepository;
    private final InvestmentRepository investmentRepository;
    private final TransactionRepository transactionRepository;

    public CustomerDashboardServiceImpl(UserRepository userRepository,
                                        WalletRepository walletRepository,
                                        LoanRepository loanRepository,
                                        InvestmentRepository investmentRepository,
                                        TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.walletRepository = walletRepository;
        this.loanRepository = loanRepository;
        this.investmentRepository = investmentRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Object getDashboard(String email) {

        // ✅ Get user
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Map<String, Object> data = new HashMap<>();

        // ✅ Basic details
        data.put("name", user.getFullName());
        data.put("email", user.getEmail());

        double balance = walletRepository.findByUser(user)
                .map(wallet -> wallet.getBalance().doubleValue())
                .orElse(0.0);
        data.put("balance", balance);

        // ✅ Other data
        data.put("loans", loanRepository.findByUser(user));
        data.put("investments", investmentRepository.findByUser(user));
        data.put("transactions", transactionRepository.findByUser(user));

        return data;
    }
}