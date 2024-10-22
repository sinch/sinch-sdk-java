package com.sinch.sdk.domains.mailgun.models.v1.emails.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({EmailNotFoundImpl.JSON_PROPERTY_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class EmailNotFoundImpl implements EmailNotFound {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<String> message;

  public EmailNotFoundImpl() {}

  protected EmailNotFoundImpl(OptionalValue<String> message) {
    this.message = message;
  }

  @JsonIgnore
  public String getMessage() {
    return message.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> message() {
    return message;
  }

  /**
   * Return true if this github.com-mailgun-influx-httpapi-GetMessageResponseNotFound object is
   * equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmailNotFoundImpl githubComMailgunInfluxHttpapiGetMessageResponseNotFound =
        (EmailNotFoundImpl) o;
    return Objects.equals(
        this.message, githubComMailgunInfluxHttpapiGetMessageResponseNotFound.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmailNotFoundImpl {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
  static class Builder implements EmailNotFound.Builder {
    OptionalValue<String> message = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    public Builder setMessage(String message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    public EmailNotFound build() {
      return new EmailNotFoundImpl(message);
    }
  }
}
