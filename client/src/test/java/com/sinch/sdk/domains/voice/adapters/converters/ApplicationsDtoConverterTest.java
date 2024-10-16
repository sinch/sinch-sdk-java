package com.sinch.sdk.domains.voice.adapters.converters;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.ApplicationAssignedNumber;
import com.sinch.sdk.domains.voice.models.ApplicationURL;
import com.sinch.sdk.domains.voice.models.CallbackUrls;
import com.sinch.sdk.domains.voice.models.CapabilityType;
import com.sinch.sdk.domains.voice.models.NumberInformation;
import com.sinch.sdk.domains.voice.models.NumberType;
import com.sinch.sdk.domains.voice.models.Price;
import com.sinch.sdk.domains.voice.models.requests.ApplicationsAssignNumbersRequestParameters;
import com.sinch.sdk.domains.voice.models.response.AssignedNumbers;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UnAssignNumberRequestTest;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UpdateCallbackUrlsRequestTest;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UpdateNumbersRequestTest;
import com.sinch.sdk.domains.voice.models.v1.applications.response.OwnedNumbersResponseTest;
import com.sinch.sdk.domains.voice.models.v1.applications.response.QueryNumberResponseTest;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ApplicationsDtoConverterTest extends BaseTest {

  public static AssignedNumbers expectedAssignedNumbersResponse =
      AssignedNumbers.builder()
          .setNumbers(
              Arrays.asList(
                  ApplicationAssignedNumber.builder()
                      .setNumber(E164PhoneNumber.valueOf("+123456789"))
                      .setApplicationKey("an application key")
                      .setCapability(CapabilityType.VOICE)
                      .build(),
                  ApplicationAssignedNumber.builder()
                      .setNumber(E164PhoneNumber.valueOf("+134567890"))
                      .setCapability(CapabilityType.SMS)
                      .build()))
          .build();

  public static CallbackUrls expectedApplicationsCallbackUrls =
      CallbackUrls.builder()
          .setUrl(
              ApplicationURL.builder()
                  .setPrimary("https://foo.com")
                  .setFallback("https://fallback.foo.com")
                  .build())
          .build();

  public static NumberInformation expectedApplicationsNumberInformation =
      NumberInformation.builder()
          .setCountryId("FR")
          .setNumberType(NumberType.MOBILE)
          .setNormalizedNumber(E164PhoneNumber.valueOf("+331234567489"))
          .setRestricted(true)
          .setRate(Price.builder().setCurrencyId("USD").setAmount(0.1850F).build())
          .build();

  public static ApplicationsAssignNumbersRequestParameters
      expectedApplicationsAssignNumbersRequestParameters =
          ApplicationsAssignNumbersRequestParameters.builder()
              .setNumbers(Collections.singletonList(E164PhoneNumber.valueOf("+12073091712")))
              .setApplicationKey("an app key")
              .setCapability(CapabilityType.VOICE)
              .build();

  @Test
  void convertGetApplicationsNumbersResponseDto() {
    TestHelpers.recursiveEquals(
        ApplicationsDtoConverter.convert(OwnedNumbersResponseTest.expected),
        expectedAssignedNumbersResponse);
  }

  @Test
  void convertCallbackUrlsResponseDto() {
    TestHelpers.recursiveEquals(
        ApplicationsDtoConverter.convert(UpdateCallbackUrlsRequestTest.expected),
        expectedApplicationsCallbackUrls);
  }

  @Test
  void convertCallbackUrlsRequestDto() {
    TestHelpers.recursiveEquals(
        ApplicationsDtoConverter.convert(expectedApplicationsCallbackUrls),
        UpdateCallbackUrlsRequestTest.expected);
  }

  @Test
  void convertGetQueryNumberDto() {
    TestHelpers.recursiveEquals(
        ApplicationsDtoConverter.convert(QueryNumberResponseTest.expected),
        expectedApplicationsNumberInformation);
  }

  @Test
  void convertApplicationsUpdateNumberRequestParameters() {
    TestHelpers.recursiveEquals(
        ApplicationsDtoConverter.convert(expectedApplicationsAssignNumbersRequestParameters),
        UpdateNumbersRequestTest.updateNumbersDto);
  }

  @Test
  void convertUnAssignNumbersDto() {
    TestHelpers.recursiveEquals(
        ApplicationsDtoConverter.convert(E164PhoneNumber.valueOf("+12073091712"), "an app key"),
        UnAssignNumberRequestTest.unAssignNumberDto);
  }
}
