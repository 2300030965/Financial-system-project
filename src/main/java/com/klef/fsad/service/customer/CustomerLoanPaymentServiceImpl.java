package com.klef.fsad.service.customer;

import com.klef.fsad.entity.Loan;
import com.klef.fsad.entity.LoanPayment;
import com.klef.fsad.repository.LoanPaymentRepository;
import com.klef.fsad.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerLoanPaymentServiceImpl implements CustomerLoanPaymentService {

    private final LoanRepository loanRepository;
    private final LoanPaymentRepository paymentRepository;

    public CustomerLoanPaymentServiceImpl(LoanRepository loanRepository,
                                          LoanPaymentRepository paymentRepository) {
        this.loanRepository = loanRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public LoanPayment payLoan(String email, Long loanId, double amount) {

        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        // 🔥 SECURITY CHECK
        if (!loan.getUser().getEmail().equals(email)) {
            throw new RuntimeException("Access denied");
        }

        if (loan.getRemainingAmount() <= 0) {
            throw new RuntimeException("Loan already completed");
        }

        // 🔥 update loan
        loan.setRemainingAmount(loan.getRemainingAmount() - amount);
        loan.setRemainingMonths(loan.getRemainingMonths() - 1);

        if (loan.getRemainingAmount() <= 0) {
            loan.setRemainingAmount(0);
            loan.setRemainingMonths(0);
            loan.setStatus("CLOSED");
        }

        loanRepository.save(loan);

        // 🔥 save payment
        LoanPayment payment = new LoanPayment();
        payment.setLoan(loan);
        payment.setAmount(amount);
        payment.setPaymentDate(LocalDate.now());

        return paymentRepository.save(payment);
    }
}