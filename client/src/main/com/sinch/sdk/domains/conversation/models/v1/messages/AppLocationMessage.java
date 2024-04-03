package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface AppLocationMessage extends AppMessage<LocationMessage> {

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return new AppLocationMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder extends AppMessage.Builder<LocationMessage> {}
}
