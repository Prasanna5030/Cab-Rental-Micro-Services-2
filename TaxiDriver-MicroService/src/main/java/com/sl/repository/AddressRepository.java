package com.sl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sl.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
