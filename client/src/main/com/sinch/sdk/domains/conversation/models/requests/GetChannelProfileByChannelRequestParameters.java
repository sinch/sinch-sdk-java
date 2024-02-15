package com.sinch.sdk.domains.conversation.models.requests;

import com.sinch.sdk.domains.conversation.models.BuildersDelegation;
import com.sinch.sdk.domains.conversation.models.ChannelIdentityRecipient;
import java.util.Collection;

/** Parameters to get channel profile by the identity as specified by the channel */
public interface GetChannelProfileByChannelRequestParameters
    extends BaseGetChannelProfileRequestParameters {

  /**
   * List of channel Recipient Identity
   *
   * @return List of channel Recipient Identity
   * @since 1.0
   */
  Collection<ChannelIdentityRecipient> getChannelIdentities();

  /**
   * Getting builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return BuildersDelegation.ContactGetChannelProfileByChannelRequestParametersBuilder();
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  interface Builder extends BaseGetChannelProfileRequestParameters.Builder<Builder> {

    /**
     * see getter
     *
     * @param channelIdentities see getter
     * @return Current builder
     * @see GetChannelProfileByChannelRequestParameters#getChannelIdentities()
     * @since 1.0
     */
    Builder setChannelIdentities(Collection<ChannelIdentityRecipient> channelIdentities);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    GetChannelProfileByChannelRequestParameters build();
  }
}
