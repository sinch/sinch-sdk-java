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
   * Allows you to specify a channel and define a corresponding channel specific message payload
   * that will override the standard Conversation API message types. The key in the map must point
   * to a valid conversation channel as defined in the enum <code>ConversationChannel</code>. The
   * message content must be provided in string format. You may use the <a
   * href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Transcoding/">transcoding
   * endpoint</a> to help create your message. For more information about how to construct an
   * explicit channel message for a particular channel, see that <a
   * href="https://developers.sinch.com/docs/conversation/channel-support/">channel's corresponding
   * documentation</a> (for example, using explicit channel messages with <a
   * href="https://developers.sinch.com/docs/conversation/channel-support/whatsapp/message-support/#explicit-channel-messages">the
   * WhatsApp channel</a>).
   *
   * @return explicitChannelMessage
   */
  Map<ConversationChannel, String> getExplicitChannelMessage();

  /**
   * Override the message's content for specified channels. The key in the map must point to a valid
   * conversation channel as defined in the enum <code>ConversationChannel</code>. The content
   * defined under the specified channel will be sent on that channel.
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
    Builder<T> setExplicitChannelMessage(Map<ConversationChannel, String> explicitChannelMessage);

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
