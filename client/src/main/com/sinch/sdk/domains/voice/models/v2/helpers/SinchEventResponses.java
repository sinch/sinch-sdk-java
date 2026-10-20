package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventResponse;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * Helpers to build the response returned to a Voice V2 Sinch Event
 *
 * <p>Serialize the response with the <code>serializeResponse</code> method of the Sinch Events
 * service.
 *
 * @since 2.4
 */
public final class SinchEventResponses {

  private SinchEventResponses() {}

  /**
   * Build the response to a <code>call.incoming</code> event, which can also name the call and set
   * the commands to run when it is hung up
   *
   * @param commands Commands to run
   * @return The creator of the response
   * @since 2.4
   */
  public static IncomingCallResponseCreator incomingCallResponse(SvamlCommand... commands) {
    return new IncomingCallResponseCreator(Commands.append(null, commands));
  }

  /**
   * Build the response to a <code>call.incoming</code> event
   *
   * @param commands Commands to run
   * @return The creator of the response
   * @see #incomingCallResponse(SvamlCommand...)
   * @since 2.4
   */
  public static IncomingCallResponseCreator incomingCallResponse(
      Collection<? extends SvamlCommand> commands) {
    return new IncomingCallResponseCreator(Commands.append(null, commands));
  }

  /**
   * Build the response to a <code>call.incoming</code> event
   *
   * @param sequence Lambda adding the commands to run
   * @return The creator of the response
   * @see #incomingCallResponse(SvamlCommand...)
   * @since 2.4
   */
  public static IncomingCallResponseCreator incomingCallResponse(
      Consumer<CommandsSequenceCreator> sequence) {
    return new IncomingCallResponseCreator(Commands.append(null, sequence));
  }

  /**
   * Build the response to any other event: only the commands are taken into account
   *
   * @param commands Commands to run
   * @return The response
   * @throws IllegalStateException if a <code>gotoMenu</code> command is outside a menu, or if a
   *     menu has a start menu or a <code>gotoMenu</code> target that is not one of its items
   * @since 2.4
   */
  public static VoiceSinchEventResponse response(SvamlCommand... commands) {
    return response(Commands.append(null, commands));
  }

  /**
   * Build the response to any other event: only the commands are taken into account
   *
   * @param commands Commands to run
   * @return The response
   * @throws IllegalStateException if a <code>gotoMenu</code> command is outside a menu, or if a
   *     menu has a start menu or a <code>gotoMenu</code> target that is not one of its items
   * @since 2.4
   */
  public static VoiceSinchEventResponse response(Collection<? extends SvamlCommand> commands) {
    List<SvamlCommand> list = Commands.append(null, commands);
    MenuCreator.checkGotoTargets(list, Collections.emptySet());
    return VoiceSinchEventResponse.builder().setCommands(list).build();
  }

  /**
   * Build the response to any other event: only the commands are taken into account
   *
   * @param sequence Lambda adding the commands to run
   * @return The response
   * @throws IllegalStateException if a <code>gotoMenu</code> command is outside a menu, or if a
   *     menu has a start menu or a <code>gotoMenu</code> target that is not one of its items
   * @since 2.4
   */
  public static VoiceSinchEventResponse response(Consumer<CommandsSequenceCreator> sequence) {
    return response(Commands.append(null, sequence));
  }
}
