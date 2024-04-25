package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface WhatsAppInteractiveHeaderMediaBase {

  WhatsAppInteractiveHeaderMedia getMedia();

  /** Dedicated Builder */
  interface Builder<B extends Builder<B>> {

    B setMedia(WhatsAppInteractiveHeaderMedia media);
  }
}
