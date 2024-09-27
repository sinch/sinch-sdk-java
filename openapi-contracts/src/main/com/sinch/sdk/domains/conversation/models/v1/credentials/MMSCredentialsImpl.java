package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  MMSCredentialsImpl.JSON_PROPERTY_ACCOUNT_ID,
  MMSCredentialsImpl.JSON_PROPERTY_API_KEY,
  MMSCredentialsImpl.JSON_PROPERTY_BASIC_AUTH
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MMSCredentialsImpl implements MMSCredentials, ChannelCredentials {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ACCOUNT_ID = "account_id";

  private OptionalValue<String> accountId;

  public static final String JSON_PROPERTY_API_KEY = "api_key";

  private OptionalValue<String> apiKey;

  public static final String JSON_PROPERTY_BASIC_AUTH = "basic_auth";

  private OptionalValue<BasicAuthCredentials> basicAuth;

  public MMSCredentialsImpl() {}

  protected MMSCredentialsImpl(
      OptionalValue<String> accountId,
      OptionalValue<String> apiKey,
      OptionalValue<BasicAuthCredentials> basicAuth) {
    this.accountId = accountId;
    this.apiKey = apiKey;
    this.basicAuth = basicAuth;
  }

  @JsonIgnore
  public String getAccountId() {
    return accountId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> accountId() {
    return accountId;
  }

  @JsonIgnore
  public String getApiKey() {
    return apiKey.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_API_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> apiKey() {
    return apiKey;
  }

  @JsonIgnore
  public BasicAuthCredentials getBasicAuth() {
    return basicAuth.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BASIC_AUTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<BasicAuthCredentials> basicAuth() {
    return basicAuth;
  }

  /** Return true if this MMS_Credentials object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MMSCredentialsImpl mmSCredentials = (MMSCredentialsImpl) o;
    return Objects.equals(this.accountId, mmSCredentials.accountId)
        && Objects.equals(this.apiKey, mmSCredentials.apiKey)
        && Objects.equals(this.basicAuth, mmSCredentials.basicAuth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, apiKey, basicAuth);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MMSCredentialsImpl {\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    apiKey: ").append(toIndentedString(apiKey)).append("\n");
    sb.append("    basicAuth: ").append(toIndentedString(basicAuth)).append("\n");
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
  static class Builder implements MMSCredentials.Builder {
    OptionalValue<String> accountId = OptionalValue.empty();
    OptionalValue<String> apiKey = OptionalValue.empty();
    OptionalValue<BasicAuthCredentials> basicAuth = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ACCOUNT_ID)
    public Builder setAccountId(String accountId) {
      this.accountId = OptionalValue.of(accountId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_API_KEY)
    public Builder setApiKey(String apiKey) {
      this.apiKey = OptionalValue.of(apiKey);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BASIC_AUTH)
    public Builder setBasicAuth(BasicAuthCredentials basicAuth) {
      this.basicAuth = OptionalValue.of(basicAuth);
      return this;
    }

    public MMSCredentials build() {
      return new MMSCredentialsImpl(accountId, apiKey, basicAuth);
    }
  }
}
