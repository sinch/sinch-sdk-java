/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import java.util.Objects;

/** ListConversationsResponseDto */
@JsonPropertyOrder({
  ListConversationsResponseDto.JSON_PROPERTY_CONVERSATIONS,
  ListConversationsResponseDto.JSON_PROPERTY_NEXT_PAGE_TOKEN,
  ListConversationsResponseDto.JSON_PROPERTY_TOTAL_SIZE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListConversationsResponseDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_CONVERSATIONS = "conversations";
  private List<ConversationDto> conversations;
  private boolean conversationsDefined = false;

  public static final String JSON_PROPERTY_NEXT_PAGE_TOKEN = "next_page_token";
  private String nextPageToken;
  private boolean nextPageTokenDefined = false;

  public static final String JSON_PROPERTY_TOTAL_SIZE = "total_size";
  private Integer totalSize;
  private boolean totalSizeDefined = false;

  public ListConversationsResponseDto() {}

  @JsonCreator
  public ListConversationsResponseDto(
      @JsonProperty(JSON_PROPERTY_CONVERSATIONS) List<ConversationDto> conversations) {
    this();
    this.conversations = conversations;
    this.conversationsDefined = true;
  }

  /**
   * List of conversations matching the search query.
   *
   * @return conversations
   */
  @JsonProperty(JSON_PROPERTY_CONVERSATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<ConversationDto> getConversations() {
    return conversations;
  }

  @JsonIgnore
  public boolean getConversationsDefined() {
    return conversationsDefined;
  }

  public ListConversationsResponseDto nextPageToken(String nextPageToken) {
    this.nextPageToken = nextPageToken;
    this.nextPageTokenDefined = true;
    return this;
  }

  /**
   * Token that should be included in the next request to fetch the next page.
   *
   * @return nextPageToken
   */
  @JsonProperty(JSON_PROPERTY_NEXT_PAGE_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getNextPageToken() {
    return nextPageToken;
  }

  @JsonIgnore
  public boolean getNextPageTokenDefined() {
    return nextPageTokenDefined;
  }

  @JsonProperty(JSON_PROPERTY_NEXT_PAGE_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNextPageToken(String nextPageToken) {
    this.nextPageToken = nextPageToken;
    this.nextPageTokenDefined = true;
  }

  public ListConversationsResponseDto totalSize(Integer totalSize) {
    this.totalSize = totalSize;
    this.totalSizeDefined = true;
    return this;
  }

  /**
   * Get totalSize
   *
   * @return totalSize
   */
  @JsonProperty(JSON_PROPERTY_TOTAL_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getTotalSize() {
    return totalSize;
  }

  @JsonIgnore
  public boolean getTotalSizeDefined() {
    return totalSizeDefined;
  }

  @JsonProperty(JSON_PROPERTY_TOTAL_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTotalSize(Integer totalSize) {
    this.totalSize = totalSize;
    this.totalSizeDefined = true;
  }

  /** Return true if this ListConversationsResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListConversationsResponseDto listConversationsResponse = (ListConversationsResponseDto) o;
    return Objects.equals(this.conversations, listConversationsResponse.conversations)
        && Objects.equals(this.nextPageToken, listConversationsResponse.nextPageToken)
        && Objects.equals(this.totalSize, listConversationsResponse.totalSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conversations, nextPageToken, totalSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListConversationsResponseDto {\n");
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
}