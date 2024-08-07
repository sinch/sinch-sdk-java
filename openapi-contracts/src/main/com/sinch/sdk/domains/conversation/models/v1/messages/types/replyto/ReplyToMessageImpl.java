package com.sinch.sdk.domains.conversation.models.v1.messages.types.replyto;

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
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ReplyToMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ReplyToMessageInternalImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

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
    return null != replyTo && replyTo.isPresent()
        ? replyTo
            .map(f -> ((ReplyToMessageInternalImpl) f).messageId())
            .orElse(OptionalValue.empty())
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

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<ReplyToMessage>> {
    @Override
    public void serialize(
        OptionalValue<ReplyToMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      ReplyToMessageImpl impl = (ReplyToMessageImpl) value.get();
      jgen.writeObject(impl.getReplyTo());
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<ReplyToMessage> {
    @Override
    public ReplyToMessage deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      ReplyToMessageImpl.Builder builder = new ReplyToMessageImpl.Builder();
      ReplyToMessageInternalImpl deserialized = jp.readValueAs(ReplyToMessageInternalImpl.class);
      builder.setReplyTo(deserialized);
      return builder.build();
    }
  }

  public static Optional<ReplyToMessage> delegatedConverter(ReplyToMessageInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setReplyTo(internal).build());
  }
}
