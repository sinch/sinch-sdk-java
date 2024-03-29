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

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** The request to update the callbacks configuration for the current project */
@JsonPropertyOrder({CallbackConfigurationUpdateDto.JSON_PROPERTY_HMAC_SECRET})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CallbackConfigurationUpdateDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_HMAC_SECRET = "hmacSecret";
  private String hmacSecret;
  private boolean hmacSecretDefined = false;

  public CallbackConfigurationUpdateDto() {}

  public CallbackConfigurationUpdateDto hmacSecret(String hmacSecret) {
    this.hmacSecret = hmacSecret;
    this.hmacSecretDefined = true;
    return this;
  }

  /**
   * The HMAC secret to be updated for the specified project
   *
   * @return hmacSecret
   */
  @JsonProperty(JSON_PROPERTY_HMAC_SECRET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getHmacSecret() {
    return hmacSecret;
  }

  @JsonIgnore
  public boolean getHmacSecretDefined() {
    return hmacSecretDefined;
  }

  @JsonProperty(JSON_PROPERTY_HMAC_SECRET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHmacSecret(String hmacSecret) {
    this.hmacSecret = hmacSecret;
    this.hmacSecretDefined = true;
  }

  /** Return true if this CallbackConfigurationUpdate object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallbackConfigurationUpdateDto callbackConfigurationUpdate = (CallbackConfigurationUpdateDto) o;
    return Objects.equals(this.hmacSecret, callbackConfigurationUpdate.hmacSecret);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hmacSecret);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallbackConfigurationUpdateDto {\n");
    sb.append("    hmacSecret: ").append(toIndentedString(hmacSecret)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
