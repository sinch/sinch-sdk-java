package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface AppCardMessage extends AppMessage<CardMessage> {

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return new AppCardMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder extends AppMessage.Builder<CardMessage> {}
}
