package com.sinch.sdk.domains.numbers.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersBaseTest;
import com.sinch.sdk.domains.numbers.models.v1.internal.VoiceConfigurationInternalImpl;
import java.time.Instant;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class VoiceConfigurationDtoTest extends NumbersBaseTest {

  @GivenTextResource("/domains/numbers/v1/active/VoiceConfigurationDtoEST.json")
  String configurationJsonEST;

  @GivenTextResource("/domains/numbers/v1/active/VoiceConfigurationDtoFAX.json")
  String configurationJsonFAX;

  @GivenTextResource("/domains/numbers/v1/active/VoiceConfigurationDtoRTC.json")
  String configurationJsonRTC;

  @GivenTextResource("/domains/numbers/v1/active/VoiceConfigurationDtoRTCSwitchToFAX.json")
  String configurationJsonRTCSwitchToFAX;

  public static VoiceConfigurationEST configurationEST =
      VoiceConfigurationEST.builder()
          .setTrunkId("AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEE")
          .setLastUpdatedTime(Instant.parse("2024-06-30T07:08:09.10Z"))
          .setScheduledProvisioning(ScheduledVoiceProvisioningDtoTest.provisioningEST)
          .build();

  public static VoiceConfigurationFAX configurationFAX =
      VoiceConfigurationFAX.builder()
          .setServiceId("AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEE")
          .setLastUpdatedTime(Instant.parse("2024-06-30T07:08:09.10Z"))
          .setScheduledProvisioning(ScheduledVoiceProvisioningDtoTest.provisioningFAX)
          .build();
  public static VoiceConfigurationRTC configurationRTC =
      VoiceConfigurationRTC.builder()
          .setAppId("AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEE")
          .setLastUpdatedTime(Instant.parse("2024-06-30T07:08:09.10Z"))
          .setScheduledProvisioning(ScheduledVoiceProvisioningDtoTest.provisioningRTC)
          .build();

  public static VoiceConfigurationRTC configurationRTCSwitchToFAX =
      VoiceConfigurationRTC.builder()
          .setAppId("AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEE")
          .setLastUpdatedTime(Instant.parse("2024-06-30T07:08:09.10Z"))
          .setScheduledProvisioning(ScheduledVoiceProvisioningDtoTest.provisioningFAX)
          .build();

  @Test
  void serializeEST() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(configurationEST);

    JSONAssert.assertEquals(configurationJsonEST, serializedString, true);
  }

  @Test
  void deserializeEST() throws JsonProcessingException {

    VoiceConfiguration deserializedString =
        objectMapper.readValue(configurationJsonEST, VoiceConfigurationEST.class);

    TestHelpers.recursiveEquals(configurationEST, deserializedString);
  }

  @Test
  void serializeFAX() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(configurationFAX);

    JSONAssert.assertEquals(configurationJsonFAX, serializedString, true);
  }

  @Test
  void deserializeFAX() throws JsonProcessingException {

    VoiceConfiguration deserializedString =
        objectMapper.readValue(configurationJsonFAX, VoiceConfigurationFAX.class);

    TestHelpers.recursiveEquals(configurationFAX, deserializedString);
  }

  @Test
  void serializeRTC() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(configurationRTC);

    JSONAssert.assertEquals(configurationJsonRTC, serializedString, true);
  }

  @Test
  void deserializeRTC() throws JsonProcessingException {

    VoiceConfiguration deserializedString =
        objectMapper.readValue(configurationJsonRTC, VoiceConfigurationRTC.class);

    TestHelpers.recursiveEquals(configurationRTC, deserializedString);
  }

  @Test
  void deserializeRTCSwitchToFax() throws JsonProcessingException {

    VoiceConfiguration deserializedString =
        objectMapper.readValue(configurationJsonRTCSwitchToFAX, VoiceConfigurationRTC.class);

    TestHelpers.recursiveEquals(configurationRTCSwitchToFAX, deserializedString);
  }

  @Test
  void deserialize() throws JsonProcessingException {

    VoiceConfigurationInternalImpl deserializedString =
        objectMapper.readValue(configurationJsonRTC, VoiceConfigurationInternalImpl.class);
    TestHelpers.recursiveEquals(configurationRTC, deserializedString.getActualInstance());
  }
}
