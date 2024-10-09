package com.sinch.sdk.domains.voice.models.v1.applications;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.GetQueryNumberDto;
import com.sinch.sdk.domains.voice.models.dto.v1.GetQueryNumberNumberDto;
import com.sinch.sdk.domains.voice.models.v1.Price;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ApplicationsQueryNumberResponseDtoTest extends BaseTest {

  public static GetQueryNumberDto expected =
      new GetQueryNumberDto()
          .number(
              new GetQueryNumberNumberDto()
                  .countryId("FR")
                  .numberType("Mobile")
                  .normalizedNumber("+331234567489")
                  .restricted(true)
                  .rate(Price.builder().setCurrencyId("USD").setAmount(0.1850F).build()));

  @GivenJsonResource("/domains/voice/v1/applications/ApplicationsQueryNumberResponseDto.json")
  GetQueryNumberDto loaded;

  @Test
  void deserializeResponse() {
    Assertions.assertThat(loaded).usingRecursiveComparison().isEqualTo(expected);
  }
}
