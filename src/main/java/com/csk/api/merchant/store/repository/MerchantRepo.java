package com.csk.api.merchant.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csk.api.merchant.store.entity.MerchantDO;

public interface MerchantRepo extends JpaRepository<MerchantDO, Integer> {

}
