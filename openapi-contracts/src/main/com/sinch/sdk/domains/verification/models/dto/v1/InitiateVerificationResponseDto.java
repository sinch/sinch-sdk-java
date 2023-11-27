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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** InitiateVerificationResponseDto */
@JsonPropertyOrder({
  InitiateVerificationResponseDto.JSON_PROPERTY_ID,
  InitiateVerificationResponseDto.JSON_PROPERTY_METHOD,
  InitiateVerificationResponseDto.JSON_PROPERTY_SMS,
  InitiateVerificationResponseDto.JSON_PROPERTY_FLASH_CALL,
  InitiateVerificationResponseDto.JSON_PROPERTY_CALLOUT,
  InitiateVerificationResponseDto.JSON_PROPERTY_SEAMLESS,
  InitiateVerificationResponseDto.JSON_PROPERTY_WHATSAPP,
  InitiateVerificationResponseDto.JSON_PROPERTY_AUTO,
  InitiateVerificationResponseDto.JSON_PROPERTY_EARLY_REJECT,
  InitiateVerificationResponseDto.JSON_PROPERTY_EARLY_REJECT_MESSAGE,
  InitiateVerificationResponseDto.JSON_PROPERTY_MAX_PRICE,
  InitiateVerificationResponseDto.JSON_PROPERTY_LINKS
})
// @javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class InitiateVerificationResponseDto {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_METHOD = "method";
  private VerificationMethodDto method;

  public static final String JSON_PROPERTY_SMS = "sms";
  private InitiateVerificationResponseSmsDto sms;

  public static final String JSON_PROPERTY_FLASH_CALL = "flashCall";
  private InitiateVerificationResponseFlashCallDto flashCall;

  public static final String JSON_PROPERTY_CALLOUT = "callout";
  private InitiateVerificationResponseCalloutDto callout;

  public static final String JSON_PROPERTY_SEAMLESS = "seamless";
  private InitiateVerificationResponseSeamlessDto seamless;

  public static final String JSON_PROPERTY_WHATSAPP = "whatsapp";
  private InitiateVerificationResponseWhatsappDto whatsapp;

  public static final String JSON_PROPERTY_AUTO = "auto";
  private InitiateVerificationResponseAutoDto auto;

  public static final String JSON_PROPERTY_EARLY_REJECT = "earlyReject";
  private Boolean earlyReject;

  public static final String JSON_PROPERTY_EARLY_REJECT_MESSAGE = "earlyRejectMessage";
  private String earlyRejectMessage;

  public static final String JSON_PROPERTY_MAX_PRICE = "maxPrice";
  private InitiateVerificationResponseMaxPriceDto maxPrice;

  public static final String JSON_PROPERTY_LINKS = "_links";
  private List<VerificationResourceLinkDto> links;

  public InitiateVerificationResponseDto() {}

  public InitiateVerificationResponseDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Verification identifier used to query for status.
   *
   * @return id
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getId() {
    return id;
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }

  public InitiateVerificationResponseDto method(VerificationMethodDto method) {
    this.method = method;
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

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMethod(VerificationMethodDto method) {
    this.method = method;
  }

  public InitiateVerificationResponseDto sms(InitiateVerificationResponseSmsDto sms) {
    this.sms = sms;
    return this;
  }

  /**
   * Get sms
   *
   * @return sms
   */
  @JsonProperty(JSON_PROPERTY_SMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public InitiateVerificationResponseSmsDto getSms() {
    return sms;
  }

  @JsonProperty(JSON_PROPERTY_SMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSms(InitiateVerificationResponseSmsDto sms) {
    this.sms = sms;
  }

  public InitiateVerificationResponseDto flashCall(
      InitiateVerificationResponseFlashCallDto flashCall) {
    this.flashCall = flashCall;
    return this;
  }

  /**
   * Get flashCall
   *
   * @return flashCall
   */
  @JsonProperty(JSON_PROPERTY_FLASH_CALL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public InitiateVerificationResponseFlashCallDto getFlashCall() {
    return flashCall;
  }

  @JsonProperty(JSON_PROPERTY_FLASH_CALL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFlashCall(InitiateVerificationResponseFlashCallDto flashCall) {
    this.flashCall = flashCall;
  }

  public InitiateVerificationResponseDto callout(InitiateVerificationResponseCalloutDto callout) {
    this.callout = callout;
    return this;
  }

  /**
   * Get callout
   *
   * @return callout
   */
  @JsonProperty(JSON_PROPERTY_CALLOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public InitiateVerificationResponseCalloutDto getCallout() {
    return callout;
  }

  @JsonProperty(JSON_PROPERTY_CALLOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCallout(InitiateVerificationResponseCalloutDto callout) {
    this.callout = callout;
  }

  public InitiateVerificationResponseDto seamless(
      InitiateVerificationResponseSeamlessDto seamless) {
    this.seamless = seamless;
    return this;
  }

  /**
   * Get seamless
   *
   * @return seamless
   */
  @JsonProperty(JSON_PROPERTY_SEAMLESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public InitiateVerificationResponseSeamlessDto getSeamless() {
    return seamless;
  }

  @JsonProperty(JSON_PROPERTY_SEAMLESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSeamless(InitiateVerificationResponseSeamlessDto seamless) {
    this.seamless = seamless;
  }

  public InitiateVerificationResponseDto whatsapp(
      InitiateVerificationResponseWhatsappDto whatsapp) {
    this.whatsapp = whatsapp;
    return this;
  }

  /**
   * Get whatsapp
   *
   * @return whatsapp
   */
  @JsonProperty(JSON_PROPERTY_WHATSAPP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public InitiateVerificationResponseWhatsappDto getWhatsapp() {
    return whatsapp;
  }

  @JsonProperty(JSON_PROPERTY_WHATSAPP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWhatsapp(InitiateVerificationResponseWhatsappDto whatsapp) {
    this.whatsapp = whatsapp;
  }

  public InitiateVerificationResponseDto auto(InitiateVerificationResponseAutoDto auto) {
    this.auto = auto;
    return this;
  }

  /**
   * Get auto
   *
   * @return auto
   */
  @JsonProperty(JSON_PROPERTY_AUTO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public InitiateVerificationResponseAutoDto getAuto() {
    return auto;
  }

  @JsonProperty(JSON_PROPERTY_AUTO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAuto(InitiateVerificationResponseAutoDto auto) {
    this.auto = auto;
  }

  public InitiateVerificationResponseDto earlyReject(Boolean earlyReject) {
    this.earlyReject = earlyReject;
    return this;
  }

  /**
   * Whether or not verification has been early rejected.
   *
   * @return earlyReject
   */
  @JsonProperty(JSON_PROPERTY_EARLY_REJECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getEarlyReject() {
    return earlyReject;
  }

  @JsonProperty(JSON_PROPERTY_EARLY_REJECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEarlyReject(Boolean earlyReject) {
    this.earlyReject = earlyReject;
  }

  public InitiateVerificationResponseDto earlyRejectMessage(String earlyRejectMessage) {
    this.earlyRejectMessage = earlyRejectMessage;
    return this;
  }

  /**
   * In case verification has been early rejected a detailed reason.
   *
   * @return earlyRejectMessage
   */
  @JsonProperty(JSON_PROPERTY_EARLY_REJECT_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getEarlyRejectMessage() {
    return earlyRejectMessage;
  }

  @JsonProperty(JSON_PROPERTY_EARLY_REJECT_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEarlyRejectMessage(String earlyRejectMessage) {
    this.earlyRejectMessage = earlyRejectMessage;
  }

  public InitiateVerificationResponseDto maxPrice(
      InitiateVerificationResponseMaxPriceDto maxPrice) {
    this.maxPrice = maxPrice;
    return this;
  }

  /**
   * Get maxPrice
   *
   * @return maxPrice
   */
  @JsonProperty(JSON_PROPERTY_MAX_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public InitiateVerificationResponseMaxPriceDto getMaxPrice() {
    return maxPrice;
  }

  @JsonProperty(JSON_PROPERTY_MAX_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMaxPrice(InitiateVerificationResponseMaxPriceDto maxPrice) {
    this.maxPrice = maxPrice;
  }

  public InitiateVerificationResponseDto links(List<VerificationResourceLinkDto> links) {
    this.links = links;
    return this;
  }

  public InitiateVerificationResponseDto addLinksItem(VerificationResourceLinkDto linksItem) {
    if (this.links == null) {
      this.links = new ArrayList<>();
    }
    this.links.add(linksItem);
    return this;
  }

  /**
   * Get links
   *
   * @return links
   */
  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<VerificationResourceLinkDto> getLinks() {
    return links;
  }

  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLinks(List<VerificationResourceLinkDto> links) {
    this.links = links;
  }

  /** Return true if this InitiateVerificationResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InitiateVerificationResponseDto initiateVerificationResponse =
        (InitiateVerificationResponseDto) o;
    return Objects.equals(this.id, initiateVerificationResponse.id)
        && Objects.equals(this.method, initiateVerificationResponse.method)
        && Objects.equals(this.sms, initiateVerificationResponse.sms)
        && Objects.equals(this.flashCall, initiateVerificationResponse.flashCall)
        && Objects.equals(this.callout, initiateVerificationResponse.callout)
        && Objects.equals(this.seamless, initiateVerificationResponse.seamless)
        && Objects.equals(this.whatsapp, initiateVerificationResponse.whatsapp)
        && Objects.equals(this.auto, initiateVerificationResponse.auto)
        && Objects.equals(this.earlyReject, initiateVerificationResponse.earlyReject)
        && Objects.equals(this.earlyRejectMessage, initiateVerificationResponse.earlyRejectMessage)
        && Objects.equals(this.maxPrice, initiateVerificationResponse.maxPrice)
        && Objects.equals(this.links, initiateVerificationResponse.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        method,
        sms,
        flashCall,
        callout,
        seamless,
        whatsapp,
        auto,
        earlyReject,
        earlyRejectMessage,
        maxPrice,
        links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InitiateVerificationResponseDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    sms: ").append(toIndentedString(sms)).append("\n");
    sb.append("    flashCall: ").append(toIndentedString(flashCall)).append("\n");
    sb.append("    callout: ").append(toIndentedString(callout)).append("\n");
    sb.append("    seamless: ").append(toIndentedString(seamless)).append("\n");
    sb.append("    whatsapp: ").append(toIndentedString(whatsapp)).append("\n");
    sb.append("    auto: ").append(toIndentedString(auto)).append("\n");
    sb.append("    earlyReject: ").append(toIndentedString(earlyReject)).append("\n");
    sb.append("    earlyRejectMessage: ").append(toIndentedString(earlyRejectMessage)).append("\n");
    sb.append("    maxPrice: ").append(toIndentedString(maxPrice)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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