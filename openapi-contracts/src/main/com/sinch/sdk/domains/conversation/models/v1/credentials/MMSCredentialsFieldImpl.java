package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({MMSCredentialsFieldImpl.JSON_PROPERTY_MMS_CREDENTIALS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MMSCredentialsFieldImpl implements MMSCredentialsField {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MMS_CREDENTIALS = "mms_credentials";

  private OptionalValue<MMSCredentials> mmsCredentials;

  public MMSCredentialsFieldImpl() {}

  protected MMSCredentialsFieldImpl(OptionalValue<MMSCredentials> mmsCredentials) {
    this.mmsCredentials = mmsCredentials;
  }

  @JsonIgnore
  public MMSCredentials getMmsCredentials() {
    return mmsCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MMS_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MMSCredentials> mmsCredentials() {
    return mmsCredentials;
  }

  /** Return true if this MMSCredentialsField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MMSCredentialsFieldImpl mmSCredentialsField = (MMSCredentialsFieldImpl) o;
    return Objects.equals(this.mmsCredentials, mmSCredentialsField.mmsCredentials);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mmsCredentials);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MMSCredentialsFieldImpl {\n");
    sb.append("    mmsCredentials: ").append(toIndentedString(mmsCredentials)).append("\n");
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
  static class Builder implements MMSCredentialsField.Builder {
    OptionalValue<MMSCredentials> mmsCredentials = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MMS_CREDENTIALS)
    public Builder setMmsCredentials(MMSCredentials mmsCredentials) {
      this.mmsCredentials = OptionalValue.of(mmsCredentials);
      return this;
    }

    public MMSCredentialsField build() {
      return new MMSCredentialsFieldImpl(mmsCredentials);
    }
  }
}
