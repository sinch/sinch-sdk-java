package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface ChoiceTextMessage extends Choice<TextMessage> {

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return new ChoiceTextMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder extends Choice.Builder<TextMessage> {}
}