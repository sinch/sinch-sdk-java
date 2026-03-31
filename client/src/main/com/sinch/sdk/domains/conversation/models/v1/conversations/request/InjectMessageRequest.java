package com.sinch.sdk.domains.conversation.models.v1.conversations.request;

import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessageBody;

/** Message to be injected */
public interface InjectMessageRequest extends InjectMessageRequestBase {

  /**
   * Get message body
   *
   * @return Body message
   */
  ConversationMessageBody getBody();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  @SuppressWarnings("rawtypes")
  static Builder<?> builder() {
    return new InjectMessageRequestImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder<B extends Builder<B>> extends InjectMessageRequestBase.Builder<B> {

    /**
     * see getter
     *
     * @param body see getter
     * @return Current builder
     * @see #getBody()
     */
    B setBody(ConversationMessageBody body);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    InjectMessageRequest build();
  }
}
