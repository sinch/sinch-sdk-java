package com.sinch.sdk.domains.sms.models.v1.batches.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.sms.models.v1.batches.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.v1.batches.MediaBody;
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
class UpdateBatchRequestDtoTest extends BaseTest {
  @GivenTextResource("/domains/sms/v1/batches/request/UpdateBinaryRequestDto.json")
  String jsonRequestBinaryDto;

  @GivenTextResource("/domains/sms/v1/batches/request/UpdateTextRequestDto.json")
  String jsonRequestTextDto;

  @GivenTextResource("/domains/sms/v1/batches/request/UpdateMediaRequestDto.json")
  String jsonRequestMediaDto;

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

  @Test
  void serializeBinaryRequestDto() throws JsonProcessingException, JSONException {

    UpdateBinaryRequest binaryRequestDTO =
        UpdateBinaryRequest.builder()
            .setFrom("+15551231234")
            .setToAdd(Arrays.asList("+15551231234", "+15987365412"))
            .setToRemove(Arrays.asList("+0123456789", "+9876543210"))
            .setDeliveryReport(DeliveryReportType.FULL)
            .setSendAt(Instant.parse("2019-08-24T14:19:22Z"))
            .setExpireAt(Instant.parse("2019-08-24T14:21:22Z"))
            .setCallbackUrl("callback url")
            .setClientReference("a client reference")
            .setFeedbackEnabled(true)
            .setBody("Hi ${name} ({an identifier}) ! How are you?")
            .setUdh("foo udh")
            .setFromTon(3)
            .setFromNpi(10)
            .build();

    String serializedString = objectMapper.writeValueAsString(binaryRequestDTO);

    JSONAssert.assertEquals(jsonRequestBinaryDto, serializedString, true);
  }

  @Test
  void serializeTextRequestDto() throws JsonProcessingException, JSONException {

    UpdateTextRequest textRequestDTO =
        UpdateTextRequest.builder()
            .setFrom("+15551231234")
            .setToAdd(Arrays.asList("+15551231234", "+15551256344"))
            .setToRemove(Arrays.asList("+0123456789", "+9876543210"))
            .setDeliveryReport(DeliveryReportType.NONE)
            .setSendAt(Instant.parse("2019-08-24T14:19:22Z"))
            .setExpireAt(Instant.parse("2019-08-24T14:21:22Z"))
            .setCallbackUrl("callback url")
            .setClientReference("a client reference")
            .setFeedbackEnabled(true)
            .setParameters(parameters)
            .setBody("Hi ${name} ({an identifier}) ! How are you?")
            .setFromTon(3)
            .setFromNpi(15)
            .setMaxNumberOfMessageParts(4)
            .setTruncateConcat(true)
            .setFlashMessage(false)
            .build();

    String serializedString = objectMapper.writeValueAsString(textRequestDTO);

    JSONAssert.assertEquals(jsonRequestTextDto, serializedString, true);
  }

  @Test
  void serializeMediaRequestDto() throws JsonProcessingException, JSONException {

    UpdateMediaRequest mediaRequestDTO =
        UpdateMediaRequest.builder()
            .setFrom("+15551231234")
            .setToAdd(Arrays.asList("+15551231234", "+15987365412"))
            .setToRemove(Arrays.asList("+0123456789", "+9876543210"))
            .setDeliveryReport(DeliveryReportType.SUMMARY)
            .setSendAt(Instant.parse("2019-08-24T14:16:22Z"))
            .setExpireAt(Instant.parse("2019-08-24T14:17:22Z"))
            .setCallbackUrl("callback url")
            .setClientReference("a client reference")
            .setFeedbackEnabled(true)
            .setBody(
                MediaBody.builder()
                    .setUrl(
                        "https://en.wikipedia.org/wiki/Sinch_(company)#/media/File:Sinch_LockUp_RGB.png")
                    .setMessage("Hi ${name} ({an identifier}) ! How are you?")
                    .build())
            .setParameters(parameters)
            .setStrictValidation(true)
            .build();

    String serializedString = objectMapper.writeValueAsString(mediaRequestDTO);

    JSONAssert.assertEquals(jsonRequestMediaDto, serializedString, true);
  }
}
