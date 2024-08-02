package com.sinch.sdk.domains.conversation.models.v1.messages.types.fallback;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.Reason;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.FallbackMessageInternal;
import java.util.Objects;

@JsonPropertyOrder({FallbackMessageImpl.JSON_PROPERTY_FALLBACK_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class FallbackMessageImpl
    implements FallbackMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_FALLBACK_MESSAGE = "fallback_message";

  private OptionalValue<FallbackMessageInternal> fallbackMessage;

  public FallbackMessageImpl() {}

  protected FallbackMessageImpl(OptionalValue<FallbackMessageInternal> fallbackMessage) {
    this.fallbackMessage = fallbackMessage;
  }

  @JsonIgnore
  public FallbackMessageInternal getFallbackMessage() {
    return fallbackMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FALLBACK_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<FallbackMessageInternal> fallbackMessage() {
    return fallbackMessage;
  }

  @JsonIgnore
  public String getRawMessage() {
    if (null == fallbackMessage
        || !fallbackMessage.isPresent()
        || null == fallbackMessage.get().getRawMessage()) {
      return null;
    }
    return fallbackMessage.get().getRawMessage();
  }

  public OptionalValue<String> rawMessage() {
    return null != fallbackMessage
        ? fallbackMessage.map(FallbackMessageInternal::getRawMessage)
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Reason getReason() {
    if (null == fallbackMessage
        || !fallbackMessage.isPresent()
        || null == fallbackMessage.get().getReason()) {
      return null;
    }
    return fallbackMessage.get().getReason();
  }

  public OptionalValue<Reason> reason() {
    return null != fallbackMessage
        ? fallbackMessage.map(FallbackMessageInternal::getReason)
        : OptionalValue.empty();
  }

  /** Return true if this FallbackMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FallbackMessageImpl fallbackMessageField = (FallbackMessageImpl) o;
    return Objects.equals(this.fallbackMessage, fallbackMessageField.fallbackMessage);
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
    OptionalValue<FallbackMessageInternal> fallbackMessage = OptionalValue.empty();

    FallbackMessageInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_FALLBACK_MESSAGE, required = true)
    public Builder setFallbackMessage(FallbackMessageInternal fallbackMessage) {
      this.fallbackMessage = OptionalValue.of(fallbackMessage);
      return this;
    }

    @JsonIgnore
    public Builder setRawMessage(String rawMessage) {
      getDelegatedBuilder().setRawMessage(rawMessage);
      return this;
    }

    @JsonIgnore
    public Builder setReason(Reason reason) {
      getDelegatedBuilder().setReason(reason);
      return this;
    }

    private FallbackMessageInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = FallbackMessageInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public FallbackMessage build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.fallbackMessage = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new FallbackMessageImpl(fallbackMessage);
    }
  }
}
