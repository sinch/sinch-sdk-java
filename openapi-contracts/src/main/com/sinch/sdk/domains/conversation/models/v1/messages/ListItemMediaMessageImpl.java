package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ListItemMediaMessageImpl.JSON_PROPERTY_MEDIA_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListItemMediaMessageImpl implements ListItemMediaMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MEDIA_MESSAGE = "media_message";

  private OptionalValue<MediaMessage> mediaMessage;

  public ListItemMediaMessageImpl() {}

  protected ListItemMediaMessageImpl(OptionalValue<MediaMessage> mediaMessage) {
    this.mediaMessage = mediaMessage;
  }

  @JsonIgnore
  public MediaMessage getMediaMessage() {
    return mediaMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MEDIA_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MediaMessage> mediaMessage() {
    return mediaMessage;
  }

  /** Return true if this MediaMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListItemMediaMessageImpl mediaMessageField = (ListItemMediaMessageImpl) o;
    return Objects.equals(this.mediaMessage, mediaMessageField.mediaMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mediaMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListItemMediaMessageImpl {\n");
    sb.append("    mediaMessage: ").append(toIndentedString(mediaMessage)).append("\n");
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
  static class Builder implements ListItemMediaMessage.Builder {
    OptionalValue<MediaMessage> mediaMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MEDIA_MESSAGE)
    public Builder setMediaMessage(MediaMessage mediaMessage) {
      this.mediaMessage = OptionalValue.of(mediaMessage);
      return this;
    }

    public ListItemMediaMessage build() {
      return new ListItemMediaMessageImpl(mediaMessage);
    }
  }
}
