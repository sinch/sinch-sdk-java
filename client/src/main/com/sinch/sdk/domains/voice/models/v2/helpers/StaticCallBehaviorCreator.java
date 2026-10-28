package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.services.StaticCallBehavior;
import com.sinch.sdk.domains.voice.models.v2.svaml.IncomingCallResponseEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlInput;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Fluent creator of a <code>STATIC</code> service call behavior
 *
 * <p>Returned by {@link CallBehaviorHelper#staticBehavior(SvamlCommand...)}.
 *
 * <p>Calling {@link #onHangup} more than once appends the commands.
 *
 * @since 2.4
 */
public final class StaticCallBehaviorCreator {

  private final List<SvamlCommand> commands;
  private String name;
  private List<SvamlCommand> onHangup;

  StaticCallBehaviorCreator(List<SvamlCommand> commands) {
    this.commands = commands;
  }

  /**
   * Set the name of the call, sent as <code>callName</code>
   *
   * @param name Name of the call, 1 to 32 characters without spaces
   * @return This creator
   * @since 2.4
   */
  public StaticCallBehaviorCreator name(String name) {
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
  public StaticCallBehaviorCreator onHangup(SvamlCommand... commands) {
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
  public StaticCallBehaviorCreator onHangup(Collection<? extends SvamlCommand> commands) {
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
  public StaticCallBehaviorCreator onHangup(Consumer<CommandsSequenceCreator> sequence) {
    onHangup = Commands.append(onHangup, sequence);
    return this;
  }

  /**
   * Build the call behavior
   *
   * @return The <code>STATIC</code> call behavior
   * @throws IllegalStateException if a <code>gotoMenu</code> command is outside a menu, or if a
   *     menu has a start menu or a <code>gotoMenu</code> target that is not one of its items
   * @since 2.4
   */
  public StaticCallBehavior build() {
    MenuCreator.checkGotoTargets(commands, Collections.emptySet());
    MenuCreator.checkGotoTargets(onHangup, Collections.emptySet());
    SvamlInput.Builder svaml = SvamlInput.builder().setCommands(Commands.copy(commands));
    if (null != name) {
      svaml.setCallName(name);
    }
    if (null != onHangup) {
      svaml.setEvents(
          IncomingCallResponseEvents.builder().setOnHangup(Commands.copy(onHangup)).build());
    }
    return StaticCallBehavior.builder().setStatic(svaml.build()).build();
  }
}
