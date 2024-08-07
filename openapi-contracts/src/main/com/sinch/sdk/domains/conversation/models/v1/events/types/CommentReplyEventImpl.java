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
import com.sinch.sdk.domains.conversation.models.v1.events.types.internal.CommentReplyEventInternal;
import com.sinch.sdk.domains.conversation.models.v1.events.types.internal.CommentReplyEventInternalImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({CommentReplyEventImpl.JSON_PROPERTY_COMMENT_REPLY_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CommentReplyEventImpl
    implements CommentReplyEvent, com.sinch.sdk.domains.conversation.models.v1.events.AppEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COMMENT_REPLY_EVENT = "comment_reply_event";

  private OptionalValue<CommentReplyEventInternal> commentReplyEvent;

  public CommentReplyEventImpl() {}

  protected CommentReplyEventImpl(OptionalValue<CommentReplyEventInternal> commentReplyEvent) {
    this.commentReplyEvent = commentReplyEvent;
  }

  @JsonIgnore
  public CommentReplyEventInternal getCommentReplyEvent() {
    return commentReplyEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COMMENT_REPLY_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CommentReplyEventInternal> commentReplyEvent() {
    return commentReplyEvent;
  }

  @JsonIgnore
  public String getText() {
    if (null == commentReplyEvent
        || !commentReplyEvent.isPresent()
        || null == commentReplyEvent.get().getText()) {
      return null;
    }
    return commentReplyEvent.get().getText();
  }

  public OptionalValue<String> text() {
    return null != commentReplyEvent && commentReplyEvent.isPresent()
        ? commentReplyEvent
            .map(f -> ((CommentReplyEventInternalImpl) f).text())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this CommentReplyEventField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommentReplyEventImpl commentReplyEventField = (CommentReplyEventImpl) o;
    return Objects.equals(this.commentReplyEvent, commentReplyEventField.commentReplyEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commentReplyEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentReplyEventImpl {\n");
    sb.append("    commentReplyEvent: ").append(toIndentedString(commentReplyEvent)).append("\n");
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
  static class Builder implements CommentReplyEvent.Builder {
    OptionalValue<CommentReplyEventInternal> commentReplyEvent = OptionalValue.empty();

    CommentReplyEventInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_COMMENT_REPLY_EVENT, required = true)
    public Builder setCommentReplyEvent(CommentReplyEventInternal commentReplyEvent) {
      this.commentReplyEvent = OptionalValue.of(commentReplyEvent);
      return this;
    }

    @JsonIgnore
    public Builder setText(String text) {
      getDelegatedBuilder().setText(text);
      return this;
    }

    private CommentReplyEventInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = CommentReplyEventInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public CommentReplyEvent build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.commentReplyEvent = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new CommentReplyEventImpl(commentReplyEvent);
    }
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<CommentReplyEvent>> {
    @Override
    public void serialize(
        OptionalValue<CommentReplyEvent> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      CommentReplyEventImpl impl = (CommentReplyEventImpl) value.get();
      jgen.writeObject(impl.getCommentReplyEvent());
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<CommentReplyEvent> {
    @Override
    public CommentReplyEvent deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      CommentReplyEventImpl.Builder builder = new CommentReplyEventImpl.Builder();
      CommentReplyEventInternalImpl deserialized =
          jp.readValueAs(CommentReplyEventInternalImpl.class);
      builder.setCommentReplyEvent(deserialized);
      return builder.build();
    }
  }

  public static Optional<CommentReplyEvent> delegatedConverter(CommentReplyEventInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setCommentReplyEvent(internal).build());
  }
}
