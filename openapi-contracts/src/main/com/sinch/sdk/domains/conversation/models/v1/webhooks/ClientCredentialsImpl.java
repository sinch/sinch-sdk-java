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
  ClientCredentialsImpl.JSON_PROPERTY_ENDPOINT
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

  public ClientCredentialsImpl() {}

  protected ClientCredentialsImpl(
      OptionalValue<String> clientId,
      OptionalValue<String> clientSecret,
      OptionalValue<String> endpoint) {
    this.clientId = clientId;
    this.clientSecret = clientSecret;
    this.endpoint = endpoint;
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
        && Objects.equals(this.endpoint, clientCredentials.endpoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, clientSecret, endpoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientCredentialsImpl {\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientSecret: ").append(toIndentedString("***")).append("\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements ClientCredentials.Builder {
    OptionalValue<String> clientId = OptionalValue.empty();
    OptionalValue<String> clientSecret = OptionalValue.empty();
    OptionalValue<String> endpoint = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CLIENT_ID)
    public Builder setClientId(String clientId) {
      this.clientId = OptionalValue.of(clientId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CLIENT_SECRET)
    public Builder setClientSecret(String clientSecret) {
      this.clientSecret = OptionalValue.of(clientSecret);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ENDPOINT)
    public Builder setEndpoint(String endpoint) {
      this.endpoint = OptionalValue.of(endpoint);
      return this;
    }

    public ClientCredentials build() {
      return new ClientCredentialsImpl(clientId, clientSecret, endpoint);
    }
  }
}
