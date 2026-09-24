package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Delays execution of the next command in the sequence for a specified duration. This is a blocking
 * command — no further commands execute until the pause completes.
 *
 * <p>The pause does not affect call audio; the call remains connected and audio continues
 * uninterrupted.
 */
@JsonDeserialize(builder = PauseCommandImpl.Builder.class)
public interface PauseCommand extends SvamlCommand {

  /** The command property. Must have the value <code>pause</code>. */
  public class CommandEnum extends EnumDynamic<String, CommandEnum> {
    /** The <code>pause</code> command. */
    public static final CommandEnum PAUSE = new CommandEnum("pause");

    private static final EnumSupportDynamic<String, CommandEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(CommandEnum.class, CommandEnum::new, Arrays.asList(PAUSE));

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
   * Duration of the pause in milliseconds.
   *
   * <p>Field is required
   *
   * @return durationMilliseconds
   */
  Integer getDurationMilliseconds();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new PauseCommandImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param durationMilliseconds see getter
     * @return Current builder
     * @see #getDurationMilliseconds
     */
    Builder setDurationMilliseconds(Integer durationMilliseconds);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    PauseCommand build();
  }
}
