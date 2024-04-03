package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface AppContactInfoMessage extends AppMessage<ContactInfoMessage> {

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return new AppContactInfoMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder extends AppMessage.Builder<ContactInfoMessage> {}
}
