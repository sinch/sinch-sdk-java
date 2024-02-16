package com.sinch.sdk.domains.conversation.adapters.models.requests;

import com.sinch.sdk.domains.conversation.models.ChannelType;
import com.sinch.sdk.domains.conversation.models.requests.BaseGetChannelProfileRequestParameters;

public class BaseGetChannelProfileRequestParametersImpl
    implements BaseGetChannelProfileRequestParameters {

  private final String appId;
  private final ChannelType channel;

  public BaseGetChannelProfileRequestParametersImpl(String appId, ChannelType channel) {
    this.appId = appId;
    this.channel = channel;
  }

  @Override
  public String getAppId() {
    return appId;
  }

  @Override
  public ChannelType getChannel() {
    return channel;
  }

  @Override
  public String toString() {
    return "BaseGetChannelProfileRequestParametersImpl{"
        + "appId='"
        + appId
        + '\''
        + ", channel="
        + channel
        + '}';
  }

  static class Builder<
      B extends Builder<B>> /* implements BaseGetChannelProfileRequestParameters.Builder<B>*/ {

    String appId;
    ChannelType channel;

    // @Override
    public B setAppId(String appId) {
      this.appId = appId;
      return self();
    }

    public B setChannel(ChannelType channel) {
      this.channel = channel;
      return self();
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
