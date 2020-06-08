package com.csk.api.merchant.store.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TMD_STORE")
public class StoreDO {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "STORE_ID")
	  private Integer storeId;	

	  @Column(name = "STORE_NAME")
	  private String storeName;

	  @Column(name = "PAYMENT_MODE")
	  private String modeOfPayment;
	  
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "ADDRESS_ID")
	  private AddressDO address;
}
