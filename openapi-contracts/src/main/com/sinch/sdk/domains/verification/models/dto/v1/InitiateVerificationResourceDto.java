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

/** InitiateVerificationResourceDto */
@JsonPropertyOrder({
  InitiateVerificationResourceDto.JSON_PROPERTY_IDENTITY,
  InitiateVerificationResourceDto.JSON_PROPERTY_METHOD,
  InitiateVerificationResourceDto.JSON_PROPERTY_REFERENCE,
  InitiateVerificationResourceDto.JSON_PROPERTY_CUSTOM,
  InitiateVerificationResourceDto.JSON_PROPERTY_FLASH_CALL_OPTIONS,
  InitiateVerificationResourceDto.JSON_PROPERTY_SMS_OPTIONS,
  InitiateVerificationResourceDto.JSON_PROPERTY_CALLOUT_OPTIONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class InitiateVerificationResourceDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_IDENTITY = "identity";
  private IdentityDto identity;
  private boolean identityDefined = false;

  public static final String JSON_PROPERTY_METHOD = "method";
  private VerificationMethodDto method;
  private boolean methodDefined = false;

  public static final String JSON_PROPERTY_REFERENCE = "reference";
  private String reference;
  private boolean referenceDefined = false;

  public static final String JSON_PROPERTY_CUSTOM = "custom";
  private String custom;
  private boolean customDefined = false;

  public static final String JSON_PROPERTY_FLASH_CALL_OPTIONS = "flashCallOptions";
  private InitiateVerificationResourceFlashCallOptionsDto flashCallOptions;
  private boolean flashCallOptionsDefined = false;

  public static final String JSON_PROPERTY_SMS_OPTIONS = "smsOptions";
  private InitiateVerificationResourceSmsOptionsDto smsOptions;
  private boolean smsOptionsDefined = false;

  public static final String JSON_PROPERTY_CALLOUT_OPTIONS = "calloutOptions";
  private InitiateVerificationResourceCalloutOptionsDto calloutOptions;
  private boolean calloutOptionsDefined = false;

  public InitiateVerificationResourceDto() {}

  public InitiateVerificationResourceDto identity(IdentityDto identity) {
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
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public IdentityDto getIdentity() {
    return identity;
  }

  @JsonIgnore
  public boolean getIdentityDefined() {
    return identityDefined;
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIdentity(IdentityDto identity) {
    this.identity = identity;
    this.identityDefined = true;
  }

  public InitiateVerificationResourceDto method(VerificationMethodDto method) {
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
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public VerificationMethodDto getMethod() {
    return method;
  }

  @JsonIgnore
  public boolean getMethodDefined() {
    return methodDefined;
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMethod(VerificationMethodDto method) {
    this.method = method;
    this.methodDefined = true;
  }

  public InitiateVerificationResourceDto reference(String reference) {
    this.reference = reference;
    this.referenceDefined = true;
    return this;
  }

  /**
   * Used to pass your own reference in the request for tracking purposes.
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

  public InitiateVerificationResourceDto custom(String custom) {
    this.custom = custom;
    this.customDefined = true;
    return this;
  }

  /**
   * Can be used to pass custom data in the request.
   *
   * @return custom
   */
  @JsonProperty(JSON_PROPERTY_CUSTOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCustom() {
    return custom;
  }

  @JsonIgnore
  public boolean getCustomDefined() {
    return customDefined;
  }

  @JsonProperty(JSON_PROPERTY_CUSTOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCustom(String custom) {
    this.custom = custom;
    this.customDefined = true;
  }

  public InitiateVerificationResourceDto flashCallOptions(
      InitiateVerificationResourceFlashCallOptionsDto flashCallOptions) {
    this.flashCallOptions = flashCallOptions;
    this.flashCallOptionsDefined = true;
    return this;
  }

  /**
   * Get flashCallOptions
   *
   * @return flashCallOptions
   */
  @JsonProperty(JSON_PROPERTY_FLASH_CALL_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public InitiateVerificationResourceFlashCallOptionsDto getFlashCallOptions() {
    return flashCallOptions;
  }

  @JsonIgnore
  public boolean getFlashCallOptionsDefined() {
    return flashCallOptionsDefined;
  }

  @JsonProperty(JSON_PROPERTY_FLASH_CALL_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFlashCallOptions(
      InitiateVerificationResourceFlashCallOptionsDto flashCallOptions) {
    this.flashCallOptions = flashCallOptions;
    this.flashCallOptionsDefined = true;
  }

  public InitiateVerificationResourceDto smsOptions(
      InitiateVerificationResourceSmsOptionsDto smsOptions) {
    this.smsOptions = smsOptions;
    this.smsOptionsDefined = true;
    return this;
  }

  /**
   * Get smsOptions
   *
   * @return smsOptions
   */
  @JsonProperty(JSON_PROPERTY_SMS_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public InitiateVerificationResourceSmsOptionsDto getSmsOptions() {
    return smsOptions;
  }

  @JsonIgnore
  public boolean getSmsOptionsDefined() {
    return smsOptionsDefined;
  }

  @JsonProperty(JSON_PROPERTY_SMS_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSmsOptions(InitiateVerificationResourceSmsOptionsDto smsOptions) {
    this.smsOptions = smsOptions;
    this.smsOptionsDefined = true;
  }

  public InitiateVerificationResourceDto calloutOptions(
      InitiateVerificationResourceCalloutOptionsDto calloutOptions) {
    this.calloutOptions = calloutOptions;
    this.calloutOptionsDefined = true;
    return this;
  }

  /**
   * Get calloutOptions
   *
   * @return calloutOptions
   */
  @JsonProperty(JSON_PROPERTY_CALLOUT_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public InitiateVerificationResourceCalloutOptionsDto getCalloutOptions() {
    return calloutOptions;
  }

  @JsonIgnore
  public boolean getCalloutOptionsDefined() {
    return calloutOptionsDefined;
  }

  @JsonProperty(JSON_PROPERTY_CALLOUT_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCalloutOptions(InitiateVerificationResourceCalloutOptionsDto calloutOptions) {
    this.calloutOptions = calloutOptions;
    this.calloutOptionsDefined = true;
  }

  /** Return true if this InitiateVerificationResource object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InitiateVerificationResourceDto initiateVerificationResource =
        (InitiateVerificationResourceDto) o;
    return Objects.equals(this.identity, initiateVerificationResource.identity)
        && Objects.equals(this.method, initiateVerificationResource.method)
        && Objects.equals(this.reference, initiateVerificationResource.reference)
        && Objects.equals(this.custom, initiateVerificationResource.custom)
        && Objects.equals(this.flashCallOptions, initiateVerificationResource.flashCallOptions)
        && Objects.equals(this.smsOptions, initiateVerificationResource.smsOptions)
        && Objects.equals(this.calloutOptions, initiateVerificationResource.calloutOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        identity, method, reference, custom, flashCallOptions, smsOptions, calloutOptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InitiateVerificationResourceDto {\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    flashCallOptions: ").append(toIndentedString(flashCallOptions)).append("\n");
    sb.append("    smsOptions: ").append(toIndentedString(smsOptions)).append("\n");
    sb.append("    calloutOptions: ").append(toIndentedString(calloutOptions)).append("\n");
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
