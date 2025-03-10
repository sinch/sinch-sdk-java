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
  LineCredentialsImpl.JSON_PROPERTY_TOKEN,
  LineCredentialsImpl.JSON_PROPERTY_SECRET
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LineCredentialsImpl implements LineCredentials, ChannelCredentials {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TOKEN = "token";

  private OptionalValue<String> token;

  public static final String JSON_PROPERTY_SECRET = "secret";

  private OptionalValue<String> secret;

  public LineCredentialsImpl() {}

  protected LineCredentialsImpl(OptionalValue<String> token, OptionalValue<String> secret) {
    this.token = token;
    this.secret = secret;
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
  public String getSecret() {
    return secret.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SECRET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> secret() {
    return secret;
  }

  /** Return true if this LINE_Credentials object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LineCredentialsImpl liNECredentials = (LineCredentialsImpl) o;
    return Objects.equals(this.token, liNECredentials.token)
        && Objects.equals(this.secret, liNECredentials.secret);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, secret);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LineCredentialsImpl {\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    secret: ").append(toIndentedString("***")).append("\n");
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
  static class Builder implements LineCredentials.Builder {
    OptionalValue<String> token = OptionalValue.empty();
    OptionalValue<String> secret = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TOKEN, required = true)
    public Builder setToken(String token) {
      this.token = OptionalValue.of(token);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_SECRET, required = true)
    public Builder setSecret(String secret) {
      this.secret = OptionalValue.of(secret);
      return this;
    }

    public LineCredentials build() {
      return new LineCredentialsImpl(token, secret);
    }
  }
}
