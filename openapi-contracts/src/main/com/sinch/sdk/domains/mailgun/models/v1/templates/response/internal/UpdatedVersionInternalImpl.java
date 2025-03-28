package com.sinch.sdk.domains.mailgun.models.v1.templates.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({UpdatedVersionInternalImpl.JSON_PROPERTY_TAG})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class UpdatedVersionInternalImpl implements UpdatedVersionInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TAG = "tag";

  private OptionalValue<String> tag;

  public UpdatedVersionInternalImpl() {}

  protected UpdatedVersionInternalImpl(OptionalValue<String> tag) {
    this.tag = tag;
  }

  @JsonIgnore
  public String getTag() {
    return tag.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TAG)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> tag() {
    return tag;
  }

  /** Return true if this github.com-mailgun-temple-httpapi-versionUpdate object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdatedVersionInternalImpl githubComMailgunTempleHttpapiVersionUpdate =
        (UpdatedVersionInternalImpl) o;
    return Objects.equals(this.tag, githubComMailgunTempleHttpapiVersionUpdate.tag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tag);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdatedVersionInternalImpl {\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
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
  static class Builder implements UpdatedVersionInternal.Builder {
    OptionalValue<String> tag = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TAG, required = true)
    public Builder setTag(String tag) {
      this.tag = OptionalValue.of(tag);
      return this;
    }

    public UpdatedVersionInternal build() {
      return new UpdatedVersionInternalImpl(tag);
    }
  }
}
