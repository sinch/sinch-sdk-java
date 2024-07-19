package com.sinch.sdk.domains.conversation;

/**
 * Conversation Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/">https://developers.sinch.com/docs/conversation/</a>
 * @since _NEXT_VERSION_
 */
public interface ConversationService {

  /**
   * Conversation Service V1
   *
   * @return V1 service instance for project
   * @see <a
   *     href="https://developers.sinch.com/docs/conversation/sdk/java/syntax-reference">Documentation</a>
   * @since 1.2
   */
  com.sinch.sdk.domains.conversation.api.v1.ConversationService v1();
}
