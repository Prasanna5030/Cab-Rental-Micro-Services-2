package com.sl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sl.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {

	List<Driver> findByAvailable(Boolean b);


}
