package com.sinch.sdk.domains.conversation.models.v1.events.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ReactionAction;
import java.util.Objects;

@JsonPropertyOrder({
  ReactionEventInternalImpl.JSON_PROPERTY_EMOJI,
  ReactionEventInternalImpl.JSON_PROPERTY_ACTION,
  ReactionEventInternalImpl.JSON_PROPERTY_MESSAGE_ID,
  ReactionEventInternalImpl.JSON_PROPERTY_REACTION_CATEGORY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ReactionEventInternalImpl implements ReactionEventInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_EMOJI = "emoji";

  private OptionalValue<String> emoji;

  public static final String JSON_PROPERTY_ACTION = "action";

  private OptionalValue<ReactionAction> action;

  public static final String JSON_PROPERTY_MESSAGE_ID = "message_id";

  private OptionalValue<String> messageId;

  public static final String JSON_PROPERTY_REACTION_CATEGORY = "reaction_category";

  private OptionalValue<String> reactionCategory;

  public ReactionEventInternalImpl() {}

  protected ReactionEventInternalImpl(
      OptionalValue<String> emoji,
      OptionalValue<ReactionAction> action,
      OptionalValue<String> messageId,
      OptionalValue<String> reactionCategory) {
    this.emoji = emoji;
    this.action = action;
    this.messageId = messageId;
    this.reactionCategory = reactionCategory;
  }

  @JsonIgnore
  public String getEmoji() {
    return emoji.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EMOJI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> emoji() {
    return emoji;
  }

  @JsonIgnore
  public ReactionAction getAction() {
    return action.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ReactionAction> action() {
    return action;
  }

  @JsonIgnore
  public String getMessageId() {
    return messageId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> messageId() {
    return messageId;
  }

  @JsonIgnore
  public String getReactionCategory() {
    return reactionCategory.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REACTION_CATEGORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> reactionCategory() {
    return reactionCategory;
  }

  /** Return true if this ReactionEvent object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReactionEventInternalImpl reactionEvent = (ReactionEventInternalImpl) o;
    return Objects.equals(this.emoji, reactionEvent.emoji)
        && Objects.equals(this.action, reactionEvent.action)
        && Objects.equals(this.messageId, reactionEvent.messageId)
        && Objects.equals(this.reactionCategory, reactionEvent.reactionCategory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emoji, action, messageId, reactionCategory);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReactionEventInternalImpl {\n");
    sb.append("    emoji: ").append(toIndentedString(emoji)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
    sb.append("    reactionCategory: ").append(toIndentedString(reactionCategory)).append("\n");
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
  static class Builder implements ReactionEventInternal.Builder {
    OptionalValue<String> emoji = OptionalValue.empty();
    OptionalValue<ReactionAction> action = OptionalValue.empty();
    OptionalValue<String> messageId = OptionalValue.empty();
    OptionalValue<String> reactionCategory = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_EMOJI, required = true)
    public Builder setEmoji(String emoji) {
      this.emoji = OptionalValue.of(emoji);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_ACTION, required = true)
    public Builder setAction(ReactionAction action) {
      this.action = OptionalValue.of(action);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_MESSAGE_ID, required = true)
    public Builder setMessageId(String messageId) {
      this.messageId = OptionalValue.of(messageId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REACTION_CATEGORY)
    public Builder setReactionCategory(String reactionCategory) {
      this.reactionCategory = OptionalValue.of(reactionCategory);
      return this;
    }

    public ReactionEventInternal build() {
      return new ReactionEventInternalImpl(emoji, action, messageId, reactionCategory);
    }
  }
}
