package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingDestinationType;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingFormatType;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingOptions;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingType;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.TranscriptionOptions;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

class RecordingTest extends HelpersBaseTest {

  static final String OPTIONS_JSON =
      "{\"destination\":\"AWS\",\"destinationUrl\":\"s3://voice-recordings/support\","
          + "\"credentials\":\"key:secret:eu-west-1\"}";

  static RecordingOptions awsOptions() {
    return Recording.options(
        RecordingDestinationType.AWS, "s3://voice-recordings/support", "key:secret:eu-west-1");
  }

  @Test
  void options() throws JsonProcessingException, JSONException {
    assertJson(awsOptions(), OPTIONS_JSON);
  }

  @Test
  void startWithDestinationOnlySetsRequiredOptions() throws JsonProcessingException, JSONException {
    assertJson(
        Recording.start(
                RecordingDestinationType.AWS,
                "s3://voice-recordings/support",
                "key:secret:eu-west-1")
            .build(),
        "{\"command\":\"startRecording\",\"recordingOptions\":" + OPTIONS_JSON + "}");
  }

  @Test
  void startWithDestinationAndOptionalOptions() throws JsonProcessingException, JSONException {
    assertJson(
        Recording.start(
                RecordingDestinationType.AWS,
                "s3://voice-recordings/support",
                "key:secret:eu-west-1")
            .format(RecordingFormatType.WAV)
            .recordingType(RecordingType.INBOUND)
            .transcriptionOptions(
                TranscriptionOptions.builder().setIsEnabled(true).setLocale("es-ES").build())
            .name("support-call")
            .build(),
        "{\"command\":\"startRecording\",\"recordingName\":\"support-call\","
            + "\"recordingOptions\":{\"destination\":\"AWS\","
            + "\"destinationUrl\":\"s3://voice-recordings/support\","
            + "\"credentials\":\"key:secret:eu-west-1\",\"format\":\"WAV\","
            + "\"recordingType\":\"INBOUND\","
            + "\"transcriptionOptions\":{\"isEnabled\":true,\"locale\":\"es-ES\"}}}");
  }

  @Test
  void creatorOptionsOverrideGivenOptions() throws JsonProcessingException, JSONException {
    RecordingOptions options =
        RecordingOptions.builder()
            .setDestination(RecordingDestinationType.AZURE)
            .setDestinationUrl("azure://container/path")
            .setCredentials("creds")
            .setFormat(RecordingFormatType.MP3)
            .setRecordingType(RecordingType.OUTBOUND)
            .build();

    assertJson(
        Recording.start(options).format(RecordingFormatType.WAV).build(),
        "{\"command\":\"startRecording\",\"recordingOptions\":{\"destination\":\"AZURE\","
            + "\"destinationUrl\":\"azure://container/path\",\"credentials\":\"creds\","
            + "\"format\":\"WAV\",\"recordingType\":\"OUTBOUND\"}}");
  }

  @Test
  void startOnlySetsOptions() throws JsonProcessingException, JSONException {
    assertJson(
        Recording.start(awsOptions()).build(),
        "{\"command\":\"startRecording\",\"recordingOptions\":" + OPTIONS_JSON + "}");
  }

  @Test
  void startAllFields() throws JsonProcessingException, JSONException {
    assertJson(
        Recording.start(awsOptions())
            .name("support-call")
            .onFinish(Calls.hangup())
            .onFailure(Calls.hangup("origin"))
            .build(),
        "{\"command\":\"startRecording\",\"recordingName\":\"support-call\","
            + "\"recordingOptions\":"
            + OPTIONS_JSON
            + ",\"events\":{\"onFinish\":["
            + HANGUP_JSON
            + "],\"onFailure\":[{\"command\":\"hangup\",\"callName\":\"origin\"}]}}");
  }

  @Test
  void startAcceptsOptionsFromBuilder() throws JsonProcessingException, JSONException {
    RecordingOptions options =
        RecordingOptions.builder()
            .setDestination(RecordingDestinationType.GCP)
            .setDestinationUrl("gs://bucket/path")
            .setCredentials("creds")
            .setFormat(RecordingFormatType.WAV)
            .build();

    assertJson(
        Recording.start(options).build(),
        "{\"command\":\"startRecording\",\"recordingOptions\":{\"destination\":\"GCP\","
            + "\"destinationUrl\":\"gs://bucket/path\",\"credentials\":\"creds\","
            + "\"format\":\"WAV\"}}");
  }

  @Test
  void stop() throws JsonProcessingException, JSONException {
    assertJson(
        Recording.stop("support-call"),
        "{\"command\":\"stopRecording\",\"recordingName\":\"support-call\"}");
  }

  @Test
  void givenOptionsAreSentUnchangedWithoutOverride() {
    RecordingOptions options =
        RecordingOptions.builder()
            .setDestination(RecordingDestinationType.AWS)
            .setDestinationUrl("s3://b")
            .setCredentials("c")
            .setTranscriptionOptions(TranscriptionOptions.builder().setIsEnabled(true).build())
            .build();

    Assertions.assertThat(Recording.start(options).name("rec").build().getRecordingOptions())
        .isSameAs(options);
    Assertions.assertThat(
            Recording.start(options).format(RecordingFormatType.WAV).build().getRecordingOptions())
        .isNotSameAs(options);
  }

  /**
   * RecordingCreator copies every field of the given options when one is overridden: a new field in
   * RecordingOptions must be copied too
   */
  @Test
  void recordingOptionsFieldsAreAllCopied() {
    Assertions.assertThat(RecordingOptions.class.getDeclaredMethods())
        .filteredOn(method -> method.getName().startsWith("get"))
        .extracting(java.lang.reflect.Method::getName)
        .containsExactlyInAnyOrder(
            "getFormat",
            "getRecordingType",
            "getDestination",
            "getDestinationUrl",
            "getCredentials",
            "getTranscriptionOptions");
  }

  @Test
  void optionsWithOptionalFields() throws JsonProcessingException, JSONException {
    RecordingOptions options =
        Recording.options(
            RecordingDestinationType.AWS,
            "s3://voice-recordings/support",
            "key:secret:eu-west-1",
            o ->
                o.setFormat(RecordingFormatType.WAV)
                    .setRecordingType(RecordingType.INBOUND)
                    .setTranscriptionOptions(
                        TranscriptionOptions.builder().setIsEnabled(true).build()));

    assertJson(
        options,
        "{\"destination\":\"AWS\",\"destinationUrl\":\"s3://voice-recordings/support\","
            + "\"credentials\":\"key:secret:eu-west-1\",\"format\":\"WAV\","
            + "\"recordingType\":\"INBOUND\",\"transcriptionOptions\":{\"isEnabled\":true}}");
  }

  @Test
  void sharedOptionsWithOptionalFieldsAreSentUnchanged() {
    RecordingOptions shared =
        Recording.options(
            RecordingDestinationType.AWS, "s3://b", "c", o -> o.setFormat(RecordingFormatType.WAV));

    Assertions.assertThat(Recording.start(shared).name("first").build().getRecordingOptions())
        .isSameAs(shared);
    Assertions.assertThat(Recording.start(shared).name("second").build().getRecordingOptions())
        .isSameAs(shared);
  }

  @Test
  void rejectsNullOptionsLambda() {
    Assertions.assertThatThrownBy(
            () -> Recording.options(RecordingDestinationType.AWS, "s3://b", "c", null))
        .isInstanceOf(NullPointerException.class);
  }

  @Test
  void rejectsNullValues() {
    Assertions.assertThatThrownBy(() -> Recording.options(null, "s3://b", "c"))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Recording.start(null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Recording.start(RecordingDestinationType.AWS, null, "c"))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Recording.start(awsOptions()).format(null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Recording.stop(null))
        .isInstanceOf(NullPointerException.class);
  }
}
