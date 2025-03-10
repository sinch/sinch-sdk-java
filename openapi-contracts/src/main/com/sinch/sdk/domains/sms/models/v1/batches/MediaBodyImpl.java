package com.sinch.sdk.domains.sms.models.v1.batches;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  MediaBodyImpl.JSON_PROPERTY_SUBJECT,
  MediaBodyImpl.JSON_PROPERTY_MESSAGE,
  MediaBodyImpl.JSON_PROPERTY_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MediaBodyImpl implements MediaBody {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SUBJECT = "subject";

  private OptionalValue<String> subject;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<String> message;

  public static final String JSON_PROPERTY_URL = "url";

  private OptionalValue<String> url;

  public MediaBodyImpl() {}

  protected MediaBodyImpl(
      OptionalValue<String> subject, OptionalValue<String> message, OptionalValue<String> url) {
    this.subject = subject;
    this.message = message;
    this.url = url;
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
  public String getUrl() {
    return url.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> url() {
    return url;
  }

  /** Return true if this MediaBody object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediaBodyImpl mediaBody = (MediaBodyImpl) o;
    return Objects.equals(this.subject, mediaBody.subject)
        && Objects.equals(this.message, mediaBody.message)
        && Objects.equals(this.url, mediaBody.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subject, message, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediaBodyImpl {\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
  static class Builder implements MediaBody.Builder {
    OptionalValue<String> subject = OptionalValue.empty();
    OptionalValue<String> message = OptionalValue.empty();
    OptionalValue<String> url = OptionalValue.empty();

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

    @JsonProperty(value = JSON_PROPERTY_URL, required = true)
    public Builder setUrl(String url) {
      this.url = OptionalValue.of(url);
      return this;
    }

    public MediaBody build() {
      return new MediaBodyImpl(subject, message, url);
    }
  }
}
