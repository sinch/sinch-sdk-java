package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface AppChoiceMessage extends AppMessage<ChoiceMessage> {

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return new AppChoiceMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder extends AppMessage.Builder<ChoiceMessage> {}
}
