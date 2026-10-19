package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingDestinationType;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingOptions;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.StopRecordingCommand;
import java.util.Objects;

/**
 * Helpers to build the call recording SVAML commands
 *
 * @since 2.4
 */
public final class Recording {

  private Recording() {}

  /**
   * Create the options to store a recording in a third party storage
   *
   * <p>Only the required fields are set. Set the format, the recording type and the transcription
   * on the creator returned by {@link #start(RecordingOptions)}.
   *
   * @param destination Third party storage the recording is delivered to
   * @param url Destination URL, sent as <code>destinationUrl</code>. Its scheme depends on the
   *     destination: <code>s3</code>, <code>gs</code> or <code>azure</code>
   * @param credentials Credentials to the third party storage
   * @return The recording options
   * @since 2.4
   */
  public static RecordingOptions options(
      RecordingDestinationType destination, String url, String credentials) {
    Objects.requireNonNull(destination, "destination must not be null");
    Objects.requireNonNull(url, "url must not be null");
    Objects.requireNonNull(credentials, "credentials must not be null");
    return RecordingOptions.builder()
        .setDestination(destination)
        .setDestinationUrl(url)
        .setCredentials(credentials)
        .build();
  }

  /**
   * Start recording the call, stored in a third party storage
   *
   * <p>Set the optional recording options (format, recording type, transcription) on the returned
   * creator.
   *
   * @param destination Third party storage the recording is delivered to
   * @param url Destination URL, sent as <code>destinationUrl</code>. Its scheme depends on the
   *     destination: <code>s3</code>, <code>gs</code> or <code>azure</code>
   * @param credentials Credentials to the third party storage
   * @return The creator of the <code>startRecording</code> command
   * @since 2.4
   */
  public static RecordingCreator start(
      RecordingDestinationType destination, String url, String credentials) {
    return new RecordingCreator(destination, url, credentials);
  }

  /**
   * Start recording the call with existing recording options, e.g. shared by several recordings
   *
   * @param options Recording options, see {@link #options(RecordingDestinationType, String,
   *     String)}
   * @return The creator of the <code>startRecording</code> command
   * @since 2.4
   */
  public static RecordingCreator start(RecordingOptions options) {
    return new RecordingCreator(options);
  }

  /**
   * Stop a named recording
   *
   * @param name Name of the recording, sent as <code>recordingName</code>
   * @return The <code>stopRecording</code> command
   * @since 2.4
   */
  public static StopRecordingCommand stop(String name) {
    Objects.requireNonNull(name, "name must not be null");
    return StopRecordingCommand.builder().setRecordingName(name).build();
  }
}
