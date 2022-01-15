package com.example.practice4.repository;

import com.example.practice4.model.LogData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogDataRepository extends JpaRepository<LogData, Long> {
}
