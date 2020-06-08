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
public class Error {
  @JsonProperty("errorCode")
  private String errorCode = null;

  @JsonProperty("errorType")
  private String errorType = null;

  @JsonProperty("errorMessage")
  private String errorMessage = null;

  @JsonProperty("target")
  private String target = null;

}
