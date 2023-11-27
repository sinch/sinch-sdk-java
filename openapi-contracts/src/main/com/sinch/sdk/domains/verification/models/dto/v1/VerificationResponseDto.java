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
import java.util.Objects;

/** VerificationResponseDto */
@JsonPropertyOrder({
  VerificationResponseDto.JSON_PROPERTY_ID,
  VerificationResponseDto.JSON_PROPERTY_METHOD,
  VerificationResponseDto.JSON_PROPERTY_STATUS,
  VerificationResponseDto.JSON_PROPERTY_REASON,
  VerificationResponseDto.JSON_PROPERTY_REFERENCE,
  VerificationResponseDto.JSON_PROPERTY_SOURCE,
  VerificationResponseDto.JSON_PROPERTY_PRICE,
  VerificationResponseDto.JSON_PROPERTY_IDENTITY,
  VerificationResponseDto.JSON_PROPERTY_COUNTRY_ID,
  VerificationResponseDto.JSON_PROPERTY_VERIFICATION_TIMESTAMP,
  VerificationResponseDto.JSON_PROPERTY_CALL_COMPLETE,
  VerificationResponseDto.JSON_PROPERTY_CALL_RESULT
})
// @javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class VerificationResponseDto {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_METHOD = "method";
  private VerificationMethodDto method;

  public static final String JSON_PROPERTY_STATUS = "status";
  private String status;

  public static final String JSON_PROPERTY_REASON = "reason";
  private String reason;

  public static final String JSON_PROPERTY_REFERENCE = "reference";
  private String reference;

  public static final String JSON_PROPERTY_SOURCE = "source";
  private String source;

  public static final String JSON_PROPERTY_PRICE = "price";
  private VerificationResponsePriceDto price;

  public static final String JSON_PROPERTY_IDENTITY = "identity";
  private VerificationResponseIdentityDto identity;

  public static final String JSON_PROPERTY_COUNTRY_ID = "countryId";
  private String countryId;

  public static final String JSON_PROPERTY_VERIFICATION_TIMESTAMP = "verificationTimestamp";
  private String verificationTimestamp;

  public static final String JSON_PROPERTY_CALL_COMPLETE = "callComplete";
  private Boolean callComplete;

  public static final String JSON_PROPERTY_CALL_RESULT = "callResult";
  private String callResult;

  public VerificationResponseDto() {}

  public VerificationResponseDto id(String id) {
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

  public VerificationResponseDto method(VerificationMethodDto method) {
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

  public VerificationResponseDto status(String status) {
    this.status = status;
    return this;
  }

  /**
   * One of: PENDING, SUCCESSFUL, FAIL, DENIED, ABORTED, ERROR
   *
   * @return status
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getStatus() {
    return status;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(String status) {
    this.status = status;
  }

  public VerificationResponseDto reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * In case of &#39;failed&#39; verification exact reason of failure.
   *
   * @return reason
   */
  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getReason() {
    return reason;
  }

  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReason(String reason) {
    this.reason = reason;
  }

  public VerificationResponseDto reference(String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * Custom Reference value if supplied during initiation.
   *
   * @return reference
   */
  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getReference() {
    return reference;
  }

  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReference(String reference) {
    this.reference = reference;
  }

  public VerificationResponseDto source(String source) {
    this.source = source;
    return this;
  }

  /**
   * Custom Source value if supplied during initiation.
   *
   * @return source
   */
  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getSource() {
    return source;
  }

  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSource(String source) {
    this.source = source;
  }

  public VerificationResponseDto price(VerificationResponsePriceDto price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   *
   * @return price
   */
  @JsonProperty(JSON_PROPERTY_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public VerificationResponsePriceDto getPrice() {
    return price;
  }

  @JsonProperty(JSON_PROPERTY_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrice(VerificationResponsePriceDto price) {
    this.price = price;
  }

  public VerificationResponseDto identity(VerificationResponseIdentityDto identity) {
    this.identity = identity;
    return this;
  }

  /**
   * Get identity
   *
   * @return identity
   */
  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public VerificationResponseIdentityDto getIdentity() {
    return identity;
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIdentity(VerificationResponseIdentityDto identity) {
    this.identity = identity;
  }

  public VerificationResponseDto countryId(String countryId) {
    this.countryId = countryId;
    return this;
  }

  /**
   * Get countryId
   *
   * @return countryId
   */
  @JsonProperty(JSON_PROPERTY_COUNTRY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCountryId() {
    return countryId;
  }

  @JsonProperty(JSON_PROPERTY_COUNTRY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCountryId(String countryId) {
    this.countryId = countryId;
  }

  public VerificationResponseDto verificationTimestamp(String verificationTimestamp) {
    this.verificationTimestamp = verificationTimestamp;
    return this;
  }

  /**
   * Get verificationTimestamp
   *
   * @return verificationTimestamp
   */
  @JsonProperty(JSON_PROPERTY_VERIFICATION_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getVerificationTimestamp() {
    return verificationTimestamp;
  }

  @JsonProperty(JSON_PROPERTY_VERIFICATION_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVerificationTimestamp(String verificationTimestamp) {
    this.verificationTimestamp = verificationTimestamp;
  }

  public VerificationResponseDto callComplete(Boolean callComplete) {
    this.callComplete = callComplete;
    return this;
  }

  /**
   * Get callComplete
   *
   * @return callComplete
   */
  @JsonProperty(JSON_PROPERTY_CALL_COMPLETE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getCallComplete() {
    return callComplete;
  }

  @JsonProperty(JSON_PROPERTY_CALL_COMPLETE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCallComplete(Boolean callComplete) {
    this.callComplete = callComplete;
  }

  public VerificationResponseDto callResult(String callResult) {
    this.callResult = callResult;
    return this;
  }

  /**
   * Get callResult
   *
   * @return callResult
   */
  @JsonProperty(JSON_PROPERTY_CALL_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCallResult() {
    return callResult;
  }

  @JsonProperty(JSON_PROPERTY_CALL_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCallResult(String callResult) {
    this.callResult = callResult;
  }

  /** Return true if this VerificationResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationResponseDto verificationResponse = (VerificationResponseDto) o;
    return Objects.equals(this.id, verificationResponse.id)
        && Objects.equals(this.method, verificationResponse.method)
        && Objects.equals(this.status, verificationResponse.status)
        && Objects.equals(this.reason, verificationResponse.reason)
        && Objects.equals(this.reference, verificationResponse.reference)
        && Objects.equals(this.source, verificationResponse.source)
        && Objects.equals(this.price, verificationResponse.price)
        && Objects.equals(this.identity, verificationResponse.identity)
        && Objects.equals(this.countryId, verificationResponse.countryId)
        && Objects.equals(this.verificationTimestamp, verificationResponse.verificationTimestamp)
        && Objects.equals(this.callComplete, verificationResponse.callComplete)
        && Objects.equals(this.callResult, verificationResponse.callResult);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        method,
        status,
        reason,
        reference,
        source,
        price,
        identity,
        countryId,
        verificationTimestamp,
        callComplete,
        callResult);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationResponseDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    countryId: ").append(toIndentedString(countryId)).append("\n");
    sb.append("    verificationTimestamp: ")
        .append(toIndentedString(verificationTimestamp))
        .append("\n");
    sb.append("    callComplete: ").append(toIndentedString(callComplete)).append("\n");
    sb.append("    callResult: ").append(toIndentedString(callResult)).append("\n");
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