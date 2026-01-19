package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessage;
import java.util.Collection;
import java.util.Objects;

@JsonPropertyOrder({
  MessagesListResponseInternalImpl.JSON_PROPERTY_MESSAGES,
  MessagesListResponseInternalImpl.JSON_PROPERTY_NEXT_PAGE_TOKEN
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MessagesListResponseInternalImpl implements MessagesListResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MESSAGES = "messages";

  private OptionalValue<Collection<ConversationMessage>> messages;

  public static final String JSON_PROPERTY_NEXT_PAGE_TOKEN = "next_page_token";

  private OptionalValue<String> nextPageToken;

  public MessagesListResponseInternalImpl() {}

  protected MessagesListResponseInternalImpl(
      OptionalValue<Collection<ConversationMessage>> messages,
      OptionalValue<String> nextPageToken) {
    this.messages = messages;
    this.nextPageToken = nextPageToken;
  }

  @JsonIgnore
  public Collection<ConversationMessage> getMessages() {
    return messages.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Collection<ConversationMessage>> messages() {
    return messages;
  }

  @JsonIgnore
  public String getNextPageToken() {
    return nextPageToken.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NEXT_PAGE_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> nextPageToken() {
    return nextPageToken;
  }

  /** Return true if this ListMessagesResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessagesListResponseInternalImpl listMessagesResponse = (MessagesListResponseInternalImpl) o;
    return Objects.equals(this.messages, listMessagesResponse.messages)
        && Objects.equals(this.nextPageToken, listMessagesResponse.nextPageToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messages, nextPageToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessagesListResponseInternalImpl {\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
    sb.append("    nextPageToken: ").append(toIndentedString(nextPageToken)).append("\n");
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
  static class Builder implements MessagesListResponseInternal.Builder {
    OptionalValue<Collection<ConversationMessage>> messages = OptionalValue.empty();
    OptionalValue<String> nextPageToken = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MESSAGES)
    public Builder setMessages(Collection<ConversationMessage> messages) {
      this.messages = OptionalValue.of(messages);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NEXT_PAGE_TOKEN)
    public Builder setNextPageToken(String nextPageToken) {
      this.nextPageToken = OptionalValue.of(nextPageToken);
      return this;
    }

    public MessagesListResponseInternal build() {
      return new MessagesListResponseInternalImpl(messages, nextPageToken);
    }
  }
}
