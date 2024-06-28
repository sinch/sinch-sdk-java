package com.sinch.sdk.domains.numbers.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersBaseTest;
import java.time.Instant;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class VoiceConfigurationDtoTest extends NumbersBaseTest {

  @GivenTextResource("/domains/numbers/v1/active/VoiceConfigurationDtoRTC.json")
  String configurationJsonRTC;

  public static VoiceConfiguration configurationRTC =
      VoiceConfiguration.builder()
          .setAppId("AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEE")
          .setType(VoiceApplicationType.RTC)
          .setLastUpdatedTime(Instant.parse("2024-06-30T07:08:09.10Z"))
          .setScheduledProvisioning(
              ScheduledVoiceProvisioning.builder()
                  .setAppId("EEEEEEEEEE-DDDD-CCCC-BBBB-AAAAAAAA")
                  .setStatus(ProvisioningStatus.WAITING)
                  .setLastUpdatedTime(Instant.parse("2024-07-01T11:58:35.610198Z"))
                  .build())
          .build();

  @Test
  void serializeRTC() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(configurationRTC);

    JSONAssert.assertEquals(configurationJsonRTC, serializedString, true);
  }

  @Test
  void deserializeRTC() throws JsonProcessingException {

    VoiceConfiguration deserializedString =
        objectMapper.readValue(configurationJsonRTC, VoiceConfiguration.class);

    TestHelpers.recursiveEquals(configurationRTC, deserializedString);
  }
}
