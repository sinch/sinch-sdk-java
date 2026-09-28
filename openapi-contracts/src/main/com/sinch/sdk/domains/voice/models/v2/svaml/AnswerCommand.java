package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Answers an inbound call leg. This is a non-blocking command — execution continues to the next
 * command in the sequence immediately after the answer is initiated.
 */
@JsonDeserialize(builder = AnswerCommandImpl.Builder.class)
public interface AnswerCommand extends SvamlCommand {

  /** The command property. Must have the value <code>answer</code>. */
  public class CommandEnum extends EnumDynamic<String, CommandEnum> {
    /** The <code>answer</code> command. */
    public static final CommandEnum ANSWER = new CommandEnum("answer");

    private static final EnumSupportDynamic<String, CommandEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(CommandEnum.class, CommandEnum::new, Arrays.asList(ANSWER));

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

  /** Default answer command, to be used instead of building an empty one */
  AnswerCommand ANSWER_COMMAND = AnswerCommand.builder().build();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new AnswerCommandImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    AnswerCommand build();
  }
}
