package com.example.practice4.repository;

import com.example.practice4.model.EmailNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailNotificationRepository extends JpaRepository<EmailNotification, Long> {
}
