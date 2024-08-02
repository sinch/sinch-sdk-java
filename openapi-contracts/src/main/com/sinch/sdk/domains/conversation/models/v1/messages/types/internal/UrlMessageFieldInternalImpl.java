package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.url.UrlMessage;
import java.util.Objects;

@JsonPropertyOrder({UrlMessageFieldInternalImpl.JSON_PROPERTY_URL_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class UrlMessageFieldInternalImpl implements UrlMessageFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_URL_MESSAGE = "url_message";

  private OptionalValue<UrlMessage> urlMessage;

  public UrlMessageFieldInternalImpl() {}

  protected UrlMessageFieldInternalImpl(OptionalValue<UrlMessage> urlMessage) {
    this.urlMessage = urlMessage;
  }

  @JsonIgnore
  public UrlMessage getUrlMessage() {
    return urlMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_URL_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<UrlMessage> urlMessage() {
    return urlMessage;
  }

  /** Return true if this UrlMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UrlMessageFieldInternalImpl urlMessageField = (UrlMessageFieldInternalImpl) o;
    return Objects.equals(this.urlMessage, urlMessageField.urlMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(urlMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UrlMessageFieldInternalImpl {\n");
    sb.append("    urlMessage: ").append(toIndentedString(urlMessage)).append("\n");
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
  static class Builder implements UrlMessageFieldInternal.Builder {
    OptionalValue<UrlMessage> urlMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_URL_MESSAGE)
    public Builder setUrlMessage(UrlMessage urlMessage) {
      this.urlMessage = OptionalValue.of(urlMessage);
      return this;
    }

    public UrlMessageFieldInternal build() {
      return new UrlMessageFieldInternalImpl(urlMessage);
    }
  }
}
