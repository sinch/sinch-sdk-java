package com.sinch.sdk.domains.conversation.models.v1.conversations.request;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.util.Objects;

public class ConversationsListQueryParametersImpl implements ConversationsListQueryParameters {

  private final OptionalValue<String> appId;
  private final OptionalValue<String> contactId;
  private final OptionalValue<Boolean> onlyActive;
  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<String> pageToken;
  private final OptionalValue<ConversationChannel> activeChannel;

  private ConversationsListQueryParametersImpl(
      OptionalValue<String> appId,
      OptionalValue<String> contactId,
      OptionalValue<Boolean> onlyActive,
      OptionalValue<Integer> pageSize,
      OptionalValue<String> pageToken,
      OptionalValue<ConversationChannel> activeChannel) {
    this.appId = appId;
    this.contactId = contactId;
    this.onlyActive = onlyActive;
    this.pageSize = pageSize;
    this.pageToken = pageToken;
    this.activeChannel = activeChannel;
  }

  public OptionalValue<String> getAppId() {
    return appId;
  }

  public OptionalValue<String> getContactId() {
    return contactId;
  }

  public OptionalValue<Boolean> getOnlyActive() {
    return onlyActive;
  }

  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  public OptionalValue<String> getPageToken() {
    return pageToken;
  }

  public OptionalValue<ConversationChannel> getActiveChannel() {
    return activeChannel;
  }

  /** Return true if this ConversationListConversationsQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConversationsListQueryParametersImpl conversationListConversationsQueryParameters =
        (ConversationsListQueryParametersImpl) o;
    return Objects.equals(this.appId, conversationListConversationsQueryParameters.appId)
        && Objects.equals(this.contactId, conversationListConversationsQueryParameters.contactId)
        && Objects.equals(this.onlyActive, conversationListConversationsQueryParameters.onlyActive)
        && Objects.equals(this.pageSize, conversationListConversationsQueryParameters.pageSize)
        && Objects.equals(this.pageToken, conversationListConversationsQueryParameters.pageToken)
        && Objects.equals(
            this.activeChannel, conversationListConversationsQueryParameters.activeChannel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appId, contactId, onlyActive, pageSize, pageToken, activeChannel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversationsListQueryParametersImpl {\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    onlyActive: ").append(toIndentedString(onlyActive)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    pageToken: ").append(toIndentedString(pageToken)).append("\n");
    sb.append("    activeChannel: ").append(toIndentedString(activeChannel)).append("\n");
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

  static class Builder implements ConversationsListQueryParameters.Builder {
    OptionalValue<String> appId = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<Boolean> onlyActive = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<String> pageToken = OptionalValue.empty();
    OptionalValue<ConversationChannel> activeChannel = OptionalValue.empty();

    protected Builder() {}

    protected Builder(ConversationsListQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      ConversationsListQueryParametersImpl parameters =
          (ConversationsListQueryParametersImpl) _parameters;
      this.appId = parameters.getAppId();
      this.contactId = parameters.getContactId();
      this.onlyActive = parameters.getOnlyActive();
      this.pageSize = parameters.getPageSize();
      this.pageToken = parameters.getPageToken();
      this.activeChannel = parameters.getActiveChannel();
    }

    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    public Builder setContactId(String contactId) {
      this.contactId = OptionalValue.of(contactId);
      return this;
    }

    public Builder setOnlyActive(Boolean onlyActive) {
      this.onlyActive = OptionalValue.of(onlyActive);
      return this;
    }

    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    public Builder setPageToken(String pageToken) {
      this.pageToken = OptionalValue.of(pageToken);
      return this;
    }

    public Builder setActiveChannel(ConversationChannel activeChannel) {
      this.activeChannel = OptionalValue.of(activeChannel);
      return this;
    }

    public ConversationsListQueryParameters build() {
      return new ConversationsListQueryParametersImpl(
          appId, contactId, onlyActive, pageSize, pageToken, activeChannel);
    }
  }
}
