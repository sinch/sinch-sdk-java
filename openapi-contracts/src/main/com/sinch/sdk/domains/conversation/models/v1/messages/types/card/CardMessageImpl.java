package com.sinch.sdk.domains.conversation.models.v1.messages.types.card;

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
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.Choice;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.CardMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.CardMessageInternalImpl;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({CardMessageImpl.JSON_PROPERTY_CARD_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CardMessageImpl
    implements CardMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride,
        com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageBody {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CARD_MESSAGE = "card_message";

  private OptionalValue<CardMessageInternal> cardMessage;

  public CardMessageImpl() {}

  protected CardMessageImpl(OptionalValue<CardMessageInternal> cardMessage) {
    this.cardMessage = cardMessage;
  }

  @JsonIgnore
  public CardMessageInternal getCardMessage() {
    return cardMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CARD_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CardMessageInternal> cardMessage() {
    return cardMessage;
  }

  @JsonIgnore
  public List<Choice<?>> getChoices() {
    if (null == cardMessage || !cardMessage.isPresent() || null == cardMessage.get().getChoices()) {
      return null;
    }
    return cardMessage.get().getChoices();
  }

  public OptionalValue<List<Choice<?>>> choices() {
    return null != cardMessage && cardMessage.isPresent()
        ? cardMessage
            .map(f -> ((CardMessageInternalImpl) f).choices())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getDescription() {
    if (null == cardMessage
        || !cardMessage.isPresent()
        || null == cardMessage.get().getDescription()) {
      return null;
    }
    return cardMessage.get().getDescription();
  }

  public OptionalValue<String> description() {
    return null != cardMessage && cardMessage.isPresent()
        ? cardMessage
            .map(f -> ((CardMessageInternalImpl) f).description())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public CardHeight getHeight() {
    if (null == cardMessage || !cardMessage.isPresent() || null == cardMessage.get().getHeight()) {
      return null;
    }
    return cardMessage.get().getHeight();
  }

  public OptionalValue<CardHeight> height() {
    return null != cardMessage && cardMessage.isPresent()
        ? cardMessage.map(f -> ((CardMessageInternalImpl) f).height()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public MediaMessageBody getMedia() {
    if (null == cardMessage || !cardMessage.isPresent() || null == cardMessage.get().getMedia()) {
      return null;
    }
    return cardMessage.get().getMedia();
  }

  public OptionalValue<MediaMessageBody> media() {
    return null != cardMessage && cardMessage.isPresent()
        ? cardMessage.map(f -> ((CardMessageInternalImpl) f).media()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getTitle() {
    if (null == cardMessage || !cardMessage.isPresent() || null == cardMessage.get().getTitle()) {
      return null;
    }
    return cardMessage.get().getTitle();
  }

  public OptionalValue<String> title() {
    return null != cardMessage && cardMessage.isPresent()
        ? cardMessage.map(f -> ((CardMessageInternalImpl) f).title()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this CardMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardMessageImpl cardMessageField = (CardMessageImpl) o;
    return Objects.equals(this.cardMessage, cardMessageField.cardMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardMessageImpl {\n");
    sb.append("    cardMessage: ").append(toIndentedString(cardMessage)).append("\n");
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
  static class Builder implements CardMessage.Builder {
    OptionalValue<CardMessageInternal> cardMessage = OptionalValue.empty();

    CardMessageInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_CARD_MESSAGE, required = true)
    public Builder setCardMessage(CardMessageInternal cardMessage) {
      this.cardMessage = OptionalValue.of(cardMessage);
      return this;
    }

    @JsonIgnore
    public Builder setChoices(List<Choice<?>> choices) {
      getDelegatedBuilder().setChoices(choices);
      return this;
    }

    @JsonIgnore
    public Builder setDescription(String description) {
      getDelegatedBuilder().setDescription(description);
      return this;
    }

    @JsonIgnore
    public Builder setHeight(CardHeight height) {
      getDelegatedBuilder().setHeight(height);
      return this;
    }

    @JsonIgnore
    public Builder setMedia(MediaMessageBody media) {
      getDelegatedBuilder().setMedia(media);
      return this;
    }

    @JsonIgnore
    public Builder setTitle(String title) {
      getDelegatedBuilder().setTitle(title);
      return this;
    }

    private CardMessageInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = CardMessageInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public CardMessage build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.cardMessage = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new CardMessageImpl(cardMessage);
    }
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<CardMessage>> {
    @Override
    public void serialize(
        OptionalValue<CardMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      CardMessageImpl impl = (CardMessageImpl) value.get();
      jgen.writeObject(null != impl ? impl.getCardMessage() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<CardMessage> {
    @Override
    public CardMessage deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

      CardMessageImpl.Builder builder = new CardMessageImpl.Builder();
      CardMessageInternalImpl deserialized = jp.readValueAs(CardMessageInternalImpl.class);
      builder.setCardMessage(deserialized);
      return builder.build();
    }
  }

  public static Optional<CardMessage> delegatedConverter(CardMessageInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setCardMessage(internal).build());
  }
}
