/*
 * Verification | Sinch
 * Verify users with SMS, flash calls (missed calls), a regular call, or data verification.
 *
 * The version of the OpenAPI document: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/** VerificationReportResponseDto */
@JsonPropertyOrder({
  VerificationReportResponseDto.JSON_PROPERTY_ID,
  VerificationReportResponseDto.JSON_PROPERTY_METHOD,
  VerificationReportResponseDto.JSON_PROPERTY_STATUS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationReportResponseDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_ID = "id";
  private String id;
  private boolean idDefined = false;

  public static final String JSON_PROPERTY_METHOD = "method";
  private VerificationMethodDto method;
  private boolean methodDefined = false;

  /** The status of the verification request. */
  public enum StatusEnum {
    PENDING("PENDING"),

    SUCCESSFUL("SUCCESSFUL"),

    FAIL("FAIL"),

    DENIED("DENIED"),

    ABORTED("ABORTED"),

    ERROR("ERROR"),

    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }
  }

  public static final String JSON_PROPERTY_STATUS = "status";
  private String status;
  private boolean statusDefined = false;

  public VerificationReportResponseDto() {}

  public VerificationReportResponseDto id(String id) {
    this.id = id;
    this.idDefined = true;
    return this;
  }

  /**
   * The unique ID of the verification request.
   *
   * @return id
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getId() {
    return id;
  }

  @JsonIgnore
  public boolean getIdDefined() {
    return idDefined;
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
    this.idDefined = true;
  }

  public VerificationReportResponseDto method(VerificationMethodDto method) {
    this.method = method;
    this.methodDefined = true;
    return this;
  }

  /**
   * Get method
   *
   * @return method
   */
  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public VerificationMethodDto getMethod() {
    return method;
  }

  @JsonIgnore
  public boolean getMethodDefined() {
    return methodDefined;
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMethod(VerificationMethodDto method) {
    this.method = method;
    this.methodDefined = true;
  }

  public VerificationReportResponseDto status(String status) {
    this.status = status;
    this.statusDefined = true;
    return this;
  }

  /**
   * The status of the verification request.
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

  /** Return true if this VerificationReportResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationReportResponseDto verificationReportResponse = (VerificationReportResponseDto) o;
    return Objects.equals(this.id, verificationReportResponse.id)
        && Objects.equals(this.method, verificationReportResponse.method)
        && Objects.equals(this.status, verificationReportResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, method, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationReportResponseDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
