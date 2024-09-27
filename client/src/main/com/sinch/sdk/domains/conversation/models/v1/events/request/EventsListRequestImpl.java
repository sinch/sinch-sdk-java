package com.sinch.sdk.domains.conversation.models.v1.events.request;

import java.util.Optional;

public class EventsListRequestImpl implements EventsListRequest {

  final String conversationId;
  final String contactId;
  final Integer pageSize;
  final String pageToken;

  public EventsListRequestImpl(
      String conversationId, String contactId, Integer pageSize, String pageToken) {
    this.conversationId = conversationId;
    this.contactId = contactId;
    this.pageSize = pageSize;
    this.pageToken = pageToken;
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
  public Optional<Integer> getPageSize() {
    return Optional.ofNullable(pageSize);
  }

  @Override
  public Optional<String> getPageToken() {
    return Optional.ofNullable(pageToken);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(EventsListRequest parameters) {
    return new Builder(parameters);
  }

  public static class Builder implements EventsListRequest.Builder {

    String conversationId;
    String contactId;
    Integer pageSize;
    String pageToken;

    Builder() {}

    Builder(EventsListRequest parameters) {

      parameters.getConversationId().ifPresent(this::setConversationId);
      parameters.getContactId().ifPresent(this::setContactId);
      parameters.getPageSize().ifPresent(this::setPageSize);
      parameters.getPageToken().ifPresent(this::setPageToken);
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
    public Builder setPageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    @Override
    public Builder setPageToken(String pageToken) {
      this.pageToken = pageToken;
      return this;
    }

    public EventsListRequest build() {
      return new EventsListRequestImpl(conversationId, contactId, pageSize, pageToken);
    }
  }
}
