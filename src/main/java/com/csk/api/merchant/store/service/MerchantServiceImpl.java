package com.csk.api.merchant.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csk.api.merchant.store.entity.MerchantDO;
import com.csk.api.merchant.store.repository.MerchantRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(readOnly = false)
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private BuildProperties buildProperties;
	
	@Autowired
	private MerchantRepo merchantRepo;
	
	@Override
	public String getVersion() {
		return buildProperties.getVersion();
	}

	@Override
	public MerchantDO createMerchant(MerchantDO merchant) {
		log.info("Dao obj: {}", merchant);
		return merchantRepo.saveAndFlush(merchant);
	}

	@Override
	public MerchantDO getMerchant(String merchantId) {
		return merchantRepo.getOne(Integer.valueOf(merchantId));
	}

}
