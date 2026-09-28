package com.sinch.sdk.domains.voice.models.v2.svaml.playback;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.List;

/**
 * Plays one or more messages on the call. Multiple messages in the array are played sequentially in
 * order.
 *
 * <p>This is a non-blocking command — the next command in the sequence executes immediately while
 * messages play in parallel. Playback outcomes are handled via the <code>events</code> property.
 * The <code>onFinish</code> event can be used to run a command after all messages complete.
 */
@JsonDeserialize(builder = MessagesCommandImpl.Builder.class)
public interface MessagesCommand extends SvamlCommand {

  /**
   * Name of the message for identification and reference within the call session.
   *
   * <p>This name is used to uniquely identify the message and must be unique within the current
   * call session. This name can be referenced in other commands (e.g., <code>stopMessages</code>)
   * to control this specific message.
   *
   * @return messagesName
   */
  String getMessagesName();

  /**
   * Ordered list of messages to play.
   *
   * <p>Field is required
   *
   * @return messages
   */
  List<Message> getMessages();

  /**
   * SVAML commands to execute based on message playback outcomes.
   *
   * @return events
   */
  MessageEvents getEvents();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new MessagesCommandImpl.Builder();
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
     * see getter
     *
     * @param messages see getter
     * @return Current builder
     * @see #getMessages
     */
    Builder setMessages(List<Message> messages);

    /**
     * see getter
     *
     * @param events see getter
     * @return Current builder
     * @see #getEvents
     */
    Builder setEvents(MessageEvents events);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    MessagesCommand build();
  }
}
