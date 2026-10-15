package com.sinch.sdk.domains.voice.models.v2.sessions.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.v2.CallDtoTest;
import com.sinch.sdk.domains.voice.models.v2.SessionState;
import java.time.Instant;
import java.util.Collections;
import org.junit.jupiter.api.Test;

@TestWithResources
public class SessionDtoTest extends BaseTest {

  public static final Session expectedSession =
      Session.builder()
          .setSessionId("01BX5ZZKBKACTAV9WEVGEMMVRB")
          .setProjectId("5c5bf2b1-35ae-4825-ab89-457e07bb60e6")
          .setServiceId("6e124178-c29d-46a5-943c-5c2ae544aade")
          .setCalls(Collections.singletonList(CallDtoTest.expectedCall))
          .setCreateTime(Instant.parse("2025-02-10T09:00:00Z"))
          .setUpdateTime(Instant.parse("2025-02-10T09:00:47Z"))
          .setEndTime(Instant.parse("2025-02-10T09:00:47Z"))
          .setState(SessionState.COMPLETED)
          .build();

  public static final Session expectedSessionMinimal =
      Session.builder()
          .setSessionId("01BX5ZZKBKACTAV9WEVGEMMVRB")
          .setProjectId("5c5bf2b1-35ae-4825-ab89-457e07bb60e6")
          .setServiceId("6e124178-c29d-46a5-943c-5c2ae544aade")
          .setCalls(Collections.singletonList(CallDtoTest.expectedCallMinimal))
          .setCreateTime(Instant.parse("2025-02-10T09:00:00Z"))
          .setState(SessionState.QUEUED)
          .build();

  @GivenTextResource("/domains/voice/v2/sessions/response/SessionDto.json")
  String jsonSession;

  @GivenTextResource("/domains/voice/v2/sessions/response/SessionMinimalDto.json")
  String jsonSessionMinimal;

  @Test
  void deserialize() throws JsonProcessingException {
    Session deserialized = objectMapper.readValue(jsonSession, Session.class);

    TestHelpers.recursiveEquals(deserialized, expectedSession);
  }

  @Test
  void deserializeMinimalDto() throws JsonProcessingException {
    Session deserialized = objectMapper.readValue(jsonSessionMinimal, Session.class);

    TestHelpers.recursiveEquals(deserialized, expectedSessionMinimal);
  }
}
