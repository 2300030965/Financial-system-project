package com.klef.fsad.entity;

import jakarta.persistence.*;

@Entity
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String planName;
    private double amount;
    private double interestRate;

    // 🔥 ADD THIS (VERY IMPORTANT)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // getters & setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPlanName() { return planName; }
    public void setPlanName(String planName) { this.planName = planName; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    // 🔥 NEW METHODS
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}