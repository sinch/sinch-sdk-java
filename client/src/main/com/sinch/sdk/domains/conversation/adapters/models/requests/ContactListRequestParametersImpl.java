package com.sinch.sdk.domains.conversation.adapters.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.ChannelType;
import com.sinch.sdk.domains.conversation.models.requests.ContactListRequestParameters;

public class ContactListRequestParametersImpl implements ContactListRequestParameters {

  private final OptionalValue<String> externalId;
  private final OptionalValue<ChannelType> channel;
  private final OptionalValue<String> identity;
  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<String> pageToken;

  private ContactListRequestParametersImpl(
      OptionalValue<String> externalId,
      OptionalValue<ChannelType> channel,
      OptionalValue<String> identity,
      OptionalValue<Integer> pageSize,
      OptionalValue<String> pageToken) {
    this.externalId = externalId;
    this.channel = channel;
    this.identity = identity;
    this.pageSize = pageSize;
    this.pageToken = pageToken;
  }

  @Override
  public OptionalValue<String> getExternalId() {
    return externalId;
  }

  @Override
  public OptionalValue<ChannelType> getChannel() {
    return channel;
  }

  @Override
  public OptionalValue<String> getIdentity() {
    return identity;
  }

  @Override
  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  @Override
  public OptionalValue<String> getPageToken() {
    return pageToken;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(ContactListRequestParameters parameters) {
    return new Builder((ContactListRequestParametersImpl) parameters);
  }

  public static class Builder implements ContactListRequestParameters.Builder {
    OptionalValue<String> externalId = OptionalValue.empty();
    OptionalValue<ChannelType> channel = OptionalValue.empty();
    OptionalValue<String> identity = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<String> pageToken = OptionalValue.empty();

    private Builder() {}

    private Builder(ContactListRequestParametersImpl parameters) {
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

    public Builder setChannel(ChannelType channel) {
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

    public ContactListRequestParametersImpl build() {
      return new ContactListRequestParametersImpl(
          externalId, channel, identity, pageSize, pageToken);
    }
  }
}
