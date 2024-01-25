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
 * If you are including the LINE channel in the &#x60;channel_identifier&#x60; property, you must
 * include this object.
 */
@JsonPropertyOrder({
  LineCredentialsDto.JSON_PROPERTY_TOKEN,
  LineCredentialsDto.JSON_PROPERTY_SECRET
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LineCredentialsDto {
  public static final String JSON_PROPERTY_TOKEN = "token";
  private String token;
  private boolean tokenDefined = false;

  public static final String JSON_PROPERTY_SECRET = "secret";
  private String secret;
  private boolean secretDefined = false;

  public LineCredentialsDto() {}

  public LineCredentialsDto token(String token) {
    this.token = token;
    this.tokenDefined = true;
    return this;
  }

  /**
   * The token for the LINE channel to which you are connecting.
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

  public LineCredentialsDto secret(String secret) {
    this.secret = secret;
    this.secretDefined = true;
    return this;
  }

  /**
   * The secret for the LINE channel to which you are connecting.
   *
   * @return secret
   */
  @JsonProperty(JSON_PROPERTY_SECRET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getSecret() {
    return secret;
  }

  @JsonIgnore
  public boolean getSecretDefined() {
    return secretDefined;
  }

  @JsonProperty(JSON_PROPERTY_SECRET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSecret(String secret) {
    this.secret = secret;
    this.secretDefined = true;
  }

  /** Return true if this LineCredentials object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LineCredentialsDto lineCredentials = (LineCredentialsDto) o;
    return Objects.equals(this.token, lineCredentials.token)
        && Objects.equals(this.secret, lineCredentials.secret);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, secret);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LineCredentialsDto {\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    secret: ").append(toIndentedString(secret)).append("\n");
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
