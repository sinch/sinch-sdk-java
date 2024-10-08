package com.sinch.sdk.domains.conversation.models.v1.messages.types.text;

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
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.TextMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.TextMessageInternalImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({TextMessageImpl.JSON_PROPERTY_TEXT_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TextMessageImpl
    implements TextMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride,
        com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageBody,
        com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessageBody,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessageType {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEXT_MESSAGE = "text_message";

  private OptionalValue<TextMessageInternal> textMessage;

  public TextMessageImpl() {}

  protected TextMessageImpl(OptionalValue<TextMessageInternal> textMessage) {
    this.textMessage = textMessage;
  }

  @JsonIgnore
  public TextMessageInternal getTextMessage() {
    return textMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TextMessageInternal> textMessage() {
    return textMessage;
  }

  @JsonIgnore
  public String getText() {
    if (null == textMessage || !textMessage.isPresent() || null == textMessage.get().getText()) {
      return null;
    }
    return textMessage.get().getText();
  }

  public OptionalValue<String> text() {
    return null != textMessage && textMessage.isPresent()
        ? textMessage.map(f -> ((TextMessageInternalImpl) f).text()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this TextMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TextMessageImpl textMessageField = (TextMessageImpl) o;
    return Objects.equals(this.textMessage, textMessageField.textMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(textMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TextMessageImpl {\n");
    sb.append("    textMessage: ").append(toIndentedString(textMessage)).append("\n");
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
  static class Builder implements TextMessage.Builder {
    OptionalValue<TextMessageInternal> textMessage = OptionalValue.empty();

    TextMessageInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_TEXT_MESSAGE, required = true)
    public Builder setTextMessage(TextMessageInternal textMessage) {
      this.textMessage = OptionalValue.of(textMessage);
      return this;
    }

    @JsonIgnore
    public Builder setText(String text) {
      getDelegatedBuilder().setText(text);
      return this;
    }

    private TextMessageInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = TextMessageInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public TextMessage build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.textMessage = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new TextMessageImpl(textMessage);
    }
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<TextMessage>> {
    @Override
    public void serialize(
        OptionalValue<TextMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      TextMessageImpl impl = (TextMessageImpl) value.get();
      jgen.writeObject(null != impl ? impl.getTextMessage() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<TextMessage> {
    @Override
    public TextMessage deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

      TextMessageImpl.Builder builder = new TextMessageImpl.Builder();
      TextMessageInternalImpl deserialized = jp.readValueAs(TextMessageInternalImpl.class);
      builder.setTextMessage(deserialized);
      return builder.build();
    }
  }

  public static Optional<TextMessage> delegatedConverter(TextMessageInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setTextMessage(internal).build());
  }
}
