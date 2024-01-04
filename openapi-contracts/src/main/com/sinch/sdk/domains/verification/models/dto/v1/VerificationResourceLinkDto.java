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

/** VerificationResourceLinkDto */
@JsonPropertyOrder({
  VerificationResourceLinkDto.JSON_PROPERTY_REL,
  VerificationResourceLinkDto.JSON_PROPERTY_HREF,
  VerificationResourceLinkDto.JSON_PROPERTY_METHOD
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationResourceLinkDto {
  public static final String JSON_PROPERTY_REL = "rel";
  private String rel;
  private boolean relDefined = false;

  public static final String JSON_PROPERTY_HREF = "href";
  private String href;
  private boolean hrefDefined = false;

  public static final String JSON_PROPERTY_METHOD = "method";
  private String method;
  private boolean methodDefined = false;

  public VerificationResourceLinkDto() {}

  public VerificationResourceLinkDto rel(String rel) {
    this.rel = rel;
    this.relDefined = true;
    return this;
  }

  /**
   * Get rel
   *
   * @return rel
   */
  @JsonProperty(JSON_PROPERTY_REL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getRel() {
    return rel;
  }

  @JsonIgnore
  public boolean getRelDefined() {
    return relDefined;
  }

  @JsonProperty(JSON_PROPERTY_REL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRel(String rel) {
    this.rel = rel;
    this.relDefined = true;
  }

  public VerificationResourceLinkDto href(String href) {
    this.href = href;
    this.hrefDefined = true;
    return this;
  }

  /**
   * Get href
   *
   * @return href
   */
  @JsonProperty(JSON_PROPERTY_HREF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getHref() {
    return href;
  }

  @JsonIgnore
  public boolean getHrefDefined() {
    return hrefDefined;
  }

  @JsonProperty(JSON_PROPERTY_HREF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHref(String href) {
    this.href = href;
    this.hrefDefined = true;
  }

  public VerificationResourceLinkDto method(String method) {
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
  public String getMethod() {
    return method;
  }

  @JsonIgnore
  public boolean getMethodDefined() {
    return methodDefined;
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMethod(String method) {
    this.method = method;
    this.methodDefined = true;
  }

  /** Return true if this VerificationResourceLink object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationResourceLinkDto verificationResourceLink = (VerificationResourceLinkDto) o;
    return Objects.equals(this.rel, verificationResourceLink.rel)
        && Objects.equals(this.href, verificationResourceLink.href)
        && Objects.equals(this.method, verificationResourceLink.method);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rel, href, method);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationResourceLinkDto {\n");
    sb.append("    rel: ").append(toIndentedString(rel)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
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
