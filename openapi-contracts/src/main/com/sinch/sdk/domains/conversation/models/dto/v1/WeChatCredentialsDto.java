/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/**
 * If you are including the WeChat channel in the &#x60;channel_identifier&#x60; property, you must
 * include this object.
 */
@JsonPropertyOrder({
  WeChatCredentialsDto.JSON_PROPERTY_APP_ID,
  WeChatCredentialsDto.JSON_PROPERTY_APP_SECRET,
  WeChatCredentialsDto.JSON_PROPERTY_TOKEN,
  WeChatCredentialsDto.JSON_PROPERTY_AES_KEY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WeChatCredentialsDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_APP_ID = "app_id";
  private String appId;
  private boolean appIdDefined = false;

  public static final String JSON_PROPERTY_APP_SECRET = "app_secret";
  private String appSecret;
  private boolean appSecretDefined = false;

  public static final String JSON_PROPERTY_TOKEN = "token";
  private String token;
  private boolean tokenDefined = false;

  public static final String JSON_PROPERTY_AES_KEY = "aes_key";
  private String aesKey;
  private boolean aesKeyDefined = false;

  public WeChatCredentialsDto() {}

  public WeChatCredentialsDto appId(String appId) {
    this.appId = appId;
    this.appIdDefined = true;
    return this;
  }

  /**
   * The AppID(Developer ID) for the WeChat channel to which you are connecting.
   *
   * @return appId
   */
  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getAppId() {
    return appId;
  }

  @JsonIgnore
  public boolean getAppIdDefined() {
    return appIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAppId(String appId) {
    this.appId = appId;
    this.appIdDefined = true;
  }

  public WeChatCredentialsDto appSecret(String appSecret) {
    this.appSecret = appSecret;
    this.appSecretDefined = true;
    return this;
  }

  /**
   * The AppSecret(Developer Password) for the WeChat channel to which you are connecting.
   *
   * @return appSecret
   */
  @JsonProperty(JSON_PROPERTY_APP_SECRET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getAppSecret() {
    return appSecret;
  }

  @JsonIgnore
  public boolean getAppSecretDefined() {
    return appSecretDefined;
  }

  @JsonProperty(JSON_PROPERTY_APP_SECRET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAppSecret(String appSecret) {
    this.appSecret = appSecret;
    this.appSecretDefined = true;
  }

  public WeChatCredentialsDto token(String token) {
    this.token = token;
    this.tokenDefined = true;
    return this;
  }

  /**
   * The Token for the WeChat channel to which you are connecting.
   *
   * @return token
   */
  @JsonProperty(JSON_PROPERTY_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getToken() {
    return token;
  }

  @JsonIgnore
  public boolean getTokenDefined() {
    return tokenDefined;
  }

  @JsonProperty(JSON_PROPERTY_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setToken(String token) {
    this.token = token;
    this.tokenDefined = true;
  }

  public WeChatCredentialsDto aesKey(String aesKey) {
    this.aesKey = aesKey;
    this.aesKeyDefined = true;
    return this;
  }

  /**
   * The Encoding AES Key for the WeChat channel to which you are connecting.
   *
   * @return aesKey
   */
  @JsonProperty(JSON_PROPERTY_AES_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getAesKey() {
    return aesKey;
  }

  @JsonIgnore
  public boolean getAesKeyDefined() {
    return aesKeyDefined;
  }

  @JsonProperty(JSON_PROPERTY_AES_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAesKey(String aesKey) {
    this.aesKey = aesKey;
    this.aesKeyDefined = true;
  }

  /** Return true if this WeChatCredentials object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WeChatCredentialsDto weChatCredentials = (WeChatCredentialsDto) o;
    return Objects.equals(this.appId, weChatCredentials.appId)
        && Objects.equals(this.appSecret, weChatCredentials.appSecret)
        && Objects.equals(this.token, weChatCredentials.token)
        && Objects.equals(this.aesKey, weChatCredentials.aesKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appId, appSecret, token, aesKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WeChatCredentialsDto {\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    appSecret: ").append(toIndentedString(appSecret)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    aesKey: ").append(toIndentedString(aesKey)).append("\n");
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