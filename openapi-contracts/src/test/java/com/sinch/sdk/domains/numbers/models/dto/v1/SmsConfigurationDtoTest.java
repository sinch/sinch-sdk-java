package com.sinch.sdk.domains.numbers.models.dto.v1;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sinch.sdk.BaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
class SmsConfigurationDtoTest extends BaseTest {

  @GivenTextResource("/domains/numbers/v1/SMSConfigurationDtoServicePlanIdNull.json")
  String SMSConfigurationDtoServicePlanIdNull;

  @GivenTextResource("/domains/numbers/v1/SMSConfigurationDtoServicePlanIdUndefined.json")
  String SMSConfigurationDtoServicePlanIdUndefined;

  @GivenTextResource("/domains/numbers/v1/SMSConfigurationDtoServicePlanIdValue.json")
  String SMSConfigurationDtoServicePlanIdValue;

  @Test
  void serializeServicePlanIdNull() throws JsonProcessingException, JSONException {
    SMSConfigurationDto dto = new SMSConfigurationDto().servicePlanId(null);

    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(SMSConfigurationDtoServicePlanIdNull, serializedString, true);
  }

  @Test
  void serializeServicePlanIdUndefined() throws JsonProcessingException, JSONException {
    SMSConfigurationDto dto = new SMSConfigurationDto();

    JsonMappingException thrown =
        assertThrows(
            JsonMappingException.class,
            () -> objectMapper.writeValueAsString(dto),
            "Expected objectMapper.writeValueAsString() to throw, but it didn't");
    assertTrue(thrown.getMessage().contains("Required property 'servicePlanId' was not set"));
  }

  @Test
  void serializeServicePlanIdValue() throws JsonProcessingException, JSONException {
    SMSConfigurationDto dto =
        new SMSConfigurationDto().servicePlanId("my service plan id").campaignId("my campaign id");

    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(SMSConfigurationDtoServicePlanIdValue, serializedString, true);
  }
}
