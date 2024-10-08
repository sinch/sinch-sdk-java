package com.sinch.sdk.domains.voice.models.v1.callouts;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.GetCalloutResponseObjDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class CalloutResponseDtoTest extends BaseTest {

  @GivenJsonResource("/domains/voice/v1/callouts/CalloutResponseDto.json")
  GetCalloutResponseObjDto loadedCalloutResponseDto;

  public static GetCalloutResponseObjDto expectedCalloutResponseDto =
      new GetCalloutResponseObjDto().callId("adf92089-df2a-4f14-a377-1e975f588fe4");

  @Test
  void deserializeResponseCallout() {
    Assertions.assertThat(loadedCalloutResponseDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedCalloutResponseDto);
  }
}
