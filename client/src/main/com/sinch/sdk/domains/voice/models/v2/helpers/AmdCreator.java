package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.amd.AmdCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.amd.AmdEvents;
import java.util.Collection;
import java.util.List;

/**
 * Fluent creator of an <code>amd</code> command, returned by {@link Amd#activate()}
 *
 * <p>Calling an event handler more than once appends the commands.
 *
 * @since 2.4
 */
public final class AmdCreator {

  private List<SvamlCommand> onHuman;
  private List<SvamlCommand> onMachine;
  private List<SvamlCommand> onBeep;
  private List<SvamlCommand> onUnknown;

  AmdCreator() {}

  /**
   * Add commands to run when a human answers
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public AmdCreator onHuman(SvamlCommand... commands) {
    onHuman = Commands.append(onHuman, commands);
    return this;
  }

  /**
   * Add commands to run when a human answers
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public AmdCreator onHuman(Collection<? extends SvamlCommand> commands) {
    onHuman = Commands.append(onHuman, commands);
    return this;
  }

  /**
   * Add commands to run when a machine answers
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public AmdCreator onMachine(SvamlCommand... commands) {
    onMachine = Commands.append(onMachine, commands);
    return this;
  }

  /**
   * Add commands to run when a machine answers
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public AmdCreator onMachine(Collection<? extends SvamlCommand> commands) {
    onMachine = Commands.append(onMachine, commands);
    return this;
  }

  /**
   * Add commands to run when a beep is detected
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public AmdCreator onBeep(SvamlCommand... commands) {
    onBeep = Commands.append(onBeep, commands);
    return this;
  }

  /**
   * Add commands to run when a beep is detected
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public AmdCreator onBeep(Collection<? extends SvamlCommand> commands) {
    onBeep = Commands.append(onBeep, commands);
    return this;
  }

  /**
   * Add commands to run when the result is unknown
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public AmdCreator onUnknown(SvamlCommand... commands) {
    onUnknown = Commands.append(onUnknown, commands);
    return this;
  }

  /**
   * Add commands to run when the result is unknown
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public AmdCreator onUnknown(Collection<? extends SvamlCommand> commands) {
    onUnknown = Commands.append(onUnknown, commands);
    return this;
  }

  /**
   * Build the <code>amd</code> command
   *
   * @return The command. Its <code>events</code> are only set when a handler was given
   * @since 2.4
   */
  public AmdCommand build() {
    AmdCommand.Builder builder = AmdCommand.builder();
    if (null != onHuman || null != onMachine || null != onBeep || null != onUnknown) {
      builder.setEvents(buildEvents());
    }
    return builder.build();
  }

  private AmdEvents buildEvents() {
    AmdEvents.Builder builder = AmdEvents.builder();
    if (null != onHuman) {
      builder.setOnHuman(Commands.copy(onHuman));
    }
    if (null != onMachine) {
      builder.setOnMachine(Commands.copy(onMachine));
    }
    if (null != onBeep) {
      builder.setOnBeep(Commands.copy(onBeep));
    }
    if (null != onUnknown) {
      builder.setOnUnknown(Commands.copy(onUnknown));
    }
    return builder.build();
  }
}
