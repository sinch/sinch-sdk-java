package com.sinch.sdk.domains.voice.models.v2.svaml.recording;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Recording options for this recording. */
@JsonDeserialize(builder = RecordingOptionsImpl.Builder.class)
public interface RecordingOptions {

  /**
   * Audio format for this recording.
   *
   * @return format
   */
  RecordingFormatType getFormat();

  /**
   * The type of recording to perform.
   *
   * @return recordingType
   */
  RecordingType getRecordingType();

  /**
   * Select target service to receive recorded and transcribed files
   *
   * <p>Field is required
   *
   * @return destination
   */
  RecordingDestinationType getDestination();

  /**
   * Destination URL for the recording.
   *
   * <p>Field is required
   *
   * @return destinationUrl
   */
  String getDestinationUrl();

  /**
   * Credentials to third party storage.
   *
   * <p>Field is required
   *
   * @return credentials
   */
  String getCredentials();

  /**
   * Configuration for automatic speech-to-text transcription of the recording.
   *
   * @return transcriptionOptions
   */
  TranscriptionOptions getTranscriptionOptions();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new RecordingOptionsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param format see getter
     * @return Current builder
     * @see #getFormat
     */
    Builder setFormat(RecordingFormatType format);

    /**
     * see getter
     *
     * @param recordingType see getter
     * @return Current builder
     * @see #getRecordingType
     */
    Builder setRecordingType(RecordingType recordingType);

    /**
     * see getter
     *
     * @param destination see getter
     * @return Current builder
     * @see #getDestination
     */
    Builder setDestination(RecordingDestinationType destination);

    /**
     * see getter
     *
     * @param destinationUrl see getter
     * @return Current builder
     * @see #getDestinationUrl
     */
    Builder setDestinationUrl(String destinationUrl);

    /**
     * see getter
     *
     * @param credentials see getter
     * @return Current builder
     * @see #getCredentials
     */
    Builder setCredentials(String credentials);

    /**
     * see getter
     *
     * @param transcriptionOptions see getter
     * @return Current builder
     * @see #getTranscriptionOptions
     */
    Builder setTranscriptionOptions(TranscriptionOptions transcriptionOptions);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    RecordingOptions build();
  }
}
