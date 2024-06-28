package com.sinch.sdk.domains.numbers.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersBaseTest;
import com.sinch.sdk.domains.numbers.models.v1.active.request.ActiveNumberUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.active.response.internal.ActiveNumberListResponseInternal;
import java.time.Instant;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ActiveNumberDtoTest extends NumbersBaseTest {

  @GivenTextResource("/domains/numbers/v1/active/active-numbers-get.json")
  String activeNumberJson;

  @GivenTextResource("/domains/numbers/v1/active/active-numbers-list.json")
  String activeListResponseJson;

  @GivenTextResource("/domains/numbers/v1/active/active-numbers-list-light.json")
  String activeListLightResponseJson;

  @GivenTextResource("/domains/numbers/v1/active/active-numbers-update.json")
  String activeNumberUpdateRequestJson;

  public static ActiveNumber activeNumber =
      ActiveNumber.builder()
          .setPhoneNumber("+447520651116XYZ")
          .setProjectId("project id")
          .setDisplayName("a display")
          .setRegionCode("GB")
          .setType(NumberType.MOBILE)
          .setCapability(Arrays.asList(Capability.SMS, Capability.VOICE))
          .setMoney(Money.builder().setCurrencyCode("EUR").setAmount(0.8).build())
          .setPaymentIntervalMonths(1)
          .setNextChargeDate(Instant.parse("2023-09-22T15:49:58.813424Z"))
          .setExpireAt(Instant.parse("2023-10-06T15:49:58.813381Z"))
          .setSmsConfiguration(SmsConfigurationDtoTest.configuration)
          .setVoiceConfiguration(VoiceConfigurationDtoTest.configurationRTC)
          .setCallbackUrl("foo callback")
          .build();

  public static ActiveNumberUpdateRequest activeNumberUpdateRequest =
      ActiveNumberUpdateRequest.builder()
          .setDisplayName("a display")
          .setSmsConfiguration(
              SmsConfiguration.builder()
                  .setServicePlanId("service plan id")
                  .setCampaignId("campaign id")
                  .build())
          .setVoiceConfiguration(
              VoiceConfiguration.builder()
                  .setAppId("AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEE")
                  .setType(VoiceApplicationType.RTC)
                  .build())
          .setCallbackUrl("foo callback")
          .build();

  public static ActiveNumberListResponseInternal activeNumberList =
      ActiveNumberListResponseInternal.builder()
          .setActiveNumbers(Arrays.asList(activeNumber))
          .setNextPageToken("foo")
          .setTotalSize(1)
          .build();

  public static ActiveNumberListResponseInternal activeNumberListLight =
      ActiveNumberListResponseInternal.builder()
          .setActiveNumbers(
              Arrays.asList(
                  ActiveNumber.builder()
                      .setPhoneNumber("+447520651116XYZ")
                      .setProjectId("project id")
                      .setDisplayName("")
                      .setRegionCode("GB")
                      .setType(NumberType.MOBILE)
                      .setCapability(Arrays.asList(Capability.SMS, Capability.VOICE))
                      .setMoney(Money.builder().setCurrencyCode("EUR").setAmount(0.8).build())
                      .setPaymentIntervalMonths(1)
                      .setNextChargeDate(Instant.parse("2023-09-22T15:49:58.813424Z"))
                      .setExpireAt(Instant.parse("2023-10-06T15:49:58.813381Z"))
                      .setSmsConfiguration(
                          SmsConfiguration.builder()
                              .setServicePlanId("service plan id")
                              .setCampaignId("")
                              .build())
                      .setVoiceConfiguration(
                          VoiceConfiguration.builder().setAppId("app id").build())
                      .setCallbackUrl("")
                      .build()))
          .setNextPageToken("")
          .setTotalSize(1)
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(activeNumber);

    JSONAssert.assertEquals(activeNumberJson, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {

    ActiveNumber deserializedString = objectMapper.readValue(activeNumberJson, ActiveNumber.class);

    TestHelpers.recursiveEquals(activeNumber, deserializedString);
  }

  @Test
  void deserializeList() throws JsonProcessingException {

    ActiveNumberListResponseInternal deserializedString =
        objectMapper.readValue(activeListResponseJson, ActiveNumberListResponseInternal.class);

    TestHelpers.recursiveEquals(activeNumberList, deserializedString);
  }

  @Test
  void deserializeListLight() throws JsonProcessingException {

    ActiveNumberListResponseInternal deserializedString =
        objectMapper.readValue(activeListLightResponseJson, ActiveNumberListResponseInternal.class);

    TestHelpers.recursiveEquals(activeNumberListLight, deserializedString);
  }

  @Test
  void serializeUpdateRequest() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(activeNumberUpdateRequest);

    JSONAssert.assertEquals(activeNumberUpdateRequestJson, serializedString, true);
  }
}
