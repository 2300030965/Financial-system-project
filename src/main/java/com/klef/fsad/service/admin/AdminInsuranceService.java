package com.klef.fsad.service.admin;

import com.klef.fsad.entity.Insurance;
import java.util.List;

public interface AdminInsuranceService {
    List<Insurance> getAll();
    Insurance approve(Long id);
    Insurance reject(Long id);
    void delete(Long id);
}