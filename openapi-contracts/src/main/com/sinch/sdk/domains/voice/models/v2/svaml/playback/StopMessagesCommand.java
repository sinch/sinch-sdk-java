package com.sinch.sdk.domains.voice.models.v2.svaml.playback;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;

/**
 * Stops a message sequence started by a <code>messages</code> command. It will also cancel any
 * messages with specified <code>messagesName</code> that will appear in the call session in the
 * future.
 *
 * <p>This is a non-blocking command.
 */
@JsonDeserialize(builder = StopMessagesCommandImpl.Builder.class)
public interface StopMessagesCommand extends SvamlCommand {

  /**
   * Name of the message sequence to stop, as set by <code>messagesName</code> in the <code>messages
   * </code> command.
   *
   * <p>Field is required
   *
   * @return messagesName
   */
  String getMessagesName();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new StopMessagesCommandImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param messagesName see getter
     * @return Current builder
     * @see #getMessagesName
     */
    Builder setMessagesName(String messagesName);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    StopMessagesCommand build();
  }
}
