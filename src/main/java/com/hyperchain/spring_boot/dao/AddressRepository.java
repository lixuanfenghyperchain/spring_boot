package com.hyperchain.spring_boot.dao;

import com.hyperchain.spring_boot.entitiy.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
