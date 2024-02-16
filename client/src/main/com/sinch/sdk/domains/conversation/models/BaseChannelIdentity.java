package com.sinch.sdk.domains.conversation.models;

public interface BaseChannelIdentity {

  String getIdentity();

  ChannelType getChannel();

  interface Builder<T extends BaseChannelIdentity, B extends Builder<T, B>> {

    B setIdentity(String identity);

    B setChannel(ChannelType channel);

    T build();

    B self();
  }
}
