package com.sinch.sdk.domains.voice.models.v1.applications.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.v1.applications.Callbacks;
import com.sinch.sdk.domains.voice.models.v1.applications.CallbacksUrl;
import org.junit.jupiter.api.Test;

@TestWithResources
public class GetCallbackUrlsResponseTest extends BaseTest {

  public static Callbacks expected =
      Callbacks.builder()
          .setUrl(
              CallbacksUrl.builder()
                  .setPrimary("https://foo.com")
                  .setFallback("https://fallback.foo.com")
                  .build())
          .build();

  @GivenJsonResource("/domains/voice/v1/applications/response/GetCallbackUrlsResponseDto.json")
  Callbacks loaded;

  @Test
  void deserializeResponse() {
    TestHelpers.recursiveEquals(loaded, expected);
  }
}
