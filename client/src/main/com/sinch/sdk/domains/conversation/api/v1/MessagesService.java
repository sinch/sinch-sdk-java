package com.sinch.sdk.domains.conversation.api.v1;

import com.sinch.sdk.domains.conversation.models.v1.messages.CardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.CarouselMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactInfoMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ListMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.TemplateMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.SendMessageResponse;
import com.sinch.sdk.domains.conversation.models.v1.response.ConversationMessage;

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
 * @since _NEXT_VERSION_
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
   * @since _NEXT_VERSION_
   */
  SendMessageResponse sendCardMessage(SendMessageRequest<CardMessage> request);

  SendMessageResponse sendCarouselMessage(SendMessageRequest<CarouselMessage> request);

  SendMessageResponse sendChoiceMessage(SendMessageRequest<ChoiceMessage> request);

  SendMessageResponse sendContactInfoMessage(SendMessageRequest<ContactInfoMessage> request);

  SendMessageResponse sendListMessage(SendMessageRequest<ListMessage> request);

  SendMessageResponse sendLocationMessage(SendMessageRequest<LocationMessage> request);

  SendMessageResponse sendMediaMessage(SendMessageRequest<MediaMessage> request);

  SendMessageResponse sendTemplateMessage(SendMessageRequest<TemplateMessage> request);

  SendMessageResponse sendTextMessage(SendMessageRequest<TextMessage> request);

  ConversationMessage get(String messageId);

  // ConversationMessage get(String messageId, MessageSource );
}
