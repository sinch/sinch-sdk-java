package com.sinch.sdk.domains.conversation.models.v1.messages.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  FallbackMessageFallbackMessageImpl.JSON_PROPERTY_RAW_MESSAGE,
  FallbackMessageFallbackMessageImpl.JSON_PROPERTY_REASON
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class FallbackMessageFallbackMessageImpl implements FallbackMessageFallbackMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_RAW_MESSAGE = "raw_message";

  private OptionalValue<String> rawMessage;

  public static final String JSON_PROPERTY_REASON = "reason";

  private OptionalValue<Reason> reason;

  public FallbackMessageFallbackMessageImpl() {}

  protected FallbackMessageFallbackMessageImpl(
      OptionalValue<String> rawMessage, OptionalValue<Reason> reason) {
    this.rawMessage = rawMessage;
    this.reason = reason;
  }

  @JsonIgnore
  public String getRawMessage() {
    return rawMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RAW_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> rawMessage() {
    return rawMessage;
  }

  @JsonIgnore
  public Reason getReason() {
    return reason.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Reason> reason() {
    return reason;
  }

  /** Return true if this FallbackMessage_fallback_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FallbackMessageFallbackMessageImpl fallbackMessageFallbackMessage =
        (FallbackMessageFallbackMessageImpl) o;
    return Objects.equals(this.rawMessage, fallbackMessageFallbackMessage.rawMessage)
        && Objects.equals(this.reason, fallbackMessageFallbackMessage.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rawMessage, reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FallbackMessageFallbackMessageImpl {\n");
    sb.append("    rawMessage: ").append(toIndentedString(rawMessage)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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
  static class Builder implements FallbackMessageFallbackMessage.Builder {
    OptionalValue<String> rawMessage = OptionalValue.empty();
    OptionalValue<Reason> reason = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_RAW_MESSAGE)
    public Builder setRawMessage(String rawMessage) {
      this.rawMessage = OptionalValue.of(rawMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REASON)
    public Builder setReason(Reason reason) {
      this.reason = OptionalValue.of(reason);
      return this;
    }

    public FallbackMessageFallbackMessage build() {
      return new FallbackMessageFallbackMessageImpl(rawMessage, reason);
    }
  }
}