package com.klef.fsad.controller.viewer;

import com.klef.fsad.entity.Investment;
import com.klef.fsad.service.viewer.ViewerInvestmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viewer/investments")
public class ViewerInvestmentController {

    private final ViewerInvestmentService service;

    public ViewerInvestmentController(ViewerInvestmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Investment> getAllInvestments() {
        return service.getAllInvestments();
    }
}