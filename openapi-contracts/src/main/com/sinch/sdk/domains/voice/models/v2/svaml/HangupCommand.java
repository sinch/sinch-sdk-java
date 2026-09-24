package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

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

  /** The command property. Must have the value <code>hangup</code>. */
  public class CommandEnum extends EnumDynamic<String, CommandEnum> {
    /** The <code>hangup</code> command. */
    public static final CommandEnum HANGUP = new CommandEnum("hangup");

    private static final EnumSupportDynamic<String, CommandEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(CommandEnum.class, CommandEnum::new, Arrays.asList(HANGUP));

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
   * Name of the call leg to end, as set by <code>callName</code> in the <code>dial</code> command.
   *
   * <p>If omitted, the current call leg is ended.
   *
   * @return callName
   */
  String getCallName();

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
