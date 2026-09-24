package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Stops a recording previously started by a <code>startRecording</code> command. This is a
 * non-blocking command — execution continues to the next command in the sequence immediately after
 * the stop is initiated.
 */
@JsonDeserialize(builder = StopRecordingCommandImpl.Builder.class)
public interface StopRecordingCommand extends SvamlCommand {

  /** The command property. Must have the value <code>stopRecording</code>. */
  public class CommandEnum extends EnumDynamic<String, CommandEnum> {
    /** The <code>stopRecording</code> command. */
    public static final CommandEnum STOP_RECORDING = new CommandEnum("stopRecording");

    private static final EnumSupportDynamic<String, CommandEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            CommandEnum.class, CommandEnum::new, Arrays.asList(STOP_RECORDING));

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
   * Name of the recording to stop, as set by <code>recordingName</code> in the <code>startRecording
   * </code> command.
   *
   * <p>Field is required
   *
   * @return recordingName
   */
  String getRecordingName();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new StopRecordingCommandImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param recordingName see getter
     * @return Current builder
     * @see #getRecordingName
     */
    Builder setRecordingName(String recordingName);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    StopRecordingCommand build();
  }
}
