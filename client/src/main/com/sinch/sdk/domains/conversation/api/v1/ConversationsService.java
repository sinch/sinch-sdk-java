package com.sinch.sdk.domains.conversation.api.v1;

import com.sinch.sdk.domains.conversation.models.v1.conversation.Conversation;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.ConversationsListRecentRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.ConversationsListRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.CreateConversationRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.InjectEventRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.InjectMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.response.ConversationsListRecentResponse;
import com.sinch.sdk.domains.conversation.models.v1.conversation.response.ConversationsListResponse;
import com.sinch.sdk.domains.conversation.models.v1.conversation.response.InjectEventResponse;
import com.sinch.sdk.domains.conversation.models.v1.request.MetadataUpdateStrategy;

/**
 * Service for working with the conversation log
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Conversation">online
 *     documentation</a>
 * @since _NEXT_VERSION_
 */
public interface ConversationsService {

  /**
   * Creates a new empty conversation.
   *
   * <p>It is generally not needed to create a conversation explicitly since sending or receiving a
   * message automatically creates a new conversation if it does not already exist between the given
   * app and contact.
   *
   * <p>Creating empty conversation is useful if the metadata of the conversation should be
   * populated when the first message in the conversation is a contact message or the first message
   * in the conversation comes out-of-band and needs to be injected with InjectMessage.
   *
   * @param request Conversation request for creation
   * @return Created conversation
   * @since _NEXT_VERSION_
   */
  Conversation create(CreateConversationRequest request);

  /**
   * Retrieves a conversation by id. A conversation has two participating entities, an app and a
   * contact.
   *
   * @param conversationId The unique ID of the conversation.
   * @return Conversation details
   * @since _NEXT_VERSION_
   */
  Conversation get(String conversationId);

  /**
   * This operation lists all conversations that are associated with an app and/or a contact.
   *
   * @param request Request parameters
   * @since _NEXT_VERSION_
   */
  ConversationsListResponse list(ConversationsListRequest request);

  /**
   * This operation lists conversations and their most recent message, ordered by when the most
   * recent message was sent for that conversation.
   *
   * @param request Request parameters
   * @since _NEXT_VERSION_
   */
  ConversationsListRecentResponse listRecent(ConversationsListRecentRequest request);

  /**
   * This operation stops the referenced conversation, if the conversation is still active.
   *
   * <p>A new conversation will be created if a new message is exchanged between the app or contact
   * that was part of the stopped conversation.
   *
   * @param conversationId The unique ID of the conversation.
   * @since _NEXT_VERSION_
   */
  void stopActive(String conversationId);

  /**
   * Deletes a conversation together with all the messages sent as part of the conversation.
   *
   * @param conversationId The unique ID of the conversation.
   * @since _NEXT_VERSION_
   */
  void delete(String conversationId);

  /**
   * This operation updates a conversation which can, for instance, be used to update the metadata
   * associated with a conversation.
   *
   * @param request Conversation instance with fields to be updated
   * @return Update conversation
   * @since _NEXT_VERSION_
   */
  Conversation update(
      String conversationId, MetadataUpdateStrategy updateStrategy, Conversation request);

  /**
   * This operation injects a conversation message in to a specific conversation.
   *
   * @param conversationId The ID of the conversation.
   * @param request Request parameters to inject message
   * @since _NEXT_VERSION_
   */
  void injectMessage(String conversationId, InjectMessageRequest request);

  /**
   * This operation injects a conversation event into a specific conversation.
   *
   * @param conversationId The ID of the conversation.
   * @param request Request parameters to inject event
   * @since _NEXT_VERSION_
   */
  InjectEventResponse injectEvent(String conversationId, InjectEventRequest request);
}
