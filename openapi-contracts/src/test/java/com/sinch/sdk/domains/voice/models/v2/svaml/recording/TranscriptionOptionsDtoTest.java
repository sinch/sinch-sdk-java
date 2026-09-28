package com.sinch.sdk.domains.voice.models.v2.svaml.recording;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class TranscriptionOptionsDtoTest extends BaseTest {

  public static final TranscriptionOptions expectedTranscriptionOptions =
      TranscriptionOptions.builder().setIsEnabled(true).setLocale("en-US").build();

  @GivenTextResource("/domains/voice/v2/svaml/recording/TranscriptionOptionsDto.json")
  String jsonTranscriptionOptions;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedTranscriptionOptions);

    JSONAssert.assertEquals(jsonTranscriptionOptions, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    TranscriptionOptions deserialized =
        objectMapper.readValue(jsonTranscriptionOptions, TranscriptionOptions.class);

    TestHelpers.recursiveEquals(deserialized, expectedTranscriptionOptions);
  }
}
