/*
 * Merchant Store API
 * Boarding Merchants and Creating Stores for Merchants
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.csk.api.merchant.store.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination   {
  @JsonProperty("offset")
  private String offset = null;

  @JsonProperty("limit")
  private String limit = null;

}
