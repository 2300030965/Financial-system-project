package com.klef.fsad.service.customer;

import com.klef.fsad.entity.Insurance;
import com.klef.fsad.repository.InsuranceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerInsuranceServiceImpl implements CustomerInsuranceService {

    private final InsuranceRepository repo;

    public CustomerInsuranceServiceImpl(InsuranceRepository repo) {
        this.repo = repo;
    }

    @Override
    public Insurance create(String email, Insurance ins) {
        ins.setUserEmail(email);
        ins.setStatus("PENDING");
        ins.setCreatedDate(LocalDate.now());
        return repo.save(ins);
    }

    @Override
    public List<Insurance> getMy(String email) {
        return repo.findByUserEmail(email);
    }

    @Override
    public Insurance update(Long id, Insurance ins) {
        Insurance i = repo.findById(id).orElseThrow();
        i.setType(ins.getType());
        i.setAmount(ins.getAmount());
        i.setDuration(ins.getDuration());
        return repo.save(i);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}