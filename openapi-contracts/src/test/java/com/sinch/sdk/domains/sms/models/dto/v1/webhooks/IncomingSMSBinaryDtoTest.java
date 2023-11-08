package com.sinch.sdk.domains.sms.models.dto.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.sms.models.webhooks.IncomingSMSBinary;
import java.time.OffsetDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class IncomingSMSBinaryDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/webhooks/IncomingSMSBinary.json")
  IncomingSMSBinary client;

  public static IncomingSMSBinary incomingSMSBinary =
      new IncomingSMSBinary(
          "VGV4dCBtZXNzYWdl",
          "16051234567",
          "01XXXXX21XXXXX119Z8P1XXXXX",
          OffsetDateTime.parse("2022-08-24T14:15:22Z"),
          "13185551234",
          null,
          "operator",
          OffsetDateTime.parse("2022-08-24T14:15:44Z"),
          "10010203040506070809000a0b0c0d0e0f");

  @Test
  void deserialize() {

    Assertions.assertThat(incomingSMSBinary).usingRecursiveComparison().isEqualTo(client);
  }
}
