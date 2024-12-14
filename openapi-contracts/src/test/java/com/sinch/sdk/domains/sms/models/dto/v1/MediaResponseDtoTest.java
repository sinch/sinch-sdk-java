package com.sinch.sdk.domains.sms.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import java.time.OffsetDateTime;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@TestWithResources
class MediaResponseDtoTest extends BaseTest {
  @GivenJsonResource("/domains/sms/v1/batches/response/BatchMediaDto.json")
  MediaResponseDto loadedDto;

  ParameterObjDto parameterObjDto = new ParameterObjDto();

  MediaResponseDto mediaDTO =
      new MediaResponseDto(
              "01FC66621XXXXX119Z8PMV1QPQ",
              false,
              "mt_media",
              OffsetDateTime.parse("2019-08-24T14:14:22Z"),
              OffsetDateTime.parse("2019-08-24T14:15:22Z"))
          .body(
              new MediaBodyDto()
                  .url(
                      "https://en.wikipedia.org/wiki/Sinch_(company)#/media/File:Sinch_LockUp_RGB.png")
                  .message("Hi ${name} ({an identifier}) ! How are you?"))
          .callbackUrl("callback url")
          .clientReference("client reference")
          .deliveryReport("summary")
          .expireAt(OffsetDateTime.parse("2019-08-24T14:17:22Z"))
          .feedbackEnabled(false)
          .from("+15551231234")
          .parameters(parameterObjDto)
          .sendAt(OffsetDateTime.parse("2019-08-24T14:16:22Z"))
          .to(Arrays.asList("+15551231234", "+15551256344"))
          .strictValidation(true);

  @Test
  void deserialize() {

    Assertions.assertThat(loadedDto).usingRecursiveComparison().isEqualTo(mediaDTO);
  }

  @BeforeEach
  void setUp() {
    parameterObjDto.put(
        "an identifier",
        Stream.of(
                new AbstractMap.SimpleEntry<>("15551231234", "an identifier value for 15551231234"),
                new AbstractMap.SimpleEntry<>("15551256344", "an identifier value for 15551256344"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

    parameterObjDto.put(
        "name",
        Stream.of(
                new AbstractMap.SimpleEntry<>("15551231234", "name value for 15551231234"),
                new AbstractMap.SimpleEntry<>("15551256344", "name value for 15551256344"),
                new AbstractMap.SimpleEntry<>(
                    ParameterObjParameterKeyDto.JSON_PROPERTY_DEFAULT, "default value"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
  }
}
