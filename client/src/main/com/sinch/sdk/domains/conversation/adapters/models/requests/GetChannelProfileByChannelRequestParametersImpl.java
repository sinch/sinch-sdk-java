package com.sinch.sdk.domains.conversation.adapters.models.requests;

import com.sinch.sdk.domains.conversation.models.ChannelIdentityRecipient;
import com.sinch.sdk.domains.conversation.models.ChannelType;
import com.sinch.sdk.domains.conversation.models.requests.GetChannelProfileByChannelRequestParameters;
import java.util.Collection;

public class GetChannelProfileByChannelRequestParametersImpl
    extends BaseGetChannelProfileRequestParametersImpl
    implements GetChannelProfileByChannelRequestParameters {

  private final Collection<ChannelIdentityRecipient> channelIdentities;

  public GetChannelProfileByChannelRequestParametersImpl(
      String appId, ChannelType channel, Collection<ChannelIdentityRecipient> channelIdentities) {
    super(appId, channel);
    this.channelIdentities = channelIdentities;
  }

  @Override
  public Collection<ChannelIdentityRecipient> getChannelIdentities() {
    return channelIdentities;
  }

  @Override
  public String toString() {
    return "GetChannelProfileByChannelRequestParametersImpl{"
        + "channelIdentities="
        + channelIdentities
        + "} "
        + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends BaseGetChannelProfileRequestParametersImpl.Builder<Builder>
      implements GetChannelProfileByChannelRequestParameters.Builder {

    Collection<ChannelIdentityRecipient> channelIdentities;

    public Builder setChannelIdentities(Collection<ChannelIdentityRecipient> channelIdentities) {
      this.channelIdentities = channelIdentities;
      return this;
    }

    public GetChannelProfileByChannelRequestParametersImpl build() {
      return new GetChannelProfileByChannelRequestParametersImpl(appId, channel, channelIdentities);
    }
  }
}
