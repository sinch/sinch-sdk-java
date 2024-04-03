package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface AppTemplateMessage extends AppMessage<TemplateMessage> {

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return new AppTemplateMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder extends AppMessage.Builder<TemplateMessage> {}
}
