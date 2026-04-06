package com.klef.fsad.service.viewer;

import com.klef.fsad.repository.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ViewerDashboardServiceImpl implements ViewerDashboardService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final LoanRepository loanRepository;
    private final InvestmentRepository investmentRepository;
    private final TransactionRepository transactionRepository;

    public ViewerDashboardServiceImpl(UserRepository userRepository,
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
    public Object getDashboard() {

        Map<String, Object> data = new HashMap<>();

        data.put("totalUsers", userRepository.count());
        data.put("totalWallets", walletRepository.count());
        data.put("totalLoans", loanRepository.count());
        data.put("totalInvestments", investmentRepository.count());
        data.put("totalTransactions", transactionRepository.count());

        return data;
    }
}