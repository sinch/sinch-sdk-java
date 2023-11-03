package com.sinch.sdk.domains.sms.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
class DryRunResponseDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/DryRunResponseDto.json")
  DryRun200ResponseDto loadedDto;

  @GivenTextResource("/domains/sms/v1/DryRunResponseDto.json")
  String jsonStringDto;

  DryRun200ResponseDto dto =
      new DryRun200ResponseDto()
          .numberOfRecipients(123)
          .numberOfMessages(456)
          .perRecipient(
              Collections.singletonList(
                  new DryRun200ResponsePerRecipientInnerDto()
                      .recipient("recipient string")
                      .messagePart("message part string")
                      .body("body string")
                      .encoding("encoding string")));

  @Test
  void deserialize() {

    Assertions.assertThat(loadedDto).usingRecursiveComparison().isEqualTo(dto);
  }

  @Test
  void serialize() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(jsonStringDto, serializedString, true);
  }
}
