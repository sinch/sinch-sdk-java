package com.sinch.sdk.domains.conversation.models.v1.conversation.request;

import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.util.Optional;

public class ConversationsListRequestImpl implements ConversationsListRequest {

  final Boolean onlyActive;
  final String contactId;
  final String appId;
  final Integer pageSize;
  final String pageToken;
  final ConversationChannel activeChannel;

  public ConversationsListRequestImpl(
      Boolean onlyActive,
      String contactId,
      String appId,
      Integer pageSize,
      String pageToken,
      ConversationChannel activeChannel) {
    this.onlyActive = onlyActive;
    this.contactId = contactId;
    this.appId = appId;
    this.pageSize = pageSize;
    this.pageToken = pageToken;
    this.activeChannel = activeChannel;
  }

  @Override
  public Optional<Boolean> getOnlyActive() {
    return Optional.ofNullable(onlyActive);
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
  public Optional<Integer> getPageSize() {
    return Optional.ofNullable(pageSize);
  }

  @Override
  public Optional<String> getPageToken() {
    return Optional.ofNullable(pageToken);
  }

  @Override
  public Optional<ConversationChannel> getActiveChannel() {
    return Optional.ofNullable(activeChannel);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(ConversationsListRequest parameters) {
    return new Builder(parameters);
  }

  public static class Builder implements ConversationsListRequest.Builder {

    Boolean onlyActive;
    String contactId;
    String appId;
    Integer pageSize;
    String pageToken;
    ConversationChannel activeChannel;

    Builder() {}

    Builder(ConversationsListRequest parameters) {

      parameters.getOnlyActive().ifPresent(this::setOnlyActive);
      parameters.getContactId().ifPresent(this::setContactId);
      parameters.getAppId().ifPresent(this::setAppId);
      parameters.getPageSize().ifPresent(this::setPageSize);
      parameters.getPageToken().ifPresent(this::setPageToken);
      parameters.getActiveChannel().ifPresent(this::setActiveChannel);
    }

    @Override
    public Builder setOnlyActive(Boolean onlyActive) {
      this.onlyActive = onlyActive;
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
    public Builder setActiveChannel(ConversationChannel channel) {
      this.activeChannel = channel;
      return this;
    }

    public ConversationsListRequest build() {
      return new ConversationsListRequestImpl(
          onlyActive, contactId, appId, pageSize, pageToken, activeChannel);
    }
  }
}
