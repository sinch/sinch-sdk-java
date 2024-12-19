package com.sinch.sdk.domains.sms.models.v1.inbounds;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import java.time.Instant;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
class InboundMessageDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/inbounds/MOBinaryDto.json")
  InboundMessage loadedBinaryMessage;

  @GivenJsonResource("/domains/sms/v1/inbounds/MOTextDto.json")
  InboundMessage loadedTextMessage;

  @GivenJsonResource("/domains/sms/v1/inbounds/MOMediaDto.json")
  InboundMessage loadedMediaMessage;

  BinaryMessage binaryDTO =
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

  TextMessage textDTO =
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

  MediaMessage mediaDTO =
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

    Assertions.assertThat(loadedBinaryMessage).usingRecursiveComparison().isEqualTo(binaryDTO);
  }

  @Test
  void deserializeTextMessage() {

    Assertions.assertThat(loadedTextMessage).usingRecursiveComparison().isEqualTo(textDTO);
  }

  @Test
  void deserializeMediaMessage() {

    Assertions.assertThat(loadedMediaMessage).usingRecursiveComparison().isEqualTo(mediaDTO);
  }
}
