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

/** Optional. Used for OAuth2 authentication. */
@JsonPropertyOrder({
  ClientCredentialsDto.JSON_PROPERTY_CLIENT_ID,
  ClientCredentialsDto.JSON_PROPERTY_CLIENT_SECRET,
  ClientCredentialsDto.JSON_PROPERTY_ENDPOINT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ClientCredentialsDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_CLIENT_ID = "client_id";
  private String clientId;
  private boolean clientIdDefined = false;

  public static final String JSON_PROPERTY_CLIENT_SECRET = "client_secret";
  private String clientSecret;
  private boolean clientSecretDefined = false;

  public static final String JSON_PROPERTY_ENDPOINT = "endpoint";
  private String endpoint;
  private boolean endpointDefined = false;

  public ClientCredentialsDto() {}

  public ClientCredentialsDto clientId(String clientId) {
    this.clientId = clientId;
    this.clientIdDefined = true;
    return this;
  }

  /**
   * The Client ID that will be used in the OAuth2 Client Credentials flow.
   *
   * @return clientId
   */
  @JsonProperty(JSON_PROPERTY_CLIENT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getClientId() {
    return clientId;
  }

  @JsonIgnore
  public boolean getClientIdDefined() {
    return clientIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_CLIENT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setClientId(String clientId) {
    this.clientId = clientId;
    this.clientIdDefined = true;
  }

  public ClientCredentialsDto clientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
    this.clientSecretDefined = true;
    return this;
  }

  /**
   * The Client Secret that will be used in the OAuth2 Client Credentials flow.
   *
   * @return clientSecret
   */
  @JsonProperty(JSON_PROPERTY_CLIENT_SECRET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getClientSecret() {
    return clientSecret;
  }

  @JsonIgnore
  public boolean getClientSecretDefined() {
    return clientSecretDefined;
  }

  @JsonProperty(JSON_PROPERTY_CLIENT_SECRET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
    this.clientSecretDefined = true;
  }

  public ClientCredentialsDto endpoint(String endpoint) {
    this.endpoint = endpoint;
    this.endpointDefined = true;
    return this;
  }

  /**
   * The endpoint that will be used in the OAuth2 Client Credentials flow. Expected to return a JSON
   * with an access token and &#x60;expires_in&#x60; value (in seconds). The &#x60;expires_in&#x60;
   * value, which must be a minimum of 30 seconds and a maximum of 3600 seconds, is how long Sinch
   * will save the access token before asking for a new one.
   *
   * @return endpoint
   */
  @JsonProperty(JSON_PROPERTY_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getEndpoint() {
    return endpoint;
  }

  @JsonIgnore
  public boolean getEndpointDefined() {
    return endpointDefined;
  }

  @JsonProperty(JSON_PROPERTY_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
    this.endpointDefined = true;
  }

  /** Return true if this ClientCredentials object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientCredentialsDto clientCredentials = (ClientCredentialsDto) o;
    return Objects.equals(this.clientId, clientCredentials.clientId)
        && Objects.equals(this.clientSecret, clientCredentials.clientSecret)
        && Objects.equals(this.endpoint, clientCredentials.endpoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, clientSecret, endpoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientCredentialsDto {\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientSecret: ").append(toIndentedString(clientSecret)).append("\n");
    sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
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
