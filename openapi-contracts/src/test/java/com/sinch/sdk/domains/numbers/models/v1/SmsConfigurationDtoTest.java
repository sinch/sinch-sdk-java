package com.sinch.sdk.domains.numbers.models.v1;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersBaseTest;
import java.time.Instant;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SmsConfigurationDtoTest extends NumbersBaseTest {

  @GivenTextResource("/domains/numbers/v1/active/SmsConfigurationDto.json")
  String configurationJSON;

  @GivenTextResource("/domains/numbers/v1/active/SmsConfigurationDtoServicePlanIdNull.json")
  String SMSConfigurationDtoServicePlanIdNull;

  @GivenTextResource("/domains/numbers/v1/active/SmsConfigurationDtoServicePlanIdValue.json")
  String SMSConfigurationDtoServicePlanIdValue;

  public static SmsConfiguration configuration =
      SmsConfiguration.builder()
          .setServicePlanId("service plan id")
          .setCampaignId("campaign id")
          .setScheduledProvisioning(
              ScheduledSmsProvisioning.builder()
                  .setServicePlanId("service plan id from scheduled")
                  .setCampaignId("campaign id from scheduled")
                  .setStatus(ProvisioningStatus.PROVISIONING_STATUS_UNSPECIFIED)
                  .setLastUpdatedTime(Instant.parse("2023-09-25T12:08:02.115Z"))
                  .setErrorCodes(Arrays.asList(SmsErrorCode.ERROR_CODE_UNSPECIFIED))
                  .build())
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(configuration);

    JSONAssert.assertEquals(configurationJSON, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {

    SmsConfiguration deserializedString =
        objectMapper.readValue(configurationJSON, configuration.getClass());

    TestHelpers.recursiveEquals(configuration, deserializedString);
  }

  @Test
  void serializeServicePlanIdNull() throws JsonProcessingException, JSONException {
    SmsConfiguration dto = SmsConfiguration.builder().setServicePlanId(null).build();

    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(SMSConfigurationDtoServicePlanIdNull, serializedString, true);
  }

  @Test
  void serializeServicePlanIdUndefined() {
    SmsConfiguration dto = SmsConfiguration.builder().build();
    JsonMappingException thrown =
        assertThrows(
            JsonMappingException.class,
            () -> objectMapper.writeValueAsString(dto),
            "Expected objectMapper.writeValueAsString() to throw, but it didn't");
    assertTrue(thrown.getMessage().contains("Required property 'servicePlanId' was not set"));
  }

  @Test
  void serializeServicePlanIdValue() throws JsonProcessingException, JSONException {
    SmsConfiguration dto =
        SmsConfiguration.builder()
            .setServicePlanId("my service plan id")
            .setCampaignId("my campaign id")
            .build();

    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(SMSConfigurationDtoServicePlanIdValue, serializedString, true);
  }
}
