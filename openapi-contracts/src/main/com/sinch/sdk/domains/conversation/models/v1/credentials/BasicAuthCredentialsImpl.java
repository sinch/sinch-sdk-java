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
  BasicAuthCredentialsImpl.JSON_PROPERTY_PASSWORD,
  BasicAuthCredentialsImpl.JSON_PROPERTY_USERNAME
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class BasicAuthCredentialsImpl implements BasicAuthCredentials {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PASSWORD = "password";

  private OptionalValue<String> password;

  public static final String JSON_PROPERTY_USERNAME = "username";

  private OptionalValue<String> username;

  public BasicAuthCredentialsImpl() {}

  protected BasicAuthCredentialsImpl(
      OptionalValue<String> password, OptionalValue<String> username) {
    this.password = password;
    this.username = username;
  }

  @JsonIgnore
  public String getPassword() {
    return password.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PASSWORD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> password() {
    return password;
  }

  @JsonIgnore
  public String getUsername() {
    return username.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_USERNAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> username() {
    return username;
  }

  /** Return true if this BasicAuthCredentials object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BasicAuthCredentialsImpl basicAuthCredentials = (BasicAuthCredentialsImpl) o;
    return Objects.equals(this.password, basicAuthCredentials.password)
        && Objects.equals(this.username, basicAuthCredentials.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(password, username);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BasicAuthCredentialsImpl {\n");
    sb.append("    password: ").append(toIndentedString("***")).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
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
  static class Builder implements BasicAuthCredentials.Builder {
    OptionalValue<String> password = OptionalValue.empty();
    OptionalValue<String> username = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PASSWORD)
    public Builder setPassword(String password) {
      this.password = OptionalValue.of(password);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_USERNAME)
    public Builder setUsername(String username) {
      this.username = OptionalValue.of(username);
      return this;
    }

    public BasicAuthCredentials build() {
      return new BasicAuthCredentialsImpl(password, username);
    }
  }
}
