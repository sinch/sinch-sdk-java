package com.sinch.sdk.domains.conversation.models.v1;

import com.sinch.sdk.core.models.OptionalValue;

public class ContactListRequest {

  private final OptionalValue<String> externalId;
  private final OptionalValue<ConversationChannel> channel;
  private final OptionalValue<String> identity;
  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<String> pageToken;

  private ContactListRequest(
      OptionalValue<String> externalId,
      OptionalValue<ConversationChannel> channel,
      OptionalValue<String> identity,
      OptionalValue<Integer> pageSize,
      OptionalValue<String> pageToken) {
    this.externalId = externalId;
    this.channel = channel;
    this.identity = identity;
    this.pageSize = pageSize;
    this.pageToken = pageToken;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(ContactListRequest parameters) {
    return new Builder(parameters);
  }

  public OptionalValue<String> getExternalId() {
    return externalId;
  }

  public OptionalValue<ConversationChannel> getChannel() {
    return channel;
  }

  public OptionalValue<String> getIdentity() {
    return identity;
  }

  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  public OptionalValue<String> getPageToken() {
    return pageToken;
  }

  public static class Builder {

    OptionalValue<String> externalId = OptionalValue.empty();
    OptionalValue<ConversationChannel> channel = OptionalValue.empty();
    OptionalValue<String> identity = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<String> pageToken = OptionalValue.empty();

    private Builder() {}

    private Builder(ContactListRequest parameters) {
      if (null == parameters) {
        return;
      }
      parameters.externalId.ifPresent(this::setExternalId);
      parameters.channel.ifPresent(this::setChannel);
      parameters.identity.ifPresent(this::setIdentity);
      parameters.pageSize.ifPresent(this::setPageSize);
      parameters.pageToken.ifPresent(this::setPageToken);
    }

    public Builder setExternalId(String externalId) {
      this.externalId = OptionalValue.of(externalId);
      return this;
    }

    public Builder setChannel(ConversationChannel channel) {
      this.channel = OptionalValue.of(channel);
      return this;
    }

    public Builder setIdentity(String identity) {
      this.identity = OptionalValue.of(identity);
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

    public ContactListRequest build() {
      return new ContactListRequest(externalId, channel, identity, pageSize, pageToken);
    }
  }
}
