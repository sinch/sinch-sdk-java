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

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** VerificationStatusResponseCommonDto */
@JsonPropertyOrder({
  VerificationStatusResponseCommonDto.JSON_PROPERTY_ID,
  VerificationStatusResponseCommonDto.JSON_PROPERTY_STATUS,
  VerificationStatusResponseCommonDto.JSON_PROPERTY_REASON,
  VerificationStatusResponseCommonDto.JSON_PROPERTY_REFERENCE,
  VerificationStatusResponseCommonDto.JSON_PROPERTY_IDENTITY,
  VerificationStatusResponseCommonDto.JSON_PROPERTY_COUNTRY_ID,
  VerificationStatusResponseCommonDto.JSON_PROPERTY_VERIFICATION_TIMESTAMP
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStatusResponseCommonDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_ID = "id";
  private String id;
  private boolean idDefined = false;

  public static final String JSON_PROPERTY_STATUS = "status";
  private VerificationStatusDto status;
  private boolean statusDefined = false;

  public static final String JSON_PROPERTY_REASON = "reason";
  private VerificationStatusReasonDto reason;
  private boolean reasonDefined = false;

  public static final String JSON_PROPERTY_REFERENCE = "reference";
  private String reference;
  private boolean referenceDefined = false;

  public static final String JSON_PROPERTY_IDENTITY = "identity";
  private IdentityDto identity;
  private boolean identityDefined = false;

  public static final String JSON_PROPERTY_COUNTRY_ID = "countryId";
  private String countryId;
  private boolean countryIdDefined = false;

  public static final String JSON_PROPERTY_VERIFICATION_TIMESTAMP = "verificationTimestamp";
  private String verificationTimestamp;
  private boolean verificationTimestampDefined = false;

  public VerificationStatusResponseCommonDto() {}

  public VerificationStatusResponseCommonDto id(String id) {
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

  public VerificationStatusResponseCommonDto status(VerificationStatusDto status) {
    this.status = status;
    this.statusDefined = true;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public VerificationStatusDto getStatus() {
    return status;
  }

  @JsonIgnore
  public boolean getStatusDefined() {
    return statusDefined;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(VerificationStatusDto status) {
    this.status = status;
    this.statusDefined = true;
  }

  public VerificationStatusResponseCommonDto reason(VerificationStatusReasonDto reason) {
    this.reason = reason;
    this.reasonDefined = true;
    return this;
  }

  /**
   * Get reason
   *
   * @return reason
   */
  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public VerificationStatusReasonDto getReason() {
    return reason;
  }

  @JsonIgnore
  public boolean getReasonDefined() {
    return reasonDefined;
  }

  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReason(VerificationStatusReasonDto reason) {
    this.reason = reason;
    this.reasonDefined = true;
  }

  public VerificationStatusResponseCommonDto reference(String reference) {
    this.reference = reference;
    this.referenceDefined = true;
    return this;
  }

  /**
   * The reference ID that was optionally passed together with the verification request.
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

  public VerificationStatusResponseCommonDto identity(IdentityDto identity) {
    this.identity = identity;
    this.identityDefined = true;
    return this;
  }

  /**
   * Get identity
   *
   * @return identity
   */
  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public IdentityDto getIdentity() {
    return identity;
  }

  @JsonIgnore
  public boolean getIdentityDefined() {
    return identityDefined;
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIdentity(IdentityDto identity) {
    this.identity = identity;
    this.identityDefined = true;
  }

  public VerificationStatusResponseCommonDto countryId(String countryId) {
    this.countryId = countryId;
    this.countryIdDefined = true;
    return this;
  }

  /**
   * The ID of the country to which the verification was sent.
   *
   * @return countryId
   */
  @JsonProperty(JSON_PROPERTY_COUNTRY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCountryId() {
    return countryId;
  }

  @JsonIgnore
  public boolean getCountryIdDefined() {
    return countryIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_COUNTRY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCountryId(String countryId) {
    this.countryId = countryId;
    this.countryIdDefined = true;
  }

  public VerificationStatusResponseCommonDto verificationTimestamp(String verificationTimestamp) {
    this.verificationTimestamp = verificationTimestamp;
    this.verificationTimestampDefined = true;
    return this;
  }

  /**
   * The timestamp in UTC format. &lt;/br&gt; **Note:** The formatting does not respect
   * &#x60;ISO-8601&#x60; and the returned value has the format &#x60;YYYY-MM-DDThh:mm:ss.SSS&#x60;.
   * If you need to parse this value into a specific date object in your programming language,
   * please append &#x60;Z&#x60; (Zulu time &#x3D; UTC) at the end of the date value to match the
   * &#x60;ISO-8601&#x60; format: &#x60;YYYY-MM-DDThh:mm:ss.SSSZ&#x60;.
   *
   * @return verificationTimestamp
   */
  @JsonProperty(JSON_PROPERTY_VERIFICATION_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getVerificationTimestamp() {
    return verificationTimestamp;
  }

  @JsonIgnore
  public boolean getVerificationTimestampDefined() {
    return verificationTimestampDefined;
  }

  @JsonProperty(JSON_PROPERTY_VERIFICATION_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVerificationTimestamp(String verificationTimestamp) {
    this.verificationTimestamp = verificationTimestamp;
    this.verificationTimestampDefined = true;
  }

  /** Return true if this VerificationStatusResponseCommon object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStatusResponseCommonDto verificationStatusResponseCommon =
        (VerificationStatusResponseCommonDto) o;
    return Objects.equals(this.id, verificationStatusResponseCommon.id)
        && Objects.equals(this.status, verificationStatusResponseCommon.status)
        && Objects.equals(this.reason, verificationStatusResponseCommon.reason)
        && Objects.equals(this.reference, verificationStatusResponseCommon.reference)
        && Objects.equals(this.identity, verificationStatusResponseCommon.identity)
        && Objects.equals(this.countryId, verificationStatusResponseCommon.countryId)
        && Objects.equals(
            this.verificationTimestamp, verificationStatusResponseCommon.verificationTimestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, reason, reference, identity, countryId, verificationTimestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStatusResponseCommonDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    countryId: ").append(toIndentedString(countryId)).append("\n");
    sb.append("    verificationTimestamp: ")
        .append(toIndentedString(verificationTimestamp))
        .append("\n");
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
