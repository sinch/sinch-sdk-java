package com.sinch.sdk.domains.numbers.adapters;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.WebHooksService;
import com.sinch.sdk.domains.numbers.adapters.converters.CallbackPayloadDtoConverter;
import com.sinch.sdk.domains.numbers.models.v1.WebhooksDtoTest;
import com.sinch.sdk.domains.numbers.models.webhooks.EventNotification;
import com.sinch.sdk.models.Configuration;
import java.io.IOException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@TestWithResources
public class WebhooksServiceTest extends BaseTest {

  @GivenTextResource("/domains/numbers/v1/webhooks/number-event.json")
  String incomingCallbackPayloadDtoJsonString;

  WebHooksService webHooksService;

  @Test
  void incomingEventNotification() throws ApiException {

    EventNotification response =
        webHooksService.unserializeEventNotification(incomingCallbackPayloadDtoJsonString);

    Assertions.assertThat(response).isInstanceOf(EventNotification.class);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(CallbackPayloadDtoConverter.convert(WebhooksDtoTest.numberEvent));
  }

  @BeforeEach
  public void setUp() throws IOException {

    Configuration configuration =
        Configuration.builder()
            .setProjectId("unused")
            .setKeyId("unused")
            .setKeySecret("unused")
            .build();

    webHooksService = new SinchClient(configuration).numbers().webhooks();
  }
}
