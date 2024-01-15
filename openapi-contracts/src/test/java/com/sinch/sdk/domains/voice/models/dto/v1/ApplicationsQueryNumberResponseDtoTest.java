package com.sinch.sdk.domains.voice.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
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
                  .rate(new PriceDto().currencyId("USD").amount(0.1850F)));

  @GivenJsonResource("/domains/voice/v1/ApplicationsQueryNumberResponseDto.json")
  GetQueryNumberDto loaded;

  @Test
  void deserializeResponse() {
    Assertions.assertThat(loaded).usingRecursiveComparison().isEqualTo(expected);
  }
}
