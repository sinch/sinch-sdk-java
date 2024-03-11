package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({InstagramCredentialsFieldImpl.JSON_PROPERTY_INSTAGRAM_CREDENTIALS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class InstagramCredentialsFieldImpl implements InstagramCredentialsField {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_INSTAGRAM_CREDENTIALS = "instagram_credentials";

  private OptionalValue<InstagramCredentials> instagramCredentials;

  public InstagramCredentialsFieldImpl() {}

  protected InstagramCredentialsFieldImpl(
      OptionalValue<InstagramCredentials> instagramCredentials) {
    this.instagramCredentials = instagramCredentials;
  }

  @JsonIgnore
  public InstagramCredentials getInstagramCredentials() {
    return instagramCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INSTAGRAM_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<InstagramCredentials> instagramCredentials() {
    return instagramCredentials;
  }

  /** Return true if this InstagramCredentialsField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstagramCredentialsFieldImpl instagramCredentialsField = (InstagramCredentialsFieldImpl) o;
    return Objects.equals(
        this.instagramCredentials, instagramCredentialsField.instagramCredentials);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instagramCredentials);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstagramCredentialsFieldImpl {\n");
    sb.append("    instagramCredentials: ")
        .append(toIndentedString(instagramCredentials))
        .append("\n");
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
  static class Builder implements InstagramCredentialsField.Builder {
    OptionalValue<InstagramCredentials> instagramCredentials = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_INSTAGRAM_CREDENTIALS)
    public Builder setInstagramCredentials(InstagramCredentials instagramCredentials) {
      this.instagramCredentials = OptionalValue.of(instagramCredentials);
      return this;
    }

    public InstagramCredentialsField build() {
      return new InstagramCredentialsFieldImpl(instagramCredentials);
    }
  }
}
