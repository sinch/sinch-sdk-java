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

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** ErrorDto */
@JsonPropertyOrder({
  ErrorDto.JSON_PROPERTY_STATUS,
  ErrorDto.JSON_PROPERTY_ERROR_CODE,
  ErrorDto.JSON_PROPERTY_MESSAGE,
  ErrorDto.JSON_PROPERTY_REFERENCE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ErrorDto {
  public static final String JSON_PROPERTY_STATUS = "status";
  private String status;
  private boolean statusDefined = false;

  public static final String JSON_PROPERTY_ERROR_CODE = "errorCode";
  private String errorCode;
  private boolean errorCodeDefined = false;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  private String message;
  private boolean messageDefined = false;

  public static final String JSON_PROPERTY_REFERENCE = "reference";
  private String reference;
  private boolean referenceDefined = false;

  public ErrorDto() {}

  public ErrorDto status(String status) {
    this.status = status;
    this.statusDefined = true;
    return this;
  }

  /**
   * A summary of the HTTP error code and error type.
   *
   * @return status
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getStatus() {
    return status;
  }

  @JsonIgnore
  public boolean getStatusDefined() {
    return statusDefined;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(String status) {
    this.status = status;
    this.statusDefined = true;
  }

  public ErrorDto errorCode(String errorCode) {
    this.errorCode = errorCode;
    this.errorCodeDefined = true;
    return this;
  }

  /**
   * The HTTP error code.
   *
   * @return errorCode
   */
  @JsonProperty(JSON_PROPERTY_ERROR_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getErrorCode() {
    return errorCode;
  }

  @JsonIgnore
  public boolean getErrorCodeDefined() {
    return errorCodeDefined;
  }

  @JsonProperty(JSON_PROPERTY_ERROR_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
    this.errorCodeDefined = true;
  }

  public ErrorDto message(String message) {
    this.message = message;
    this.messageDefined = true;
    return this;
  }

  /**
   * A simple description of the cause of the error.
   *
   * @return message
   */
  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMessage() {
    return message;
  }

  @JsonIgnore
  public boolean getMessageDefined() {
    return messageDefined;
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMessage(String message) {
    this.message = message;
    this.messageDefined = true;
  }

  public ErrorDto reference(String reference) {
    this.reference = reference;
    this.referenceDefined = true;
    return this;
  }

  /**
   * If applicable, a reference ID for support to use with diagnosing the error.
   *
   * @return reference
   */
  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getReference() {
    return reference;
  }

  @JsonIgnore
  public boolean getReferenceDefined() {
    return referenceDefined;
  }

  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReference(String reference) {
    this.reference = reference;
    this.referenceDefined = true;
  }

  /** Return true if this Error object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDto error = (ErrorDto) o;
    return Objects.equals(this.status, error.status)
        && Objects.equals(this.errorCode, error.errorCode)
        && Objects.equals(this.message, error.message)
        && Objects.equals(this.reference, error.reference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, errorCode, message, reference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDto {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
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
