package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class RecordingOptionsDtoTest extends BaseTest {

  public static final RecordingOptions expectedRecordingOptions =
      RecordingOptions.builder()
          .setFormat(RecordingFormatType.MP3)
          .setRecordingType(RecordingType.COMBINED)
          .setDestination(RecordingDestinationType.AWS)
          .setDestinationUrl("s3://my-bucket/recordings")
          .setCredentials("access-key:secret-key")
          .setTranscriptionOptions(TranscriptionOptionsDtoTest.expectedTranscriptionOptions)
          .build();

  @GivenTextResource("/domains/voice/v2/svaml/RecordingOptionsDto.json")
  String jsonRecordingOptions;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedRecordingOptions);

    JSONAssert.assertEquals(jsonRecordingOptions, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    RecordingOptions deserialized =
        objectMapper.readValue(jsonRecordingOptions, RecordingOptions.class);

    TestHelpers.recursiveEquals(deserialized, expectedRecordingOptions);
  }

  @Test
  void toStringMasksCredentials() {
    String string = expectedRecordingOptions.toString();

    Assertions.assertFalse(string.contains("access-key:secret-key"), string);
    Assertions.assertTrue(string.contains("credentials: ***"), string);
  }
}
