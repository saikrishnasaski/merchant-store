package com.csk.api.merchant.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csk.api.merchant.store.entity.AddressDO;

public interface AddressRepo extends JpaRepository<AddressDO, Integer> {

}
