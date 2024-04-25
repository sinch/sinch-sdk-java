package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface WhatsAppInteractiveHeaderText extends WhatsAppInteractiveHeader {

  String getText();

  static Builder builder() {
    return WhatsAppInteractiveHeaderTextImpl.builder();
  }

  /** Dedicated Builder */
  interface Builder {

    Builder setText(String text);

    WhatsAppInteractiveHeaderText build();
  }
}
