package com.sinch.sdk.domains.voice.models.v2.svaml.calls;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;

/**
 * Ends a call leg. This is a non-blocking command — execution continues to the next command in the
 * sequence even though the call has been ended. The <code>onHangup</code> event is triggered for
 * the call leg that was ended.
 *
 * <p>Any subsequent commands that target the ended call leg (such as <code>messages</code> or other
 * media commands) are valid but will not be executed. Commands that operate independently — such as
 * initiating a new call with <code>dial</code> — will execute normally. This makes it possible, for
 * example, to end one call and immediately start another within the same sequence.
 */
@JsonDeserialize(builder = HangupCommandImpl.Builder.class)
public interface HangupCommand extends SvamlCommand {

  /**
   * Name of the call leg to end, as set by <code>callName</code> in the <code>dial</code> command.
   *
   * <p>If omitted, the current call leg is ended.
   *
   * @return callName
   */
  String getCallName();

  /** Hangup command for the current call leg, to be used instead of building an empty one */
  HangupCommand HANGUP_COMMAND = HangupCommand.builder().build();

  /**
   * Create a hangup command for the given call leg
   *
   * @param callName see {@link #getCallName()}
   * @return A new HangupCommand
   */
  static HangupCommand of(String callName) {
    return builder().setCallName(callName).build();
  }

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new HangupCommandImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param callName see getter
     * @return Current builder
     * @see #getCallName
     */
    Builder setCallName(String callName);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    HangupCommand build();
  }
}
