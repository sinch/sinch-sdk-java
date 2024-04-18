package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface WhatsAppInteractiveHeaderVideo
    extends WhatsAppInteractiveHeaderMediaBase, WhatsAppInteractiveHeader {

  static Builder builder() {
    return WhatsAppInteractiveHeaderVideoImpl.builder();
  }

  /** Dedicated Builder */
  interface Builder extends WhatsAppInteractiveHeaderMediaBase.Builder<Builder> {

    WhatsAppInteractiveHeaderVideo build();
  }
}
