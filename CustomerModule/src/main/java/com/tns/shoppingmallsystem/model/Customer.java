package com.tns.shoppingmallsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    private int id;
    private String name;
    @Column(name = "order_id")
    private String orderId;
    private String phone;
    private String email;

    // Constructor to initialize the data members
    public Customer(int id, String name, String orderId, String phone, String email) {
        this.id = id;
        this.name = name;
        this.orderId = orderId;
        this.phone = phone;
        this.email = email;
    }

    public Customer() {
        super();
    }

    // Getters and Setters (optional)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderId='" + orderId + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
