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
  StaticBearerCredentialsImpl.JSON_PROPERTY_CLAIMED_IDENTITY,
  StaticBearerCredentialsImpl.JSON_PROPERTY_TOKEN
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StaticBearerCredentialsImpl implements StaticBearerCredentials {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CLAIMED_IDENTITY = "claimed_identity";

  private OptionalValue<String> claimedIdentity;

  public static final String JSON_PROPERTY_TOKEN = "token";

  private OptionalValue<String> token;

  public StaticBearerCredentialsImpl() {}

  protected StaticBearerCredentialsImpl(
      OptionalValue<String> claimedIdentity, OptionalValue<String> token) {
    this.claimedIdentity = claimedIdentity;
    this.token = token;
  }

  @JsonIgnore
  public String getClaimedIdentity() {
    return claimedIdentity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLAIMED_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> claimedIdentity() {
    return claimedIdentity;
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

  /** Return true if this Static_Bearer_Credentials object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StaticBearerCredentialsImpl staticBearerCredentials = (StaticBearerCredentialsImpl) o;
    return Objects.equals(this.claimedIdentity, staticBearerCredentials.claimedIdentity)
        && Objects.equals(this.token, staticBearerCredentials.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(claimedIdentity, token);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StaticBearerCredentialsImpl {\n");
    sb.append("    claimedIdentity: ").append(toIndentedString(claimedIdentity)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
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
  static class Builder implements StaticBearerCredentials.Builder {
    OptionalValue<String> claimedIdentity = OptionalValue.empty();
    OptionalValue<String> token = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CLAIMED_IDENTITY)
    public Builder setClaimedIdentity(String claimedIdentity) {
      this.claimedIdentity = OptionalValue.of(claimedIdentity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TOKEN)
    public Builder setToken(String token) {
      this.token = OptionalValue.of(token);
      return this;
    }

    public StaticBearerCredentials build() {
      return new StaticBearerCredentialsImpl(claimedIdentity, token);
    }
  }
}
