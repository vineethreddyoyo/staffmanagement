package com.example.management;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository  extends JpaRepository<Images, Long> {

	List<Images> findBymanagerId(Long staff_id);

}
