package com.csk.api.merchant.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MerchantStoreApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MerchantStoreApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MerchantStoreApplication.class);
	}

}
