package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.ReplyToMessage;
import java.util.Objects;

@JsonPropertyOrder({ReplyToMessageFieldInternalImpl.JSON_PROPERTY_REPLY_TO})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ReplyToMessageFieldInternalImpl implements ReplyToMessageFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_REPLY_TO = "reply_to";

  private OptionalValue<ReplyToMessage> replyTo;

  public ReplyToMessageFieldInternalImpl() {}

  protected ReplyToMessageFieldInternalImpl(OptionalValue<ReplyToMessage> replyTo) {
    this.replyTo = replyTo;
  }

  @JsonIgnore
  public ReplyToMessage getReplyTo() {
    return replyTo.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REPLY_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ReplyToMessage> replyTo() {
    return replyTo;
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
    ReplyToMessageFieldInternalImpl replyToMessageField = (ReplyToMessageFieldInternalImpl) o;
    return Objects.equals(this.replyTo, replyToMessageField.replyTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(replyTo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReplyToMessageFieldInternalImpl {\n");
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
  static class Builder implements ReplyToMessageFieldInternal.Builder {
    OptionalValue<ReplyToMessage> replyTo = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_REPLY_TO)
    public Builder setReplyTo(ReplyToMessage replyTo) {
      this.replyTo = OptionalValue.of(replyTo);
      return this;
    }

    public ReplyToMessageFieldInternal build() {
      return new ReplyToMessageFieldInternalImpl(replyTo);
    }
  }
}
