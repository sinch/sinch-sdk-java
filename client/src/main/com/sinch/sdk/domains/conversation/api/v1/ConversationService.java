package com.sinch.sdk.domains.conversation.api.v1;

/**
 * Conversation Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/">https://developers.sinch.com/docs/conversation/</a>
 * @since 1.3
 */
public interface ConversationService {

  /**
   * Applications Service instance
   *
   * @return service instance for project
   * @since 1.3
   */
  AppService app();

  /**
   * Contact Service instance
   *
   * @return service instance for project
   * @since 1.3
   */
  ContactService contact();

  /**
   * Messages Service instance
   *
   * @return service instance for project
   * @since 1.3
   */
  MessagesService messages();

  /**
   * Conversations Service instance
   *
   * @return service instance for project
   * @since 1.3
   */
  ConversationsService conversations();

  /**
   * Events Service instance
   *
   * @return service instance for project
   * @since 1.3
   */
  EventsService events();

  /**
   * Transcoding Service instance
   *
   * @return service instance for project
   * @since 1.3
   */
  TranscodingService transcoding();

  /**
   * Capability Service instance
   *
   * @return service instance for project
   * @since 1.3
   */
  CapabilityService capability();

  /**
   * WebHooksService Service instance
   *
   * @return service instance for project
   * @since 1.3
   */
  WebHooksService webhooks();
}
