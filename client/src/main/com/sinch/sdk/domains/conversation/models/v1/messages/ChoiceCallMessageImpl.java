package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.sinch.sdk.core.models.OptionalValue;

public class ChoiceCallMessageImpl extends ChoiceImpl<CallMessage> implements ChoiceCallMessage {

  private ChoiceCallMessageImpl(
      OptionalValue<CallMessage> message, OptionalValue<Object> postbackData) {
    super(message, postbackData);
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder builder() {
    return new Builder();
  }

  /** Dedicated Builder */
  public static class Builder extends ChoiceImpl.Builder<CallMessage>
      implements ChoiceCallMessage.Builder {}
}
