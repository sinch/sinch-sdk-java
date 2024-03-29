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

/** VerificationMetadataSimCardInfoCollectionDto */
@JsonPropertyOrder({
  VerificationMetadataSimCardInfoCollectionDto.JSON_PROPERTY_1,
  VerificationMetadataSimCardInfoCollectionDto.JSON_PROPERTY_2,
  VerificationMetadataSimCardInfoCollectionDto.JSON_PROPERTY_3,
  VerificationMetadataSimCardInfoCollectionDto.JSON_PROPERTY_COUNT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationMetadataSimCardInfoCollectionDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_1 = "1";
  private VerificationMetadataSimCardInfoCollection1Dto _1;
  private boolean _1Defined = false;

  public static final String JSON_PROPERTY_2 = "2";
  private VerificationMetadataSimCardInfoCollection1Dto _2;
  private boolean _2Defined = false;

  public static final String JSON_PROPERTY_3 = "3";
  private VerificationMetadataSimCardInfoCollection1Dto _3;
  private boolean _3Defined = false;

  public static final String JSON_PROPERTY_COUNT = "count";
  private Integer count;
  private boolean countDefined = false;

  public VerificationMetadataSimCardInfoCollectionDto() {}

  public VerificationMetadataSimCardInfoCollectionDto _1(
      VerificationMetadataSimCardInfoCollection1Dto _1) {
    this._1 = _1;
    this._1Defined = true;
    return this;
  }

  /**
   * Get _1
   *
   * @return _1
   */
  @JsonProperty(JSON_PROPERTY_1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public VerificationMetadataSimCardInfoCollection1Dto get1() {
    return _1;
  }

  @JsonIgnore
  public boolean get1Defined() {
    return _1Defined;
  }

  @JsonProperty(JSON_PROPERTY_1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void set1(VerificationMetadataSimCardInfoCollection1Dto _1) {
    this._1 = _1;
    this._1Defined = true;
  }

  public VerificationMetadataSimCardInfoCollectionDto _2(
      VerificationMetadataSimCardInfoCollection1Dto _2) {
    this._2 = _2;
    this._2Defined = true;
    return this;
  }

  /**
   * Get _2
   *
   * @return _2
   */
  @JsonProperty(JSON_PROPERTY_2)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public VerificationMetadataSimCardInfoCollection1Dto get2() {
    return _2;
  }

  @JsonIgnore
  public boolean get2Defined() {
    return _2Defined;
  }

  @JsonProperty(JSON_PROPERTY_2)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void set2(VerificationMetadataSimCardInfoCollection1Dto _2) {
    this._2 = _2;
    this._2Defined = true;
  }

  public VerificationMetadataSimCardInfoCollectionDto _3(
      VerificationMetadataSimCardInfoCollection1Dto _3) {
    this._3 = _3;
    this._3Defined = true;
    return this;
  }

  /**
   * Get _3
   *
   * @return _3
   */
  @JsonProperty(JSON_PROPERTY_3)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public VerificationMetadataSimCardInfoCollection1Dto get3() {
    return _3;
  }

  @JsonIgnore
  public boolean get3Defined() {
    return _3Defined;
  }

  @JsonProperty(JSON_PROPERTY_3)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void set3(VerificationMetadataSimCardInfoCollection1Dto _3) {
    this._3 = _3;
    this._3Defined = true;
  }

  public VerificationMetadataSimCardInfoCollectionDto count(Integer count) {
    this.count = count;
    this.countDefined = true;
    return this;
  }

  /**
   * Get count
   *
   * @return count
   */
  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getCount() {
    return count;
  }

  @JsonIgnore
  public boolean getCountDefined() {
    return countDefined;
  }

  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCount(Integer count) {
    this.count = count;
    this.countDefined = true;
  }

  /** Return true if this VerificationMetadataSimCardInfoCollection object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationMetadataSimCardInfoCollectionDto verificationMetadataSimCardInfoCollection =
        (VerificationMetadataSimCardInfoCollectionDto) o;
    return Objects.equals(this._1, verificationMetadataSimCardInfoCollection._1)
        && Objects.equals(this._2, verificationMetadataSimCardInfoCollection._2)
        && Objects.equals(this._3, verificationMetadataSimCardInfoCollection._3)
        && Objects.equals(this.count, verificationMetadataSimCardInfoCollection.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_1, _2, _3, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationMetadataSimCardInfoCollectionDto {\n");
    sb.append("    _1: ").append(toIndentedString(_1)).append("\n");
    sb.append("    _2: ").append(toIndentedString(_2)).append("\n");
    sb.append("    _3: ").append(toIndentedString(_3)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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
