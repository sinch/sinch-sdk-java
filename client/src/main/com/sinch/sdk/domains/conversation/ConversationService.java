package com.sinch.sdk.domains.conversation;

import com.sinch.sdk.domains.conversation.api.templates.TemplatesService;

/**
 * Conversation Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/">https://developers.sinch.com/docs/conversation/</a>
 * @since 1.3
 */
public interface ConversationService {

  /**
   * Conversation Service V1
   *
   * @return V1 service instance for project
   * @see <a
   *     href="https://developers.sinch.com/docs/conversation/sdk/java/syntax-reference">Documentation</a>
   * @since 1.3
   */
  com.sinch.sdk.domains.conversation.api.v1.ConversationService v1();

  /**
   * Templates service
   *
   * <p>The Template Management API offers a way to manage templates that can be used together with
   * the Conversation API.
   *
   * <p>Note that you may also use the Message Composer tool on the Sinch Customer Dashboard to
   * manage templates.
   *
   * @return Service instance for project
   * @see <a
   *     href="https://developers.sinch.com/docs/conversation/api-reference/template/overview/#section/Managing-templates">Documentation</a>
   * @since 1.3
   */
  TemplatesService templates();
}
