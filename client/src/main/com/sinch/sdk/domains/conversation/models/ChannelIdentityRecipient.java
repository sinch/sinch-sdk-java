package com.sinch.sdk.domains.conversation.models;

public interface ChannelIdentityRecipient extends BaseChannelIdentity {

  static Builder<?> builder() {
    return BuildersDelegation.ChannelIdentityRecipientBuilder();
  }

  interface Builder<T extends ChannelIdentityRecipient>
      extends BaseChannelIdentity.Builder<T, Builder<T>> {

    T build();
  }
}
