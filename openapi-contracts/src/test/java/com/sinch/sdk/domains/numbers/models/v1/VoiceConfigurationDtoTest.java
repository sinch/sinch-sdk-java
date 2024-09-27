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

  @GivenTextResource("/domains/numbers/v1/active/VoiceConfigurationRequestDtoEST.json")
  String configurationRequestJsonEST;

  @GivenTextResource("/domains/numbers/v1/active/VoiceConfigurationResponseDtoEST.json")
  String configurationResponseJsonEST;

  @GivenTextResource("/domains/numbers/v1/active/VoiceConfigurationRequestDtoFAX.json")
  String configurationRequestJsonFAX;

  @GivenTextResource("/domains/numbers/v1/active/VoiceConfigurationResponseDtoFAX.json")
  String configurationResponseJsonFAX;

  @GivenTextResource("/domains/numbers/v1/active/VoiceConfigurationRequestDtoRTC.json")
  String configurationRequestJsonRTC;

  @GivenTextResource("/domains/numbers/v1/active/VoiceConfigurationResponseDtoRTC.json")
  String configurationResponseJsonRTC;

  @GivenTextResource("/domains/numbers/v1/active/VoiceConfigurationDtoRTCSwitchToFAX.json")
  String configurationJsonRTCSwitchToFAX;

  public static VoiceConfigurationEST configurationRequestEST =
      VoiceConfigurationEST.builder().setTrunkId("AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEE").build();

  public static VoiceConfigurationEST configurationResponseEST =
      VoiceConfigurationEST.builder()
          .setTrunkId("AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEE")
          .setLastUpdatedTime(Instant.parse("2024-06-30T07:08:09.10Z"))
          .setScheduledProvisioning(ScheduledVoiceProvisioningDtoTest.provisioningEST)
          .build();
  public static VoiceConfigurationFAX configurationRequestFAX =
      VoiceConfigurationFAX.builder().setServiceId("AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEE").build();

  public static VoiceConfigurationFAX configurationResponseFAX =
      VoiceConfigurationFAX.builder()
          .setServiceId("AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEE")
          .setLastUpdatedTime(Instant.parse("2024-06-30T07:08:09.10Z"))
          .setScheduledProvisioning(ScheduledVoiceProvisioningDtoTest.provisioningFAX)
          .build();

  public static VoiceConfigurationRTC configurationRequestRTC =
      VoiceConfigurationRTC.builder().setAppId("AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEE").build();

  public static VoiceConfigurationRTC configurationResponseRTC =
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

    String serializedString = objectMapper.writeValueAsString(configurationRequestEST);

    JSONAssert.assertEquals(configurationRequestJsonEST, serializedString, true);
  }

  @Test
  void deserializeEST() throws JsonProcessingException {

    VoiceConfiguration deserializedString =
        objectMapper.readValue(configurationResponseJsonEST, VoiceConfigurationEST.class);

    TestHelpers.recursiveEquals(configurationResponseEST, deserializedString);
  }

  @Test
  void serializeFAX() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(configurationRequestFAX);

    JSONAssert.assertEquals(configurationRequestJsonFAX, serializedString, true);
  }

  @Test
  void deserializeFAX() throws JsonProcessingException {

    VoiceConfiguration deserializedString =
        objectMapper.readValue(configurationResponseJsonFAX, VoiceConfigurationFAX.class);

    TestHelpers.recursiveEquals(configurationResponseFAX, deserializedString);
  }

  @Test
  void serializeRTC() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(configurationRequestRTC);

    JSONAssert.assertEquals(configurationRequestJsonRTC, serializedString, true);
  }

  @Test
  void deserializeRTC() throws JsonProcessingException {

    VoiceConfiguration deserializedString =
        objectMapper.readValue(configurationResponseJsonRTC, VoiceConfigurationRTC.class);

    TestHelpers.recursiveEquals(configurationResponseRTC, deserializedString);
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
        objectMapper.readValue(configurationRequestJsonRTC, VoiceConfigurationInternalImpl.class);
    TestHelpers.recursiveEquals(configurationRequestRTC, deserializedString.getActualInstance());
  }
}
