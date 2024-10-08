package com.sinch.sdk.domains.voice.adapters.converters;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.ApplicationAssignedNumber;
import com.sinch.sdk.domains.voice.models.ApplicationURL;
import com.sinch.sdk.domains.voice.models.CallbackUrls;
import com.sinch.sdk.domains.voice.models.CapabilityType;
import com.sinch.sdk.domains.voice.models.NumberInformation;
import com.sinch.sdk.domains.voice.models.NumberType;
import com.sinch.sdk.domains.voice.models.Price;
import com.sinch.sdk.domains.voice.models.requests.ApplicationsAssignNumbersRequestParameters;
import com.sinch.sdk.domains.voice.models.response.AssignedNumbers;
import com.sinch.sdk.domains.voice.models.v1.applications.ApplicationsCallbackUrlsDtoTest;
import com.sinch.sdk.domains.voice.models.v1.applications.ApplicationsGetNumbersResponseDtoTest;
import com.sinch.sdk.domains.voice.models.v1.applications.ApplicationsQueryNumberResponseDtoTest;
import com.sinch.sdk.domains.voice.models.v1.applications.ApplicationsUnassignNumberRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v1.applications.ApplicationsUpdateNumberRequestDtoTest;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Arrays;
import java.util.Collections;
import org.assertj.core.api.Assertions;
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
    Assertions.assertThat(
            ApplicationsDtoConverter.convert(ApplicationsGetNumbersResponseDtoTest.expected))
        .usingRecursiveComparison()
        .isEqualTo(expectedAssignedNumbersResponse);
  }

  @Test
  void convertCallbackUrlsResponseDto() {
    Assertions.assertThat(
            ApplicationsDtoConverter.convert(ApplicationsCallbackUrlsDtoTest.expected))
        .usingRecursiveComparison()
        .isEqualTo(expectedApplicationsCallbackUrls);
  }

  @Test
  void convertCallbackUrlsRequestDto() {
    Assertions.assertThat(ApplicationsDtoConverter.convert(expectedApplicationsCallbackUrls))
        .usingRecursiveComparison()
        .isEqualTo(ApplicationsCallbackUrlsDtoTest.expected);
  }

  @Test
  void convertGetQueryNumberDto() {
    Assertions.assertThat(
            ApplicationsDtoConverter.convert(ApplicationsQueryNumberResponseDtoTest.expected))
        .usingRecursiveComparison()
        .isEqualTo(expectedApplicationsNumberInformation);
  }

  @Test
  void convertApplicationsUpdateNumberRequestParameters() {
    Assertions.assertThat(
            ApplicationsDtoConverter.convert(expectedApplicationsAssignNumbersRequestParameters))
        .usingRecursiveComparison()
        .isEqualTo(ApplicationsUpdateNumberRequestDtoTest.updateNumbersDto);
  }

  @Test
  void convertUnassignNumbersDto() {
    Assertions.assertThat(
            ApplicationsDtoConverter.convert(E164PhoneNumber.valueOf("+12073091712"), "an app key"))
        .usingRecursiveComparison()
        .isEqualTo(ApplicationsUnassignNumberRequestDtoTest.unassignNumberDto);
  }
}
