package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.voice.models.v2.destination.CallDestination;
import com.sinch.sdk.domains.voice.models.v2.destination.CallOrigin;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Initiates a new outbound call leg within the current session.
 *
 * <p>This is a non-blocking command — the next command in the sequence executes immediately while
 * the call is being established in parallel. Call lifecycle events (answer, busy, reject, timeout,
 * hangup, failure) are handled via the <code>events</code> property.
 *
 * <p>The <code>from</code> and <code>to</code> endpoint types should ideally match. If they differ,
 * the platform attempts to convert the <code>from</code> value to be compatible with the <code>to
 * </code> type. For example, PSTN supports only E.164 phone numbers, so a SIP address such as
 * <code>sip:46701234567&#64;acme.se</code> can be converted to an E.164 number. If the <code>from
 * </code> value cannot be converted, it defaults to null (anonymous).
 */
@JsonDeserialize(builder = DialCommandImpl.Builder.class)
public interface DialCommand extends SvamlCommand {

  /** The command property. Must have the value <code>dial</code>. */
  public class CommandEnum extends EnumDynamic<String, CommandEnum> {
    /** The <code>dial</code> command. */
    public static final CommandEnum DIAL = new CommandEnum("dial");

    private static final EnumSupportDynamic<String, CommandEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(CommandEnum.class, CommandEnum::new, Arrays.asList(DIAL));

    private CommandEnum(String value) {
      super(value);
    }

    public static Stream<CommandEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static CommandEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(CommandEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Identifier for this call leg within the session. Must be unique across all active call legs in
   * the session.
   *
   * <p>Other commands (e.g., <code>hangup</code>) can reference this name to target this specific
   * leg.
   *
   * @return callName
   */
  String getCallName();

  /**
   * Call origin - Phone Number or SIP endpoint
   *
   * @return from
   */
  CallOrigin getFrom();

  /**
   * Call destination - Phone Number or Stream URI
   *
   * <p>Field is required
   *
   * @return to
   */
  CallDestination getTo();

  /**
   * Maximum time in seconds to wait for the call to be answered. If the timeout expires without an
   * answer, the <code>onTimeout</code> event is triggered.
   *
   * @return dialTimeoutDurationSeconds
   */
  Integer getDialTimeoutDurationSeconds();

  /**
   * Maximum duration of the call in seconds. The call is terminated automatically when this limit
   * is reached.
   *
   * @return maxCallDurationSeconds
   */
  Integer getMaxCallDurationSeconds();

  /**
   * Webhook to handle call events, used when callBehaviors are set to WEBHOOK
   *
   * @return events
   */
  CallEvents getEvents();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new DialCommandImpl.Builder();
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
     * see getter
     *
     * @param from see getter
     * @return Current builder
     * @see #getFrom
     */
    Builder setFrom(CallOrigin from);

    /**
     * see getter
     *
     * @param to see getter
     * @return Current builder
     * @see #getTo
     */
    Builder setTo(CallDestination to);

    /**
     * see getter
     *
     * @param dialTimeoutDurationSeconds see getter
     * @return Current builder
     * @see #getDialTimeoutDurationSeconds
     */
    Builder setDialTimeoutDurationSeconds(Integer dialTimeoutDurationSeconds);

    /**
     * see getter
     *
     * @param maxCallDurationSeconds see getter
     * @return Current builder
     * @see #getMaxCallDurationSeconds
     */
    Builder setMaxCallDurationSeconds(Integer maxCallDurationSeconds);

    /**
     * see getter
     *
     * @param events see getter
     * @return Current builder
     * @see #getEvents
     */
    Builder setEvents(CallEvents events);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    DialCommand build();
  }
}
