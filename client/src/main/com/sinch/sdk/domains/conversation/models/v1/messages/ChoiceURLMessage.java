package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface ChoiceURLMessage extends Choice<UrlMessage> {

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return new ChoiceURLMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder extends Choice.Builder<UrlMessage> {}
}
