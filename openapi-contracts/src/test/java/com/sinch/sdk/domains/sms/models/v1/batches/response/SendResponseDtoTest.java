package com.sinch.sdk.domains.sms.models.v1.batches.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.sms.models.v1.batches.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.v1.batches.MediaBodyDtoTest;
import java.time.Instant;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

@TestWithResources
class SendResponseDtoTest extends BaseTest {
  @GivenJsonResource("/domains/sms/v1/batches/response/BatchBinaryDto.json")
  Batch loadedBinaryDto;

  @GivenJsonResource("/domains/sms/v1/batches/response/BatchTextDto.json")
  Batch loadedTextDto;

  @GivenJsonResource("/domains/sms/v1/batches/response/BatchMediaDto.json")
  Batch loadedMediaDto;

  BatchBinary binaryResponseDto =
      BatchBinary.builder()
          .setBody("Hi ${name} ({an identifier}) ! How are you?")
          .setCallbackUrl("callback url")
          .setClientReference("myReference")
          .setDeliveryReport(DeliveryReportType.NONE)
          .setExpireAt(Instant.parse("2019-08-24T14:21:22Z"))
          .setFeedbackEnabled(false)
          .setFrom("+15551231234")
          .setFromTon(6)
          .setFromNpi(18)
          .setSendAt(Instant.parse("2019-08-24T14:19:22Z"))
          .setTo(Arrays.asList("+15551231234", "+15551256344"))
          .setUdh("foo udh")
          .setCanceled(false)
          .setCreatedAt(Instant.parse("2019-08-24T14:15:22Z"))
          .setModifiedAt(Instant.parse("2019-08-24T14:17:22Z"))
          .setId("01FC66621XXXXX119Z8PMV1QPQ")
          .build();

  Map<String, String> anIdentifierParameters =
      Stream.of(
              new AbstractMap.SimpleEntry<>("15551231234", "an identifier value for 15551231234"),
              new AbstractMap.SimpleEntry<>("15551256344", "an identifier value for 15551256344"))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

  Map<String, String> nameParameters =
      Stream.of(
              new AbstractMap.SimpleEntry<>("15551231234", "name value for 15551231234"),
              new AbstractMap.SimpleEntry<>("15551256344", "name value for 15551256344"),
              new AbstractMap.SimpleEntry<>("default", "default value"))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

  Map<String, Map<String, String>> parameters =
      Stream.of(
              new AbstractMap.SimpleEntry<>("name", nameParameters),
              new AbstractMap.SimpleEntry<>("an identifier", anIdentifierParameters))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  BatchText textResponseDto =
      BatchText.builder()
          .setId("01FC66621XXXXX119Z8PMV1QPQ")
          .setCreatedAt(Instant.parse("2019-08-24T14:15:22Z"))
          .setCanceled(false)
          .setModifiedAt(Instant.parse("2019-08-24T14:17:22Z"))
          .setBody("Hi ${name} ({an identifier}) ! How are you?")
          .setCallbackUrl("callback url")
          .setClientReference("myReference")
          .setDeliveryReport(DeliveryReportType.NONE)
          .setExpireAt(Instant.parse("2019-08-24T14:21:22Z"))
          .setFeedbackEnabled(false)
          .setFlashMessage(true)
          .setFrom("+15551231234")
          .setFromTon(6)
          .setFromNpi(18)
          .setMaxNumberOfMessageParts(1)
          .setParameters(parameters)
          .setSendAt(Instant.parse("2019-08-24T14:19:22Z"))
          .setTo(Arrays.asList("+15551231234", "+15551256344"))
          .setTruncateConcat(true)
          .build();

  BatchMedia mediaResponseDto =
      BatchMedia.builder()
          .setId("01FC66621XXXXX119Z8PMV1QPQ")
          .setCanceled(false)
          .setCreatedAt(Instant.parse("2019-08-24T14:14:22Z"))
          .setModifiedAt(Instant.parse("2019-08-24T14:15:22Z"))
          .setBody(MediaBodyDtoTest.mediaBodyDto)
          .setCallbackUrl("callback url")
          .setClientReference("client reference")
          .setDeliveryReport(DeliveryReportType.SUMMARY)
          .setExpireAt(Instant.parse("2019-08-24T14:17:22Z"))
          .setFeedbackEnabled(false)
          .setFrom("+15551231234")
          .setParameters(parameters)
          .setSendAt(Instant.parse("2019-08-24T14:16:22Z"))
          .setTo(Arrays.asList("+15551231234", "+15551256344"))
          .setStrictValidation(true)
          .build();

  @Test
  void deserializeBinary() {

    TestHelpers.recursiveEquals(loadedBinaryDto, binaryResponseDto);
  }

  @Test
  void deserializeText() {

    TestHelpers.recursiveEquals(loadedTextDto, textResponseDto);
  }

  @Test
  void deserializeMedia() {

    TestHelpers.recursiveEquals(loadedMediaDto, mediaResponseDto);
  }
}
