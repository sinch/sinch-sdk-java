package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

/** Prompt configuration for menu playback, including prompt messages and barge-in behavior. */
@JsonDeserialize(builder = MenuPromptImpl.Builder.class)
public interface MenuPrompt {

  /**
   * Controls whether input can interrupt prompt playback.
   *
   * <p>When enabled, playback stops as soon as input is detected and the input is evaluated
   * immediately if matching conditions are met.
   *
   * <p>When disabled, input is still collected during playback and evaluated after playback
   * finishes.
   *
   * @return allowBargeIn
   */
  Boolean getAllowBargeIn();

  /**
   * Ordered list of messages to play.
   *
   * <p>Field is required
   *
   * @return messages
   */
  List<Message> getMessages();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new MenuPromptImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param allowBargeIn see getter
     * @return Current builder
     * @see #getAllowBargeIn
     */
    Builder setAllowBargeIn(Boolean allowBargeIn);

    /**
     * see getter
     *
     * @param messages see getter
     * @return Current builder
     * @see #getMessages
     */
    Builder setMessages(List<Message> messages);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    MenuPrompt build();
  }
}
