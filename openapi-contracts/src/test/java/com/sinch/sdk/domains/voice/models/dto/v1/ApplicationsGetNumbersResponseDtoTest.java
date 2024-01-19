package com.sinch.sdk.domains.voice.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ApplicationsGetNumbersResponseDtoTest extends BaseTest {

  public static GetNumbersResponseObjDto expected =
      new GetNumbersResponseObjDto()
          .numbers(
              Arrays.asList(
                  new GetNumbersResponseObjNumbersInnerDto()
                      .number("+123456789")
                      .applicationkey("an application key")
                      .capability("voice"),
                  new GetNumbersResponseObjNumbersInnerDto()
                      .number("+134567890")
                      .capability("sms")));

  @GivenJsonResource("/domains/voice/v1/ApplicationsGetNumbersResponseDto.json")
  GetNumbersResponseObjDto loaded;

  @Test
  void deserializeResponse() {
    Assertions.assertThat(loaded).usingRecursiveComparison().isEqualTo(expected);
  }
}
