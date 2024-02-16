package com.sinch.sdk.domains.conversation.adapters.models;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.ChannelIdentityRecipient;
import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ChannelIdentityRecipientImpl extends BaseChannelIdentityImpl
    implements ChannelIdentityRecipient {

  protected ChannelIdentityRecipientImpl(
      OptionalValue<String> identity, OptionalValue<ChannelType> channel) {
    super(identity, channel);
  }

  @Override
  public String toString() {
    return "ChannelIdentityRecipientImpl{} " + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>>
      extends BaseChannelIdentityImpl.Builder<ChannelIdentityRecipientImpl, Builder<B>>
      implements ChannelIdentityRecipient.Builder<ChannelIdentityRecipientImpl> {

    @Override
    public ChannelIdentityRecipientImpl build() {
      return new ChannelIdentityRecipientImpl(identity, channel);
    }

    @Override
    @SuppressWarnings("unchecked")
    public B self() {
      return (B) this;
    }
  }
}
