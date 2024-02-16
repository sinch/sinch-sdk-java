package com.sinch.sdk.domains.conversation.models;

public interface ChannelIdentity extends BaseChannelIdentity {

  String getAppId();

  static Builder<?, ?> builder() {
    return BuildersDelegation.ChannelIdentityBuilder();
  }

  interface Builder<T extends ChannelIdentity, B extends Builder<T, B>>
      extends BaseChannelIdentity.Builder<T, Builder<T, B>> {

    B setAppId(String appId);

    T build();
  }
}
