package com.klef.fsad.controller.viewer;

import com.klef.fsad.entity.Insurance;
import com.klef.fsad.service.viewer.ViewerInsuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viewer/insurance")
public class ViewerInsuranceController {

    private final ViewerInsuranceService service;

    public ViewerInsuranceController(ViewerInsuranceService service) {
        this.service = service;
    }

    // 👁 ONLY VIEW
    @GetMapping
    public List<Insurance> getAll() {
        return service.getAll();
    }
}