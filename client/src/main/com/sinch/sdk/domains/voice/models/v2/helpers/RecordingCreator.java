package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingDestinationType;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingFormatType;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingOptions;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingType;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.StartRecordingCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.TranscriptionOptions;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Fluent creator of a <code>startRecording</code> command
 *
 * <p>Returned by {@link Recording#start(RecordingDestinationType, String, String)}.
 *
 * <p>Also returned by {@link Recording#start(RecordingOptions)}: the optional recording options set
 * here override the ones of the given {@link RecordingOptions}.
 *
 * <p>Calling an event handler more than once appends the commands.
 *
 * @since 2.4
 */
public final class RecordingCreator {

  private final RecordingDestinationType destination;
  private final String url;
  private final String credentials;
  private RecordingFormatType format;
  private RecordingType recordingType;
  private TranscriptionOptions transcriptionOptions;
  private String name;
  private List<SvamlCommand> onFinish;
  private List<SvamlCommand> onFailure;

  RecordingCreator(RecordingDestinationType destination, String url, String credentials) {
    this.destination = Objects.requireNonNull(destination, "destination must not be null");
    this.url = Objects.requireNonNull(url, "url must not be null");
    this.credentials = Objects.requireNonNull(credentials, "credentials must not be null");
  }

  RecordingCreator(RecordingOptions options) {
    Objects.requireNonNull(options, "options must not be null");
    this.destination = options.getDestination();
    this.url = options.getDestinationUrl();
    this.credentials = options.getCredentials();
    this.format = options.getFormat();
    this.recordingType = options.getRecordingType();
    this.transcriptionOptions = options.getTranscriptionOptions();
  }

  /**
   * Set the audio format of the recording. The API default is <code>MP3</code>
   *
   * @param format Audio format
   * @return This creator
   * @since 2.4
   */
  public RecordingCreator format(RecordingFormatType format) {
    this.format = Objects.requireNonNull(format, "format must not be null");
    return this;
  }

  /**
   * Set which voice streams are recorded. The API default is <code>COMBINED</code>
   *
   * @param recordingType Recorded voice streams
   * @return This creator
   * @since 2.4
   */
  public RecordingCreator recordingType(RecordingType recordingType) {
    this.recordingType = Objects.requireNonNull(recordingType, "recordingType must not be null");
    return this;
  }

  /**
   * Set the speech-to-text transcription of the recording
   *
   * @param transcriptionOptions Transcription options
   * @return This creator
   * @since 2.4
   */
  public RecordingCreator transcriptionOptions(TranscriptionOptions transcriptionOptions) {
    this.transcriptionOptions =
        Objects.requireNonNull(transcriptionOptions, "transcriptionOptions must not be null");
    return this;
  }

  /**
   * Set the name of the recording, sent as <code>recordingName</code>. Without a name, the
   * recording can only be stopped by ending the call
   *
   * @param name Name of the recording, unique within the session
   * @return This creator
   * @since 2.4
   */
  public RecordingCreator name(String name) {
    this.name = Objects.requireNonNull(name, "name must not be null");
    return this;
  }

  /**
   * Add commands to run when the recording is stopped
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public RecordingCreator onFinish(SvamlCommand... commands) {
    onFinish = Commands.append(onFinish, commands);
    return this;
  }

  /**
   * Add commands to run when the recording is stopped
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public RecordingCreator onFinish(Collection<? extends SvamlCommand> commands) {
    onFinish = Commands.append(onFinish, commands);
    return this;
  }

  /**
   * Add commands to run when the recording is stopped
   *
   * @param sequence Lambda adding the commands to append
   * @return This creator
   * @since 2.4
   */
  public RecordingCreator onFinish(Consumer<CommandsSequenceCreator> sequence) {
    onFinish = Commands.append(onFinish, sequence);
    return this;
  }

  /**
   * Add commands to run when the recording fails to start
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public RecordingCreator onFailure(SvamlCommand... commands) {
    onFailure = Commands.append(onFailure, commands);
    return this;
  }

  /**
   * Add commands to run when the recording fails to start
   *
   * @param commands Commands to append
   * @return This creator
   * @since 2.4
   */
  public RecordingCreator onFailure(Collection<? extends SvamlCommand> commands) {
    onFailure = Commands.append(onFailure, commands);
    return this;
  }

  /**
   * Add commands to run when the recording fails to start
   *
   * @param sequence Lambda adding the commands to append
   * @return This creator
   * @since 2.4
   */
  public RecordingCreator onFailure(Consumer<CommandsSequenceCreator> sequence) {
    onFailure = Commands.append(onFailure, sequence);
    return this;
  }

  /**
   * Build the <code>startRecording</code> command
   *
   * @return The command. Its <code>events</code> are only set when a handler was given
   * @since 2.4
   */
  public StartRecordingCommand build() {
    StartRecordingCommand.Builder builder =
        StartRecordingCommand.builder().setRecordingOptions(buildOptions());
    if (null != name) {
      builder.setRecordingName(name);
    }
    if (null != onFinish || null != onFailure) {
      RecordingEvents.Builder events = RecordingEvents.builder();
      if (null != onFinish) {
        events.setOnFinish(Commands.copy(onFinish));
      }
      if (null != onFailure) {
        events.setOnFailure(Commands.copy(onFailure));
      }
      builder.setEvents(events.build());
    }
    return builder.build();
  }

  /** Only the fields that have a value are set, so unset ones are left to the API defaults */
  private RecordingOptions buildOptions() {
    RecordingOptions.Builder builder = RecordingOptions.builder();
    if (null != destination) {
      builder.setDestination(destination);
    }
    if (null != url) {
      builder.setDestinationUrl(url);
    }
    if (null != credentials) {
      builder.setCredentials(credentials);
    }
    if (null != format) {
      builder.setFormat(format);
    }
    if (null != recordingType) {
      builder.setRecordingType(recordingType);
    }
    if (null != transcriptionOptions) {
      builder.setTranscriptionOptions(transcriptionOptions);
    }
    return builder.build();
  }
}
