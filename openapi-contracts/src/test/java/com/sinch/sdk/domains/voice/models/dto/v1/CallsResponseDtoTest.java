package com.sinch.sdk.domains.voice.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.GetCallResponseObjDto.ReasonEnum;
import com.sinch.sdk.domains.voice.models.dto.v1.GetCallResponseObjDto.ResultEnum;
import com.sinch.sdk.domains.voice.models.dto.v1.GetCallResponseObjDto.StatusEnum;
import java.time.OffsetDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class CallsResponseDtoTest extends BaseTest {

  @GivenJsonResource("/domains/voice/v1/CallsGetInformationResponseDto.json")
  GetCallResponseObjDto loadedCallsGetInformationResponseDto;

  public static GetCallResponseObjDto expectedCallsGetInformationResponseDto =
      new GetCallResponseObjDto()
          .from(
              new DestinationDto()
                  .type(DestinationTypeDto.USERNAME2)
                  .endpoint("user name endpoint validation"))
          .to(new DestinationDto().type(DestinationTypeDto.NUMBER2).endpoint("+33123456789"))
          .domain("pstn")
          .callId("a call UUID")
          .duration(138)
          .status(StatusEnum.FINAL.getValue())
          .result(ResultEnum.ANSWERED.getValue())
          .reason(ReasonEnum.CALLEEHANGUP.getValue())
          .timestamp(OffsetDateTime.parse("2024-01-08T09:48:12Z"))
          .custom("{}")
          .userRate(new PriceDto().currencyId("EUR").amount(0.1758F))
          .debit(new PriceDto().currencyId("EUR").amount(0.5274F));

  @Test
  void deserializeResponseCallout() {
    Assertions.assertThat(loadedCallsGetInformationResponseDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedCallsGetInformationResponseDto);
  }
}
