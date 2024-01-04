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

/** SmsOptionsDto */
@JsonPropertyOrder({
  SmsOptionsDto.JSON_PROPERTY_CODE,
  SmsOptionsDto.JSON_PROPERTY_CODE_TYPE,
  SmsOptionsDto.JSON_PROPERTY_CODE_MASK,
  SmsOptionsDto.JSON_PROPERTY_TEMPLATE,
  SmsOptionsDto.JSON_PROPERTY_READ_PERMISSION_TOKEN,
  SmsOptionsDto.JSON_PROPERTY_APPLICATION_HASH
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SmsOptionsDto {
  public static final String JSON_PROPERTY_CODE = "code";
  private String code;
  private boolean codeDefined = false;

  public static final String JSON_PROPERTY_CODE_TYPE = "codeType";
  private String codeType;
  private boolean codeTypeDefined = false;

  public static final String JSON_PROPERTY_CODE_MASK = "codeMask";
  private String codeMask;
  private boolean codeMaskDefined = false;

  public static final String JSON_PROPERTY_TEMPLATE = "template";
  private String template;
  private boolean templateDefined = false;

  public static final String JSON_PROPERTY_READ_PERMISSION_TOKEN = "readPermissionToken";
  private String readPermissionToken;
  private boolean readPermissionTokenDefined = false;

  public static final String JSON_PROPERTY_APPLICATION_HASH = "applicationHash";
  private String applicationHash;
  private boolean applicationHashDefined = false;

  public SmsOptionsDto() {}

  public SmsOptionsDto code(String code) {
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

  public SmsOptionsDto codeType(String codeType) {
    this.codeType = codeType;
    this.codeTypeDefined = true;
    return this;
  }

  /**
   * Get codeType
   *
   * @return codeType
   */
  @JsonProperty(JSON_PROPERTY_CODE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCodeType() {
    return codeType;
  }

  @JsonIgnore
  public boolean getCodeTypeDefined() {
    return codeTypeDefined;
  }

  @JsonProperty(JSON_PROPERTY_CODE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCodeType(String codeType) {
    this.codeType = codeType;
    this.codeTypeDefined = true;
  }

  public SmsOptionsDto codeMask(String codeMask) {
    this.codeMask = codeMask;
    this.codeMaskDefined = true;
    return this;
  }

  /**
   * Get codeMask
   *
   * @return codeMask
   */
  @JsonProperty(JSON_PROPERTY_CODE_MASK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCodeMask() {
    return codeMask;
  }

  @JsonIgnore
  public boolean getCodeMaskDefined() {
    return codeMaskDefined;
  }

  @JsonProperty(JSON_PROPERTY_CODE_MASK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCodeMask(String codeMask) {
    this.codeMask = codeMask;
    this.codeMaskDefined = true;
  }

  public SmsOptionsDto template(String template) {
    this.template = template;
    this.templateDefined = true;
    return this;
  }

  /**
   * Get template
   *
   * @return template
   */
  @JsonProperty(JSON_PROPERTY_TEMPLATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getTemplate() {
    return template;
  }

  @JsonIgnore
  public boolean getTemplateDefined() {
    return templateDefined;
  }

  @JsonProperty(JSON_PROPERTY_TEMPLATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTemplate(String template) {
    this.template = template;
    this.templateDefined = true;
  }

  public SmsOptionsDto readPermissionToken(String readPermissionToken) {
    this.readPermissionToken = readPermissionToken;
    this.readPermissionTokenDefined = true;
    return this;
  }

  /**
   * Get readPermissionToken
   *
   * @return readPermissionToken
   */
  @JsonProperty(JSON_PROPERTY_READ_PERMISSION_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getReadPermissionToken() {
    return readPermissionToken;
  }

  @JsonIgnore
  public boolean getReadPermissionTokenDefined() {
    return readPermissionTokenDefined;
  }

  @JsonProperty(JSON_PROPERTY_READ_PERMISSION_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReadPermissionToken(String readPermissionToken) {
    this.readPermissionToken = readPermissionToken;
    this.readPermissionTokenDefined = true;
  }

  public SmsOptionsDto applicationHash(String applicationHash) {
    this.applicationHash = applicationHash;
    this.applicationHashDefined = true;
    return this;
  }

  /**
   * Get applicationHash
   *
   * @return applicationHash
   */
  @JsonProperty(JSON_PROPERTY_APPLICATION_HASH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getApplicationHash() {
    return applicationHash;
  }

  @JsonIgnore
  public boolean getApplicationHashDefined() {
    return applicationHashDefined;
  }

  @JsonProperty(JSON_PROPERTY_APPLICATION_HASH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setApplicationHash(String applicationHash) {
    this.applicationHash = applicationHash;
    this.applicationHashDefined = true;
  }

  /** Return true if this SmsOptions object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmsOptionsDto smsOptions = (SmsOptionsDto) o;
    return Objects.equals(this.code, smsOptions.code)
        && Objects.equals(this.codeType, smsOptions.codeType)
        && Objects.equals(this.codeMask, smsOptions.codeMask)
        && Objects.equals(this.template, smsOptions.template)
        && Objects.equals(this.readPermissionToken, smsOptions.readPermissionToken)
        && Objects.equals(this.applicationHash, smsOptions.applicationHash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, codeType, codeMask, template, readPermissionToken, applicationHash);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmsOptionsDto {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    codeType: ").append(toIndentedString(codeType)).append("\n");
    sb.append("    codeMask: ").append(toIndentedString(codeMask)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
    sb.append("    readPermissionToken: ")
        .append(toIndentedString(readPermissionToken))
        .append("\n");
    sb.append("    applicationHash: ").append(toIndentedString(applicationHash)).append("\n");
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
