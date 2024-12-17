package com.sinch.sdk.domains.sms.models.v1.batches.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.sms.models.v1.batches.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.v1.batches.MediaBodyDtoTest;
import java.time.Instant;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
class SendRequestDtoTest extends BaseTest {
  @GivenTextResource("/domains/sms/v1/batches/request/BinaryRequestDto.json")
  String jsonRequestBinaryDto;

  @GivenTextResource("/domains/sms/v1/batches/request/TextRequestDto.json")
  String jsonRequestTextDto;

  @GivenTextResource("/domains/sms/v1/batches/request/MediaRequestDto.json")
  String jsonRequestMediaDto;

  @Test
  void serializeBinaryRequestDto() throws JsonProcessingException, JSONException {

    BinaryRequest binaryRequestDTO =
        BinaryRequest.builder()
            .setTo(Arrays.asList("+15551231234", "+15551256344"))
            .setBody("Hi ${name} ({an identifier}) ! How are you?")
            .setUdh("foo udh")
            .setFrom("+15551231234")
            .setDeliveryReport(DeliveryReportType.NONE)
            .setSendAt(Instant.parse("2019-08-24T14:19:22Z"))
            .setExpireAt(Instant.parse("2019-08-24T14:21:22Z"))
            .setCallbackUrl("callback url")
            .setClientReference("myReference")
            .setFeedbackEnabled(false)
            .setFromTon(6)
            .setFromNpi(18)
            .build();

    String serializedString = objectMapper.writeValueAsString(binaryRequestDTO);

    JSONAssert.assertEquals(jsonRequestBinaryDto, serializedString, true);
  }

  @Test
  void serializeTextRequestDto() throws JsonProcessingException, JSONException {

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

    TextRequest textRequestDTO =
        TextRequest.builder()
            .setTo(Arrays.asList("+15551231234", "+15551256344"))
            .setBody("Hi ${name} ({an identifier}) ! How are you?")
            .setFrom("+15551231234")
            .setDeliveryReport(DeliveryReportType.NONE)
            .setSendAt(Instant.parse("2019-08-24T14:19:22Z"))
            .setExpireAt(Instant.parse("2019-08-24T14:21:22Z"))
            .setCallbackUrl("callback url")
            .setClientReference("myReference")
            .setFeedbackEnabled(false)
            .setFlashMessage(true)
            .setTruncateConcat(true)
            .setMaxNumberOfMessageParts(1)
            .setFromTon(6)
            .setFromNpi(18)
            .setParameters(parameters)
            .build();

    String serializedString = objectMapper.writeValueAsString(textRequestDTO);

    JSONAssert.assertEquals(jsonRequestTextDto, serializedString, true);
  }

  @Test
  void serializeMediaRequestDto() throws JsonProcessingException, JSONException {

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

    MediaRequest mediaRequestDTO =
        MediaRequest.builder()
            .setTo(Arrays.asList("+15551231234", "+15551256344"))
            .setBody(MediaBodyDtoTest.mediaBodyDto)
            .setFrom("+15551231234")
            .setDeliveryReport(DeliveryReportType.SUMMARY)
            .setSendAt(Instant.parse("2019-08-24T14:16:22Z"))
            .setExpireAt(Instant.parse("2019-08-24T14:17:22Z"))
            .setCallbackUrl("callback url")
            .setClientReference("client reference")
            .setFeedbackEnabled(false)
            .setStrictValidation(true)
            .setParameters(parameters)
            .build();

    String serializedString = objectMapper.writeValueAsString(mediaRequestDTO);

    JSONAssert.assertEquals(jsonRequestMediaDto, serializedString, true);
  }
}
