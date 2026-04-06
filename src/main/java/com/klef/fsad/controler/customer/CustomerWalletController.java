package com.klef.fsad.controler.customer;

import com.klef.fsad.entity.Wallet;
import com.klef.fsad.service.customer.CustomerWalletService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer/wallet")
public class CustomerWalletController {

    private final CustomerWalletService service;

    public CustomerWalletController(CustomerWalletService service) {
        this.service = service;
    }

    @GetMapping
    public Wallet getWallet(Authentication auth) {
        return service.getWallet(auth.getName());
    }

    @PostMapping("/add")
    public Wallet addMoney(Authentication auth, @RequestParam double amount) {
        return service.addMoney(auth.getName(), amount);
    }

    @PostMapping("/withdraw")
    public Wallet withdraw(Authentication auth, @RequestParam double amount) {
        return service.withdrawMoney(auth.getName(), amount);
    }
}