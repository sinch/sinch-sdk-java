package com.sinch.sdk.domains.sms.models.v1.batches;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class MediaBodyDtoTest extends BaseTest {
  @GivenTextResource("/domains/sms/v1/batches/MediaBodyDto.json")
  String jsonMediaBodyDto;

  @GivenJsonResource("/domains/sms/v1/batches/MediaBodyDto.json")
  MediaBody loadedMediaBodyDto;

  public static final MediaBody mediaBodyDto =
      MediaBody.builder()
          .setSubject("subject field")
          .setUrl("https://en.wikipedia.org/wiki/Sinch_(company)#/media/File:Sinch_LockUp_RGB.png")
          .setMessage("Hi ${name} ({an identifier}) ! How are you?")
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(mediaBodyDto);

    JSONAssert.assertEquals(jsonMediaBodyDto, serializedString, true);
  }

  @Test
  void deserialize() {

    TestHelpers.recursiveEquals(loadedMediaBodyDto, mediaBodyDto);
  }
}
