package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.sinch.sdk.domains.conversation.models.v1.Agent;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificMessage;
import java.util.Map;

/**
 * Message originating from an app
 *
 * @param <T> Body type for message
 * @since 1.3
 */
public interface AppMessage<T extends AppMessageBody> extends ConversationMessageBody {

  /**
   * Get message body
   *
   * @return Message body
   */
  T getBody();

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
  Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>
      getExplicitChannelOmniMessage();

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

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static <T extends AppMessageBody> Builder<T> builder() {
    return new AppMessageImpl.Builder<>();
  }

  /** Dedicated Builder */
  interface Builder<T extends AppMessageBody> {

    /**
     * see getter
     *
     * @param message see getter
     * @return Current builder
     * @see #getBody()
     */
    Builder<T> setBody(T message);

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
        Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>
            explicitChannelOmniMessage);

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
