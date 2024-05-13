package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface ChoiceLocationMessage extends Choice<LocationMessage> {

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return new ChoiceLocationMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder extends Choice.Builder<LocationMessage> {}
}