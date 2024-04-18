package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.WhatsAppInteractiveHeaderImageImpl.Builder;

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
