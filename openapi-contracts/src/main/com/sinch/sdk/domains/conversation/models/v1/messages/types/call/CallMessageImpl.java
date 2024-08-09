package com.sinch.sdk.domains.conversation.models.v1.messages.types.call;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.CallMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.CallMessageInternalImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({CallMessageImpl.JSON_PROPERTY_CALL_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CallMessageImpl
    implements CallMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessageType {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CALL_MESSAGE = "call_message";

  private OptionalValue<CallMessageInternal> callMessage;

  public CallMessageImpl() {}

  protected CallMessageImpl(OptionalValue<CallMessageInternal> callMessage) {
    this.callMessage = callMessage;
  }

  @JsonIgnore
  public CallMessageInternal getCallMessage() {
    return callMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CallMessageInternal> callMessage() {
    return callMessage;
  }

  @JsonIgnore
  public String getPhoneNumber() {
    if (null == callMessage
        || !callMessage.isPresent()
        || null == callMessage.get().getPhoneNumber()) {
      return null;
    }
    return callMessage.get().getPhoneNumber();
  }

  public OptionalValue<String> phoneNumber() {
    return null != callMessage && callMessage.isPresent()
        ? callMessage
            .map(f -> ((CallMessageInternalImpl) f).phoneNumber())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getTitle() {
    if (null == callMessage || !callMessage.isPresent() || null == callMessage.get().getTitle()) {
      return null;
    }
    return callMessage.get().getTitle();
  }

  public OptionalValue<String> title() {
    return null != callMessage && callMessage.isPresent()
        ? callMessage.map(f -> ((CallMessageInternalImpl) f).title()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
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
    CallMessageImpl callMessageField = (CallMessageImpl) o;
    return Objects.equals(this.callMessage, callMessageField.callMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallMessageImpl {\n");
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
  static class Builder implements CallMessage.Builder {
    OptionalValue<CallMessageInternal> callMessage = OptionalValue.empty();

    CallMessageInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_CALL_MESSAGE, required = true)
    public Builder setCallMessage(CallMessageInternal callMessage) {
      this.callMessage = OptionalValue.of(callMessage);
      return this;
    }

    @JsonIgnore
    public Builder setPhoneNumber(String phoneNumber) {
      getDelegatedBuilder().setPhoneNumber(phoneNumber);
      return this;
    }

    @JsonIgnore
    public Builder setTitle(String title) {
      getDelegatedBuilder().setTitle(title);
      return this;
    }

    private CallMessageInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = CallMessageInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public CallMessage build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.callMessage = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new CallMessageImpl(callMessage);
    }
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<CallMessage>> {
    @Override
    public void serialize(
        OptionalValue<CallMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      CallMessageImpl impl = (CallMessageImpl) value.get();
      jgen.writeObject(impl.getCallMessage());
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<CallMessage> {
    @Override
    public CallMessage deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

      CallMessageImpl.Builder builder = new CallMessageImpl.Builder();
      CallMessageInternalImpl deserialized = jp.readValueAs(CallMessageInternalImpl.class);
      builder.setCallMessage(deserialized);
      return builder.build();
    }
  }

  public static Optional<CallMessage> delegatedConverter(CallMessageInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setCallMessage(internal).build());
  }
}
