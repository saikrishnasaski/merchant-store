package com.csk.api.merchant.store.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="TMD_MRCHNT")
public class MerchantDO {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "I_MRCHNT")
	  private Integer merchantId;		 

	  @Column(name = "MRCHNT_NAME")
	  private String merchantName;

	  @Column(name = "MRCHNT_CAT_CODE")
	  private String merchantCategoryCode;
	  
	  @OneToMany(cascade = CascadeType.ALL)
	  @JoinColumn(name = "STORE_ID")
	  private List<StoreDO> stores;
}
