package com.sinch.sdk.domains.conversation.adapters.models;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.BaseChannelIdentity;
import com.sinch.sdk.domains.conversation.models.ChannelType;

public class BaseChannelIdentityImpl implements BaseChannelIdentity {

  private final OptionalValue<String> identity;
  private final OptionalValue<ChannelType> channel;

  protected BaseChannelIdentityImpl(
      OptionalValue<String> identity, OptionalValue<ChannelType> channel) {
    this.identity = identity;
    this.channel = channel;
  }

  @Override
  public String getIdentity() {
    return identity.orElse(null);
  }

  public OptionalValue<String> identity() {
    return identity;
  }

  @Override
  public ChannelType getChannel() {
    return channel.orElse(null);
  }

  public OptionalValue<ChannelType> channel() {
    return channel;
  }

  @Override
  public String toString() {
    return "BaseChannelIdentityImpl{"
        + "identity='"
        + identity
        + '\''
        + ", channel="
        + channel
        + '}';
  }

  public abstract static class Builder<T extends BaseChannelIdentity, B extends Builder<T, B>> {

    OptionalValue<String> identity = OptionalValue.empty();
    OptionalValue<ChannelType> channel = OptionalValue.empty();

    public B setIdentity(String identity) {
      this.identity = OptionalValue.of(identity);
      return self();
    }

    public B setChannel(ChannelType channel) {
      this.channel = OptionalValue.of(channel);
      return self();
    }

    public abstract T build();

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
