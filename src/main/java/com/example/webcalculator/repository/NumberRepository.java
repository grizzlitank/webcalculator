package com.example.webcalculator.repository;

import com.example.webcalculator.model.Numbers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepository extends JpaRepository<Numbers, Integer> {
}
