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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** CalloutInitiateVerificationResponseDto */
@JsonPropertyOrder({
  CalloutInitiateVerificationResponseDto.JSON_PROPERTY_SUB_VERIFICATION_ID,
  CalloutInitiateVerificationResponseDto.JSON_PROPERTY_CODE,
  CalloutInitiateVerificationResponseDto.JSON_PROPERTY_LINKS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CalloutInitiateVerificationResponseDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_SUB_VERIFICATION_ID = "subVerificationId";
  private String subVerificationId;
  private boolean subVerificationIdDefined = false;

  public static final String JSON_PROPERTY_CODE = "code";
  private String code;
  private boolean codeDefined = false;

  public static final String JSON_PROPERTY_LINKS = "_links";
  private List<VerificationResourceLinkDto> links;
  private boolean linksDefined = false;

  public CalloutInitiateVerificationResponseDto() {}

  public CalloutInitiateVerificationResponseDto subVerificationId(String subVerificationId) {
    this.subVerificationId = subVerificationId;
    this.subVerificationIdDefined = true;
    return this;
  }

  /**
   * Get subVerificationId
   *
   * @return subVerificationId
   */
  @JsonProperty(JSON_PROPERTY_SUB_VERIFICATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getSubVerificationId() {
    return subVerificationId;
  }

  @JsonIgnore
  public boolean getSubVerificationIdDefined() {
    return subVerificationIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_SUB_VERIFICATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSubVerificationId(String subVerificationId) {
    this.subVerificationId = subVerificationId;
    this.subVerificationIdDefined = true;
  }

  public CalloutInitiateVerificationResponseDto code(String code) {
    this.code = code;
    this.codeDefined = true;
    return this;
  }

  /**
   * Get code
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

  public CalloutInitiateVerificationResponseDto links(List<VerificationResourceLinkDto> links) {
    this.links = links;
    this.linksDefined = true;
    return this;
  }

  public CalloutInitiateVerificationResponseDto addLinksItem(
      VerificationResourceLinkDto linksItem) {
    if (this.links == null) {
      this.links = new ArrayList<>();
    }
    this.linksDefined = true;
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

  @JsonIgnore
  public boolean getLinksDefined() {
    return linksDefined;
  }

  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLinks(List<VerificationResourceLinkDto> links) {
    this.links = links;
    this.linksDefined = true;
  }

  /** Return true if this CalloutInitiateVerificationResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalloutInitiateVerificationResponseDto calloutInitiateVerificationResponse =
        (CalloutInitiateVerificationResponseDto) o;
    return Objects.equals(
            this.subVerificationId, calloutInitiateVerificationResponse.subVerificationId)
        && Objects.equals(this.code, calloutInitiateVerificationResponse.code)
        && Objects.equals(this.links, calloutInitiateVerificationResponse.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subVerificationId, code, links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalloutInitiateVerificationResponseDto {\n");
    sb.append("    subVerificationId: ").append(toIndentedString(subVerificationId)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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
