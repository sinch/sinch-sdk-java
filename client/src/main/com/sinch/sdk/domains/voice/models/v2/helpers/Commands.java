package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/** Collects the commands given to the event handlers of the creators */
final class Commands {

  private Commands() {}

  /**
   * Append commands to a list, creating it on first use. Calling with no command still creates the
   * list, so an explicitly empty handler is sent as an empty list.
   */
  static List<SvamlCommand> append(List<SvamlCommand> current, SvamlCommand... commands) {
    Objects.requireNonNull(commands, "commands must not be null");
    return append(current, Arrays.asList(commands));
  }

  static List<SvamlCommand> append(
      List<SvamlCommand> current, Collection<? extends SvamlCommand> commands) {
    Objects.requireNonNull(commands, "commands must not be null");
    List<SvamlCommand> list = null == current ? new ArrayList<>() : current;
    for (SvamlCommand command : commands) {
      list.add(Objects.requireNonNull(command, "command must not be null"));
    }
    return list;
  }

  /** Append the commands added by a lambda to a new sequence */
  static List<SvamlCommand> append(
      List<SvamlCommand> current, Consumer<CommandsSequenceCreator> sequence) {
    Objects.requireNonNull(sequence, "sequence must not be null");
    CommandsSequenceCreator creator = new CommandsSequenceCreator();
    sequence.accept(creator);
    return append(current, creator.commands());
  }

  /** Copy taken at build time, so a creator reused after <code>build()</code> does not alias it */
  static List<SvamlCommand> copy(List<SvamlCommand> commands) {
    return null == commands ? null : new ArrayList<>(commands);
  }
}
