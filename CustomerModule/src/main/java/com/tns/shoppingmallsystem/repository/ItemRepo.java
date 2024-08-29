package com.tns.shoppingmallsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.shoppingmallsystem.model.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {
    List<Item> findByName(String name);
}