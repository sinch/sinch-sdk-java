package com.sinch.sdk.domains.voice.models.v2.svaml.recording;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;

/**
 * Stops a recording previously started by a <code>startRecording</code> command. This is a
 * non-blocking command — execution continues to the next command in the sequence immediately after
 * the stop is initiated.
 */
@JsonDeserialize(builder = StopRecordingCommandImpl.Builder.class)
public interface StopRecordingCommand extends SvamlCommand {

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
