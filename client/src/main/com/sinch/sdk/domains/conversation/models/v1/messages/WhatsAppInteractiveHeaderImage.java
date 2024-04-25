package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface WhatsAppInteractiveHeaderImage
    extends WhatsAppInteractiveHeaderMediaBase, WhatsAppInteractiveHeader {

  static Builder builder() {
    return WhatsAppInteractiveHeaderImageImpl.builder();
  }

  /** Dedicated Builder */
  interface Builder extends WhatsAppInteractiveHeaderMediaBase.Builder<Builder> {

    WhatsAppInteractiveHeaderImage build();
  }
}
