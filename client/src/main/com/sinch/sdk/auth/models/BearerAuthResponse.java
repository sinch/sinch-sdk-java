package com.sinch.sdk.auth.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BearerAuthResponse {
  @JsonProperty("access_token")
  String accessToken;

  @JsonProperty("expires_in")
  Integer expiresIn;

  @JsonProperty("scope")
  String scope;

  @JsonProperty("token_type")
  String tokenType;

  public String getAccessToken() {
    return accessToken;
  }

  /**
   * @return Integer Token period expiration in seconds
   */
  public Integer getExpiresIn() {
    return expiresIn;
  }

  public String getScope() {
    return scope;
  }

  public String getTokenType() {
    return tokenType;
  }

  @Override
  public String toString() {
    // do not log token value
    return "BearerAuthResponse{"
        + "accessToken='"
        + "<...>"
        + '\''
        + ", expiresIn="
        + expiresIn
        + ", scope='"
        + scope
        + '\''
        + ", tokenType='"
        + tokenType
        + '\''
        + '}';
  }
}
