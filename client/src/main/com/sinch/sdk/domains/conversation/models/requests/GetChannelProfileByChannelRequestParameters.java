package com.sinch.sdk.domains.conversation.models.requests;

import com.sinch.sdk.domains.conversation.models.BuildersDelegation;
import com.sinch.sdk.domains.conversation.models.ChannelIdentityRecipient;
import java.util.Collection;

public interface GetChannelProfileByChannelRequestParameters
    extends BaseGetChannelProfileRequestParameters {

  Collection<ChannelIdentityRecipient> getChannelIdentities();

  static Builder builder() {
    return BuildersDelegation.ContactGetChannelProfileByChannelRequestParametersBuilder();
  }

  interface Builder extends BaseGetChannelProfileRequestParameters.Builder<Builder> {

    Builder setChannelIdentities(Collection<ChannelIdentityRecipient> channelIdentities);

    GetChannelProfileByChannelRequestParameters build();
  }
}
