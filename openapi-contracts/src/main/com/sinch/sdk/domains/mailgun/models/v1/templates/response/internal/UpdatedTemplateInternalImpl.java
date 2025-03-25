package com.sinch.sdk.domains.mailgun.models.v1.templates.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  UpdatedTemplateInternalImpl.JSON_PROPERTY_NAME,
  UpdatedTemplateInternalImpl.JSON_PROPERTY_VERSION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class UpdatedTemplateInternalImpl implements UpdatedTemplateInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<String> name;

  public static final String JSON_PROPERTY_VERSION = "version";

  private OptionalValue<UpdatedVersionInternal> version;

  public UpdatedTemplateInternalImpl() {}

  protected UpdatedTemplateInternalImpl(
      OptionalValue<String> name, OptionalValue<UpdatedVersionInternal> version) {
    this.name = name;
    this.version = version;
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> name() {
    return name;
  }

  @JsonIgnore
  public UpdatedVersionInternal getVersion() {
    return version.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<UpdatedVersionInternal> version() {
    return version;
  }

  /** Return true if this github.com-mailgun-temple-httpapi-templateUpdate object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdatedTemplateInternalImpl githubComMailgunTempleHttpapiTemplateUpdate =
        (UpdatedTemplateInternalImpl) o;
    return Objects.equals(this.name, githubComMailgunTempleHttpapiTemplateUpdate.name)
        && Objects.equals(this.version, githubComMailgunTempleHttpapiTemplateUpdate.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdatedTemplateInternalImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
  static class Builder implements UpdatedTemplateInternal.Builder {
    OptionalValue<String> name = OptionalValue.empty();
    OptionalValue<UpdatedVersionInternal> version = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_NAME, required = true)
    public Builder setName(String name) {
      this.name = OptionalValue.of(name);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    public Builder setVersion(UpdatedVersionInternal version) {
      this.version = OptionalValue.of(version);
      return this;
    }

    public UpdatedTemplateInternal build() {
      return new UpdatedTemplateInternalImpl(name, version);
    }
  }
}
