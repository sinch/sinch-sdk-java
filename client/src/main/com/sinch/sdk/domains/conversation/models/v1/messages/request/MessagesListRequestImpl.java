package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.sinch.sdk.domains.conversation.api.v1.MessagesService.MessageSource;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.time.Instant;
import java.util.Optional;

public class MessagesListRequestImpl implements MessagesListRequest {

  final String conversationId;
  final String contactId;
  final String appId;
  final String channelIdentity;
  final Instant startTime;
  final Instant endTime;
  final Integer pageSize;
  final String pageToken;
  final ConversationMessagesView view;
  final MessageSource messagesSource;
  final Boolean onlyRecipientOriginated;
  final ConversationChannel channel;

  public MessagesListRequestImpl(
      String conversationId,
      String contactId,
      String appId,
      String channelIdentity,
      Instant startTime,
      Instant endTime,
      Integer pageSize,
      String pageToken,
      ConversationMessagesView view,
      MessageSource messagesSource,
      Boolean onlyRecipientOriginated,
      ConversationChannel channel) {
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

  @Override
  public Optional<String> getConversationId() {
    return Optional.ofNullable(conversationId);
  }

  @Override
  public Optional<String> getContactId() {
    return Optional.ofNullable(contactId);
  }

  @Override
  public Optional<String> getAppId() {
    return Optional.ofNullable(appId);
  }

  @Override
  public Optional<String> getChannelIdentity() {
    return Optional.ofNullable(channelIdentity);
  }

  @Override
  public Optional<Instant> getStartTime() {
    return Optional.ofNullable(startTime);
  }

  @Override
  public Optional<Instant> getEndTime() {
    return Optional.ofNullable(endTime);
  }

  @Override
  public Optional<Integer> getPageSize() {
    return Optional.ofNullable(pageSize);
  }

  @Override
  public Optional<String> getPageToken() {
    return Optional.ofNullable(pageToken);
  }

  @Override
  public Optional<ConversationMessagesView> getView() {
    return Optional.ofNullable(view);
  }

  @Override
  public Optional<MessageSource> getMessagesSource() {
    return Optional.ofNullable(messagesSource);
  }

  @Override
  public Optional<Boolean> getOnlyRecipientOriginated() {
    return Optional.ofNullable(onlyRecipientOriginated);
  }

  @Override
  public Optional<ConversationChannel> getChannel() {
    return Optional.ofNullable(channel);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(MessagesListRequest parameters) {
    return new Builder(parameters);
  }

  public static class Builder implements MessagesListRequest.Builder {

    String conversationId;
    String contactId;
    String appId;
    String channelIdentity;
    Instant startTime;
    Instant endTime;
    Integer pageSize;
    String pageToken;
    ConversationMessagesView view;
    MessageSource messagesSource;
    Boolean onlyRecipientOriginated;
    ConversationChannel channel;

    Builder() {}

    Builder(MessagesListRequest parameters) {

      parameters.getConversationId().ifPresent(this::setConversationId);
      parameters.getContactId().ifPresent(this::setContactId);
      parameters.getAppId().ifPresent(this::setAppId);
      parameters.getChannelIdentity().ifPresent(this::setChannelIdentity);
      parameters.getStartTime().ifPresent(this::setStartTime);
      parameters.getEndTime().ifPresent(this::setEndTime);
      parameters.getPageSize().ifPresent(this::setPageSize);
      parameters.getPageToken().ifPresent(this::setPageToken);
      parameters.getView().ifPresent(this::setView);
      parameters.getMessagesSource().ifPresent(this::setMessagesSource);
      parameters.getOnlyRecipientOriginated().ifPresent(this::setOnlyRecipientOriginated);
      parameters.getChannel().ifPresent(this::setChannel);
    }

    @Override
    public Builder setConversationId(String conversationId) {
      this.conversationId = conversationId;
      return this;
    }

    @Override
    public Builder setContactId(String contactId) {
      this.contactId = contactId;
      return this;
    }

    @Override
    public Builder setAppId(String appId) {
      this.appId = appId;
      return this;
    }

    @Override
    public Builder setChannelIdentity(String channelIdentity) {
      this.channelIdentity = channelIdentity;
      return this;
    }

    @Override
    public Builder setStartTime(Instant startTime) {
      this.startTime = startTime;
      return this;
    }

    @Override
    public Builder setEndTime(Instant endTime) {
      this.endTime = endTime;
      return this;
    }

    @Override
    public Builder setPageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    @Override
    public Builder setPageToken(String pageToken) {
      this.pageToken = pageToken;
      return this;
    }

    @Override
    public Builder setView(ConversationMessagesView view) {
      this.view = view;
      return this;
    }

    @Override
    public Builder setMessagesSource(MessageSource messagesSource) {
      this.messagesSource = messagesSource;
      return this;
    }

    @Override
    public Builder setOnlyRecipientOriginated(Boolean onlyRecipientOriginated) {
      this.onlyRecipientOriginated = onlyRecipientOriginated;
      return this;
    }

    @Override
    public Builder setChannel(ConversationChannel channel) {
      this.channel = channel;
      return this;
    }

    public MessagesListRequest build() {
      return new MessagesListRequestImpl(
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
