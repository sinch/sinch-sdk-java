package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows;

import com.sinch.sdk.core.models.OptionalValue;

public class WhatsAppInteractiveHeaderMediaBaseImpl implements WhatsAppInteractiveHeaderMediaBase {

  private final OptionalValue<WhatsAppInteractiveHeaderMedia> media;

  public WhatsAppInteractiveHeaderMediaBaseImpl(
      OptionalValue<WhatsAppInteractiveHeaderMedia> media) {
    this.media = media;
  }

  @Override
  public WhatsAppInteractiveHeaderMedia getMedia() {
    return media.orElse(null);
  }

  public OptionalValue<WhatsAppInteractiveHeaderMedia> media() {
    return media;
  }

  /** Dedicated Builder */
  public static class Builder<B extends Builder<B>> {
    OptionalValue<WhatsAppInteractiveHeaderMedia> media = OptionalValue.empty();

    protected Builder() {}
    ;

    public B setMedia(WhatsAppInteractiveHeaderMedia media) {
      this.media = OptionalValue.of(media);
      return self();
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
