package com.sinch.sdk.domains.conversation.models.v1.messages.types.replyto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ReplyToMessageInternal;
import java.util.Objects;

@JsonPropertyOrder({ReplyToMessageImpl.JSON_PROPERTY_REPLY_TO})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ReplyToMessageImpl
    implements ReplyToMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_REPLY_TO = "reply_to";

  private OptionalValue<ReplyToMessageInternal> replyTo;

  public ReplyToMessageImpl() {}

  protected ReplyToMessageImpl(OptionalValue<ReplyToMessageInternal> replyTo) {
    this.replyTo = replyTo;
  }

  @JsonIgnore
  public ReplyToMessageInternal getReplyTo() {
    return replyTo.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REPLY_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ReplyToMessageInternal> replyTo() {
    return replyTo;
  }

  @JsonIgnore
  public String getMessageId() {
    if (null == replyTo || !replyTo.isPresent() || null == replyTo.get().getMessageId()) {
      return null;
    }
    return replyTo.get().getMessageId();
  }

  public OptionalValue<String> messageId() {
    return null != replyTo
        ? replyTo.map(ReplyToMessageInternal::getMessageId)
        : OptionalValue.empty();
  }

  /** Return true if this ReplyToMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReplyToMessageImpl replyToMessageField = (ReplyToMessageImpl) o;
    return Objects.equals(this.replyTo, replyToMessageField.replyTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(replyTo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReplyToMessageImpl {\n");
    sb.append("    replyTo: ").append(toIndentedString(replyTo)).append("\n");
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
  static class Builder implements ReplyToMessage.Builder {
    OptionalValue<ReplyToMessageInternal> replyTo = OptionalValue.empty();

    ReplyToMessageInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_REPLY_TO, required = true)
    public Builder setReplyTo(ReplyToMessageInternal replyTo) {
      this.replyTo = OptionalValue.of(replyTo);
      return this;
    }

    @JsonIgnore
    public Builder setMessageId(String messageId) {
      getDelegatedBuilder().setMessageId(messageId);
      return this;
    }

    private ReplyToMessageInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = ReplyToMessageInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public ReplyToMessage build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.replyTo = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new ReplyToMessageImpl(replyTo);
    }
  }
}
