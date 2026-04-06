package com.klef.fsad.entity;

import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private String type;
    private String status;

    // 🔥 ADD THIS (VERY IMPORTANT)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // getters & setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // 🔥 NEW METHODS
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}