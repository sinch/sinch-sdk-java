package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows;

import com.sinch.sdk.core.models.OptionalValue;

public class WhatsAppInteractiveHeaderVideoImpl extends WhatsAppInteractiveHeaderMediaBaseImpl
    implements WhatsAppInteractiveHeaderVideo {

  public WhatsAppInteractiveHeaderVideoImpl(OptionalValue<WhatsAppInteractiveHeaderMedia> media) {
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
      implements WhatsAppInteractiveHeaderVideo.Builder {

    public WhatsAppInteractiveHeaderVideo build() {
      return new WhatsAppInteractiveHeaderVideoImpl(media);
    }
  }
}
