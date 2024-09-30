package com.sinch.sdk.domains.conversation.models.v1.messages.types.choice;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.url.UrlMessage;

public class ChoiceURLMessageImpl extends ChoiceImpl<UrlMessage> implements ChoiceURLMessage {

  private ChoiceURLMessageImpl(
      OptionalValue<UrlMessage> message, OptionalValue<Object> postbackData) {
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
  public static class Builder extends ChoiceImpl.Builder<UrlMessage>
      implements ChoiceURLMessage.Builder {}
}
