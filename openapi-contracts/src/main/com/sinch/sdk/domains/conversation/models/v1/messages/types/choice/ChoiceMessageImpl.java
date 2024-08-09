package com.sinch.sdk.domains.conversation.models.v1.messages.types.choice;

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
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.ChoiceMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.ChoiceMessageInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({ChoiceMessageImpl.JSON_PROPERTY_CHOICE_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChoiceMessageImpl
    implements ChoiceMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride,
        com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageBody {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHOICE_MESSAGE = "choice_message";

  private OptionalValue<ChoiceMessageInternal> choiceMessage;

  public ChoiceMessageImpl() {}

  protected ChoiceMessageImpl(OptionalValue<ChoiceMessageInternal> choiceMessage) {
    this.choiceMessage = choiceMessage;
  }

  @JsonIgnore
  public ChoiceMessageInternal getChoiceMessage() {
    return choiceMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHOICE_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChoiceMessageInternal> choiceMessage() {
    return choiceMessage;
  }

  @JsonIgnore
  public List<Choice<?>> getChoices() {
    if (null == choiceMessage
        || !choiceMessage.isPresent()
        || null == choiceMessage.get().getChoices()) {
      return null;
    }
    return choiceMessage.get().getChoices();
  }

  public OptionalValue<List<Choice<?>>> choices() {
    return null != choiceMessage && choiceMessage.isPresent()
        ? choiceMessage
            .map(f -> ((ChoiceMessageInternalImpl) f).choices())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public TextMessage getTextMessage() {
    if (null == choiceMessage
        || !choiceMessage.isPresent()
        || null == choiceMessage.get().getTextMessage()) {
      return null;
    }
    return choiceMessage.get().getTextMessage();
  }

  public OptionalValue<TextMessage> textMessage() {
    return null != choiceMessage && choiceMessage.isPresent()
        ? choiceMessage
            .map(f -> ((ChoiceMessageInternalImpl) f).textMessage())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this ChoiceMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoiceMessageImpl choiceMessageField = (ChoiceMessageImpl) o;
    return Objects.equals(this.choiceMessage, choiceMessageField.choiceMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(choiceMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoiceMessageImpl {\n");
    sb.append("    choiceMessage: ").append(toIndentedString(choiceMessage)).append("\n");
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
  static class Builder implements ChoiceMessage.Builder {
    OptionalValue<ChoiceMessageInternal> choiceMessage = OptionalValue.empty();

    ChoiceMessageInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_CHOICE_MESSAGE, required = true)
    public Builder setChoiceMessage(ChoiceMessageInternal choiceMessage) {
      this.choiceMessage = OptionalValue.of(choiceMessage);
      return this;
    }

    @JsonIgnore
    public Builder setChoices(List<Choice<?>> choices) {
      getDelegatedBuilder().setChoices(choices);
      return this;
    }

    @JsonIgnore
    public Builder setTextMessage(TextMessage textMessage) {
      getDelegatedBuilder().setTextMessage(textMessage);
      return this;
    }

    private ChoiceMessageInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = ChoiceMessageInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public ChoiceMessage build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.choiceMessage = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new ChoiceMessageImpl(choiceMessage);
    }
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<ChoiceMessage>> {
    @Override
    public void serialize(
        OptionalValue<ChoiceMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      ChoiceMessageImpl impl = (ChoiceMessageImpl) value.get();
      jgen.writeObject(impl.getChoiceMessage());
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<ChoiceMessage> {
    @Override
    public ChoiceMessage deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      ChoiceMessageImpl.Builder builder = new ChoiceMessageImpl.Builder();
      ChoiceMessageInternalImpl deserialized = jp.readValueAs(ChoiceMessageInternalImpl.class);
      builder.setChoiceMessage(deserialized);
      return builder.build();
    }
  }

  public static Optional<ChoiceMessage> delegatedConverter(ChoiceMessageInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setChoiceMessage(internal).build());
  }
}
