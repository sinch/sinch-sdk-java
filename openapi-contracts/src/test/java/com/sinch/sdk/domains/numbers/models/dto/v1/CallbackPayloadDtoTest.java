package com.sinch.sdk.domains.numbers.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class CallbackPayloadDtoTest extends BaseTest {

  @GivenJsonResource("/domains/numbers/v1/CallbackPayloadDto.json")
  CallbackPayloadDto loadedCallbackPayloadDto;

  public static CallbackPayloadDto expectedCallbackPayloadDtoDto =
      new CallbackPayloadDto()
          .eventId("abcd1234efghijklmnop567890")
          .timestamp("2023-06-06T07:45:27.78789")
          .projectId("abcd12ef-ab12-ab12-bc34-abcdef123456")
          .resourceId("+12345612345")
          .resourceType("ACTIVE_NUMBER")
          .eventType("PROVISIONING_TO_CAMPAIGN")
          .status("FAILED")
          .failureCode("CAMPAIGN_NOT_AVAILABLE");

  @Test
  void deserializeCallbackPayload() {
    Assertions.assertThat(loadedCallbackPayloadDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedCallbackPayloadDtoDto);
  }
}
