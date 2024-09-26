package com.sinch.sdk.domains.conversation.api.v1;

import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageBody;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.MessageUpdateRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.MessagesListRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.MessagesListResponse;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.SendMessageResponse;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel.CarouselMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo.ContactInfoMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.list.ListMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.template.TemplateMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;

/**
 * Messages related service
 *
 * <p>To start sending messages you must have a Conversation API <a
 * href="https://dashboard.sinch.com/convapi/apps">app</a>. The app holds information about the
 * channel credentials and registered webhooks to which the API delivers callbacks such as message
 * delivery receipts and contact messages. If you don't already have an app please follow the
 * instructions in the getting started guide available in the Sinch Dashboard to create one.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Messages">https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Messages</a>
 * @since 1.3
 */
public interface MessagesService {

  /**
   * Send a message
   *
   * <p>You can send a message from a Conversation app to a contact associated with that app. If the
   * recipient is not associated with an existing contact, a new contact will be created.
   *
   * <p>The message is added to the active conversation with the contact if a conversation already
   * exists. If no active conversation exists a new one is started automatically.
   *
   * <p>You can find all of your IDs and authentication credentials on the Sinch Customer Dashboard.
   *
   * @return Response related to messages sent (from {@link
   *     com.sinch.sdk.domains.conversation.models.v1.messages.response.SendMessageResponse})
   * @since 1.3
   */
  SendMessageResponse sendMessage(SendMessageRequest<? extends AppMessageBody> request);

  /**
   * Send a card message
   *
   * @param request CardMessage request
   * @return Response
   * @see #sendMessage(SendMessageRequest)
   */
  SendMessageResponse sendCardMessage(SendMessageRequest<CardMessage> request);

  /**
   * Send a carousel message
   *
   * @param request CarouselMessage request
   * @return Response
   * @see #sendMessage(SendMessageRequest)
   */
  SendMessageResponse sendCarouselMessage(SendMessageRequest<CarouselMessage> request);

  /**
   * Send a choice message
   *
   * @param request ChoiceMessage request
   * @return Response
   * @see #sendMessage(SendMessageRequest)
   */
  SendMessageResponse sendChoiceMessage(SendMessageRequest<ChoiceMessage> request);

  /**
   * Send a contact info message
   *
   * @param request ContactInfoMessage request
   * @return Response
   * @see #sendMessage(SendMessageRequest)
   */
  SendMessageResponse sendContactInfoMessage(SendMessageRequest<ContactInfoMessage> request);

  /**
   * Send a list message
   *
   * @param request ListMessage request
   * @return Response
   * @see #sendMessage(SendMessageRequest)
   */
  SendMessageResponse sendListMessage(SendMessageRequest<ListMessage> request);

  /**
   * Send a location message
   *
   * @param request LocationMessage request
   * @return Response
   * @see #sendMessage(SendMessageRequest)
   */
  SendMessageResponse sendLocationMessage(SendMessageRequest<LocationMessage> request);

  /**
   * Send a media message
   *
   * @param request MediaMessage request
   * @return Response
   * @see #sendMessage(SendMessageRequest)
   */
  SendMessageResponse sendMediaMessage(SendMessageRequest<MediaMessage> request);

  /**
   * Send a template message
   *
   * @param request TemplateMessage request
   * @return Response
   * @see #sendMessage(SendMessageRequest)
   */
  SendMessageResponse sendTemplateMessage(SendMessageRequest<TemplateMessage> request);

  /**
   * Send a send message request message
   *
   * @param request request
   * @return Response
   * @see #sendMessage(SendMessageRequest)
   */
  SendMessageResponse sendTextMessage(SendMessageRequest<TextMessage> request);

  /**
   * Helper method for {@link #get(String, MessageSource)}
   *
   * @see #get(String, MessageSource)
   * @param messageId The unique ID of the message.
   * @return Conversation message
   */
  ConversationMessage get(String messageId);

  /**
   * Retrieves a specific message by its ID.
   *
   * @param messageId The unique ID of the message.
   * @param messageSource Specifies the message source for which the request will be processed. Used
   *     for operations on messages in Dispatch Mode. For more information, see <a
   *     href="https://developers.sinch.com/docs/conversation/processing-modes">Processing Modes</a>
   * @default <code>CONVERSATION_SOURCE</code>
   * @return Conversation message
   */
  ConversationMessage get(String messageId, MessageSource messageSource);

  /**
   * This operation lists all messages sent or received via particular {@link
   * com.sinch.sdk.domains.conversation.models.v1.ProcessingMode}.
   *
   * <p>Setting the <code>messages_source</code> parameter to <code>CONVERSATION_SOURCE</code>
   * allows for querying messages in <code>CONVERSATION</code> mode, and setting it to <code>
   * DISPATCH_SOURCE</code> will allow for queries of messages in DISPATCH mode.
   *
   * <p>Combining multiple parameters is supported for more detailed filtering of messages, but some
   * of them are not supported depending on the value specified for <code>messages_source</code>.
   * The description for each field will inform if that field may not be supported.
   *
   * <p>The messages are ordered by their <code>accept_time</code> property in descending order,
   * where <code>accept_time</code> is a timestamp of when the message was enqueued by the
   * Conversation API. This means messages received most recently will be listed first.
   *
   * @param request Request parameters
   * @return List of messages
   * @since 1.3
   */
  MessagesListResponse list(MessagesListRequest request);

  /**
   * Helper method for {@link #delete(String, MessageSource)}
   *
   * @see #delete(String, MessageSource)
   * @param messageId The unique ID of the message.
   */
  void delete(String messageId);

  /**
   * Delete a specific message by its ID.
   *
   * @apiNote Removing all messages of a conversation will not automatically delete the
   *     conversation.
   * @param messageId The unique ID of the message.
   * @param messageSource Specifies the message source for which the request will be processed. Used
   *     for operations on messages in Dispatch Mode. For more information, see <a
   *     href="https://developers.sinch.com/docs/conversation/processing-modes">Processing Modes</a>
   * @default <code>CONVERSATION_SOURCE</code>
   */
  void delete(String messageId, MessageSource messageSource);

  /**
   * Helper method for {@link #update(String, MessageSource, MessageUpdateRequest)}
   *
   * @see #update(String, MessageSource, MessageUpdateRequest)
   * @param messageId The unique ID of the message.
   * @param request Request parameters to be used for updating
   * @return Updated message
   */
  ConversationMessage update(String messageId, MessageUpdateRequest request);

  /**
   * Update a specific message by its ID.
   *
   * @param messageId The unique ID of the message
   * @param messageSource Specifies the message source for which the request will be processed. Used
   *     for operations on messages in Dispatch Mode. For more information, see <a
   *     href="https://developers.sinch.com/docs/conversation/processing-modes">Processing Modes</a>
   * @default <code>CONVERSATION_SOURCE</code>
   * @param request Request parameters to be used for updating
   * @return Updated message
   */
  ConversationMessage update(
      String messageId, MessageSource messageSource, MessageUpdateRequest request);

  /**
   * Specifies the message source for which the request will be processed. Used for operations on
   * messages in Dispatch Mode
   */
  enum MessageSource {
    /**
     * The default messages source. Retrieves messages sent in the default <code>CONVERSATION</code>
     * processing mode, which associates the messages with a specific conversation and contact.
     */
    CONVERSATION_SOURCE,
    /**
     * Retrieves messages sent in the <code>DISPATCH</code> processing mode. These types of messages
     * are not associated with any conversation or contact.
     */
    DISPATCH_SOURCE
  }
}
