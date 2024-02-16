package com.sinch.sdk.domains.conversation.adapters.models;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ChannelIdentityImpl extends BaseChannelIdentityImpl implements ChannelIdentity {

  private final OptionalValue<String> appId;

  private ChannelIdentityImpl(
      OptionalValue<String> identity,
      OptionalValue<ChannelType> channel,
      OptionalValue<String> appId) {
    super(identity, channel);

    this.appId = appId;
  }

  @Override
  public String getAppId() {
    return appId.orElse(null);
  }

  public OptionalValue<String> appId() {
    return appId;
  }

  @Override
  public String toString() {
    return "ChannelIdentityImpl{" + "appId=" + appId + "} " + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>>
      extends BaseChannelIdentityImpl.Builder<ChannelIdentityImpl, B>
      implements ChannelIdentity.Builder<ChannelIdentityImpl, B> {

    OptionalValue<String> appId = OptionalValue.empty();

    public B setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return self();
    }

    @Override
    public ChannelIdentityImpl build() {
      return new ChannelIdentityImpl(identity, channel, appId);
    }

    @Override
    @SuppressWarnings("unchecked")
    public B self() {
      return (B) this;
    }
  }
}
