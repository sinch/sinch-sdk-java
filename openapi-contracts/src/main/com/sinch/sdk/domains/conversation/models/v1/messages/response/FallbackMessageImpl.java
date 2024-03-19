package com.sinch.sdk.domains.conversation.models.v1.messages.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({FallbackMessageImpl.JSON_PROPERTY_FALLBACK_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class FallbackMessageImpl implements FallbackMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_FALLBACK_MESSAGE = "fallback_message";

  private OptionalValue<FallbackMessageFallbackMessage> fallbackMessage;

  public FallbackMessageImpl() {}

  protected FallbackMessageImpl(OptionalValue<FallbackMessageFallbackMessage> fallbackMessage) {
    this.fallbackMessage = fallbackMessage;
  }

  @JsonIgnore
  public FallbackMessageFallbackMessage getFallbackMessage() {
    return fallbackMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FALLBACK_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<FallbackMessageFallbackMessage> fallbackMessage() {
    return fallbackMessage;
  }

  /** Return true if this FallbackMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FallbackMessageImpl fallbackMessage = (FallbackMessageImpl) o;
    return Objects.equals(this.fallbackMessage, fallbackMessage.fallbackMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fallbackMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FallbackMessageImpl {\n");
    sb.append("    fallbackMessage: ").append(toIndentedString(fallbackMessage)).append("\n");
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
  static class Builder implements FallbackMessage.Builder {
    OptionalValue<FallbackMessageFallbackMessage> fallbackMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_FALLBACK_MESSAGE)
    public Builder setFallbackMessage(FallbackMessageFallbackMessage fallbackMessage) {
      this.fallbackMessage = OptionalValue.of(fallbackMessage);
      return this;
    }

    public FallbackMessage build() {
      return new FallbackMessageImpl(fallbackMessage);
    }
  }
}
