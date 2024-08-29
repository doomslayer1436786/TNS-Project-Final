package com.tns.shoppingmallsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.shoppingmallsystem.model.Mall;

public interface MallRepo extends JpaRepository<Mall, Long> {
}
