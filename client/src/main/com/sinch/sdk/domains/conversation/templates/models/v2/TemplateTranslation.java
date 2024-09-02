package com.sinch.sdk.domains.conversation.templates.models.v2;

import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageBody;

/** Message to be injected */
public interface TemplateTranslation extends TemplateTranslationBase {

  /**
   * Get translation message
   *
   * @return Body message
   */
  AppMessageBody getMessage();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  @SuppressWarnings("rawtypes")
  static Builder<?> builder() {
    return new TemplateTranslationImpl.Builder();
  }

  static TemplateTranslation from(TemplateTranslationBase from) {
    return new TemplateTranslationImpl(from);
  }

  /** Dedicated Builder */
  interface Builder<B extends Builder<B>> extends TemplateTranslationBase.Builder<B> {

    /**
     * see getter
     *
     * @param message see getter
     * @return Current builder
     * @see #getMessage()
     */
    B setMessage(AppMessageBody message);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    TemplateTranslation build();
  }
}
