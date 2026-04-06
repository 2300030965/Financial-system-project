package com.klef.fsad.service.customer;

import com.klef.fsad.entity.Investment;
import com.klef.fsad.entity.User;
import com.klef.fsad.repository.InvestmentRepository;
import com.klef.fsad.repository.TransactionRepository;
import com.klef.fsad.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerInvestmentServiceImpl implements CustomerInvestmentService {

    private final TransactionRepository transactionRepository;

    private final InvestmentRepository investmentRepository;
    private final UserRepository userRepository;


    public CustomerInvestmentServiceImpl(InvestmentRepository investmentRepository,
                                         UserRepository userRepository, TransactionRepository transactionRepository) {
        this.investmentRepository = investmentRepository;
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Investment invest(String email, Investment inv) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        inv.setUser(user);

        return investmentRepository.save(inv);
    }

    @Override
    public List<Investment> getMy(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return investmentRepository.findByUser(user);
    }
    
    @Override
    public List<Investment> filterInvestments(
            String email,
            String type,
            String category,
            String startDate,
            String endDate) {

        if (type != null) {
            return investmentRepository.findByUserEmailAndType(email, type);
        }

        if (category != null) {
            return investmentRepository.findByUserEmailAndCategory(email, category);
        }

        if (startDate != null && endDate != null) {
            return investmentRepository.findByUserEmailAndDateBetween(
                    email,
                    java.time.LocalDate.parse(startDate),
                    java.time.LocalDate.parse(endDate)
            );
        }

        return investmentRepository.findByUserEmail(email);
    }
}