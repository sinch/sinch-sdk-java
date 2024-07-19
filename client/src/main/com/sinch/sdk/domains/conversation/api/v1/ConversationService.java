package com.sinch.sdk.domains.conversation.api.v1;

/**
 * Conversation Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/">https://developers.sinch.com/docs/conversation/</a>
 * @since _NEXT_VERSION_
 */
public interface ConversationService {

  /**
   * Applications Service instance
   *
   * @return service instance for project
   * @since _NEXT_VERSION_
   */
  AppService app();

  /**
   * Contact Service instance
   *
   * @return service instance for project
   * @since _NEXT_VERSION_
   */
  ContactService contact();

  /**
   * Messages Service instance
   *
   * @return service instance for project
   * @since_NEXT_VERSION_
   */
  MessagesService messages();
}
