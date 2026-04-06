package com.klef.fsad.service.customer;

import com.klef.fsad.entity.Loan;
import com.klef.fsad.entity.LoanPayment;
import com.klef.fsad.entity.User;
import com.klef.fsad.repository.LoanPaymentRepository;
import com.klef.fsad.repository.LoanRepository;
import com.klef.fsad.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerLoanServiceImpl implements CustomerLoanService {

    private final LoanRepository loanRepository;
    private final LoanPaymentRepository loanPaymentRepository;
    private final UserRepository userRepository;

    public CustomerLoanServiceImpl(LoanRepository loanRepository,
                                   LoanPaymentRepository loanPaymentRepository,
                                   UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.loanPaymentRepository = loanPaymentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Loan applyLoan(String email, Loan loan) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        loan.setUser(user);
        loan.setStatus("ACTIVE");
        loan.setRemainingAmount(loan.getTotalAmount());
        loan.setRemainingMonths(loan.getTotalMonths());

        if (loan.getStartDate() == null) {
            loan.setStartDate(LocalDate.now());
        }

        if (loan.getTotalMonths() > 0 && loan.getEmiAmount() == 0) {
            loan.setEmiAmount(loan.getTotalAmount() / loan.getTotalMonths());
        }

        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getMyLoans(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return loanRepository.findByUser(user);
    }

    @Override
    public List<Loan> filterLoans(String email,
                                  String type,
                                  String category,
                                  String startDate,
                                  String endDate) {

        if (type != null && !type.isBlank()) {
            return loanRepository.findByUserEmailAndType(email, type);
        }

        if (category != null && !category.isBlank()) {
            return loanRepository.findByUserEmailAndCategory(email, category);
        }

        if (startDate != null && endDate != null &&
                !startDate.isBlank() && !endDate.isBlank()) {
            return loanRepository.findByUserEmailAndStartDateBetween(
                    email,
                    LocalDate.parse(startDate),
                    LocalDate.parse(endDate)
            );
        }

        return loanRepository.findByUserEmail(email);
    }

    @Override
    public LoanPayment payLoan(String email, Long loanId, double amount) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        if (!loan.getUser().getEmail().equals(email)) {
            throw new RuntimeException("You cannot pay another user's loan");
        }

        if (loan.getRemainingAmount() <= 0) {
            throw new RuntimeException("Loan already completed");
        }

        if (amount <= 0) {
            throw new RuntimeException("Payment amount must be greater than zero");
        }

        double newRemainingAmount = loan.getRemainingAmount() - amount;
        loan.setRemainingAmount(Math.max(newRemainingAmount, 0));

        if (loan.getRemainingMonths() > 0) {
            loan.setRemainingMonths(loan.getRemainingMonths() - 1);
        }

        if (loan.getRemainingAmount() <= 0 || loan.getRemainingMonths() <= 0) {
            loan.setRemainingAmount(0);
            loan.setRemainingMonths(0);
            loan.setStatus("CLOSED");
        } else {
            loan.setStatus("ACTIVE");
        }

        loanRepository.save(loan);

        LoanPayment payment = new LoanPayment();
        payment.setLoan(loan);
        payment.setAmount(amount);
        payment.setPaymentDate(LocalDate.now());

        return loanPaymentRepository.save(payment);
    }

    @Override
    public Map<String, Object> getLoanStatus(String email) {
        List<Loan> loans = loanRepository.findByUserEmail(email);

        double totalLoanTaken = 0;
        double totalRemainingAmount = 0;
        int activeLoans = 0;

        for (Loan loan : loans) {
            totalLoanTaken += loan.getTotalAmount();
            totalRemainingAmount += loan.getRemainingAmount();

            if ("ACTIVE".equalsIgnoreCase(loan.getStatus())) {
                activeLoans++;
            }
        }

        Map<String, Object> data = new HashMap<>();
        data.put("totalLoanTaken", totalLoanTaken);
        data.put("remainingAmount", totalRemainingAmount);
        data.put("activeLoans", activeLoans);
        data.put("loans", loans);

        if (!loans.isEmpty()) {
            Loan currentLoan = loans.get(0);
            LocalDate nextPaymentDate = currentLoan.getStartDate()
                    .plusMonths(currentLoan.getTotalMonths() - currentLoan.getRemainingMonths());

            data.put("currentLoanAmount", currentLoan.getTotalAmount());
            data.put("currentLoanRemaining", currentLoan.getRemainingAmount());
            data.put("currentLoanEMI", currentLoan.getEmiAmount());
            data.put("remainingMonths", currentLoan.getRemainingMonths());
            data.put("nextPaymentDate", nextPaymentDate);
            data.put("loanStatus", currentLoan.getStatus());
        }

        return data;
    }

    @Override
    public List<LoanPayment> getLoanPayments(Long loanId) {
        return loanPaymentRepository.findByLoanId(loanId);
    }
}