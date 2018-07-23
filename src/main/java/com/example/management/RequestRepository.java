package com.example.management;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RequestRepository extends JpaRepository<Request, Long>{

	List<Request> findByhotelId(Long to_hotel_id);
	
}
