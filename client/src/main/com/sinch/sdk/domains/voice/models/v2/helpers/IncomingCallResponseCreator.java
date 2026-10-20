package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventResponse;
import com.sinch.sdk.domains.voice.models.v2.svaml.IncomingCallResponseEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Fluent creator of the response to a <code>call.incoming</code> Sinch Event
 *
 * <p>Returned by {@link SinchEventResponses#incomingCallResponse(SvamlCommand...)}.
 *
 * <p>Calling {@link #onHangup} more than once appends the commands.
 *
 * @since 2.4
 */
public final class IncomingCallResponseCreator {

  private final List<SvamlCommand> commands;
  private String name;
  private List<SvamlCommand> onHangup;

  IncomingCallResponseCreator(List<SvamlCommand> commands) {
    this.commands = commands;
  }

  /**
   * Set the name of the incoming call, sent as <code>callName</code>
   *
   * @param name Name of the call, 1 to 32 characters without spaces
   * @return This creator
   * @since 2.4
   */
  public IncomingCallResponseCreator name(String name) {
    this.name = Objects.requireNonNull(name, "name must not be null");
    return this;
  }

  /**
   * Add commands to run when the call is hung up
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public IncomingCallResponseCreator onHangup(SvamlCommand... commands) {
    onHangup = Commands.append(onHangup, commands);
    return this;
  }

  /**
   * Add commands to run when the call is hung up
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public IncomingCallResponseCreator onHangup(Collection<? extends SvamlCommand> commands) {
    onHangup = Commands.append(onHangup, commands);
    return this;
  }

  /**
   * Add commands to run when the call is hung up
   *
   * @param sequence Lambda adding the commands to append
   * @return This creator
   * @since 2.4
   */
  public IncomingCallResponseCreator onHangup(Consumer<CommandsSequenceCreator> sequence) {
    onHangup = Commands.append(onHangup, sequence);
    return this;
  }

  /**
   * Build the response
   *
   * @return The response, to serialize with the Sinch Events service
   * @throws IllegalStateException if a <code>gotoMenu</code> command is outside a menu, or if a
   *     menu has a start menu or a <code>gotoMenu</code> target that is not one of its items
   * @since 2.4
   */
  public VoiceSinchEventResponse build() {
    MenuCreator.checkGotoTargets(commands, Collections.emptySet());
    MenuCreator.checkGotoTargets(onHangup, Collections.emptySet());
    VoiceSinchEventResponse.Builder builder =
        VoiceSinchEventResponse.builder().setCommands(Commands.copy(commands));
    if (null != name) {
      builder.setCallName(name);
    }
    if (null != onHangup) {
      builder.setEvents(
          IncomingCallResponseEvents.builder().setOnHangup(Commands.copy(onHangup)).build());
    }
    return builder.build();
  }
}
