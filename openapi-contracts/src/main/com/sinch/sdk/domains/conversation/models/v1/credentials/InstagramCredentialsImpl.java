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
  InstagramCredentialsImpl.JSON_PROPERTY_TOKEN,
  InstagramCredentialsImpl.JSON_PROPERTY_BUSINESS_ACCOUNT_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class InstagramCredentialsImpl implements InstagramCredentials {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TOKEN = "token";

  private OptionalValue<String> token;

  public static final String JSON_PROPERTY_BUSINESS_ACCOUNT_ID = "business_account_id";

  private OptionalValue<String> businessAccountId;

  public InstagramCredentialsImpl() {}

  protected InstagramCredentialsImpl(
      OptionalValue<String> token, OptionalValue<String> businessAccountId) {
    this.token = token;
    this.businessAccountId = businessAccountId;
  }

  @JsonIgnore
  public String getToken() {
    return token.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> token() {
    return token;
  }

  @JsonIgnore
  public String getBusinessAccountId() {
    return businessAccountId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BUSINESS_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> businessAccountId() {
    return businessAccountId;
  }

  /** Return true if this Instagram_Credentials object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstagramCredentialsImpl instagramCredentials = (InstagramCredentialsImpl) o;
    return Objects.equals(this.token, instagramCredentials.token)
        && Objects.equals(this.businessAccountId, instagramCredentials.businessAccountId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, businessAccountId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstagramCredentialsImpl {\n");
    sb.append("    token: ").append(toIndentedString("***")).append("\n");
    sb.append("    businessAccountId: ").append(toIndentedString(businessAccountId)).append("\n");
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
  static class Builder implements InstagramCredentials.Builder {
    OptionalValue<String> token = OptionalValue.empty();
    OptionalValue<String> businessAccountId = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TOKEN)
    public Builder setToken(String token) {
      this.token = OptionalValue.of(token);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BUSINESS_ACCOUNT_ID)
    public Builder setBusinessAccountId(String businessAccountId) {
      this.businessAccountId = OptionalValue.of(businessAccountId);
      return this;
    }

    public InstagramCredentials build() {
      return new InstagramCredentialsImpl(token, businessAccountId);
    }
  }
}
