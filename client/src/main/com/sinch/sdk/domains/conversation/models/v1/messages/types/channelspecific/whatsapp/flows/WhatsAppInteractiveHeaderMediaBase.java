package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows;

public interface WhatsAppInteractiveHeaderMediaBase {

  WhatsAppInteractiveHeaderMedia getMedia();

  /** Dedicated Builder */
  interface Builder<B extends Builder<B>> {

    B setMedia(WhatsAppInteractiveHeaderMedia media);
  }
}
