package com.sinch.sdk.domains.conversation.models.v1.conversation.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ListRecentConversationsResponseImpl.JSON_PROPERTY_CONVERSATIONS,
  ListRecentConversationsResponseImpl.JSON_PROPERTY_NEXT_PAGE_TOKEN,
  ListRecentConversationsResponseImpl.JSON_PROPERTY_TOTAL_SIZE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListRecentConversationsResponseImpl implements ListRecentConversationsResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONVERSATIONS = "conversations";

  private OptionalValue<List<ConversationRecentMessage>> conversations;

  public static final String JSON_PROPERTY_NEXT_PAGE_TOKEN = "next_page_token";

  private OptionalValue<String> nextPageToken;

  public static final String JSON_PROPERTY_TOTAL_SIZE = "total_size";

  private OptionalValue<Integer> totalSize;

  public ListRecentConversationsResponseImpl() {}

  protected ListRecentConversationsResponseImpl(
      OptionalValue<List<ConversationRecentMessage>> conversations,
      OptionalValue<String> nextPageToken,
      OptionalValue<Integer> totalSize) {
    this.conversations = conversations;
    this.nextPageToken = nextPageToken;
    this.totalSize = totalSize;
  }

  @JsonIgnore
  public List<ConversationRecentMessage> getConversations() {
    return conversations.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONVERSATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<ConversationRecentMessage>> conversations() {
    return conversations;
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

  @JsonIgnore
  public Integer getTotalSize() {
    return totalSize.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TOTAL_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> totalSize() {
    return totalSize;
  }

  /** Return true if this ListRecentConversationsResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListRecentConversationsResponseImpl listRecentConversationsResponse =
        (ListRecentConversationsResponseImpl) o;
    return Objects.equals(this.conversations, listRecentConversationsResponse.conversations)
        && Objects.equals(this.nextPageToken, listRecentConversationsResponse.nextPageToken)
        && Objects.equals(this.totalSize, listRecentConversationsResponse.totalSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conversations, nextPageToken, totalSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListRecentConversationsResponseImpl {\n");
    sb.append("    conversations: ").append(toIndentedString(conversations)).append("\n");
    sb.append("    nextPageToken: ").append(toIndentedString(nextPageToken)).append("\n");
    sb.append("    totalSize: ").append(toIndentedString(totalSize)).append("\n");
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
  static class Builder implements ListRecentConversationsResponse.Builder {
    OptionalValue<List<ConversationRecentMessage>> conversations = OptionalValue.empty();
    OptionalValue<String> nextPageToken = OptionalValue.empty();
    OptionalValue<Integer> totalSize = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CONVERSATIONS)
    public Builder setConversations(List<ConversationRecentMessage> conversations) {
      this.conversations = OptionalValue.of(conversations);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NEXT_PAGE_TOKEN)
    public Builder setNextPageToken(String nextPageToken) {
      this.nextPageToken = OptionalValue.of(nextPageToken);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TOTAL_SIZE)
    public Builder setTotalSize(Integer totalSize) {
      this.totalSize = OptionalValue.of(totalSize);
      return this;
    }

    public ListRecentConversationsResponse build() {
      return new ListRecentConversationsResponseImpl(conversations, nextPageToken, totalSize);
    }
  }
}
