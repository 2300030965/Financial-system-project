package com.klef.fsad.service.viewer;

import com.klef.fsad.entity.Insurance;
import com.klef.fsad.repository.InsuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewerInsuranceServiceImpl implements ViewerInsuranceService {

    private final InsuranceRepository repo;

    public ViewerInsuranceServiceImpl(InsuranceRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Insurance> getAll() {
        return repo.findAll();
    }
}