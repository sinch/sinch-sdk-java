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
import com.sinch.sdk.domains.conversation.models.v1.events.types.internal.CommentEventInternal;
import com.sinch.sdk.domains.conversation.models.v1.events.types.internal.CommentEventInternalImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({CommentEventImpl.JSON_PROPERTY_COMMENT_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CommentEventImpl
    implements CommentEvent, com.sinch.sdk.domains.conversation.models.v1.events.ContactEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COMMENT_EVENT = "comment_event";

  private OptionalValue<CommentEventInternal> commentEvent;

  public CommentEventImpl() {}

  protected CommentEventImpl(OptionalValue<CommentEventInternal> commentEvent) {
    this.commentEvent = commentEvent;
  }

  @JsonIgnore
  public CommentEventInternal getCommentEvent() {
    return commentEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COMMENT_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CommentEventInternal> commentEvent() {
    return commentEvent;
  }

  @JsonIgnore
  public String getId() {
    if (null == commentEvent || !commentEvent.isPresent() || null == commentEvent.get().getId()) {
      return null;
    }
    return commentEvent.get().getId();
  }

  public OptionalValue<String> id() {
    return null != commentEvent && commentEvent.isPresent()
        ? commentEvent.map(f -> ((CommentEventInternalImpl) f).id()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getText() {
    if (null == commentEvent || !commentEvent.isPresent() || null == commentEvent.get().getText()) {
      return null;
    }
    return commentEvent.get().getText();
  }

  public OptionalValue<String> text() {
    return null != commentEvent && commentEvent.isPresent()
        ? commentEvent.map(f -> ((CommentEventInternalImpl) f).text()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public CommentTypeEnum getCommentType() {
    if (null == commentEvent
        || !commentEvent.isPresent()
        || null == commentEvent.get().getCommentType()) {
      return null;
    }
    return CommentTypeEnum.from(commentEvent.get().getCommentType().value());
  }

  public OptionalValue<CommentTypeEnum> commentType() {
    return null != commentEvent && commentEvent.isPresent()
        ? commentEvent.map(f -> CommentTypeEnum.from(commentEvent.get().getCommentType().value()))
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getCommentedOn() {
    if (null == commentEvent
        || !commentEvent.isPresent()
        || null == commentEvent.get().getCommentedOn()) {
      return null;
    }
    return commentEvent.get().getCommentedOn();
  }

  public OptionalValue<String> commentedOn() {
    return null != commentEvent && commentEvent.isPresent()
        ? commentEvent
            .map(f -> ((CommentEventInternalImpl) f).commentedOn())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getUser() {
    if (null == commentEvent || !commentEvent.isPresent() || null == commentEvent.get().getUser()) {
      return null;
    }
    return commentEvent.get().getUser();
  }

  public OptionalValue<String> user() {
    return null != commentEvent && commentEvent.isPresent()
        ? commentEvent.map(f -> ((CommentEventInternalImpl) f).user()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this CommentEventField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommentEventImpl commentEventField = (CommentEventImpl) o;
    return Objects.equals(this.commentEvent, commentEventField.commentEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commentEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentEventImpl {\n");
    sb.append("    commentEvent: ").append(toIndentedString(commentEvent)).append("\n");
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
  static class Builder implements CommentEvent.Builder {
    OptionalValue<CommentEventInternal> commentEvent = OptionalValue.empty();

    CommentEventInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_COMMENT_EVENT, required = true)
    public Builder setCommentEvent(CommentEventInternal commentEvent) {
      this.commentEvent = OptionalValue.of(commentEvent);
      return this;
    }

    @JsonIgnore
    public Builder setId(String id) {
      getDelegatedBuilder().setId(id);
      return this;
    }

    @JsonIgnore
    public Builder setText(String text) {
      getDelegatedBuilder().setText(text);
      return this;
    }

    @JsonIgnore
    public Builder setCommentType(CommentTypeEnum commentType) {
      getDelegatedBuilder()
          .setCommentType(
              null != commentType
                  ? CommentEventInternalImpl.CommentTypeEnum.from(commentType.value())
                  : null);
      return this;
    }

    @JsonIgnore
    public Builder setCommentedOn(String commentedOn) {
      getDelegatedBuilder().setCommentedOn(commentedOn);
      return this;
    }

    @JsonIgnore
    public Builder setUser(String user) {
      getDelegatedBuilder().setUser(user);
      return this;
    }

    private CommentEventInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = CommentEventInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public CommentEvent build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.commentEvent = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new CommentEventImpl(commentEvent);
    }
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<CommentEvent>> {
    @Override
    public void serialize(
        OptionalValue<CommentEvent> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      CommentEventImpl impl = (CommentEventImpl) value.get();
      jgen.writeObject(impl.getCommentEvent());
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<CommentEvent> {
    @Override
    public CommentEvent deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

      CommentEventImpl.Builder builder = new CommentEventImpl.Builder();
      CommentEventInternalImpl deserialized = jp.readValueAs(CommentEventInternalImpl.class);
      builder.setCommentEvent(deserialized);
      return builder.build();
    }
  }

  public static Optional<CommentEvent> delegatedConverter(CommentEventInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setCommentEvent(internal).build());
  }
}
