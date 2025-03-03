package com.sinch.sdk.domains.conversation.models.v1.messages.types.card;

import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;

/**
 * Deprecated class, use
 *
 * @deprecated use {@link
 *     com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage} instead.
 */
@Deprecated
public interface CardMessageMedia extends MediaMessage {
  /**
   * Getting builder
   *
   * @return New Builder instance
   * @deprecated use {@link MediaMessage#builder()} instead.
   */
  @Deprecated
  static Builder builder() {
    return new CardMessageMediaImpl.Builder();
  }

  /**
   * @deprecated use {@link MediaMessage.Builder} instead.
   */
  @Deprecated
  interface Builder extends MediaMessage.Builder {}
}
