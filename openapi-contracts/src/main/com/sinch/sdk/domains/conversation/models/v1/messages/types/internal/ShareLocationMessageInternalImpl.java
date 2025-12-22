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
  ShareLocationMessageInternalImpl.JSON_PROPERTY_TITLE,
  ShareLocationMessageInternalImpl.JSON_PROPERTY_FALLBACK_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ShareLocationMessageInternalImpl implements ShareLocationMessageInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public static final String JSON_PROPERTY_FALLBACK_URL = "fallback_url";

  private OptionalValue<String> fallbackUrl;

  public ShareLocationMessageInternalImpl() {}

  protected ShareLocationMessageInternalImpl(
      OptionalValue<String> title, OptionalValue<String> fallbackUrl) {
    this.title = title;
    this.fallbackUrl = fallbackUrl;
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
  public String getFallbackUrl() {
    return fallbackUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> fallbackUrl() {
    return fallbackUrl;
  }

  /** Return true if this Share_Location_Message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShareLocationMessageInternalImpl shareLocationMessage = (ShareLocationMessageInternalImpl) o;
    return Objects.equals(this.title, shareLocationMessage.title)
        && Objects.equals(this.fallbackUrl, shareLocationMessage.fallbackUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, fallbackUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShareLocationMessageInternalImpl {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    fallbackUrl: ").append(toIndentedString(fallbackUrl)).append("\n");
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
  static class Builder implements ShareLocationMessageInternal.Builder {
    OptionalValue<String> title = OptionalValue.empty();
    OptionalValue<String> fallbackUrl = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TITLE, required = true)
    public Builder setTitle(String title) {
      this.title = OptionalValue.of(title);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_FALLBACK_URL, required = true)
    public Builder setFallbackUrl(String fallbackUrl) {
      this.fallbackUrl = OptionalValue.of(fallbackUrl);
      return this;
    }

    public ShareLocationMessageInternal build() {
      return new ShareLocationMessageInternalImpl(title, fallbackUrl);
    }
  }
}
