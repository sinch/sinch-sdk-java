package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface AppTextMessage extends AppMessage<TextMessage> {

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return new AppTextMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder extends AppMessage.Builder<TextMessage> {}
}
