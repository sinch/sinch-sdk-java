package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface WhatsAppInteractiveHeaderDocument
    extends WhatsAppInteractiveHeaderMediaBase, WhatsAppInteractiveHeader {

  static Builder builder() {
    return WhatsAppInteractiveHeaderDocumentImpl.builder();
  }

  /** Dedicated Builder */
  interface Builder extends WhatsAppInteractiveHeaderMediaBase.Builder<Builder> {

    WhatsAppInteractiveHeaderDocument build();
  }
}
