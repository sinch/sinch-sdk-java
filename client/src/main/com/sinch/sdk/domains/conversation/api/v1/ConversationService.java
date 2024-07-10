package com.sinch.sdk.domains.conversation.api.v1;

/**
 * Conversation Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/">https://developers.sinch.com/docs/conversation/</a>
 * @since 1.0
 */
public interface ConversationService {

  /**
   * Applications Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  AppService app();

  /**
   * Contact Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  ContactService contact();

  /**
   * Messages Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  MessagesService messages();
}
