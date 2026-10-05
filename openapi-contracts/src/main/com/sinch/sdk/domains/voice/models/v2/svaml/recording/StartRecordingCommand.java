package com.sinch.sdk.domains.voice.models.v2.svaml.recording;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;

/**
 * Starts recording the call. This is a non-blocking command — execution continues to the next
 * command in the sequence immediately after recording begins.
 */
@JsonDeserialize(builder = StartRecordingCommandImpl.Builder.class)
public interface StartRecordingCommand extends SvamlCommand {

  /**
   * Identifier for this recording within the session. Must be unique across active recordings in
   * the session.
   *
   * <p>Other commands (e.g., <code>stopRecording</code>) reference this name to target a specific
   * recording.
   *
   * <p>Setting the recording name is useful for stopping the recording using the <code>
   * stopRecording</code> command. If name is not set, recording can only be stopped when the call
   * is disconnected.
   *
   * @return recordingName
   */
  String getRecordingName();

  /**
   * Recording options for this recording.
   *
   * <p>Field is required
   *
   * @return recordingOptions
   */
  RecordingOptions getRecordingOptions();

  /**
   * SVAML commands to execute based on recording lifecycle outcomes.
   *
   * @return events
   */
  RecordingEvents getEvents();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new StartRecordingCommandImpl.Builder();
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
     * see getter
     *
     * @param recordingOptions see getter
     * @return Current builder
     * @see #getRecordingOptions
     */
    Builder setRecordingOptions(RecordingOptions recordingOptions);

    /**
     * see getter
     *
     * @param events see getter
     * @return Current builder
     * @see #getEvents
     */
    Builder setEvents(RecordingEvents events);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    StartRecordingCommand build();
  }
}
