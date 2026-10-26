package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.destination.CallDestination;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.AnswerCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.BridgeCallCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.HangupCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.PauseCommand;
import java.util.Objects;

/**
 * Helpers to build the call control SVAML commands
 *
 * @since 2.4
 */
public final class Calls {

  private Calls() {}

  /**
   * Answer the current call leg
   *
   * @return The <code>answer</code> command
   * @since 2.4
   */
  public static AnswerCommand answer() {
    return AnswerCommand.ANSWER_COMMAND;
  }

  /**
   * Join a bridge, created if no bridge with this name exists in the session
   *
   * @param name Name of the bridge, sent as <code>bridgeName</code>
   * @return The <code>bridgeCall</code> command
   * @since 2.4
   */
  public static BridgeCallCommand bridgeCall(String name) {
    Objects.requireNonNull(name, "name must not be null");
    return BridgeCallCommand.builder().setBridgeName(name).build();
  }

  /**
   * Start a new outbound call leg
   *
   * @param to Call destination
   * @return The creator of the <code>dial</code> command
   * @since 2.4
   */
  public static DialCreator dial(CallDestination to) {
    return new DialCreator(to);
  }

  /**
   * Start a new outbound call leg
   *
   * @param to Call destination, parsed with {@link Destination#of(String)}
   * @return The creator of the <code>dial</code> command
   * @since 2.4
   */
  public static DialCreator dial(String to) {
    return new DialCreator(Destination.of(to));
  }

  /**
   * End the current call leg
   *
   * @return The <code>hangup</code> command
   * @since 2.4
   */
  public static HangupCommand hangup() {
    return HangupCommand.HANGUP_COMMAND;
  }

  /**
   * End a call leg
   *
   * @param name Name of the call leg to end, sent as <code>callName</code>
   * @return The <code>hangup</code> command
   * @since 2.4
   */
  public static HangupCommand hangup(String name) {
    Objects.requireNonNull(name, "name must not be null");
    return HangupCommand.builder().setCallName(name).build();
  }

  /**
   * Delay the next command in the sequence. The call audio is not affected
   *
   * @param durationMilliseconds Duration of the pause in milliseconds
   * @return The <code>pause</code> command
   * @since 2.4
   */
  public static PauseCommand pause(int durationMilliseconds) {
    return PauseCommand.builder().setDurationMilliseconds(durationMilliseconds).build();
  }
}
