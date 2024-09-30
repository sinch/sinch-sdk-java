package com.sinch.sdk.domains.conversation.models.v1.events.types;

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
import com.sinch.sdk.domains.conversation.models.v1.events.types.internal.ReactionEventInternal;
import com.sinch.sdk.domains.conversation.models.v1.events.types.internal.ReactionEventInternalImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({ReactionEventImpl.JSON_PROPERTY_REACTION_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ReactionEventImpl
    implements ReactionEvent,
        com.sinch.sdk.domains.conversation.models.v1.events.ContactMessageEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_REACTION_EVENT = "reaction_event";

  private OptionalValue<ReactionEventInternal> reactionEvent;

  public ReactionEventImpl() {}

  protected ReactionEventImpl(OptionalValue<ReactionEventInternal> reactionEvent) {
    this.reactionEvent = reactionEvent;
  }

  @JsonIgnore
  public ReactionEventInternal getReactionEvent() {
    return reactionEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REACTION_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ReactionEventInternal> reactionEvent() {
    return reactionEvent;
  }

  @JsonIgnore
  public String getEmoji() {
    if (null == reactionEvent
        || !reactionEvent.isPresent()
        || null == reactionEvent.get().getEmoji()) {
      return null;
    }
    return reactionEvent.get().getEmoji();
  }

  public OptionalValue<String> emoji() {
    return null != reactionEvent && reactionEvent.isPresent()
        ? reactionEvent
            .map(f -> ((ReactionEventInternalImpl) f).emoji())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public ReactionAction getAction() {
    if (null == reactionEvent
        || !reactionEvent.isPresent()
        || null == reactionEvent.get().getAction()) {
      return null;
    }
    return reactionEvent.get().getAction();
  }

  public OptionalValue<ReactionAction> action() {
    return null != reactionEvent && reactionEvent.isPresent()
        ? reactionEvent
            .map(f -> ((ReactionEventInternalImpl) f).action())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getMessageId() {
    if (null == reactionEvent
        || !reactionEvent.isPresent()
        || null == reactionEvent.get().getMessageId()) {
      return null;
    }
    return reactionEvent.get().getMessageId();
  }

  public OptionalValue<String> messageId() {
    return null != reactionEvent && reactionEvent.isPresent()
        ? reactionEvent
            .map(f -> ((ReactionEventInternalImpl) f).messageId())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getReactionCategory() {
    if (null == reactionEvent
        || !reactionEvent.isPresent()
        || null == reactionEvent.get().getReactionCategory()) {
      return null;
    }
    return reactionEvent.get().getReactionCategory();
  }

  public OptionalValue<String> reactionCategory() {
    return null != reactionEvent && reactionEvent.isPresent()
        ? reactionEvent
            .map(f -> ((ReactionEventInternalImpl) f).reactionCategory())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this Reaction object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReactionEventImpl reaction = (ReactionEventImpl) o;
    return Objects.equals(this.reactionEvent, reaction.reactionEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reactionEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReactionEventImpl {\n");
    sb.append("    reactionEvent: ").append(toIndentedString(reactionEvent)).append("\n");
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
  static class Builder implements ReactionEvent.Builder {
    OptionalValue<ReactionEventInternal> reactionEvent = OptionalValue.empty();

    ReactionEventInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_REACTION_EVENT, required = true)
    public Builder setReactionEvent(ReactionEventInternal reactionEvent) {
      this.reactionEvent = OptionalValue.of(reactionEvent);
      return this;
    }

    @JsonIgnore
    public Builder setEmoji(String emoji) {
      getDelegatedBuilder().setEmoji(emoji);
      return this;
    }

    @JsonIgnore
    public Builder setAction(ReactionAction action) {
      getDelegatedBuilder().setAction(action);
      return this;
    }

    @JsonIgnore
    public Builder setMessageId(String messageId) {
      getDelegatedBuilder().setMessageId(messageId);
      return this;
    }

    @JsonIgnore
    public Builder setReactionCategory(String reactionCategory) {
      getDelegatedBuilder().setReactionCategory(reactionCategory);
      return this;
    }

    private ReactionEventInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = ReactionEventInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public ReactionEvent build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.reactionEvent = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new ReactionEventImpl(reactionEvent);
    }
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<ReactionEvent>> {
    @Override
    public void serialize(
        OptionalValue<ReactionEvent> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      ReactionEventImpl impl = (ReactionEventImpl) value.get();
      jgen.writeObject(null != impl ? impl.getReactionEvent() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<ReactionEvent> {
    @Override
    public ReactionEvent deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      ReactionEventImpl.Builder builder = new ReactionEventImpl.Builder();
      ReactionEventInternalImpl deserialized = jp.readValueAs(ReactionEventInternalImpl.class);
      builder.setReactionEvent(deserialized);
      return builder.build();
    }
  }

  public static Optional<ReactionEvent> delegatedConverter(ReactionEventInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setReactionEvent(internal).build());
  }
}
