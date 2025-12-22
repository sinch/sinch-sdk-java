package com.sinch.sdk.domains.conversation.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  ClientCredentialsImpl.JSON_PROPERTY_CLIENT_ID,
  ClientCredentialsImpl.JSON_PROPERTY_CLIENT_SECRET,
  ClientCredentialsImpl.JSON_PROPERTY_ENDPOINT,
  ClientCredentialsImpl.JSON_PROPERTY_SCOPE,
  ClientCredentialsImpl.JSON_PROPERTY_RESPONSE_TYPE,
  ClientCredentialsImpl.JSON_PROPERTY_TOKEN_REQUEST_TYPE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ClientCredentialsImpl implements ClientCredentials {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CLIENT_ID = "client_id";

  private OptionalValue<String> clientId;

  public static final String JSON_PROPERTY_CLIENT_SECRET = "client_secret";

  private OptionalValue<String> clientSecret;

  public static final String JSON_PROPERTY_ENDPOINT = "endpoint";

  private OptionalValue<String> endpoint;

  public static final String JSON_PROPERTY_SCOPE = "scope";

  private OptionalValue<String> scope;

  public static final String JSON_PROPERTY_RESPONSE_TYPE = "response_type";

  private OptionalValue<String> responseType;

  public static final String JSON_PROPERTY_TOKEN_REQUEST_TYPE = "token_request_type";

  private OptionalValue<TokenRequestTypeEnum> tokenRequestType;

  public ClientCredentialsImpl() {}

  protected ClientCredentialsImpl(
      OptionalValue<String> clientId,
      OptionalValue<String> clientSecret,
      OptionalValue<String> endpoint,
      OptionalValue<String> scope,
      OptionalValue<String> responseType,
      OptionalValue<TokenRequestTypeEnum> tokenRequestType) {
    this.clientId = clientId;
    this.clientSecret = clientSecret;
    this.endpoint = endpoint;
    this.scope = scope;
    this.responseType = responseType;
    this.tokenRequestType = tokenRequestType;
  }

  @JsonIgnore
  public String getClientId() {
    return clientId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLIENT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> clientId() {
    return clientId;
  }

  @JsonIgnore
  public String getClientSecret() {
    return clientSecret.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLIENT_SECRET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> clientSecret() {
    return clientSecret;
  }

  @JsonIgnore
  public String getEndpoint() {
    return endpoint.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> endpoint() {
    return endpoint;
  }

  @JsonIgnore
  public String getScope() {
    return scope.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SCOPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> scope() {
    return scope;
  }

  @JsonIgnore
  public String getResponseType() {
    return responseType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RESPONSE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> responseType() {
    return responseType;
  }

  @JsonIgnore
  public TokenRequestTypeEnum getTokenRequestType() {
    return tokenRequestType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TOKEN_REQUEST_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TokenRequestTypeEnum> tokenRequestType() {
    return tokenRequestType;
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
    ClientCredentialsImpl clientCredentials = (ClientCredentialsImpl) o;
    return Objects.equals(this.clientId, clientCredentials.clientId)
        && Objects.equals(this.clientSecret, clientCredentials.clientSecret)
        && Objects.equals(this.endpoint, clientCredentials.endpoint)
        && Objects.equals(this.scope, clientCredentials.scope)
        && Objects.equals(this.responseType, clientCredentials.responseType)
        && Objects.equals(this.tokenRequestType, clientCredentials.tokenRequestType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, clientSecret, endpoint, scope, responseType, tokenRequestType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientCredentialsImpl {\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientSecret: ").append(toIndentedString("***")).append("\n");
    sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    responseType: ").append(toIndentedString(responseType)).append("\n");
    sb.append("    tokenRequestType: ").append(toIndentedString(tokenRequestType)).append("\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements ClientCredentials.Builder {
    OptionalValue<String> clientId = OptionalValue.empty();
    OptionalValue<String> clientSecret = OptionalValue.empty();
    OptionalValue<String> endpoint = OptionalValue.empty();
    OptionalValue<String> scope = OptionalValue.empty();
    OptionalValue<String> responseType = OptionalValue.empty();
    OptionalValue<TokenRequestTypeEnum> tokenRequestType = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_CLIENT_ID, required = true)
    public Builder setClientId(String clientId) {
      this.clientId = OptionalValue.of(clientId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_CLIENT_SECRET, required = true)
    public Builder setClientSecret(String clientSecret) {
      this.clientSecret = OptionalValue.of(clientSecret);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_ENDPOINT, required = true)
    public Builder setEndpoint(String endpoint) {
      this.endpoint = OptionalValue.of(endpoint);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SCOPE)
    public Builder setScope(String scope) {
      this.scope = OptionalValue.of(scope);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RESPONSE_TYPE)
    public Builder setResponseType(String responseType) {
      this.responseType = OptionalValue.of(responseType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TOKEN_REQUEST_TYPE)
    public Builder setTokenRequestType(TokenRequestTypeEnum tokenRequestType) {
      this.tokenRequestType = OptionalValue.of(tokenRequestType);
      return this;
    }

    public ClientCredentials build() {
      return new ClientCredentialsImpl(
          clientId, clientSecret, endpoint, scope, responseType, tokenRequestType);
    }
  }
}
