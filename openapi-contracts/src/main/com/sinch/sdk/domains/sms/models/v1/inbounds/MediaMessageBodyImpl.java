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
  MediaMessageBodyImpl.JSON_PROPERTY_SUBJECT,
  MediaMessageBodyImpl.JSON_PROPERTY_MESSAGE,
  MediaMessageBodyImpl.JSON_PROPERTY_MEDIA
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MediaMessageBodyImpl implements MediaMessageBody {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SUBJECT = "subject";

  private OptionalValue<String> subject;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<String> message;

  public static final String JSON_PROPERTY_MEDIA = "media";

  private OptionalValue<List<MediaMessageBodyDetails>> media;

  public MediaMessageBodyImpl() {}

  protected MediaMessageBodyImpl(
      OptionalValue<String> subject,
      OptionalValue<String> message,
      OptionalValue<List<MediaMessageBodyDetails>> media) {
    this.subject = subject;
    this.message = message;
    this.media = media;
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
  public List<MediaMessageBodyDetails> getMedia() {
    return media.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MEDIA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<MediaMessageBodyDetails>> media() {
    return media;
  }

  /** Return true if this MOMediaBody object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediaMessageBodyImpl moMediaBody = (MediaMessageBodyImpl) o;
    return Objects.equals(this.subject, moMediaBody.subject)
        && Objects.equals(this.message, moMediaBody.message)
        && Objects.equals(this.media, moMediaBody.media);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subject, message, media);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediaMessageBodyImpl {\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    media: ").append(toIndentedString(media)).append("\n");
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
    OptionalValue<String> subject = OptionalValue.empty();
    OptionalValue<String> message = OptionalValue.empty();
    OptionalValue<List<MediaMessageBodyDetails>> media = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_SUBJECT)
    public Builder setSubject(String subject) {
      this.subject = OptionalValue.of(subject);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    public Builder setMessage(String message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MEDIA)
    public Builder setMedia(List<MediaMessageBodyDetails> media) {
      this.media = OptionalValue.of(media);
      return this;
    }

    public MediaMessageBody build() {
      return new MediaMessageBodyImpl(subject, message, media);
    }
  }
}
