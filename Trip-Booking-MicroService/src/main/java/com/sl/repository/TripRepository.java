package com.sl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sl.entity.TripBooking;

@Repository
public interface TripRepository extends JpaRepository<TripBooking, Long>{

}
