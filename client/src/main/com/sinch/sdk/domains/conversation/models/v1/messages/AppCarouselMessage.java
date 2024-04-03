package com.sinch.sdk.domains.conversation.models.v1.messages;

public interface AppCarouselMessage extends AppMessage<CarouselMessage> {

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return new AppCarouselMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder extends AppMessage.Builder<CarouselMessage> {}
}
