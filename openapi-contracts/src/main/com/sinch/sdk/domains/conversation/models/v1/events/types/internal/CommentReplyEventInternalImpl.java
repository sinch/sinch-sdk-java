package com.sinch.sdk.domains.conversation.models.v1.events.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({CommentReplyEventInternalImpl.JSON_PROPERTY_TEXT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CommentReplyEventInternalImpl implements CommentReplyEventInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEXT = "text";

  private OptionalValue<String> text;

  public CommentReplyEventInternalImpl() {}

  protected CommentReplyEventInternalImpl(OptionalValue<String> text) {
    this.text = text;
  }

  @JsonIgnore
  public String getText() {
    return text.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEXT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> text() {
    return text;
  }

  /** Return true if this Comment_Reply_Event object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommentReplyEventInternalImpl commentReplyEvent = (CommentReplyEventInternalImpl) o;
    return Objects.equals(this.text, commentReplyEvent.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentReplyEventInternalImpl {\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
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
  static class Builder implements CommentReplyEventInternal.Builder {
    OptionalValue<String> text = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TEXT, required = true)
    public Builder setText(String text) {
      this.text = OptionalValue.of(text);
      return this;
    }

    public CommentReplyEventInternal build() {
      return new CommentReplyEventInternalImpl(text);
    }
  }
}
