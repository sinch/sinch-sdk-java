/*
 * Voice API | Sinch
 * The Voice API exposes calling- and conference-related functionality in the Sinch Voice Platform.
 *
 * The version of the OpenAPI document: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Can be of type &#x60;number&#x60; for PSTN endpoints or of type &#x60;username&#x60; for data
 * endpoints.
 */
public enum DestinationTypeDto {
  NUMBER("number"),

  NUMBER2("Number"),

  USERNAME("username"),

  USERNAME2("Username"),

  SIP("sip"),

  DID("did"),

  UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

  private String value;

  DestinationTypeDto(String value) {
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
  public static DestinationTypeDto fromValue(String value) {
    for (DestinationTypeDto b : DestinationTypeDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    return UNKNOWN_DEFAULT_OPEN_API;
  }
}
