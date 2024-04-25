package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface ChoiceCallMessage extends Choice<CallMessage> {

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return new ChoiceCallMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder extends Choice.Builder<CallMessage> {}
}
