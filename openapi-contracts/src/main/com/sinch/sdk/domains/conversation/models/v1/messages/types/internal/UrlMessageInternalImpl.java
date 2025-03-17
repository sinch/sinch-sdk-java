package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  UrlMessageInternalImpl.JSON_PROPERTY_TITLE,
  UrlMessageInternalImpl.JSON_PROPERTY_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class UrlMessageInternalImpl implements UrlMessageInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public static final String JSON_PROPERTY_URL = "url";

  private OptionalValue<String> url;

  public UrlMessageInternalImpl() {}

  protected UrlMessageInternalImpl(OptionalValue<String> title, OptionalValue<String> url) {
    this.title = title;
    this.url = url;
  }

  @JsonIgnore
  public String getTitle() {
    return title.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> title() {
    return title;
  }

  @JsonIgnore
  public String getUrl() {
    return url.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> url() {
    return url;
  }

  /** Return true if this URL_Message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UrlMessageInternalImpl urLMessage = (UrlMessageInternalImpl) o;
    return Objects.equals(this.title, urLMessage.title) && Objects.equals(this.url, urLMessage.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UrlMessageInternalImpl {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
  static class Builder implements UrlMessageInternal.Builder {
    OptionalValue<String> title = OptionalValue.empty();
    OptionalValue<String> url = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TITLE, required = true)
    public Builder setTitle(String title) {
      this.title = OptionalValue.of(title);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_URL, required = true)
    public Builder setUrl(String url) {
      this.url = OptionalValue.of(url);
      return this;
    }

    public UrlMessageInternal build() {
      return new UrlMessageInternalImpl(title, url);
    }
  }
}
