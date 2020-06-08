package com.csk.api.merchant.store.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.csk.api.merchant.store.entity.AddressDO;
import com.csk.api.merchant.store.entity.MerchantDO;
import com.csk.api.merchant.store.entity.StoreDO;
import com.csk.api.merchant.store.exception.BadRequestException;
import com.csk.api.merchant.store.model.Address;
import com.csk.api.merchant.store.model.Error;
import com.csk.api.merchant.store.model.MerchantRequest;
import com.csk.api.merchant.store.util.AppConstants;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RequestValidator {

	private StoreDO storeDO;
	private AddressDO addressDO;
	private List<StoreDO> stores;
	private List<AddressDO> addressList;

	public MerchantDO validateCreateMerchant(MerchantRequest request) {
		MerchantDO merchant = new MerchantDO();
		List<Error> errors = new ArrayList<>();
		if (request != null) {
			if (request.getMerchant() != null) {
				if (StringUtils.isBlank(request.getMerchant().getMerchantName()))
					errors.add(new Error(AppConstants.ERROR_REQUEST_PARAM, AppConstants.FIELD_REQUIRED,
							"Merchant Name is required.", "merchantName"));
				else
					merchant.setMerchantName(request.getMerchant().getMerchantName());
				if (StringUtils.isBlank(request.getMerchant().getMerchantCategoryCode()))
					errors.add(new Error(AppConstants.ERROR_REQUEST_PARAM, AppConstants.FIELD_REQUIRED,
							"Merchant Category Code is required.", "merchantCategoryCode"));
				else
					merchant.setMerchantCategoryCode(request.getMerchant().getMerchantCategoryCode());
			} else
				errors.add(new Error(AppConstants.ERROR_REQUEST_STRUCTURE, AppConstants.FIELD_REQUIRED,
						"Merchant is required.", "merchant"));
			if (CollectionUtils.isEmpty(request.getStores()))
				errors.add(new Error(AppConstants.ERROR_REQUEST_STRUCTURE, AppConstants.FIELD_REQUIRED,
						"Store is required.", "store"));
			else {
				stores = new ArrayList<>();
				request.getStores().forEach(store -> {
					storeDO = new StoreDO();
					if (StringUtils.isBlank(store.getStore().getStoreName()))
						errors.add(new Error(AppConstants.ERROR_REQUEST_PARAM, AppConstants.FIELD_REQUIRED,
								"Store Name is required.", "storeName"));
					else
						storeDO.setStoreName(store.getStore().getStoreName());
					if (CollectionUtils.isEmpty(store.getStore().getModeOfPayment()))
						errors.add(new Error(AppConstants.ERROR_REQUEST_PARAM, AppConstants.FIELD_REQUIRED,
								"Mode of Payment is required.", "modeOfPayment"));
					else {
						store.getStore().getModeOfPayment().forEach(mode -> {
							if (storeDO.getModeOfPayment() == null)
								storeDO.setModeOfPayment(mode);
							else
								storeDO.setModeOfPayment(storeDO.getModeOfPayment() + " " + mode);
						});
					}
					if (store.getAddress() == null)
						errors.add(new Error(AppConstants.ERROR_REQUEST_STRUCTURE, AppConstants.FIELD_REQUIRED,
								"Address is required.", "address"));
					else {
						Address address = store.getAddress();
						addressDO = new AddressDO();
						addressDO.setCountry(address.getCountry());
						addressDO.setState(address.getState());
						addressDO.setDivision(address.getState());
						storeDO.setAddress(addressDO);
					}
					stores.add(storeDO);
				});
				merchant.setStores(stores);
			}
		}
		if (!CollectionUtils.isEmpty(errors)) {
			throw new BadRequestException(errors);
		}
		log.info("Create Merchant Request: {}", merchant);
		return merchant;
	}

	public void validateGetMerchant(String merchantId) {
		List<Error> errors = new ArrayList<>();
		if (StringUtils.isBlank(merchantId))
			errors.add(new Error(AppConstants.ERROR_REQUEST_PARAM, AppConstants.FIELD_REQUIRED,
					"Merchant Id is required", "merchantId"));
		else if (!StringUtils.isNumeric(merchantId))
			errors.add(new Error(AppConstants.ERROR_REQUEST_PARAM, AppConstants.INVALID_FIELD, "Invalid Merchant Id",
					"merchantId"));
		else {
			try {
				Integer.parseInt(merchantId);
			} catch (NumberFormatException e) {
				errors.add(new Error(AppConstants.ERROR_REQUEST_PARAM, AppConstants.INVALID_FIELD,
						"Merchant Id exceeds maximum value permitted.", "merchantId"));
			}
		}
		if (!CollectionUtils.isEmpty(errors)) {
			throw new BadRequestException(errors);
		}
	}

}
