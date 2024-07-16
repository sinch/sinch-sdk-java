package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.api.v1.WebHooksService;
import com.sinch.sdk.domains.numbers.models.v1.WebhooksDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.webhooks.NumberEvent;
import com.sinch.sdk.models.Configuration;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@TestWithResources
public class WebhooksServiceTest extends BaseTest {

  @GivenTextResource("/domains/numbers/v1/webhooks/number-event.json")
  String incomingWebhookJSON;

  WebHooksService webHooksService;

  @Test
  void parse() throws ApiException {

    NumberEvent response = webHooksService.parseEvent(incomingWebhookJSON);

    TestHelpers.recursiveEquals(response, WebhooksDtoTest.numberEvent);
  }

  @BeforeEach
  public void setUp() throws IOException {

    Configuration configuration =
        Configuration.builder()
            .setProjectId("unused")
            .setKeyId("unused")
            .setKeySecret("unused")
            .build();

    webHooksService = new SinchClient(configuration).numbers().v1().webhooks();
  }
}
