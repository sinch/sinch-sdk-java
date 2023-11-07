package com.sinch.sdk.domains.sms.models.dto.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.sms.models.webhooks.IncomingSMSText;
import java.time.OffsetDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class IncomingSMSTextDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/webhooks/IncomingSMSText.json")
  IncomingSMSText client;

  public static IncomingSMSText incomingSMSText =
      new IncomingSMSText(
          "This is a test message.",
          "16051234567",
          "01XXXXX21XXXXX119Z8P1XXXXX",
          OffsetDateTime.parse("2022-08-24T14:15:22Z"),
          "13185551234",
          null,
          "string",
          null);

  @Test
  void deserialize() {

    Assertions.assertThat(incomingSMSText).usingRecursiveComparison().isEqualTo(client);
  }
}
