package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.destination.CallDestination;
import com.sinch.sdk.domains.voice.models.v2.destination.CallOrigin;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.CallEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.DialCommand;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Fluent creator of a <code>dial</code> command, returned by {@link Calls#dial(CallDestination)}
 *
 * <p>Calling an event handler more than once appends the commands.
 *
 * @since 2.4
 */
public final class DialCreator {

  private final CallDestination to;
  private CallOrigin from;
  private String name;
  private Integer timeoutDurationSeconds;
  private Integer maxDurationSeconds;
  private List<SvamlCommand> onAnswer;
  private List<SvamlCommand> onBusy;
  private List<SvamlCommand> onReject;
  private List<SvamlCommand> onTimeout;
  private List<SvamlCommand> onHangup;
  private List<SvamlCommand> onFailure;

  DialCreator(CallDestination to) {
    this.to = Objects.requireNonNull(to, "to must not be null");
  }

  /**
   * Set the call origin
   *
   * @param from Call origin
   * @return This creator
   * @since 2.4
   */
  public DialCreator from(CallOrigin from) {
    this.from = Objects.requireNonNull(from, "from must not be null");
    return this;
  }

  /**
   * Set the call origin from a string, parsed with {@link Destination#of(String)}
   *
   * @param from Call origin, optionally prefixed with its type
   * @return This creator
   * @since 2.4
   */
  public DialCreator from(String from) {
    return from(Destination.of(from));
  }

  /**
   * Set the name of the call leg, sent as <code>callName</code>
   *
   * @param name Name of the call leg, unique within the session
   * @return This creator
   * @since 2.4
   */
  public DialCreator name(String name) {
    this.name = Objects.requireNonNull(name, "name must not be null");
    return this;
  }

  /**
   * Set how long to wait for an answer, sent as <code>dialTimeoutDurationSeconds</code>
   *
   * @param seconds Timeout in seconds
   * @return This creator
   * @since 2.4
   */
  public DialCreator timeoutDurationSeconds(int seconds) {
    this.timeoutDurationSeconds = seconds;
    return this;
  }

  /**
   * Set the maximum duration of the call, sent as <code>maxCallDurationSeconds</code>
   *
   * @param seconds Maximum duration in seconds
   * @return This creator
   * @since 2.4
   */
  public DialCreator maxDurationSeconds(int seconds) {
    this.maxDurationSeconds = seconds;
    return this;
  }

  /**
   * Add commands to run when the call is answered
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public DialCreator onAnswer(SvamlCommand... commands) {
    onAnswer = Commands.append(onAnswer, commands);
    return this;
  }

  /**
   * Add commands to run when the call is answered
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public DialCreator onAnswer(Collection<? extends SvamlCommand> commands) {
    onAnswer = Commands.append(onAnswer, commands);
    return this;
  }

  /**
   * Add commands to run when the callee is busy
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public DialCreator onBusy(SvamlCommand... commands) {
    onBusy = Commands.append(onBusy, commands);
    return this;
  }

  /**
   * Add commands to run when the callee is busy
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public DialCreator onBusy(Collection<? extends SvamlCommand> commands) {
    onBusy = Commands.append(onBusy, commands);
    return this;
  }

  /**
   * Add commands to run when the call is rejected
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public DialCreator onReject(SvamlCommand... commands) {
    onReject = Commands.append(onReject, commands);
    return this;
  }

  /**
   * Add commands to run when the call is rejected
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public DialCreator onReject(Collection<? extends SvamlCommand> commands) {
    onReject = Commands.append(onReject, commands);
    return this;
  }

  /**
   * Add commands to run when the call is not answered in time
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public DialCreator onTimeout(SvamlCommand... commands) {
    onTimeout = Commands.append(onTimeout, commands);
    return this;
  }

  /**
   * Add commands to run when the call is not answered in time
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public DialCreator onTimeout(Collection<? extends SvamlCommand> commands) {
    onTimeout = Commands.append(onTimeout, commands);
    return this;
  }

  /**
   * Add commands to run when the call is hung up
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public DialCreator onHangup(SvamlCommand... commands) {
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
  public DialCreator onHangup(Collection<? extends SvamlCommand> commands) {
    onHangup = Commands.append(onHangup, commands);
    return this;
  }

  /**
   * Add commands to run when the call fails
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public DialCreator onFailure(SvamlCommand... commands) {
    onFailure = Commands.append(onFailure, commands);
    return this;
  }

  /**
   * Add commands to run when the call fails
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public DialCreator onFailure(Collection<? extends SvamlCommand> commands) {
    onFailure = Commands.append(onFailure, commands);
    return this;
  }

  /**
   * Build the <code>dial</code> command
   *
   * @return The command. Its <code>events</code> are only set when a handler was given
   * @since 2.4
   */
  public DialCommand build() {
    DialCommand.Builder builder = DialCommand.builder().setTo(to);
    if (null != from) {
      builder.setFrom(from);
    }
    if (null != name) {
      builder.setCallName(name);
    }
    if (null != timeoutDurationSeconds) {
      builder.setDialTimeoutDurationSeconds(timeoutDurationSeconds);
    }
    if (null != maxDurationSeconds) {
      builder.setMaxCallDurationSeconds(maxDurationSeconds);
    }
    if (hasEvents()) {
      builder.setEvents(buildEvents());
    }
    return builder.build();
  }

  private boolean hasEvents() {
    return null != onAnswer
        || null != onBusy
        || null != onReject
        || null != onTimeout
        || null != onHangup
        || null != onFailure;
  }

  private CallEvents buildEvents() {
    CallEvents.Builder builder = CallEvents.builder();
    if (null != onAnswer) {
      builder.setOnAnswer(Commands.copy(onAnswer));
    }
    if (null != onBusy) {
      builder.setOnBusy(Commands.copy(onBusy));
    }
    if (null != onReject) {
      builder.setOnReject(Commands.copy(onReject));
    }
    if (null != onTimeout) {
      builder.setOnTimeout(Commands.copy(onTimeout));
    }
    if (null != onHangup) {
      builder.setOnHangup(Commands.copy(onHangup));
    }
    if (null != onFailure) {
      builder.setOnFailure(Commands.copy(onFailure));
    }
    return builder.build();
  }
}
