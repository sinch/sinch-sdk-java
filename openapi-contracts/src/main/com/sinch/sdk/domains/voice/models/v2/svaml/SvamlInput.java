package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

/**
 * A SVAML v2 (Sinch Voice Application Markup Language) document describing a call flow. Contains
 * the ordered list of commands to execute, an optional call name, and optional event handlers.
 */
@JsonDeserialize(builder = SvamlInputImpl.Builder.class)
public interface SvamlInput {

  /**
   * The ordered list of SVAML commands to execute. Contains at least one command.
   *
   * <p>Blocking vs. non-blocking: Some commands block execution until they complete (<code>pause
   * </code>, <code>webhook</code>, <code>menu</code>, <code>gotoMenu</code>), while others return
   * immediately and run in parallel (<code>dial</code>, <code>messages</code>, <code>amd</code>,
   * <code>answer</code>, <code>hangup</code>, <code>startRecording</code>, <code>stopRecording
   * </code>, <code>bridgeCall</code>, <code>stopMessages</code>). Each command's description
   * specifies its behavior.
   *
   * <p>Nesting scope: Commands that appear inside event handlers (e.g., <code>dial.events.onAnswer
   * </code>, <code>messages.events.onFinish</code>) form independent sequences and execute in their
   * own context — they are not continuations of the parent sequence.
   *
   * <p>Field is required
   *
   * @return commands
   */
  List<SvamlCommand> getCommands();

  /**
   * Name of the call.
   *
   * <p>Must be 1-32 characters, without whitespace.
   *
   * @return callName
   */
  String getCallName();

  /**
   * Commands to execute on specific events for this call.
   *
   * @return events
   */
  IncomingCallResponseEvents getEvents();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SvamlInputImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param commands see getter
     * @return Current builder
     * @see #getCommands
     */
    Builder setCommands(List<SvamlCommand> commands);

    /**
     * see getter
     *
     * @param callName see getter
     * @return Current builder
     * @see #getCallName
     */
    Builder setCallName(String callName);

    /**
     * see getter
     *
     * @param events see getter
     * @return Current builder
     * @see #getEvents
     */
    Builder setEvents(IncomingCallResponseEvents events);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SvamlInput build();
  }
}
