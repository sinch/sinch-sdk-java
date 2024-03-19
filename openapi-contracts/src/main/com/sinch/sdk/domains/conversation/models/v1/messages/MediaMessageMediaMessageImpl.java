package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  MediaMessageMediaMessageImpl.JSON_PROPERTY_THUMBNAIL_URL,
  MediaMessageMediaMessageImpl.JSON_PROPERTY_URL,
  MediaMessageMediaMessageImpl.JSON_PROPERTY_FILENAME_OVERRIDE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MediaMessageMediaMessageImpl implements MediaMessageMediaMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_THUMBNAIL_URL = "thumbnail_url";

  private OptionalValue<String> thumbnailUrl;

  public static final String JSON_PROPERTY_URL = "url";

  private OptionalValue<String> url;

  public static final String JSON_PROPERTY_FILENAME_OVERRIDE = "filename_override";

  private OptionalValue<String> filenameOverride;

  public MediaMessageMediaMessageImpl() {}

  protected MediaMessageMediaMessageImpl(
      OptionalValue<String> thumbnailUrl,
      OptionalValue<String> url,
      OptionalValue<String> filenameOverride) {
    this.thumbnailUrl = thumbnailUrl;
    this.url = url;
    this.filenameOverride = filenameOverride;
  }

  @JsonIgnore
  public String getThumbnailUrl() {
    return thumbnailUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_THUMBNAIL_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> thumbnailUrl() {
    return thumbnailUrl;
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

  @JsonIgnore
  public String getFilenameOverride() {
    return filenameOverride.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FILENAME_OVERRIDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> filenameOverride() {
    return filenameOverride;
  }

  /** Return true if this MediaMessage_media_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediaMessageMediaMessageImpl mediaMessageMediaMessage = (MediaMessageMediaMessageImpl) o;
    return Objects.equals(this.thumbnailUrl, mediaMessageMediaMessage.thumbnailUrl)
        && Objects.equals(this.url, mediaMessageMediaMessage.url)
        && Objects.equals(this.filenameOverride, mediaMessageMediaMessage.filenameOverride);
  }

  @Override
  public int hashCode() {
    return Objects.hash(thumbnailUrl, url, filenameOverride);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediaMessageMediaMessageImpl {\n");
    sb.append("    thumbnailUrl: ").append(toIndentedString(thumbnailUrl)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    filenameOverride: ").append(toIndentedString(filenameOverride)).append("\n");
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
  static class Builder implements MediaMessageMediaMessage.Builder {
    OptionalValue<String> thumbnailUrl = OptionalValue.empty();
    OptionalValue<String> url = OptionalValue.empty();
    OptionalValue<String> filenameOverride = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_THUMBNAIL_URL)
    public Builder setThumbnailUrl(String thumbnailUrl) {
      this.thumbnailUrl = OptionalValue.of(thumbnailUrl);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_URL)
    public Builder setUrl(String url) {
      this.url = OptionalValue.of(url);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FILENAME_OVERRIDE)
    public Builder setFilenameOverride(String filenameOverride) {
      this.filenameOverride = OptionalValue.of(filenameOverride);
      return this;
    }

    public MediaMessageMediaMessage build() {
      return new MediaMessageMediaMessageImpl(thumbnailUrl, url, filenameOverride);
    }
  }
}
