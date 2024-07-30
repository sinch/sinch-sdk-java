package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows;

import com.sinch.sdk.core.models.OptionalValue;

public class WhatsAppInteractiveHeaderDocumentImpl extends WhatsAppInteractiveHeaderMediaBaseImpl
    implements WhatsAppInteractiveHeaderDocument {

  public WhatsAppInteractiveHeaderDocumentImpl(
      OptionalValue<WhatsAppInteractiveHeaderMedia> media) {
    super(media);
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
  public static class Builder extends WhatsAppInteractiveHeaderMediaBaseImpl.Builder<Builder>
      implements WhatsAppInteractiveHeaderDocument.Builder {

    public WhatsAppInteractiveHeaderDocument build() {
      return new WhatsAppInteractiveHeaderDocumentImpl(media);
    }
  }
}
