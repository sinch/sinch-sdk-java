package com.sinch.sdk.domains.sms.models.v1.inbounds;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@TestWithResources
public class InboundMessageDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/inbounds/InboundBinaryDto.json")
  InboundMessage loadedBinaryMessage;

  @GivenJsonResource("/domains/sms/v1/inbounds/InboundTextDto.json")
  InboundMessage loadedTextMessage;

  @GivenJsonResource("/domains/sms/v1/inbounds/InboundMediaDto.json")
  InboundMessage loadedMediaMessage;

  public static BinaryMessage binaryDTO =
      BinaryMessage.builder()
          .setClientReference("a client reference")
          .setFrom("+11203494390")
          .setId("01FC66621XXXXX119Z8PMV1QPA")
          .setOperatorId("35000")
          .setReceivedAt(Instant.parse("2019-08-24T14:17:22Z"))
          .setSentAt(Instant.parse("2019-08-24T14:15:22Z"))
          .setTo("11203453453")
          .setBody("a body")
          .setUdh("foo udh")
          .build();

  public static TextMessage textDTO =
      TextMessage.builder()
          .setClientReference("a client reference")
          .setFrom("+11203494390")
          .setId("01FC66621XXXXX119Z8PMV1QPA")
          .setOperatorId("35000")
          .setReceivedAt(Instant.parse("2019-08-24T14:17:22Z"))
          .setSentAt(Instant.parse("2019-08-24T14:15:22Z"))
          .setTo("11203453453")
          .setBody("a body")
          .build();

  public static MediaMessage mediaDTO =
      MediaMessage.builder()
          .setClientReference("a client reference")
          .setFrom("+11203494390")
          .setId("01FC66621XXXXX119Z8PMV1QPA")
          .setOperatorId("35000")
          .setReceivedAt(Instant.parse("2019-08-24T14:17:22Z"))
          .setSentAt(Instant.parse("2019-08-24T14:15:22Z"))
          .setTo("11203453453")
          .setBody(
              MediaMessageBody.builder()
                  .setMessage("my message")
                  .setSubject("mmy subject")
                  .setMedia(
                      Arrays.asList(
                          MediaMessageBodyDetails.builder()
                              .setCode(1234)
                              .setContentType("content/type")
                              .setStatus("a status")
                              .setUrl("https://foo.url")
                              .build()))
                  .build())
          .build();

  @Test
  void deserializeBinaryMessage() {

    TestHelpers.recursiveEquals(binaryDTO, loadedBinaryMessage);
  }

  @Test
  void deserializeTextMessage() {

    TestHelpers.recursiveEquals(textDTO, loadedTextMessage);
  }

  @Test
  void deserializeMediaMessage() {

    TestHelpers.recursiveEquals(mediaDTO, loadedMediaMessage);
  }
}
