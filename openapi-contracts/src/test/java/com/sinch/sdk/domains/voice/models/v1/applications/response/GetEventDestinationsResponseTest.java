package com.sinch.sdk.domains.voice.models.v1.applications.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.v1.applications.EventDestinationTarget;
import com.sinch.sdk.domains.voice.models.v1.applications.EventDestinations;
import org.junit.jupiter.api.Test;

@TestWithResources
public class GetEventDestinationsResponseTest extends BaseTest {

  public static EventDestinations expected =
      EventDestinations.builder()
          .setTarget(
              EventDestinationTarget.builder()
                  .setPrimary("https://foo.com")
                  .setFallback("https://fallback.foo.com")
                  .build())
          .build();

  @GivenJsonResource("/domains/voice/v1/applications/response/GetEventDestinationsResponseDto.json")
  EventDestinations loaded;

  @Test
  void deserializeResponse() {
    TestHelpers.recursiveEquals(loaded, expected);
  }
}
