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

/** ServiceReplyDto */
@JsonPropertyOrder({
  ServiceReplyDto.JSON_PROPERTY_RESULT,
  ServiceReplyDto.JSON_PROPERTY_MESSAGE,
  ServiceReplyDto.JSON_PROPERTY_STACK_TRACE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ServiceReplyDto {
  public static final String JSON_PROPERTY_RESULT = "result";
  private Integer result;
  private boolean resultDefined = false;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  private String message;
  private boolean messageDefined = false;

  public static final String JSON_PROPERTY_STACK_TRACE = "stackTrace";
  private String stackTrace;
  private boolean stackTraceDefined = false;

  public ServiceReplyDto() {}

  public ServiceReplyDto result(Integer result) {
    this.result = result;
    this.resultDefined = true;
    return this;
  }

  /**
   * Get result
   *
   * @return result
   */
  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getResult() {
    return result;
  }

  @JsonIgnore
  public boolean getResultDefined() {
    return resultDefined;
  }

  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResult(Integer result) {
    this.result = result;
    this.resultDefined = true;
  }

  public ServiceReplyDto message(String message) {
    this.message = message;
    this.messageDefined = true;
    return this;
  }

  /**
   * Get message
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

  public ServiceReplyDto stackTrace(String stackTrace) {
    this.stackTrace = stackTrace;
    this.stackTraceDefined = true;
    return this;
  }

  /**
   * Get stackTrace
   *
   * @return stackTrace
   */
  @JsonProperty(JSON_PROPERTY_STACK_TRACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getStackTrace() {
    return stackTrace;
  }

  @JsonIgnore
  public boolean getStackTraceDefined() {
    return stackTraceDefined;
  }

  @JsonProperty(JSON_PROPERTY_STACK_TRACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStackTrace(String stackTrace) {
    this.stackTrace = stackTrace;
    this.stackTraceDefined = true;
  }

  /** Return true if this ServiceReply object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceReplyDto serviceReply = (ServiceReplyDto) o;
    return Objects.equals(this.result, serviceReply.result)
        && Objects.equals(this.message, serviceReply.message)
        && Objects.equals(this.stackTrace, serviceReply.stackTrace);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, message, stackTrace);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceReplyDto {\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    stackTrace: ").append(toIndentedString(stackTrace)).append("\n");
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
