package com.example.demo.Repository;

import com.example.demo.Domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
