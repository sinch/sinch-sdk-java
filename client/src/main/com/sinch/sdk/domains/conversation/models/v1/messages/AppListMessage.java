package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface AppListMessage extends AppMessage<ListMessage> {

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return new AppListMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder extends AppMessage.Builder<ListMessage> {}
}
