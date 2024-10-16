package com.sinch.sdk.domains.voice.models.v1.applications.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.v1.Price;
import com.sinch.sdk.domains.voice.models.v1.applications.response.QueryNumberInformation.NumberTypeEnum;
import org.junit.jupiter.api.Test;

@TestWithResources
public class QueryNumberResponseTest extends BaseTest {

  public static QueryNumberResponse expected =
      QueryNumberResponse.builder()
          .setNumber(
              QueryNumberInformation.builder()
                  .setCountryId("FR")
                  .setNumberType(NumberTypeEnum.MOBILE)
                  .setNormalizedNumber("+331234567489")
                  .setRestricted(true)
                  .setRate(Price.builder().setCurrencyId("USD").setAmount(0.1850F).build())
                  .build())
          .build();

  @GivenJsonResource("/domains/voice/v1/applications/response/QueryNumberResponseDto.json")
  QueryNumberResponse loaded;

  @Test
  void deserializeResponse() {
    TestHelpers.recursiveEquals(loaded, expected);
  }
}
