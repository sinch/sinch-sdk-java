package com.sinch.sdk.domains.conversation.models.v1.messages.types.choiceresponse;

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
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ChoiceResponseMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ChoiceResponseMessageInternalImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({ChoiceResponseMessageImpl.JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChoiceResponseMessageImpl
    implements ChoiceResponseMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE = "choice_response_message";

  private OptionalValue<ChoiceResponseMessageInternal> choiceResponseMessage;

  public ChoiceResponseMessageImpl() {}

  protected ChoiceResponseMessageImpl(
      OptionalValue<ChoiceResponseMessageInternal> choiceResponseMessage) {
    this.choiceResponseMessage = choiceResponseMessage;
  }

  @JsonIgnore
  public ChoiceResponseMessageInternal getChoiceResponseMessage() {
    return choiceResponseMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChoiceResponseMessageInternal> choiceResponseMessage() {
    return choiceResponseMessage;
  }

  @JsonIgnore
  public String getMessageId() {
    if (null == choiceResponseMessage
        || !choiceResponseMessage.isPresent()
        || null == choiceResponseMessage.get().getMessageId()) {
      return null;
    }
    return choiceResponseMessage.get().getMessageId();
  }

  public OptionalValue<String> messageId() {
    return null != choiceResponseMessage && choiceResponseMessage.isPresent()
        ? choiceResponseMessage
            .map(f -> ((ChoiceResponseMessageInternalImpl) f).messageId())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getPostbackData() {
    if (null == choiceResponseMessage
        || !choiceResponseMessage.isPresent()
        || null == choiceResponseMessage.get().getPostbackData()) {
      return null;
    }
    return choiceResponseMessage.get().getPostbackData();
  }

  public OptionalValue<String> postbackData() {
    return null != choiceResponseMessage && choiceResponseMessage.isPresent()
        ? choiceResponseMessage
            .map(f -> ((ChoiceResponseMessageInternalImpl) f).postbackData())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this ChoiceResponseMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoiceResponseMessageImpl choiceResponseMessageField = (ChoiceResponseMessageImpl) o;
    return Objects.equals(
        this.choiceResponseMessage, choiceResponseMessageField.choiceResponseMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(choiceResponseMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoiceResponseMessageImpl {\n");
    sb.append("    choiceResponseMessage: ")
        .append(toIndentedString(choiceResponseMessage))
        .append("\n");
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
  static class Builder implements ChoiceResponseMessage.Builder {
    OptionalValue<ChoiceResponseMessageInternal> choiceResponseMessage = OptionalValue.empty();

    ChoiceResponseMessageInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE, required = true)
    public Builder setChoiceResponseMessage(ChoiceResponseMessageInternal choiceResponseMessage) {
      this.choiceResponseMessage = OptionalValue.of(choiceResponseMessage);
      return this;
    }

    @JsonIgnore
    public Builder setMessageId(String messageId) {
      getDelegatedBuilder().setMessageId(messageId);
      return this;
    }

    @JsonIgnore
    public Builder setPostbackData(String postbackData) {
      getDelegatedBuilder().setPostbackData(postbackData);
      return this;
    }

    private ChoiceResponseMessageInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = ChoiceResponseMessageInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public ChoiceResponseMessage build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.choiceResponseMessage = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new ChoiceResponseMessageImpl(choiceResponseMessage);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<ChoiceResponseMessage>> {
    @Override
    public void serialize(
        OptionalValue<ChoiceResponseMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      ChoiceResponseMessageImpl impl = (ChoiceResponseMessageImpl) value.get();
      jgen.writeObject(impl.getChoiceResponseMessage());
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<ChoiceResponseMessage> {
    @Override
    public ChoiceResponseMessage deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      ChoiceResponseMessageImpl.Builder builder = new ChoiceResponseMessageImpl.Builder();
      ChoiceResponseMessageInternalImpl deserialized =
          jp.readValueAs(ChoiceResponseMessageInternalImpl.class);
      builder.setChoiceResponseMessage(deserialized);
      return builder.build();
    }
  }

  public static Optional<ChoiceResponseMessage> delegatedConverter(
      ChoiceResponseMessageInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setChoiceResponseMessage(internal).build());
  }
}
