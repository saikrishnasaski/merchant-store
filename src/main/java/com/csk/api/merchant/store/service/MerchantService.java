package com.csk.api.merchant.store.service;

import com.csk.api.merchant.store.entity.MerchantDO;

public interface MerchantService {
	
	public String getVersion();
	
	public MerchantDO createMerchant(MerchantDO merchant);
	public MerchantDO getMerchant(String merchantId);

}
