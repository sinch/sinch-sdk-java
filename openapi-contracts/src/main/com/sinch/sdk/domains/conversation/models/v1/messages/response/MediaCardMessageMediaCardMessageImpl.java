package com.sinch.sdk.domains.conversation.models.v1.messages.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  MediaCardMessageMediaCardMessageImpl.JSON_PROPERTY_CAPTION,
  MediaCardMessageMediaCardMessageImpl.JSON_PROPERTY_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MediaCardMessageMediaCardMessageImpl implements MediaCardMessageMediaCardMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CAPTION = "caption";

  private OptionalValue<String> caption;

  public static final String JSON_PROPERTY_URL = "url";

  private OptionalValue<String> url;

  public MediaCardMessageMediaCardMessageImpl() {}

  protected MediaCardMessageMediaCardMessageImpl(
      OptionalValue<String> caption, OptionalValue<String> url) {
    this.caption = caption;
    this.url = url;
  }

  @JsonIgnore
  public String getCaption() {
    return caption.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CAPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> caption() {
    return caption;
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

  /** Return true if this MediaCardMessage_media_card_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediaCardMessageMediaCardMessageImpl mediaCardMessageMediaCardMessage =
        (MediaCardMessageMediaCardMessageImpl) o;
    return Objects.equals(this.caption, mediaCardMessageMediaCardMessage.caption)
        && Objects.equals(this.url, mediaCardMessageMediaCardMessage.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caption, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediaCardMessageMediaCardMessageImpl {\n");
    sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
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
  static class Builder implements MediaCardMessageMediaCardMessage.Builder {
    OptionalValue<String> caption = OptionalValue.empty();
    OptionalValue<String> url = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CAPTION)
    public Builder setCaption(String caption) {
      this.caption = OptionalValue.of(caption);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_URL)
    public Builder setUrl(String url) {
      this.url = OptionalValue.of(url);
      return this;
    }

    public MediaCardMessageMediaCardMessage build() {
      return new MediaCardMessageMediaCardMessageImpl(caption, url);
    }
  }
}
