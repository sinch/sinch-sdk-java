package com.sinch.sdk.domains.conversation.models.requests;

import com.sinch.sdk.domains.conversation.models.ChannelType;

/**
 * Common class for {@link
 * com.sinch.sdk.domains.conversation.ContactService#getChannelProfileByChannelIdentity(GetChannelProfileByChannelRequestParameters)}
 * and {@link
 * com.sinch.sdk.domains.conversation.ContactService#getChannelProfileByContactId(GetChannelProfileByContactRequestParameters)}
 * request parameters
 */
public interface BaseGetChannelProfileRequestParameters {

  /**
   * The ID of the app
   *
   * @return app ID value
   */
  String getAppId();

  /**
   * The channel. Must be one of the supported channels for this operation
   *
   * <ul>
   *   <li>{@link ChannelType#MESSENGER}
   *   <li>{@link ChannelType#INSTAGRAM}
   *   <li>{@link ChannelType#VIBER}
   *   <li>{@link ChannelType#LINE}
   * </ul>
   *
   * @return The channel
   */
  ChannelType getChannel();

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  interface Builder<B extends Builder<B>> {

    /**
     * see getter
     *
     * @param appId see getter
     * @return Current builder
     * @see BaseGetChannelProfileRequestParameters#getAppId()
     * @since 1.0
     */
    B setAppId(String appId);

    /**
     * see getter
     *
     * @param channel see getter
     * @return Current builder
     * @see BaseGetChannelProfileRequestParameters#getChannel()
     * @since 1.0
     */
    B setChannel(ChannelType channel);
  }
}
