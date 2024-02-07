package com.sinch.sdk.domains.conversation.models.requests;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public interface BaseGetChannelProfileRequestParameters {

  String getAppId();

  ChannelType getChannel();

  interface Builder<B extends Builder<B>> {

    B setAppId(String appId);

    B setChannel(ChannelType channel);
  }
}
