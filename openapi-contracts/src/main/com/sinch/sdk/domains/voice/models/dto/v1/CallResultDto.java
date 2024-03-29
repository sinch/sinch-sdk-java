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

/** Contains the result of a call. */
public enum CallResultDto {
  N_A("N/A"),

  ANSWERED("ANSWERED"),

  BUSY("BUSY"),

  NOANSWER("NOANSWER"),

  FAILED("FAILED"),

  UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

  private String value;

  CallResultDto(String value) {
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
  public static CallResultDto fromValue(String value) {
    for (CallResultDto b : CallResultDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    return UNKNOWN_DEFAULT_OPEN_API;
  }
}
