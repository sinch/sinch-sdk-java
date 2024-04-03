package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.sinch.sdk.domains.conversation.models.v1.Agent;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.util.Map;

public interface AppMessage<T> {

  T getMessage();

  /**
   * Channel specific messages, overriding any transcoding. The key in the map must point to a valid
   * conversation channel as defined in the enum &#x60;ConversationChannel&#x60;.
   *
   * @return explicitChannelMessage
   */
  Map<ConversationChannel, Object> getExplicitChannelMessage();

  /**
   * The option to override the omni-channel template configuration with a channel-specific template
   * (for channels on which channel-specific templates can be created. For more information, see
   * [Channel Specific
   * Templates](../../../../../conversation/templates/#channel-specific-templates)).
   *
   * @return explicitChannelOmniMessage
   */
  Map<ConversationChannel, OmniMessageOverride> getExplicitChannelOmniMessage();

  /**
   * Channel specific messages, overriding any transcoding. The structure of this property is more
   * well-defined than the open structure of the &#x60;explicit_channel_message&#x60; property, and
   * may be easier to use. The key in the map must point to a valid conversation channel as defined
   * in the enum &#x60;ConversationChannel&#x60;.
   *
   * @return channelSpecificMessage
   */
  Map<ConversationChannel, ChannelSpecificMessage> getChannelSpecificMessage();

  /**
   * Get agent
   *
   * @return agent
   */
  Agent getAgent();

  /** Dedicated Builder */
  interface Builder<T> {

    Builder<T> setMessage(T message);

    /**
     * see getter
     *
     * @param explicitChannelMessage see getter
     * @return Current builder
     * @see #getExplicitChannelMessage
     */
    Builder<T> setExplicitChannelMessage(Map<ConversationChannel, Object> explicitChannelMessage);

    /**
     * see getter
     *
     * @param explicitChannelOmniMessage see getter
     * @return Current builder
     * @see #getExplicitChannelOmniMessage
     */
    Builder<T> setExplicitChannelOmniMessage(
        Map<ConversationChannel, OmniMessageOverride> explicitChannelOmniMessage);

    /**
     * see getter
     *
     * @param channelSpecificMessage see getter
     * @return Current builder
     * @see #getChannelSpecificMessage
     */
    Builder<T> setChannelSpecificMessage(
        Map<ConversationChannel, ChannelSpecificMessage> channelSpecificMessage);

    /**
     * see getter
     *
     * @param agent see getter
     * @return Current builder
     * @see #getAgent
     */
    Builder<T> setAgent(Agent agent);

    AppMessage<T> build();
  }
}
