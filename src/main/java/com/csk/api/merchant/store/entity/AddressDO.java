package com.csk.api.merchant.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TMD_ADDRESS")
public class AddressDO {
	  
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "ADDRESS_ID", insertable = false, updatable = false)
	  private Integer addressId;

	  @Column(name = "COUNTRY")
	  private String country;

	  @Column(name = "STATE")
	  private String state;

	  @Column(name = "SUB_DIVISION")
	  private String division;
	  
}
