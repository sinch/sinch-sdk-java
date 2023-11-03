package com.sinch.sdk.domains.sms.adapters.converters;

import static org.assertj.core.api.Assertions.assertThat;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.sms.models.DryRun;
import com.sinch.sdk.domains.sms.models.DryRunPerRecipientDetails;
import com.sinch.sdk.domains.sms.models.dto.v1.DryRun200ResponseDto;
import java.util.Collections;
import org.junit.jupiter.api.Test;

@TestWithResources
public class DryRunDtoConverterTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/DryRunResponseDto.json")
  DryRun200ResponseDto loadedDto;

  public static DryRun dryRunClient =
      DryRun.builder()
          .setNumberOfRecipients(123)
          .setNumberOfMessages(456)
          .setPerRecipient(
              Collections.singletonList(
                  DryRunPerRecipientDetails.builder()
                      .setRecipient("recipient string")
                      .setMessagePart("message part string")
                      .setBody("body string")
                      .setEncoding("encoding string")
                      .build()))
          .build();

  @Test
  void testConvertDryRun() {
    assertThat(DryRunDtoConverter.convert(loadedDto))
        .usingRecursiveComparison()
        .isEqualTo(dryRunClient);
  }
}
