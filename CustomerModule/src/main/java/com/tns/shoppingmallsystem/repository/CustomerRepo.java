package com.tns.shoppingmallsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.shoppingmallsystem.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
