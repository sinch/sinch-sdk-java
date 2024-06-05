package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  FlashCallRequestEventResponseImpl.JSON_PROPERTY_ACTION,
  FlashCallRequestEventResponseImpl.JSON_PROPERTY_FLASH_CALL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class FlashCallRequestEventResponseImpl implements FlashCallRequestEventResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ACTION = "action";

  private OptionalValue<VerificationEventResponseAction> action;

  public static final String JSON_PROPERTY_FLASH_CALL = "flashCall";

  private OptionalValue<FlashCallRequestEventResponseFlashCallContent> flashCall;

  public FlashCallRequestEventResponseImpl() {}

  protected FlashCallRequestEventResponseImpl(
      OptionalValue<VerificationEventResponseAction> action,
      OptionalValue<FlashCallRequestEventResponseFlashCallContent> flashCall) {
    this.action = action;
    this.flashCall = flashCall;
  }

  @JsonIgnore
  public VerificationEventResponseAction getAction() {
    return action.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationEventResponseAction> action() {
    return action;
  }

  @JsonIgnore
  public FlashCallRequestEventResponseFlashCallContent getFlashCall() {
    return flashCall.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLASH_CALL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<FlashCallRequestEventResponseFlashCallContent> flashCall() {
    return flashCall;
  }

  /** Return true if this FlashCallRequestEventResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlashCallRequestEventResponseImpl flashCallRequestEventResponse =
        (FlashCallRequestEventResponseImpl) o;
    return Objects.equals(this.action, flashCallRequestEventResponse.action)
        && Objects.equals(this.flashCall, flashCallRequestEventResponse.flashCall);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, flashCall);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlashCallRequestEventResponseImpl {\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    flashCall: ").append(toIndentedString(flashCall)).append("\n");
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
  static class Builder implements FlashCallRequestEventResponse.Builder {
    OptionalValue<VerificationEventResponseAction> action = OptionalValue.empty();
    OptionalValue<FlashCallRequestEventResponseFlashCallContent> flashCall = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ACTION)
    public Builder setAction(VerificationEventResponseAction action) {
      this.action = OptionalValue.of(action);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FLASH_CALL)
    public Builder setFlashCall(FlashCallRequestEventResponseFlashCallContent flashCall) {
      this.flashCall = OptionalValue.of(flashCall);
      return this;
    }

    public FlashCallRequestEventResponse build() {
      return new FlashCallRequestEventResponseImpl(action, flashCall);
    }
  }
}
