package com.csk.api.merchant.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csk.api.merchant.store.entity.StoreDO;

public interface StoreRepo extends JpaRepository<StoreDO, Integer> {

}
