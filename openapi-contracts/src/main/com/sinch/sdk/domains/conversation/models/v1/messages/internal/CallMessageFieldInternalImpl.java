package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.CallMessage;
import java.util.Objects;

@JsonPropertyOrder({CallMessageFieldInternalImpl.JSON_PROPERTY_CALL_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CallMessageFieldInternalImpl implements CallMessageFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CALL_MESSAGE = "call_message";

  private OptionalValue<CallMessage> callMessage;

  public CallMessageFieldInternalImpl() {}

  protected CallMessageFieldInternalImpl(OptionalValue<CallMessage> callMessage) {
    this.callMessage = callMessage;
  }

  @JsonIgnore
  public CallMessage getCallMessage() {
    return callMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CallMessage> callMessage() {
    return callMessage;
  }

  /** Return true if this CallMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallMessageFieldInternalImpl callMessageField = (CallMessageFieldInternalImpl) o;
    return Objects.equals(this.callMessage, callMessageField.callMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallMessageFieldInternalImpl {\n");
    sb.append("    callMessage: ").append(toIndentedString(callMessage)).append("\n");
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
  static class Builder implements CallMessageFieldInternal.Builder {
    OptionalValue<CallMessage> callMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CALL_MESSAGE)
    public Builder setCallMessage(CallMessage callMessage) {
      this.callMessage = OptionalValue.of(callMessage);
      return this;
    }

    public CallMessageFieldInternal build() {
      return new CallMessageFieldInternalImpl(callMessage);
    }
  }
}
