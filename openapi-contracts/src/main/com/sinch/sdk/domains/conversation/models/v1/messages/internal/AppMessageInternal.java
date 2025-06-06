/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.Agent;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel.CarouselMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo.ContactInfoMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.list.ListMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.template.TemplateMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import java.util.Map;

/** A message originating from a Conversation API app */
@JsonDeserialize(builder = AppMessageInternalImpl.Builder.class)
public interface AppMessageInternal {

  /**
   * Get cardMessage
   *
   * @return cardMessage
   */
  CardMessage getCardMessage();

  /**
   * Get carouselMessage
   *
   * @return carouselMessage
   */
  CarouselMessage getCarouselMessage();

  /**
   * Get choiceMessage
   *
   * @return choiceMessage
   */
  ChoiceMessage getChoiceMessage();

  /**
   * Get locationMessage
   *
   * @return locationMessage
   */
  LocationMessage getLocationMessage();

  /**
   * Get mediaMessage
   *
   * @return mediaMessage
   */
  MediaMessage getMediaMessage();

  /**
   * Get templateMessage
   *
   * @return templateMessage
   */
  TemplateMessage getTemplateMessage();

  /**
   * Get textMessage
   *
   * @return textMessage
   */
  TextMessage getTextMessage();

  /**
   * Get listMessage
   *
   * @return listMessage
   */
  ListMessage getListMessage();

  /**
   * Get contactInfoMessage
   *
   * @return contactInfoMessage
   */
  ContactInfoMessage getContactInfoMessage();

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
   * well-defined than the open structure of the <code>explicit_channel_message</code> property, and
   * may be easier to use. The key in the map must point to a valid conversation channel as defined
   * in the enum <code>ConversationChannel</code>.
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
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new AppMessageInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param cardMessage see getter
     * @return Current builder
     * @see #getCardMessage
     */
    Builder setCardMessage(CardMessage cardMessage);

    /**
     * see getter
     *
     * @param carouselMessage see getter
     * @return Current builder
     * @see #getCarouselMessage
     */
    Builder setCarouselMessage(CarouselMessage carouselMessage);

    /**
     * see getter
     *
     * @param choiceMessage see getter
     * @return Current builder
     * @see #getChoiceMessage
     */
    Builder setChoiceMessage(ChoiceMessage choiceMessage);

    /**
     * see getter
     *
     * @param locationMessage see getter
     * @return Current builder
     * @see #getLocationMessage
     */
    Builder setLocationMessage(LocationMessage locationMessage);

    /**
     * see getter
     *
     * @param mediaMessage see getter
     * @return Current builder
     * @see #getMediaMessage
     */
    Builder setMediaMessage(MediaMessage mediaMessage);

    /**
     * see getter
     *
     * @param templateMessage see getter
     * @return Current builder
     * @see #getTemplateMessage
     */
    Builder setTemplateMessage(TemplateMessage templateMessage);

    /**
     * see getter
     *
     * @param textMessage see getter
     * @return Current builder
     * @see #getTextMessage
     */
    Builder setTextMessage(TextMessage textMessage);

    /**
     * see getter
     *
     * @param listMessage see getter
     * @return Current builder
     * @see #getListMessage
     */
    Builder setListMessage(ListMessage listMessage);

    /**
     * see getter
     *
     * @param contactInfoMessage see getter
     * @return Current builder
     * @see #getContactInfoMessage
     */
    Builder setContactInfoMessage(ContactInfoMessage contactInfoMessage);

    /**
     * see getter
     *
     * @param explicitChannelMessage see getter
     * @return Current builder
     * @see #getExplicitChannelMessage
     */
    Builder setExplicitChannelMessage(Map<ConversationChannel, String> explicitChannelMessage);

    /**
     * see getter
     *
     * @param explicitChannelOmniMessage see getter
     * @return Current builder
     * @see #getExplicitChannelOmniMessage
     */
    Builder setExplicitChannelOmniMessage(
        Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>
            explicitChannelOmniMessage);

    /**
     * see getter
     *
     * @param channelSpecificMessage see getter
     * @return Current builder
     * @see #getChannelSpecificMessage
     */
    Builder setChannelSpecificMessage(
        Map<ConversationChannel, ChannelSpecificMessage> channelSpecificMessage);

    /**
     * see getter
     *
     * @param agent see getter
     * @return Current builder
     * @see #getAgent
     */
    Builder setAgent(Agent agent);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    AppMessageInternal build();
  }
}
