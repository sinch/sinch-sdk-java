package com.sinch.sdk.domains.sms.models.v1.batches.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.sms.models.v1.batches.response.DryRunPerRecipientDetails.EncodingEnum;
import java.util.Collections;
import org.junit.jupiter.api.Test;

@TestWithResources
class DryRunResponseDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/batches/response/DryRunResponseDto.json")
  DryRunResponse loadedDto;

  DryRunResponse dto =
      DryRunResponse.builder()
          .setNumberOfRecipients(123)
          .setNumberOfMessages(456)
          .setPerRecipient(
              Collections.singletonList(
                  DryRunPerRecipientDetails.builder()
                      .setRecipient("recipient string")
                      .setNumberOfParts(1)
                      .setBody("body string")
                      .setEncoding(EncodingEnum.from("encoding string"))
                      .build()))
          .build();

  @Test
  void deserialize() {

    TestHelpers.recursiveEquals(loadedDto, dto);
  }
}
