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
 * If you are including the MMS channel in the &#x60;channel_identifier&#x60; property, you must
 * include this object.
 */
@JsonPropertyOrder({
  MMSCredentialsDto.JSON_PROPERTY_ACCOUNT_ID,
  MMSCredentialsDto.JSON_PROPERTY_API_KEY,
  MMSCredentialsDto.JSON_PROPERTY_BASIC_AUTH,
  MMSCredentialsDto.JSON_PROPERTY_DEFAULT_SENDER
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MMSCredentialsDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_ACCOUNT_ID = "account_id";
  private String accountId;
  private boolean accountIdDefined = false;

  public static final String JSON_PROPERTY_API_KEY = "api_key";
  private String apiKey;
  private boolean apiKeyDefined = false;

  public static final String JSON_PROPERTY_BASIC_AUTH = "basic_auth";
  private BasicAuthCredentialDto basicAuth;
  private boolean basicAuthDefined = false;

  public static final String JSON_PROPERTY_DEFAULT_SENDER = "default_sender";
  private String defaultSender;
  private boolean defaultSenderDefined = false;

  public MMSCredentialsDto() {}

  public MMSCredentialsDto accountId(String accountId) {
    this.accountId = accountId;
    this.accountIdDefined = true;
    return this;
  }

  /**
   * MMS Account ID.
   *
   * @return accountId
   */
  @JsonProperty(JSON_PROPERTY_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getAccountId() {
    return accountId;
  }

  @JsonIgnore
  public boolean getAccountIdDefined() {
    return accountIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAccountId(String accountId) {
    this.accountId = accountId;
    this.accountIdDefined = true;
  }

  public MMSCredentialsDto apiKey(String apiKey) {
    this.apiKey = apiKey;
    this.apiKeyDefined = true;
    return this;
  }

  /**
   * MMS API Key.
   *
   * @return apiKey
   */
  @JsonProperty(JSON_PROPERTY_API_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getApiKey() {
    return apiKey;
  }

  @JsonIgnore
  public boolean getApiKeyDefined() {
    return apiKeyDefined;
  }

  @JsonProperty(JSON_PROPERTY_API_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
    this.apiKeyDefined = true;
  }

  public MMSCredentialsDto basicAuth(BasicAuthCredentialDto basicAuth) {
    this.basicAuth = basicAuth;
    this.basicAuthDefined = true;
    return this;
  }

  /**
   * Get basicAuth
   *
   * @return basicAuth
   */
  @JsonProperty(JSON_PROPERTY_BASIC_AUTH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public BasicAuthCredentialDto getBasicAuth() {
    return basicAuth;
  }

  @JsonIgnore
  public boolean getBasicAuthDefined() {
    return basicAuthDefined;
  }

  @JsonProperty(JSON_PROPERTY_BASIC_AUTH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBasicAuth(BasicAuthCredentialDto basicAuth) {
    this.basicAuth = basicAuth;
    this.basicAuthDefined = true;
  }

  public MMSCredentialsDto defaultSender(String defaultSender) {
    this.defaultSender = defaultSender;
    this.defaultSenderDefined = true;
    return this;
  }

  /**
   * Default Sender (shortcode or longnumber), will be used when {{YOUR_MMS_SENDER}} in a message is
   * empty
   *
   * @return defaultSender
   */
  @JsonProperty(JSON_PROPERTY_DEFAULT_SENDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDefaultSender() {
    return defaultSender;
  }

  @JsonIgnore
  public boolean getDefaultSenderDefined() {
    return defaultSenderDefined;
  }

  @JsonProperty(JSON_PROPERTY_DEFAULT_SENDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDefaultSender(String defaultSender) {
    this.defaultSender = defaultSender;
    this.defaultSenderDefined = true;
  }

  /** Return true if this MMSCredentials object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MMSCredentialsDto mmSCredentials = (MMSCredentialsDto) o;
    return Objects.equals(this.accountId, mmSCredentials.accountId)
        && Objects.equals(this.apiKey, mmSCredentials.apiKey)
        && Objects.equals(this.basicAuth, mmSCredentials.basicAuth)
        && Objects.equals(this.defaultSender, mmSCredentials.defaultSender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, apiKey, basicAuth, defaultSender);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MMSCredentialsDto {\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    apiKey: ").append(toIndentedString(apiKey)).append("\n");
    sb.append("    basicAuth: ").append(toIndentedString(basicAuth)).append("\n");
    sb.append("    defaultSender: ").append(toIndentedString(defaultSender)).append("\n");
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
