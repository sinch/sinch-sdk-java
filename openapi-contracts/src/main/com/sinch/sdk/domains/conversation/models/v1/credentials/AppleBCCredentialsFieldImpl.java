package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({AppleBCCredentialsFieldImpl.JSON_PROPERTY_APPLEBC_CREDENTIALS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AppleBCCredentialsFieldImpl implements AppleBCCredentialsField {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APPLEBC_CREDENTIALS = "applebc_credentials";

  private OptionalValue<AppleBcCredentials> applebcCredentials;

  public AppleBCCredentialsFieldImpl() {}

  protected AppleBCCredentialsFieldImpl(OptionalValue<AppleBcCredentials> applebcCredentials) {
    this.applebcCredentials = applebcCredentials;
  }

  @JsonIgnore
  public AppleBcCredentials getApplebcCredentials() {
    return applebcCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APPLEBC_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<AppleBcCredentials> applebcCredentials() {
    return applebcCredentials;
  }

  /** Return true if this AppleBCCredentialsField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppleBCCredentialsFieldImpl appleBCCredentialsField = (AppleBCCredentialsFieldImpl) o;
    return Objects.equals(this.applebcCredentials, appleBCCredentialsField.applebcCredentials);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applebcCredentials);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppleBCCredentialsFieldImpl {\n");
    sb.append("    applebcCredentials: ").append(toIndentedString(applebcCredentials)).append("\n");
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
  static class Builder implements AppleBCCredentialsField.Builder {
    OptionalValue<AppleBcCredentials> applebcCredentials = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_APPLEBC_CREDENTIALS)
    public Builder setApplebcCredentials(AppleBcCredentials applebcCredentials) {
      this.applebcCredentials = OptionalValue.of(applebcCredentials);
      return this;
    }

    public AppleBCCredentialsField build() {
      return new AppleBCCredentialsFieldImpl(applebcCredentials);
    }
  }
}
