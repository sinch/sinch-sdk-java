package com.sinch.sdk.domains.sms.models.v1.inbounds;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  MediaMessageBodyImpl.JSON_PROPERTY_MEDIA,
  MediaMessageBodyImpl.JSON_PROPERTY_MESSAGE,
  MediaMessageBodyImpl.JSON_PROPERTY_SUBJECT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MediaMessageBodyImpl implements MediaMessageBody {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MEDIA = "media";

  private OptionalValue<List<MediaMessageBodyDetails>> media;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<String> message;

  public static final String JSON_PROPERTY_SUBJECT = "subject";

  private OptionalValue<String> subject;

  public MediaMessageBodyImpl() {}

  protected MediaMessageBodyImpl(
      OptionalValue<List<MediaMessageBodyDetails>> media,
      OptionalValue<String> message,
      OptionalValue<String> subject) {
    this.media = media;
    this.message = message;
    this.subject = subject;
  }

  @JsonIgnore
  public List<MediaMessageBodyDetails> getMedia() {
    return media.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MEDIA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<MediaMessageBodyDetails>> media() {
    return media;
  }

  @JsonIgnore
  public String getMessage() {
    return message.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> message() {
    return message;
  }

  @JsonIgnore
  public String getSubject() {
    return subject.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SUBJECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> subject() {
    return subject;
  }

  /** Return true if this MmsMoBody object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediaMessageBodyImpl mmsMoBody = (MediaMessageBodyImpl) o;
    return Objects.equals(this.media, mmsMoBody.media)
        && Objects.equals(this.message, mmsMoBody.message)
        && Objects.equals(this.subject, mmsMoBody.subject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(media, message, subject);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediaMessageBodyImpl {\n");
    sb.append("    media: ").append(toIndentedString(media)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
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
  static class Builder implements MediaMessageBody.Builder {
    OptionalValue<List<MediaMessageBodyDetails>> media = OptionalValue.empty();
    OptionalValue<String> message = OptionalValue.empty();
    OptionalValue<String> subject = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MEDIA)
    public Builder setMedia(List<MediaMessageBodyDetails> media) {
      this.media = OptionalValue.of(media);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    public Builder setMessage(String message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SUBJECT)
    public Builder setSubject(String subject) {
      this.subject = OptionalValue.of(subject);
      return this;
    }

    public MediaMessageBody build() {
      return new MediaMessageBodyImpl(media, message, subject);
    }
  }
}
