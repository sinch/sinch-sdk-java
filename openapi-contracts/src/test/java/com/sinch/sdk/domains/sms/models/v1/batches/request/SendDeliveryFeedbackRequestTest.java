package com.sinch.sdk.domains.sms.models.v1.batches.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
class SendDeliveryFeedbackRequestTest extends BaseTest {
  @GivenTextResource("/domains/sms/v1/batches/request/SendDeliveryFeedbackRequestDto.json")
  String jsonSendDeliveryFeedbackRequestDto;

  @Test
  void sendDeliveryFeedbackRequestRequestDto() throws JsonProcessingException, JSONException {

    SendDeliveryFeedbackRequest requestDTO =
        SendDeliveryFeedbackRequest.builder()
            .setRecipients(Arrays.asList("foo number 1", "foo number 2"))
            .build();

    String serializedString = objectMapper.writeValueAsString(requestDTO);

    JSONAssert.assertEquals(jsonSendDeliveryFeedbackRequestDto, serializedString, true);
  }
}
