package com.klef.fsad.controller.viewer;

import com.klef.fsad.service.viewer.ViewerDashboardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/viewer/dashboard")
public class ViewerDashboardController {

    private final ViewerDashboardService service;

    public ViewerDashboardController(ViewerDashboardService service) {
        this.service = service;
    }

    @GetMapping
    public Object getDashboard() {
        return service.getDashboard();
    }
}