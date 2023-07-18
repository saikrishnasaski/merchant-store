package com.csk.api.merchant.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csk.api.merchant.store.ResponseMapper;
import com.csk.api.merchant.store.entity.MerchantDO;
import com.csk.api.merchant.store.model.MerchantRequest;
import com.csk.api.merchant.store.model.MerchantResponse;
import com.csk.api.merchant.store.service.MerchantService;
import com.csk.api.merchant.store.validator.RequestValidator;

@RestController
@RequestMapping("/v1")
public class MerchantController {
	
	private MerchantService merchantService;
	private RequestValidator requestValidator;
	private ResponseMapper mapper;
	@Autowired
	public MerchantController(MerchantService merchantService, RequestValidator requestValidator, ResponseMapper mapper) {
		this.merchantService = merchantService;
		this.requestValidator = requestValidator;
		this.mapper = mapper;
	}

	@GetMapping(value = "/version", produces = "application/json")
	public ResponseEntity<String> getVersion() {
		return new ResponseEntity<String>(merchantService.getVersion(), HttpStatus.OK);
	}
	
	@PostMapping(value ="/merchants", consumes = "application/json", produces = "application/json")
	public ResponseEntity<MerchantResponse> createMerchant(@RequestBody MerchantRequest request) {
		MerchantDO merchantInputBean = requestValidator.validateCreateMerchant(request);
		MerchantDO merchant = merchantService.createMerchant(merchantInputBean);
		MerchantResponse response = mapper.mapCreateMerchant(merchant);
		return new ResponseEntity<MerchantResponse>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/merchants/{merchantId}", produces = "application/json")
	public ResponseEntity<MerchantResponse> getMerchant(@PathVariable String merchantId) {
		requestValidator.validateGetMerchant(merchantId);
		MerchantDO merchant = merchantService.getMerchant(merchantId);
		MerchantResponse response = mapper.mapCreateMerchant(merchant);
		return new ResponseEntity<MerchantResponse>(response, HttpStatus.OK);
	}

}
