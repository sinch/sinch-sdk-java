/*
 * Numbers | Sinch
 * An API service for getting, listing and managing Sinch virtual numbers.
 *
 * The version of the OpenAPI document: 1.0.2
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.numbers.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The provisioning status. It will be either &#x60;WAITING&#x60;, &#x60;IN_PROGRESS&#x60; or
 * &#x60;FAILED&#x60;. If the provisioning fails, a reason for the failure will be provided.
 */
public enum ProvisioningStatusDto {
  PROVISIONING_STATUS_UNSPECIFIED("PROVISIONING_STATUS_UNSPECIFIED"),

  WAITING("WAITING"),

  IN_PROGRESS("IN_PROGRESS"),

  FAILED("FAILED"),

  UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

  private String value;

  ProvisioningStatusDto(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ProvisioningStatusDto fromValue(String value) {
    for (ProvisioningStatusDto b : ProvisioningStatusDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    return UNKNOWN_DEFAULT_OPEN_API;
  }
}
