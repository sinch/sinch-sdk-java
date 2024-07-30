package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows;

import com.sinch.sdk.core.models.OptionalValue;

public class WhatsAppInteractiveHeaderTextImpl
    implements WhatsAppInteractiveHeaderText, WhatsAppInteractiveHeader {

  private final OptionalValue<String> text;

  public WhatsAppInteractiveHeaderTextImpl(OptionalValue<String> text) {
    this.text = text;
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

  @Override
  public String getText() {
    return text.orElse(null);
  }

  public OptionalValue<String> text() {
    return text;
  }

  @Override
  public String toString() {
    return "WhatsAppInteractiveHeaderTextImpl{" + "text=" + text + '}';
  }

  /** Dedicated Builder */
  public static class Builder implements WhatsAppInteractiveHeaderText.Builder {

    OptionalValue<String> text = OptionalValue.empty();

    public Builder setText(String text) {
      this.text = OptionalValue.of(text);
      return this;
    }

    public WhatsAppInteractiveHeaderText build() {
      return new WhatsAppInteractiveHeaderTextImpl(text);
    }
  }
}
