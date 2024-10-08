package com.sinch.sdk.domains.voice.models.v1.svaml.instruction;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SvamlInstructionPlayFilesTest extends BaseTest {

  public static SvamlInstructionPlayFiles dto =
      SvamlInstructionPlayFiles.builder()
          .setIds(Collections.singletonList("[Welcome]"))
          .setLocale("en")
          .build();

  @GivenTextResource("/domains/voice/v1/svaml/instruction/SvamlInstructionPlayFilesDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
