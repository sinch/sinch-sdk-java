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

/** VerificationMetadataDto */
@JsonPropertyOrder({
  VerificationMetadataDto.JSON_PROPERTY_OS,
  VerificationMetadataDto.JSON_PROPERTY_DEVICE_ID,
  VerificationMetadataDto.JSON_PROPERTY_PLATFORM,
  VerificationMetadataDto.JSON_PROPERTY_SDK,
  VerificationMetadataDto.JSON_PROPERTY_SDK_FLAVOR,
  VerificationMetadataDto.JSON_PROPERTY_DEFAULT_LOCALE,
  VerificationMetadataDto.JSON_PROPERTY_BATTERY_LEVEL,
  VerificationMetadataDto.JSON_PROPERTY_SIM_CARDS_COUNT,
  VerificationMetadataDto.JSON_PROPERTY_PERMISSIONS,
  VerificationMetadataDto.JSON_PROPERTY_DEVICE,
  VerificationMetadataDto.JSON_PROPERTY_SIM,
  VerificationMetadataDto.JSON_PROPERTY_OPERATOR,
  VerificationMetadataDto.JSON_PROPERTY_NETWORK_INFO,
  VerificationMetadataDto.JSON_PROPERTY_SIM_CARDS_INFO,
  VerificationMetadataDto.JSON_PROPERTY_CLIENT_PRODUCT_ID,
  VerificationMetadataDto.JSON_PROPERTY_FIRST_ATTEMPT,
  VerificationMetadataDto.JSON_PROPERTY_PURPOSE,
  VerificationMetadataDto.JSON_PROPERTY_OTHER
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationMetadataDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_OS = "os";
  private String os;
  private boolean osDefined = false;

  public static final String JSON_PROPERTY_DEVICE_ID = "deviceId";
  private String deviceId;
  private boolean deviceIdDefined = false;

  public static final String JSON_PROPERTY_PLATFORM = "platform";
  private String platform;
  private boolean platformDefined = false;

  public static final String JSON_PROPERTY_SDK = "sdk";
  private String sdk;
  private boolean sdkDefined = false;

  public static final String JSON_PROPERTY_SDK_FLAVOR = "sdkFlavor";
  private String sdkFlavor;
  private boolean sdkFlavorDefined = false;

  public static final String JSON_PROPERTY_DEFAULT_LOCALE = "defaultLocale";
  private String defaultLocale;
  private boolean defaultLocaleDefined = false;

  public static final String JSON_PROPERTY_BATTERY_LEVEL = "batteryLevel";
  private String batteryLevel;
  private boolean batteryLevelDefined = false;

  public static final String JSON_PROPERTY_SIM_CARDS_COUNT = "simCardsCount";
  private Integer simCardsCount;
  private boolean simCardsCountDefined = false;

  public static final String JSON_PROPERTY_PERMISSIONS = "permissions";
  private VerificationMetadataPermissionsDto permissions;
  private boolean permissionsDefined = false;

  public static final String JSON_PROPERTY_DEVICE = "device";
  private VerificationMetadataDeviceDto device;
  private boolean deviceDefined = false;

  public static final String JSON_PROPERTY_SIM = "sim";
  private VerificationMetadataSimDto sim;
  private boolean simDefined = false;

  public static final String JSON_PROPERTY_OPERATOR = "operator";
  private VerificationMetadataOperatorDto operator;
  private boolean operatorDefined = false;

  public static final String JSON_PROPERTY_NETWORK_INFO = "networkInfo";
  private VerificationMetadataNetworkInfoDto networkInfo;
  private boolean networkInfoDefined = false;

  public static final String JSON_PROPERTY_SIM_CARDS_INFO = "simCardsInfo";
  private VerificationMetadataSimCardsInfoDto simCardsInfo;
  private boolean simCardsInfoDefined = false;

  public static final String JSON_PROPERTY_CLIENT_PRODUCT_ID = "clientProductId";
  private String clientProductId;
  private boolean clientProductIdDefined = false;

  public static final String JSON_PROPERTY_FIRST_ATTEMPT = "firstAttempt";
  private Boolean firstAttempt;
  private boolean firstAttemptDefined = false;

  public static final String JSON_PROPERTY_PURPOSE = "purpose";
  private String purpose;
  private boolean purposeDefined = false;

  public static final String JSON_PROPERTY_OTHER = "other";
  private String other;
  private boolean otherDefined = false;

  public VerificationMetadataDto() {}

  public VerificationMetadataDto os(String os) {
    this.os = os;
    this.osDefined = true;
    return this;
  }

  /**
   * Get os
   *
   * @return os
   */
  @JsonProperty(JSON_PROPERTY_OS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getOs() {
    return os;
  }

  @JsonIgnore
  public boolean getOsDefined() {
    return osDefined;
  }

  @JsonProperty(JSON_PROPERTY_OS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOs(String os) {
    this.os = os;
    this.osDefined = true;
  }

  public VerificationMetadataDto deviceId(String deviceId) {
    this.deviceId = deviceId;
    this.deviceIdDefined = true;
    return this;
  }

  /**
   * Get deviceId
   *
   * @return deviceId
   */
  @JsonProperty(JSON_PROPERTY_DEVICE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDeviceId() {
    return deviceId;
  }

  @JsonIgnore
  public boolean getDeviceIdDefined() {
    return deviceIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_DEVICE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
    this.deviceIdDefined = true;
  }

  public VerificationMetadataDto platform(String platform) {
    this.platform = platform;
    this.platformDefined = true;
    return this;
  }

  /**
   * Get platform
   *
   * @return platform
   */
  @JsonProperty(JSON_PROPERTY_PLATFORM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPlatform() {
    return platform;
  }

  @JsonIgnore
  public boolean getPlatformDefined() {
    return platformDefined;
  }

  @JsonProperty(JSON_PROPERTY_PLATFORM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPlatform(String platform) {
    this.platform = platform;
    this.platformDefined = true;
  }

  public VerificationMetadataDto sdk(String sdk) {
    this.sdk = sdk;
    this.sdkDefined = true;
    return this;
  }

  /**
   * Get sdk
   *
   * @return sdk
   */
  @JsonProperty(JSON_PROPERTY_SDK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getSdk() {
    return sdk;
  }

  @JsonIgnore
  public boolean getSdkDefined() {
    return sdkDefined;
  }

  @JsonProperty(JSON_PROPERTY_SDK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSdk(String sdk) {
    this.sdk = sdk;
    this.sdkDefined = true;
  }

  public VerificationMetadataDto sdkFlavor(String sdkFlavor) {
    this.sdkFlavor = sdkFlavor;
    this.sdkFlavorDefined = true;
    return this;
  }

  /**
   * Get sdkFlavor
   *
   * @return sdkFlavor
   */
  @JsonProperty(JSON_PROPERTY_SDK_FLAVOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getSdkFlavor() {
    return sdkFlavor;
  }

  @JsonIgnore
  public boolean getSdkFlavorDefined() {
    return sdkFlavorDefined;
  }

  @JsonProperty(JSON_PROPERTY_SDK_FLAVOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSdkFlavor(String sdkFlavor) {
    this.sdkFlavor = sdkFlavor;
    this.sdkFlavorDefined = true;
  }

  public VerificationMetadataDto defaultLocale(String defaultLocale) {
    this.defaultLocale = defaultLocale;
    this.defaultLocaleDefined = true;
    return this;
  }

  /**
   * Get defaultLocale
   *
   * @return defaultLocale
   */
  @JsonProperty(JSON_PROPERTY_DEFAULT_LOCALE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDefaultLocale() {
    return defaultLocale;
  }

  @JsonIgnore
  public boolean getDefaultLocaleDefined() {
    return defaultLocaleDefined;
  }

  @JsonProperty(JSON_PROPERTY_DEFAULT_LOCALE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDefaultLocale(String defaultLocale) {
    this.defaultLocale = defaultLocale;
    this.defaultLocaleDefined = true;
  }

  public VerificationMetadataDto batteryLevel(String batteryLevel) {
    this.batteryLevel = batteryLevel;
    this.batteryLevelDefined = true;
    return this;
  }

  /**
   * Get batteryLevel
   *
   * @return batteryLevel
   */
  @JsonProperty(JSON_PROPERTY_BATTERY_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getBatteryLevel() {
    return batteryLevel;
  }

  @JsonIgnore
  public boolean getBatteryLevelDefined() {
    return batteryLevelDefined;
  }

  @JsonProperty(JSON_PROPERTY_BATTERY_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBatteryLevel(String batteryLevel) {
    this.batteryLevel = batteryLevel;
    this.batteryLevelDefined = true;
  }

  public VerificationMetadataDto simCardsCount(Integer simCardsCount) {
    this.simCardsCount = simCardsCount;
    this.simCardsCountDefined = true;
    return this;
  }

  /**
   * Get simCardsCount
   *
   * @return simCardsCount
   */
  @JsonProperty(JSON_PROPERTY_SIM_CARDS_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getSimCardsCount() {
    return simCardsCount;
  }

  @JsonIgnore
  public boolean getSimCardsCountDefined() {
    return simCardsCountDefined;
  }

  @JsonProperty(JSON_PROPERTY_SIM_CARDS_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSimCardsCount(Integer simCardsCount) {
    this.simCardsCount = simCardsCount;
    this.simCardsCountDefined = true;
  }

  public VerificationMetadataDto permissions(VerificationMetadataPermissionsDto permissions) {
    this.permissions = permissions;
    this.permissionsDefined = true;
    return this;
  }

  /**
   * Get permissions
   *
   * @return permissions
   */
  @JsonProperty(JSON_PROPERTY_PERMISSIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public VerificationMetadataPermissionsDto getPermissions() {
    return permissions;
  }

  @JsonIgnore
  public boolean getPermissionsDefined() {
    return permissionsDefined;
  }

  @JsonProperty(JSON_PROPERTY_PERMISSIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPermissions(VerificationMetadataPermissionsDto permissions) {
    this.permissions = permissions;
    this.permissionsDefined = true;
  }

  public VerificationMetadataDto device(VerificationMetadataDeviceDto device) {
    this.device = device;
    this.deviceDefined = true;
    return this;
  }

  /**
   * Get device
   *
   * @return device
   */
  @JsonProperty(JSON_PROPERTY_DEVICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public VerificationMetadataDeviceDto getDevice() {
    return device;
  }

  @JsonIgnore
  public boolean getDeviceDefined() {
    return deviceDefined;
  }

  @JsonProperty(JSON_PROPERTY_DEVICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDevice(VerificationMetadataDeviceDto device) {
    this.device = device;
    this.deviceDefined = true;
  }

  public VerificationMetadataDto sim(VerificationMetadataSimDto sim) {
    this.sim = sim;
    this.simDefined = true;
    return this;
  }

  /**
   * Get sim
   *
   * @return sim
   */
  @JsonProperty(JSON_PROPERTY_SIM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public VerificationMetadataSimDto getSim() {
    return sim;
  }

  @JsonIgnore
  public boolean getSimDefined() {
    return simDefined;
  }

  @JsonProperty(JSON_PROPERTY_SIM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSim(VerificationMetadataSimDto sim) {
    this.sim = sim;
    this.simDefined = true;
  }

  public VerificationMetadataDto operator(VerificationMetadataOperatorDto operator) {
    this.operator = operator;
    this.operatorDefined = true;
    return this;
  }

  /**
   * Get operator
   *
   * @return operator
   */
  @JsonProperty(JSON_PROPERTY_OPERATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public VerificationMetadataOperatorDto getOperator() {
    return operator;
  }

  @JsonIgnore
  public boolean getOperatorDefined() {
    return operatorDefined;
  }

  @JsonProperty(JSON_PROPERTY_OPERATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOperator(VerificationMetadataOperatorDto operator) {
    this.operator = operator;
    this.operatorDefined = true;
  }

  public VerificationMetadataDto networkInfo(VerificationMetadataNetworkInfoDto networkInfo) {
    this.networkInfo = networkInfo;
    this.networkInfoDefined = true;
    return this;
  }

  /**
   * Get networkInfo
   *
   * @return networkInfo
   */
  @JsonProperty(JSON_PROPERTY_NETWORK_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public VerificationMetadataNetworkInfoDto getNetworkInfo() {
    return networkInfo;
  }

  @JsonIgnore
  public boolean getNetworkInfoDefined() {
    return networkInfoDefined;
  }

  @JsonProperty(JSON_PROPERTY_NETWORK_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNetworkInfo(VerificationMetadataNetworkInfoDto networkInfo) {
    this.networkInfo = networkInfo;
    this.networkInfoDefined = true;
  }

  public VerificationMetadataDto simCardsInfo(VerificationMetadataSimCardsInfoDto simCardsInfo) {
    this.simCardsInfo = simCardsInfo;
    this.simCardsInfoDefined = true;
    return this;
  }

  /**
   * Get simCardsInfo
   *
   * @return simCardsInfo
   */
  @JsonProperty(JSON_PROPERTY_SIM_CARDS_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public VerificationMetadataSimCardsInfoDto getSimCardsInfo() {
    return simCardsInfo;
  }

  @JsonIgnore
  public boolean getSimCardsInfoDefined() {
    return simCardsInfoDefined;
  }

  @JsonProperty(JSON_PROPERTY_SIM_CARDS_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSimCardsInfo(VerificationMetadataSimCardsInfoDto simCardsInfo) {
    this.simCardsInfo = simCardsInfo;
    this.simCardsInfoDefined = true;
  }

  public VerificationMetadataDto clientProductId(String clientProductId) {
    this.clientProductId = clientProductId;
    this.clientProductIdDefined = true;
    return this;
  }

  /**
   * Get clientProductId
   *
   * @return clientProductId
   */
  @JsonProperty(JSON_PROPERTY_CLIENT_PRODUCT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getClientProductId() {
    return clientProductId;
  }

  @JsonIgnore
  public boolean getClientProductIdDefined() {
    return clientProductIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_CLIENT_PRODUCT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setClientProductId(String clientProductId) {
    this.clientProductId = clientProductId;
    this.clientProductIdDefined = true;
  }

  public VerificationMetadataDto firstAttempt(Boolean firstAttempt) {
    this.firstAttempt = firstAttempt;
    this.firstAttemptDefined = true;
    return this;
  }

  /**
   * Get firstAttempt
   *
   * @return firstAttempt
   */
  @JsonProperty(JSON_PROPERTY_FIRST_ATTEMPT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getFirstAttempt() {
    return firstAttempt;
  }

  @JsonIgnore
  public boolean getFirstAttemptDefined() {
    return firstAttemptDefined;
  }

  @JsonProperty(JSON_PROPERTY_FIRST_ATTEMPT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFirstAttempt(Boolean firstAttempt) {
    this.firstAttempt = firstAttempt;
    this.firstAttemptDefined = true;
  }

  public VerificationMetadataDto purpose(String purpose) {
    this.purpose = purpose;
    this.purposeDefined = true;
    return this;
  }

  /**
   * Get purpose
   *
   * @return purpose
   */
  @JsonProperty(JSON_PROPERTY_PURPOSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPurpose() {
    return purpose;
  }

  @JsonIgnore
  public boolean getPurposeDefined() {
    return purposeDefined;
  }

  @JsonProperty(JSON_PROPERTY_PURPOSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPurpose(String purpose) {
    this.purpose = purpose;
    this.purposeDefined = true;
  }

  public VerificationMetadataDto other(String other) {
    this.other = other;
    this.otherDefined = true;
    return this;
  }

  /**
   * Get other
   *
   * @return other
   */
  @JsonProperty(JSON_PROPERTY_OTHER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getOther() {
    return other;
  }

  @JsonIgnore
  public boolean getOtherDefined() {
    return otherDefined;
  }

  @JsonProperty(JSON_PROPERTY_OTHER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOther(String other) {
    this.other = other;
    this.otherDefined = true;
  }

  /** Return true if this VerificationMetadata object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationMetadataDto verificationMetadata = (VerificationMetadataDto) o;
    return Objects.equals(this.os, verificationMetadata.os)
        && Objects.equals(this.deviceId, verificationMetadata.deviceId)
        && Objects.equals(this.platform, verificationMetadata.platform)
        && Objects.equals(this.sdk, verificationMetadata.sdk)
        && Objects.equals(this.sdkFlavor, verificationMetadata.sdkFlavor)
        && Objects.equals(this.defaultLocale, verificationMetadata.defaultLocale)
        && Objects.equals(this.batteryLevel, verificationMetadata.batteryLevel)
        && Objects.equals(this.simCardsCount, verificationMetadata.simCardsCount)
        && Objects.equals(this.permissions, verificationMetadata.permissions)
        && Objects.equals(this.device, verificationMetadata.device)
        && Objects.equals(this.sim, verificationMetadata.sim)
        && Objects.equals(this.operator, verificationMetadata.operator)
        && Objects.equals(this.networkInfo, verificationMetadata.networkInfo)
        && Objects.equals(this.simCardsInfo, verificationMetadata.simCardsInfo)
        && Objects.equals(this.clientProductId, verificationMetadata.clientProductId)
        && Objects.equals(this.firstAttempt, verificationMetadata.firstAttempt)
        && Objects.equals(this.purpose, verificationMetadata.purpose)
        && Objects.equals(this.other, verificationMetadata.other);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        os,
        deviceId,
        platform,
        sdk,
        sdkFlavor,
        defaultLocale,
        batteryLevel,
        simCardsCount,
        permissions,
        device,
        sim,
        operator,
        networkInfo,
        simCardsInfo,
        clientProductId,
        firstAttempt,
        purpose,
        other);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationMetadataDto {\n");
    sb.append("    os: ").append(toIndentedString(os)).append("\n");
    sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
    sb.append("    platform: ").append(toIndentedString(platform)).append("\n");
    sb.append("    sdk: ").append(toIndentedString(sdk)).append("\n");
    sb.append("    sdkFlavor: ").append(toIndentedString(sdkFlavor)).append("\n");
    sb.append("    defaultLocale: ").append(toIndentedString(defaultLocale)).append("\n");
    sb.append("    batteryLevel: ").append(toIndentedString(batteryLevel)).append("\n");
    sb.append("    simCardsCount: ").append(toIndentedString(simCardsCount)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    device: ").append(toIndentedString(device)).append("\n");
    sb.append("    sim: ").append(toIndentedString(sim)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    networkInfo: ").append(toIndentedString(networkInfo)).append("\n");
    sb.append("    simCardsInfo: ").append(toIndentedString(simCardsInfo)).append("\n");
    sb.append("    clientProductId: ").append(toIndentedString(clientProductId)).append("\n");
    sb.append("    firstAttempt: ").append(toIndentedString(firstAttempt)).append("\n");
    sb.append("    purpose: ").append(toIndentedString(purpose)).append("\n");
    sb.append("    other: ").append(toIndentedString(other)).append("\n");
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
