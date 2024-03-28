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
  FlowChannelSpecificMessageHeaderImpl.JSON_PROPERTY_TYPE,
  FlowChannelSpecificMessageHeaderImpl.JSON_PROPERTY_TEXT,
  FlowChannelSpecificMessageHeaderImpl.JSON_PROPERTY_IMAGE,
  FlowChannelSpecificMessageHeaderImpl.JSON_PROPERTY_DOCUMENT,
  FlowChannelSpecificMessageHeaderImpl.JSON_PROPERTY_VIDEO
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class FlowChannelSpecificMessageHeaderImpl implements FlowChannelSpecificMessageHeader {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<String> type;

  public static final String JSON_PROPERTY_TEXT = "text";

  private OptionalValue<String> text;

  public static final String JSON_PROPERTY_IMAGE = "image";

  private OptionalValue<WhatsAppInteractiveHeaderMedia> image;

  public static final String JSON_PROPERTY_DOCUMENT = "document";

  private OptionalValue<WhatsAppInteractiveHeaderMedia> document;

  public static final String JSON_PROPERTY_VIDEO = "video";

  private OptionalValue<WhatsAppInteractiveHeaderMedia> video;

  public FlowChannelSpecificMessageHeaderImpl() {}

  protected FlowChannelSpecificMessageHeaderImpl(
      OptionalValue<String> type,
      OptionalValue<String> text,
      OptionalValue<WhatsAppInteractiveHeaderMedia> image,
      OptionalValue<WhatsAppInteractiveHeaderMedia> document,
      OptionalValue<WhatsAppInteractiveHeaderMedia> video) {
    this.type = type;
    this.text = text;
    this.image = image;
    this.document = document;
    this.video = video;
  }

  @JsonIgnore
  public String getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> type() {
    return type;
  }

  @JsonIgnore
  public String getText() {
    return text.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEXT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> text() {
    return text;
  }

  @JsonIgnore
  public WhatsAppInteractiveHeaderMedia getImage() {
    return image.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IMAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<WhatsAppInteractiveHeaderMedia> image() {
    return image;
  }

  @JsonIgnore
  public WhatsAppInteractiveHeaderMedia getDocument() {
    return document.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DOCUMENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<WhatsAppInteractiveHeaderMedia> document() {
    return document;
  }

  @JsonIgnore
  public WhatsAppInteractiveHeaderMedia getVideo() {
    return video.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VIDEO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<WhatsAppInteractiveHeaderMedia> video() {
    return video;
  }

  /** Return true if this FlowChannelSpecificMessage_header object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlowChannelSpecificMessageHeaderImpl flowChannelSpecificMessageHeader =
        (FlowChannelSpecificMessageHeaderImpl) o;
    return Objects.equals(this.type, flowChannelSpecificMessageHeader.type)
        && Objects.equals(this.text, flowChannelSpecificMessageHeader.text)
        && Objects.equals(this.image, flowChannelSpecificMessageHeader.image)
        && Objects.equals(this.document, flowChannelSpecificMessageHeader.document)
        && Objects.equals(this.video, flowChannelSpecificMessageHeader.video);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, text, image, document, video);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlowChannelSpecificMessageHeaderImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    document: ").append(toIndentedString(document)).append("\n");
    sb.append("    video: ").append(toIndentedString(video)).append("\n");
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
  static class Builder implements FlowChannelSpecificMessageHeader.Builder {
    OptionalValue<String> type = OptionalValue.empty();
    OptionalValue<String> text = OptionalValue.empty();
    OptionalValue<WhatsAppInteractiveHeaderMedia> image = OptionalValue.empty();
    OptionalValue<WhatsAppInteractiveHeaderMedia> document = OptionalValue.empty();
    OptionalValue<WhatsAppInteractiveHeaderMedia> video = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(String type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEXT)
    public Builder setText(String text) {
      this.text = OptionalValue.of(text);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_IMAGE)
    public Builder setImage(WhatsAppInteractiveHeaderMedia image) {
      this.image = OptionalValue.of(image);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DOCUMENT)
    public Builder setDocument(WhatsAppInteractiveHeaderMedia document) {
      this.document = OptionalValue.of(document);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VIDEO)
    public Builder setVideo(WhatsAppInteractiveHeaderMedia video) {
      this.video = OptionalValue.of(video);
      return this;
    }

    public FlowChannelSpecificMessageHeader build() {
      return new FlowChannelSpecificMessageHeaderImpl(type, text, image, document, video);
    }
  }
}
