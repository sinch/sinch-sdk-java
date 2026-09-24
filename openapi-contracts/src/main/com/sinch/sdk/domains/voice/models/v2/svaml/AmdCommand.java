package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * AMD (Answering Machine Detection) command to detect what answered the call. Possible outcomes
 * are: human, machine, beep, or unknown.
 *
 * <p>This is a non-blocking command — the next command in the sequence executes immediately while
 * detection runs in parallel. Results are delivered via the <code>events</code> property.
 */
@JsonDeserialize(builder = AmdCommandImpl.Builder.class)
public interface AmdCommand extends SvamlCommand {

  /** The command property. Must have the value <code>amd</code>. */
  public class CommandEnum extends EnumDynamic<String, CommandEnum> {
    /** The <code>amd</code> command. */
    public static final CommandEnum AMD = new CommandEnum("amd");

    private static final EnumSupportDynamic<String, CommandEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(CommandEnum.class, CommandEnum::new, Arrays.asList(AMD));

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
   * SVAML commands to execute based on the answering machine detection result. These events define
   * different call flows depending on whether a human, machine, beep, or unknown entity answers the
   * call.
   *
   * @return events
   */
  AmdEvents getEvents();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new AmdCommandImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param events see getter
     * @return Current builder
     * @see #getEvents
     */
    Builder setEvents(AmdEvents events);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    AmdCommand build();
  }
}
