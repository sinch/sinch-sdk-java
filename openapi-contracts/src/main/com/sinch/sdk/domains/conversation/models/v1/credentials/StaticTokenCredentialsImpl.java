package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({StaticTokenCredentialsImpl.JSON_PROPERTY_TOKEN})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StaticTokenCredentialsImpl implements StaticTokenCredentials {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TOKEN = "token";

  private OptionalValue<String> token;

  public StaticTokenCredentialsImpl() {}

  protected StaticTokenCredentialsImpl(OptionalValue<String> token) {
    this.token = token;
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

  /** Return true if this Static_Token_Credentials object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StaticTokenCredentialsImpl staticTokenCredentials = (StaticTokenCredentialsImpl) o;
    return Objects.equals(this.token, staticTokenCredentials.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StaticTokenCredentialsImpl {\n");
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
  static class Builder implements StaticTokenCredentials.Builder {
    OptionalValue<String> token = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TOKEN)
    public Builder setToken(String token) {
      this.token = OptionalValue.of(token);
      return this;
    }

    public StaticTokenCredentials build() {
      return new StaticTokenCredentialsImpl(token);
    }
  }
}
