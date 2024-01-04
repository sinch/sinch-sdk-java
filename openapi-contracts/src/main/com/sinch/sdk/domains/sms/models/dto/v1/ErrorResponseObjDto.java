/*
 * API Overview | Sinch
 * Sinch SMS API is one of the easiest APIs we offer and enables you to add fast and reliable global SMS to your applications. Send single messages, scheduled batch messages, use available message templates and more.
 *
 * The version of the OpenAPI document: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** ErrorResponseObjDto */
@JsonPropertyOrder({ErrorResponseObjDto.JSON_PROPERTY_CODE, ErrorResponseObjDto.JSON_PROPERTY_TEXT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ErrorResponseObjDto {
  public static final String JSON_PROPERTY_CODE = "code";
  private String code;
  private boolean codeDefined = false;

  public static final String JSON_PROPERTY_TEXT = "text";
  private String text;
  private boolean textDefined = false;

  public ErrorResponseObjDto() {}

  public ErrorResponseObjDto code(String code) {
    this.code = code;
    this.codeDefined = true;
    return this;
  }

  /**
   * The error code. See [error codes](/docs/sms/api-reference/#error-codes).
   *
   * @return code
   */
  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCode() {
    return code;
  }

  @JsonIgnore
  public boolean getCodeDefined() {
    return codeDefined;
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCode(String code) {
    this.code = code;
    this.codeDefined = true;
  }

  public ErrorResponseObjDto text(String text) {
    this.text = text;
    this.textDefined = true;
    return this;
  }

  /**
   * The human readable description of the error.
   *
   * @return text
   */
  @JsonProperty(JSON_PROPERTY_TEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getText() {
    return text;
  }

  @JsonIgnore
  public boolean getTextDefined() {
    return textDefined;
  }

  @JsonProperty(JSON_PROPERTY_TEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setText(String text) {
    this.text = text;
    this.textDefined = true;
  }

  /** Return true if this errorResponseObj object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponseObjDto errorResponseObj = (ErrorResponseObjDto) o;
    return Objects.equals(this.code, errorResponseObj.code)
        && Objects.equals(this.text, errorResponseObj.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponseObjDto {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
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
