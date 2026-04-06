package com.klef.fsad.service.admin;

import com.klef.fsad.entity.Insurance;
import com.klef.fsad.repository.InsuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminInsuranceServiceImpl implements AdminInsuranceService {

    private final InsuranceRepository repo;

    public AdminInsuranceServiceImpl(InsuranceRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Insurance> getAll() {
        return repo.findAll();
    }

    @Override
    public Insurance approve(Long id) {
        Insurance i = repo.findById(id).orElseThrow();
        i.setStatus("APPROVED");
        return repo.save(i);
    }

    @Override
    public Insurance reject(Long id) {
        Insurance i = repo.findById(id).orElseThrow();
        i.setStatus("REJECTED");
        return repo.save(i);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}