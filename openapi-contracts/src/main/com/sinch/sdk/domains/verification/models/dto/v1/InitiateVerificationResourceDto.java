/*
 * Verification
 * Verification REST API for verifying phone numbers and users. Support of FlashCall verification, PIN SMS verification and Callout verification.    **Note:** OTP CODE must be the full valid E.164 number that we called from.    ## Overview    For general information on how to use the Sinch APIs including methods, types, errors and authorization, please check the [Using REST](doc:using-rest) page.  Use the Sinch Verification Service to verify end-user's mobile phone numbers. The Sinch Verification APIs should be used in combination with the Verification SDKs for a complete end-to-end solution, though it is possible to only use the APIs. Currently, there are three verification methods supported:    - FlashCall verification - Android only  - PIN SMS verification - iOS, Android, Javascript  - Callout verification (voice call) - iOS only  - Data verification (distinguished by method = `seamless`) - iOS, Android    #### FlashCall verification    With the flashCall verification method, a user's phone number is verified by triggering a \"missed call\" towards this number. The call is intercepted by the Android SDK in the mobile app and blocked automatically.  To initiate a flashCall verification, check the [Android SDK documentation](doc:verification-android-the-verification-process#flash-call-verification). For additional security, it is recommended that you control which verification requests should proceed and which ones not, by listening in your backend for the [Verification Request Event](doc:verification-rest-verification-api#verification-request) and respond accordingly. Your backend will be notified on the result of the verification with the [Verification Result Event](doc:verification-rest-callback-api#verification-result-event).    #### PIN SMS verification    With the PIN SMS verification method, a user's phone number is verified by sending an SMS containing a PIN code to this number. In the case of iOS or Javascript, the user needs to enter the PIN manually in the app, while for Android there is an option of intercepting the SMS message delivery and capturing the PIN code automatically.  To initiate a PIN SMS verification, check the [iOS](doc:verification-ios-sms-verification), [Android](doc:verification-for-android) and [Javascript](doc:verification-for-javascript) documentation. For additional security, it is recommended that you control which verification requests should proceed and which ones not, by listening in your backend for the [Verification Request Event](doc:verification-rest-verification-api#verification-request) and respond accordingly. Your backend will be notified on the result of the verification with the [Verification Result Event](doc:verification-rest-callback-api#verification-result-event).    #### Callout verification    With the callout verification method, a user's phone number is verified by receiving a phone call and hearing a pre-recorded or text-to-speech message, advising the user to press a digit code. When the user presses the digit code in the dialpad, the verification is successful.  To initiate a callout verification, check the [iOS documentation](doc:verification-ios-callout-verification). For additional security, it is recommended that you control which verification requests should proceed and which ones not, by listening in your backend for the [Verification Request Event](doc:verification-rest-verification-api#verification-request) and respond accordingly. Your backend will be notified on the result of the verification with the [Verification Result Event](doc:verification-rest-callback-api#verification-result-event).    #### Data verification    With the data verification method, a user's phone number is verified by carrier using mobile data network. For additional security, it is recommended that you control which verification requests should proceed and which ones not, by listening in your backend for the [Verification Request Event](doc:verification-rest-verification-api#verification-request) and respond accordingly. Your backend will be notified on the result of the verification with the [Verification Result Event](doc:verification-rest-callback-api#verification-result-event).    > 📘 For information about webhooks and the verifications events [Callbacks](/docs/verification-rest-callback-api).
 *
 * The version of the OpenAPI document: 1.0.0
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
  InitiateVerificationResourceDto.JSON_PROPERTY_METADATA,
  InitiateVerificationResourceDto.JSON_PROPERTY_FLASH_CALL_OPTIONS,
  InitiateVerificationResourceDto.JSON_PROPERTY_CALLOUT_OPTIONS,
  InitiateVerificationResourceDto.JSON_PROPERTY_SMS_OPTIONS,
  InitiateVerificationResourceDto.JSON_PROPERTY_WHATSAPP_OPTIONS,
  InitiateVerificationResourceDto.JSON_PROPERTY_SEAMLESS_OPTIONS,
  InitiateVerificationResourceDto.JSON_PROPERTY_HONOUR_EARLY_REJECT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class InitiateVerificationResourceDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_IDENTITY = "identity";
  private InitiateVerificationResourceIdentityDto identity;
  private boolean identityDefined = false;

  public static final String JSON_PROPERTY_METHOD = "method";
  private InitiateVerificationResourceMethodDto method;
  private boolean methodDefined = false;

  public static final String JSON_PROPERTY_REFERENCE = "reference";
  private String reference;
  private boolean referenceDefined = false;

  public static final String JSON_PROPERTY_CUSTOM = "custom";
  private String custom;
  private boolean customDefined = false;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private InitiateVerificationResourceMetadataDto metadata;
  private boolean metadataDefined = false;

  public static final String JSON_PROPERTY_FLASH_CALL_OPTIONS = "flashCallOptions";
  private InitiateVerificationResourceFlashCallOptionsDto flashCallOptions;
  private boolean flashCallOptionsDefined = false;

  public static final String JSON_PROPERTY_CALLOUT_OPTIONS = "calloutOptions";
  private InitiateVerificationResourceCalloutOptionsDto calloutOptions;
  private boolean calloutOptionsDefined = false;

  public static final String JSON_PROPERTY_SMS_OPTIONS = "smsOptions";
  private InitiateVerificationResourceSmsOptionsDto smsOptions;
  private boolean smsOptionsDefined = false;

  public static final String JSON_PROPERTY_WHATSAPP_OPTIONS = "whatsappOptions";
  private InitiateVerificationResourceWhatsappOptionsDto whatsappOptions;
  private boolean whatsappOptionsDefined = false;

  public static final String JSON_PROPERTY_SEAMLESS_OPTIONS = "seamlessOptions";
  private InitiateVerificationResourceSeamlessOptionsDto seamlessOptions;
  private boolean seamlessOptionsDefined = false;

  public static final String JSON_PROPERTY_HONOUR_EARLY_REJECT = "honourEarlyReject";
  private Boolean honourEarlyReject;
  private boolean honourEarlyRejectDefined = false;

  public InitiateVerificationResourceDto() {}

  public InitiateVerificationResourceDto identity(
      InitiateVerificationResourceIdentityDto identity) {
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
  public InitiateVerificationResourceIdentityDto getIdentity() {
    return identity;
  }

  @JsonIgnore
  public boolean getIdentityDefined() {
    return identityDefined;
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIdentity(InitiateVerificationResourceIdentityDto identity) {
    this.identity = identity;
    this.identityDefined = true;
  }

  public InitiateVerificationResourceDto method(InitiateVerificationResourceMethodDto method) {
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
  public InitiateVerificationResourceMethodDto getMethod() {
    return method;
  }

  @JsonIgnore
  public boolean getMethodDefined() {
    return methodDefined;
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMethod(InitiateVerificationResourceMethodDto method) {
    this.method = method;
    this.methodDefined = true;
  }

  public InitiateVerificationResourceDto reference(String reference) {
    this.reference = reference;
    this.referenceDefined = true;
    return this;
  }

  /**
   * Custom identifier used to get verification status.
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
   * Custom data passed back to callback.
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

  public InitiateVerificationResourceDto metadata(
      InitiateVerificationResourceMetadataDto metadata) {
    this.metadata = metadata;
    this.metadataDefined = true;
    return this;
  }

  /**
   * Get metadata
   *
   * @return metadata
   */
  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public InitiateVerificationResourceMetadataDto getMetadata() {
    return metadata;
  }

  @JsonIgnore
  public boolean getMetadataDefined() {
    return metadataDefined;
  }

  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMetadata(InitiateVerificationResourceMetadataDto metadata) {
    this.metadata = metadata;
    this.metadataDefined = true;
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

  public InitiateVerificationResourceDto whatsappOptions(
      InitiateVerificationResourceWhatsappOptionsDto whatsappOptions) {
    this.whatsappOptions = whatsappOptions;
    this.whatsappOptionsDefined = true;
    return this;
  }

  /**
   * Get whatsappOptions
   *
   * @return whatsappOptions
   */
  @JsonProperty(JSON_PROPERTY_WHATSAPP_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public InitiateVerificationResourceWhatsappOptionsDto getWhatsappOptions() {
    return whatsappOptions;
  }

  @JsonIgnore
  public boolean getWhatsappOptionsDefined() {
    return whatsappOptionsDefined;
  }

  @JsonProperty(JSON_PROPERTY_WHATSAPP_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWhatsappOptions(InitiateVerificationResourceWhatsappOptionsDto whatsappOptions) {
    this.whatsappOptions = whatsappOptions;
    this.whatsappOptionsDefined = true;
  }

  public InitiateVerificationResourceDto seamlessOptions(
      InitiateVerificationResourceSeamlessOptionsDto seamlessOptions) {
    this.seamlessOptions = seamlessOptions;
    this.seamlessOptionsDefined = true;
    return this;
  }

  /**
   * Get seamlessOptions
   *
   * @return seamlessOptions
   */
  @JsonProperty(JSON_PROPERTY_SEAMLESS_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public InitiateVerificationResourceSeamlessOptionsDto getSeamlessOptions() {
    return seamlessOptions;
  }

  @JsonIgnore
  public boolean getSeamlessOptionsDefined() {
    return seamlessOptionsDefined;
  }

  @JsonProperty(JSON_PROPERTY_SEAMLESS_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSeamlessOptions(InitiateVerificationResourceSeamlessOptionsDto seamlessOptions) {
    this.seamlessOptions = seamlessOptions;
    this.seamlessOptionsDefined = true;
  }

  public InitiateVerificationResourceDto honourEarlyReject(Boolean honourEarlyReject) {
    this.honourEarlyReject = honourEarlyReject;
    this.honourEarlyRejectDefined = true;
    return this;
  }

  /**
   * Explicitly control if early rejects should be honoured.
   *
   * @return honourEarlyReject
   */
  @JsonProperty(JSON_PROPERTY_HONOUR_EARLY_REJECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getHonourEarlyReject() {
    return honourEarlyReject;
  }

  @JsonIgnore
  public boolean getHonourEarlyRejectDefined() {
    return honourEarlyRejectDefined;
  }

  @JsonProperty(JSON_PROPERTY_HONOUR_EARLY_REJECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHonourEarlyReject(Boolean honourEarlyReject) {
    this.honourEarlyReject = honourEarlyReject;
    this.honourEarlyRejectDefined = true;
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
        && Objects.equals(this.metadata, initiateVerificationResource.metadata)
        && Objects.equals(this.flashCallOptions, initiateVerificationResource.flashCallOptions)
        && Objects.equals(this.calloutOptions, initiateVerificationResource.calloutOptions)
        && Objects.equals(this.smsOptions, initiateVerificationResource.smsOptions)
        && Objects.equals(this.whatsappOptions, initiateVerificationResource.whatsappOptions)
        && Objects.equals(this.seamlessOptions, initiateVerificationResource.seamlessOptions)
        && Objects.equals(this.honourEarlyReject, initiateVerificationResource.honourEarlyReject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        identity,
        method,
        reference,
        custom,
        metadata,
        flashCallOptions,
        calloutOptions,
        smsOptions,
        whatsappOptions,
        seamlessOptions,
        honourEarlyReject);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InitiateVerificationResourceDto {\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    flashCallOptions: ").append(toIndentedString(flashCallOptions)).append("\n");
    sb.append("    calloutOptions: ").append(toIndentedString(calloutOptions)).append("\n");
    sb.append("    smsOptions: ").append(toIndentedString(smsOptions)).append("\n");
    sb.append("    whatsappOptions: ").append(toIndentedString(whatsappOptions)).append("\n");
    sb.append("    seamlessOptions: ").append(toIndentedString(seamlessOptions)).append("\n");
    sb.append("    honourEarlyReject: ").append(toIndentedString(honourEarlyReject)).append("\n");
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
