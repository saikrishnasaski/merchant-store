package com.csk.api.merchant.store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.csk.api.merchant.store.entity.AddressDO;
import com.csk.api.merchant.store.entity.MerchantDO;
import com.csk.api.merchant.store.model.AddressResponse;
import com.csk.api.merchant.store.model.Merchant;
import com.csk.api.merchant.store.model.MerchantResponse;
import com.csk.api.merchant.store.model.Store;
import com.csk.api.merchant.store.model.StoreResponse;

@Component
public class ResponseMapper {

	private List<StoreResponse> storeList;
	private StoreResponse storeResponse;
	private Store store;
	private AddressResponse addressResponse;

	public MerchantResponse mapCreateMerchant(MerchantDO merchantInputBean) {
		MerchantResponse response = new MerchantResponse();
		List<StoreResponse> storeList = new ArrayList<>();
		if (merchantInputBean != null) {
			response.setMerchantId(String.valueOf(merchantInputBean.getMerchantId()));
			Merchant merchant = new Merchant();
			merchant.setMerchantName(merchantInputBean.getMerchantName());
			merchant.setMerchantCategoryCode(merchantInputBean.getMerchantCategoryCode());
			response.setMerchant(merchant);
			if (merchantInputBean.getStores() != null) {
				merchantInputBean.getStores().forEach(s -> {
					storeResponse = new StoreResponse();
					storeResponse.setStoreId(String.valueOf(s.getStoreId()));
					store = new Store();
					store.setStoreName(s.getStoreName());
					store.setModeOfPayment(Arrays.asList(s.getModeOfPayment().split(" ")));
					storeResponse.setStore(store);
					AddressDO add = s.getAddress();
					addressResponse = new AddressResponse();
					addressResponse.setAddressId(String.valueOf(add.getAddressId()));
					addressResponse.setCountry(add.getCountry());
					addressResponse.setState(add.getState());
					addressResponse.setDivision(add.getDivision());
					storeResponse.setAddress(addressResponse);
					storeList.add(storeResponse);
				});
				response.setStores(storeList);
			}

		}
		return response;
	}

}
