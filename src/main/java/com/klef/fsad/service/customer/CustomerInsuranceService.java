package com.klef.fsad.service.customer;

import com.klef.fsad.entity.Insurance;
import java.util.List;

public interface CustomerInsuranceService {
    Insurance create(String email, Insurance ins);
    List<Insurance> getMy(String email);
    Insurance update(Long id, Insurance ins);
    void delete(Long id);
}