package com.sinch.sdk.domains.conversation.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  CommentEventImpl.JSON_PROPERTY_ID,
  CommentEventImpl.JSON_PROPERTY_TEXT,
  CommentEventImpl.JSON_PROPERTY_COMMENT_TYPE,
  CommentEventImpl.JSON_PROPERTY_COMMENTED_ON,
  CommentEventImpl.JSON_PROPERTY_USER
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CommentEventImpl implements CommentEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_TEXT = "text";

  private OptionalValue<String> text;

  public static final String JSON_PROPERTY_COMMENT_TYPE = "comment_type";

  private OptionalValue<CommentTypeEnum> commentType;

  public static final String JSON_PROPERTY_COMMENTED_ON = "commented_on";

  private OptionalValue<String> commentedOn;

  public static final String JSON_PROPERTY_USER = "user";

  private OptionalValue<String> user;

  public CommentEventImpl() {}

  protected CommentEventImpl(
      OptionalValue<String> id,
      OptionalValue<String> text,
      OptionalValue<CommentTypeEnum> commentType,
      OptionalValue<String> commentedOn,
      OptionalValue<String> user) {
    this.id = id;
    this.text = text;
    this.commentType = commentType;
    this.commentedOn = commentedOn;
    this.user = user;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> id() {
    return id;
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

  @JsonIgnore
  public CommentTypeEnum getCommentType() {
    return commentType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COMMENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CommentTypeEnum> commentType() {
    return commentType;
  }

  @JsonIgnore
  public String getCommentedOn() {
    return commentedOn.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COMMENTED_ON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> commentedOn() {
    return commentedOn;
  }

  @JsonIgnore
  public String getUser() {
    return user.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_USER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> user() {
    return user;
  }

  /** Return true if this CommentEvent object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommentEventImpl commentEvent = (CommentEventImpl) o;
    return Objects.equals(this.id, commentEvent.id)
        && Objects.equals(this.text, commentEvent.text)
        && Objects.equals(this.commentType, commentEvent.commentType)
        && Objects.equals(this.commentedOn, commentEvent.commentedOn)
        && Objects.equals(this.user, commentEvent.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, text, commentType, commentedOn, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentEventImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    commentType: ").append(toIndentedString(commentType)).append("\n");
    sb.append("    commentedOn: ").append(toIndentedString(commentedOn)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<String> text = OptionalValue.empty();
    OptionalValue<CommentTypeEnum> commentType = OptionalValue.empty();
    OptionalValue<String> commentedOn = OptionalValue.empty();
    OptionalValue<String> user = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEXT)
    public Builder setText(String text) {
      this.text = OptionalValue.of(text);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_COMMENT_TYPE)
    public Builder setCommentType(CommentTypeEnum commentType) {
      this.commentType = OptionalValue.of(commentType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_COMMENTED_ON)
    public Builder setCommentedOn(String commentedOn) {
      this.commentedOn = OptionalValue.of(commentedOn);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_USER)
    public Builder setUser(String user) {
      this.user = OptionalValue.of(user);
      return this;
    }

    public CommentEvent build() {
      return new CommentEventImpl(id, text, commentType, commentedOn, user);
    }
  }
}
