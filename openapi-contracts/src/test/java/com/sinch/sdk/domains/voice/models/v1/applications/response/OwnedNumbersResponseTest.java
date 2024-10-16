package com.sinch.sdk.domains.voice.models.v1.applications.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.v1.applications.Capability;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@TestWithResources
public class OwnedNumbersResponseTest extends BaseTest {

  public static OwnedNumbersResponse expected =
      OwnedNumbersResponse.builder()
          .setNumbers(
              Arrays.asList(
                  OwnedNumberInformation.builder()
                      .setNumber("+123456789")
                      .setApplicationKey("an application key")
                      .setCapability(Capability.VOICE)
                      .build(),
                  OwnedNumberInformation.builder()
                      .setNumber("+134567890")
                      .setCapability(Capability.SMS)
                      .build()))
          .build();

  @GivenJsonResource("/domains/voice/v1/applications/response/OwnedNumbersResponseDto.json")
  OwnedNumbersResponse loaded;

  @Test
  void deserializeResponse() {
    TestHelpers.recursiveEquals(loaded, expected);
  }
}
