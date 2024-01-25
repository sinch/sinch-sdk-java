/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** MediaMessageMediaMessageDto */
@JsonPropertyOrder({
  MediaMessageMediaMessageDto.JSON_PROPERTY_URL,
  MediaMessageMediaMessageDto.JSON_PROPERTY_THUMBNAIL_URL,
  MediaMessageMediaMessageDto.JSON_PROPERTY_FILENAME_OVERRIDE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MediaMessageMediaMessageDto {
  public static final String JSON_PROPERTY_URL = "url";
  private String url;
  private boolean urlDefined = false;

  public static final String JSON_PROPERTY_THUMBNAIL_URL = "thumbnail_url";
  private String thumbnailUrl;
  private boolean thumbnailUrlDefined = false;

  public static final String JSON_PROPERTY_FILENAME_OVERRIDE = "filename_override";
  private String filenameOverride;
  private boolean filenameOverrideDefined = false;

  public MediaMessageMediaMessageDto() {}

  public MediaMessageMediaMessageDto url(String url) {
    this.url = url;
    this.urlDefined = true;
    return this;
  }

  /**
   * Url to the media file.
   *
   * @return url
   */
  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getUrl() {
    return url;
  }

  @JsonIgnore
  public boolean getUrlDefined() {
    return urlDefined;
  }

  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUrl(String url) {
    this.url = url;
    this.urlDefined = true;
  }

  public MediaMessageMediaMessageDto thumbnailUrl(String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
    this.thumbnailUrlDefined = true;
    return this;
  }

  /**
   * An optional parameter. Will be used where it is natively supported.
   *
   * @return thumbnailUrl
   */
  @JsonProperty(JSON_PROPERTY_THUMBNAIL_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getThumbnailUrl() {
    return thumbnailUrl;
  }

  @JsonIgnore
  public boolean getThumbnailUrlDefined() {
    return thumbnailUrlDefined;
  }

  @JsonProperty(JSON_PROPERTY_THUMBNAIL_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setThumbnailUrl(String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
    this.thumbnailUrlDefined = true;
  }

  public MediaMessageMediaMessageDto filenameOverride(String filenameOverride) {
    this.filenameOverride = filenameOverride;
    this.filenameOverrideDefined = true;
    return this;
  }

  /**
   * Overrides the media file name.
   *
   * @return filenameOverride
   */
  @JsonProperty(JSON_PROPERTY_FILENAME_OVERRIDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getFilenameOverride() {
    return filenameOverride;
  }

  @JsonIgnore
  public boolean getFilenameOverrideDefined() {
    return filenameOverrideDefined;
  }

  @JsonProperty(JSON_PROPERTY_FILENAME_OVERRIDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFilenameOverride(String filenameOverride) {
    this.filenameOverride = filenameOverride;
    this.filenameOverrideDefined = true;
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
    MediaMessageMediaMessageDto mediaMessageMediaMessage = (MediaMessageMediaMessageDto) o;
    return Objects.equals(this.url, mediaMessageMediaMessage.url)
        && Objects.equals(this.thumbnailUrl, mediaMessageMediaMessage.thumbnailUrl)
        && Objects.equals(this.filenameOverride, mediaMessageMediaMessage.filenameOverride);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, thumbnailUrl, filenameOverride);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediaMessageMediaMessageDto {\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    thumbnailUrl: ").append(toIndentedString(thumbnailUrl)).append("\n");
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
}
