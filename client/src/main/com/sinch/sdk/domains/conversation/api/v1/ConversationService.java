package com.sinch.sdk.domains.conversation.api.v1;

import com.sinch.sdk.domains.conversation.templates.api.TemplatesService;

/**
 * Conversation Service V1
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
  AppsService apps();

  /**
   * Contact Service instance
   *
   * @return service instance for project
   * @since 1.3
   */
  ContactsService contacts();

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
   * ProjectSettings Service instance
   *
   * @return service instance for project
   * @since 2.0
   */
  ProjectSettingsService projectSettings();

  /**
   * WebHooksService Service instance
   *
   * @return service instance for project
   * @since 1.3
   */
  WebhooksService webhooks();

  /**
   * Templates Service instance
   *
   * @return service instance for project
   * @since 2.0
   */
  TemplatesService templates();
}
