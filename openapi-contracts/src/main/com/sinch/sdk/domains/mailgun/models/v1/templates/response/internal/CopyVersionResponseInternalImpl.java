package com.sinch.sdk.domains.mailgun.models.v1.templates.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.mailgun.models.v1.templates.VersionDetails;
import java.util.Objects;

@JsonPropertyOrder({
  CopyVersionResponseInternalImpl.JSON_PROPERTY_MESSAGE,
  CopyVersionResponseInternalImpl.JSON_PROPERTY_VERSION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CopyVersionResponseInternalImpl implements CopyVersionResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<String> message;

  public static final String JSON_PROPERTY_VERSION = "version";

  private OptionalValue<VersionDetails> version;

  public CopyVersionResponseInternalImpl() {}

  protected CopyVersionResponseInternalImpl(
      OptionalValue<String> message, OptionalValue<VersionDetails> version) {
    this.message = message;
    this.version = version;
  }

  @JsonIgnore
  public String getMessage() {
    return message.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> message() {
    return message;
  }

  @JsonIgnore
  public VersionDetails getVersion() {
    return version.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VersionDetails> version() {
    return version;
  }

  /**
   * Return true if this github.com-mailgun-temple-httpapi-versionCopyResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CopyVersionResponseInternalImpl githubComMailgunTempleHttpapiVersionCopyResponse =
        (CopyVersionResponseInternalImpl) o;
    return Objects.equals(this.message, githubComMailgunTempleHttpapiVersionCopyResponse.message)
        && Objects.equals(this.version, githubComMailgunTempleHttpapiVersionCopyResponse.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CopyVersionResponseInternalImpl {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
  static class Builder implements CopyVersionResponseInternal.Builder {
    OptionalValue<String> message = OptionalValue.empty();
    OptionalValue<VersionDetails> version = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_MESSAGE, required = true)
    public Builder setMessage(String message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_VERSION, required = true)
    public Builder setVersion(VersionDetails version) {
      this.version = OptionalValue.of(version);
      return this;
    }

    public CopyVersionResponseInternal build() {
      return new CopyVersionResponseInternalImpl(message, version);
    }
  }
}
