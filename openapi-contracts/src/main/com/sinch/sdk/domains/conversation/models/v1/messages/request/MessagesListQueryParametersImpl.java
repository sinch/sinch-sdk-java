package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.time.Instant;
import java.util.Objects;

public class MessagesListQueryParametersImpl implements MessagesListQueryParameters {

  private final OptionalValue<String> conversationId;
  private final OptionalValue<String> contactId;
  private final OptionalValue<String> appId;
  private final OptionalValue<String> channelIdentity;
  private final OptionalValue<Instant> startTime;
  private final OptionalValue<Instant> endTime;
  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<String> pageToken;
  private final OptionalValue<ConversationMessagesView> view;
  private final OptionalValue<MessagesSource> messagesSource;
  private final OptionalValue<Boolean> onlyRecipientOriginated;
  private final OptionalValue<ConversationChannel> channel;

  private MessagesListQueryParametersImpl(
      OptionalValue<String> conversationId,
      OptionalValue<String> contactId,
      OptionalValue<String> appId,
      OptionalValue<String> channelIdentity,
      OptionalValue<Instant> startTime,
      OptionalValue<Instant> endTime,
      OptionalValue<Integer> pageSize,
      OptionalValue<String> pageToken,
      OptionalValue<ConversationMessagesView> view,
      OptionalValue<MessagesSource> messagesSource,
      OptionalValue<Boolean> onlyRecipientOriginated,
      OptionalValue<ConversationChannel> channel) {
    this.conversationId = conversationId;
    this.contactId = contactId;
    this.appId = appId;
    this.channelIdentity = channelIdentity;
    this.startTime = startTime;
    this.endTime = endTime;
    this.pageSize = pageSize;
    this.pageToken = pageToken;
    this.view = view;
    this.messagesSource = messagesSource;
    this.onlyRecipientOriginated = onlyRecipientOriginated;
    this.channel = channel;
  }

  public OptionalValue<String> getConversationId() {
    return conversationId;
  }

  public OptionalValue<String> getContactId() {
    return contactId;
  }

  public OptionalValue<String> getAppId() {
    return appId;
  }

  public OptionalValue<String> getChannelIdentity() {
    return channelIdentity;
  }

  public OptionalValue<Instant> getStartTime() {
    return startTime;
  }

  public OptionalValue<Instant> getEndTime() {
    return endTime;
  }

  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  public OptionalValue<String> getPageToken() {
    return pageToken;
  }

  public OptionalValue<ConversationMessagesView> getView() {
    return view;
  }

  public OptionalValue<MessagesSource> getMessagesSource() {
    return messagesSource;
  }

  public OptionalValue<Boolean> getOnlyRecipientOriginated() {
    return onlyRecipientOriginated;
  }

  public OptionalValue<ConversationChannel> getChannel() {
    return channel;
  }

  /** Return true if this MessagesListMessagesQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessagesListQueryParametersImpl messagesListMessagesQueryParameters =
        (MessagesListQueryParametersImpl) o;
    return Objects.equals(this.conversationId, messagesListMessagesQueryParameters.conversationId)
        && Objects.equals(this.contactId, messagesListMessagesQueryParameters.contactId)
        && Objects.equals(this.appId, messagesListMessagesQueryParameters.appId)
        && Objects.equals(this.channelIdentity, messagesListMessagesQueryParameters.channelIdentity)
        && Objects.equals(this.startTime, messagesListMessagesQueryParameters.startTime)
        && Objects.equals(this.endTime, messagesListMessagesQueryParameters.endTime)
        && Objects.equals(this.pageSize, messagesListMessagesQueryParameters.pageSize)
        && Objects.equals(this.pageToken, messagesListMessagesQueryParameters.pageToken)
        && Objects.equals(this.view, messagesListMessagesQueryParameters.view)
        && Objects.equals(this.messagesSource, messagesListMessagesQueryParameters.messagesSource)
        && Objects.equals(
            this.onlyRecipientOriginated,
            messagesListMessagesQueryParameters.onlyRecipientOriginated)
        && Objects.equals(this.channel, messagesListMessagesQueryParameters.channel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        conversationId,
        contactId,
        appId,
        channelIdentity,
        startTime,
        endTime,
        pageSize,
        pageToken,
        view,
        messagesSource,
        onlyRecipientOriginated,
        channel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessagesListQueryParametersImpl {\n");
    sb.append("    conversationId: ").append(toIndentedString(conversationId)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    channelIdentity: ").append(toIndentedString(channelIdentity)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    pageToken: ").append(toIndentedString(pageToken)).append("\n");
    sb.append("    view: ").append(toIndentedString(view)).append("\n");
    sb.append("    messagesSource: ").append(toIndentedString(messagesSource)).append("\n");
    sb.append("    onlyRecipientOriginated: ")
        .append(toIndentedString(onlyRecipientOriginated))
        .append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
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

  static class Builder implements MessagesListQueryParameters.Builder {
    OptionalValue<String> conversationId = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<String> appId = OptionalValue.empty();
    OptionalValue<String> channelIdentity = OptionalValue.empty();
    OptionalValue<Instant> startTime = OptionalValue.empty();
    OptionalValue<Instant> endTime = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<String> pageToken = OptionalValue.empty();
    OptionalValue<ConversationMessagesView> view = OptionalValue.empty();
    OptionalValue<MessagesSource> messagesSource = OptionalValue.empty();
    OptionalValue<Boolean> onlyRecipientOriginated = OptionalValue.empty();
    OptionalValue<ConversationChannel> channel = OptionalValue.empty();

    protected Builder() {}

    protected Builder(MessagesListQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      MessagesListQueryParametersImpl parameters = (MessagesListQueryParametersImpl) _parameters;
      this.conversationId = parameters.getConversationId();
      this.contactId = parameters.getContactId();
      this.appId = parameters.getAppId();
      this.channelIdentity = parameters.getChannelIdentity();
      this.startTime = parameters.getStartTime();
      this.endTime = parameters.getEndTime();
      this.pageSize = parameters.getPageSize();
      this.pageToken = parameters.getPageToken();
      this.view = parameters.getView();
      this.messagesSource = parameters.getMessagesSource();
      this.onlyRecipientOriginated = parameters.getOnlyRecipientOriginated();
      this.channel = parameters.getChannel();
    }

    public Builder setConversationId(String conversationId) {
      this.conversationId = OptionalValue.of(conversationId);
      return this;
    }

    public Builder setContactId(String contactId) {
      this.contactId = OptionalValue.of(contactId);
      return this;
    }

    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    public Builder setChannelIdentity(String channelIdentity) {
      this.channelIdentity = OptionalValue.of(channelIdentity);
      return this;
    }

    public Builder setStartTime(Instant startTime) {
      this.startTime = OptionalValue.of(startTime);
      return this;
    }

    public Builder setEndTime(Instant endTime) {
      this.endTime = OptionalValue.of(endTime);
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

    public Builder setView(ConversationMessagesView view) {
      this.view = OptionalValue.of(view);
      return this;
    }

    public Builder setMessagesSource(MessagesSource messagesSource) {
      this.messagesSource = OptionalValue.of(messagesSource);
      return this;
    }

    public Builder setOnlyRecipientOriginated(Boolean onlyRecipientOriginated) {
      this.onlyRecipientOriginated = OptionalValue.of(onlyRecipientOriginated);
      return this;
    }

    public Builder setChannel(ConversationChannel channel) {
      this.channel = OptionalValue.of(channel);
      return this;
    }

    public MessagesListQueryParameters build() {
      return new MessagesListQueryParametersImpl(
          conversationId,
          contactId,
          appId,
          channelIdentity,
          startTime,
          endTime,
          pageSize,
          pageToken,
          view,
          messagesSource,
          onlyRecipientOriginated,
          channel);
    }
  }
}
