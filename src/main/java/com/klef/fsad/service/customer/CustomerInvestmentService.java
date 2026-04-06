package com.klef.fsad.service.customer;

import com.klef.fsad.entity.Investment;
import java.util.List;

public interface CustomerInvestmentService {

    Investment invest(String email, Investment inv);

    List<Investment> getMy(String email);
    
    List<Investment> filterInvestments(
            String email,
            String type,
            String category,
            String startDate,
            String endDate
    );
}