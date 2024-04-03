package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface AppMediaMessage extends AppMessage<MediaMessage> {

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return new AppMediaMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder extends AppMessage.Builder<MediaMessage> {}
}
