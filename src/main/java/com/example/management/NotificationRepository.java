package com.example.management;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository  extends JpaRepository<Notification, Long>{

	Set<Notification> findBytohotelId(Long hotel_id);

	Set<Notification> findBystaffId(Long i);

}
