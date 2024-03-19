package com.sinch.sdk.domains.conversation.models.v1.messages.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ReplyToImpl.JSON_PROPERTY_REPLY_TO})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ReplyToImpl implements ReplyTo {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_REPLY_TO = "reply_to";

  private OptionalValue<ReplyToReplyTo> replyTo;

  public ReplyToImpl() {}

  protected ReplyToImpl(OptionalValue<ReplyToReplyTo> replyTo) {
    this.replyTo = replyTo;
  }

  @JsonIgnore
  public ReplyToReplyTo getReplyTo() {
    return replyTo.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REPLY_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ReplyToReplyTo> replyTo() {
    return replyTo;
  }

  /** Return true if this ReplyTo object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReplyToImpl replyTo = (ReplyToImpl) o;
    return Objects.equals(this.replyTo, replyTo.replyTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(replyTo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReplyToImpl {\n");
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
  static class Builder implements ReplyTo.Builder {
    OptionalValue<ReplyToReplyTo> replyTo = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_REPLY_TO)
    public Builder setReplyTo(ReplyToReplyTo replyTo) {
      this.replyTo = OptionalValue.of(replyTo);
      return this;
    }

    public ReplyTo build() {
      return new ReplyToImpl(replyTo);
    }
  }
}
