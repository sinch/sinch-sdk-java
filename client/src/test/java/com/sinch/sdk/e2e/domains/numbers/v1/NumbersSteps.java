package com.sinch.sdk.e2e.domains.numbers.v1;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.Money;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.ProvisioningStatus;
import com.sinch.sdk.domains.numbers.models.v1.ScheduledSmsProvisioning;
import com.sinch.sdk.domains.numbers.models.v1.ScheduledVoiceProvisioningFAX;
import com.sinch.sdk.domains.numbers.models.v1.ScheduledVoiceProvisioningRTC;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.SmsErrorCode;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationEST;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationFAX;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationRTC;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentAnyRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.SearchPattern;
import com.sinch.sdk.domains.numbers.models.v1.request.SearchPosition;
import com.sinch.sdk.domains.numbers.models.v1.response.ActiveNumberListResponse;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumber;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumberListResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;

public class NumbersSteps {

  NumbersService service;

  AvailableNumberListResponse searchForAvailableNumbersResponse;
  AvailableNumber checkAvailabilityResponse;
  ApiException availabilityResponseException;
  ActiveNumber rentAnyResponse;
  ActiveNumber rentResponse;
  ActiveNumberListResponse activeNumberListResponse;
  ActiveNumberListResponse activeNumberListAllResponse;
  ActiveNumber updateResponse;
  ActiveNumber getResponse;
  ApiException getResponseException;
  ActiveNumber releaseResponse;

  @Given("^the Numbers service is available")
  public void serviceAvailable() {

    service = Config.getSinchClient().numbers().v1();
  }

  @When("^I send a request to search for available phone numbers$")
  public void searchForAvailableNumbers() {

    AvailableNumberListRequest parameters =
        AvailableNumberListRequest.builder().setRegionCode("US").setType(NumberType.LOCAL).build();
    searchForAvailableNumbersResponse = service.searchForAvailableNumbers(parameters);
  }

  @When("I send a request to check the availability of the phone number {string}")
  public void checkAvailability(String phoneNumber) {

    try {
      checkAvailabilityResponse = service.checkAvailability(phoneNumber);
    } catch (ApiException e) {
      availabilityResponseException = e;
    }
  }

  @When("^I send a request to rent a number with some criteria$")
  public void rentAny() {

    AvailableNumberRentAnyRequest parameters =
        AvailableNumberRentAnyRequest.builder()
            .setRegionCode("US")
            .setType(NumberType.LOCAL)
            .setCapabilities(Arrays.asList(Capability.SMS, Capability.VOICE))
            .setSmsConfiguration(
                SmsConfiguration.builder().setServicePlanId("SpaceMonkeySquadron").build())
            .setVoiceConfiguration(
                VoiceConfigurationRTC.builder()
                    .setAppId("sunshine-rain-drop-very-beautifulday")
                    .build())
            .setNumberPattern(
                SearchPattern.builder()
                    .setPattern("7654321")
                    .setPosition(SearchPosition.END)
                    .build())
            .build();
    rentAnyResponse = service.rentAny(parameters);
  }

  @When("I send a request to rent the phone number {string}")
  public void rent(String phoneNumber) {

    AvailableNumberRentRequest parameters =
        AvailableNumberRentRequest.builder()
            .setSmsConfiguration(
                SmsConfiguration.builder().setServicePlanId("SpaceMonkeySquadron").build())
            .setVoiceConfiguration(
                VoiceConfigurationRTC.builder()
                    .setAppId("sunshine-rain-drop-very-beautifulday")
                    .build())
            .build();
    rentResponse = service.rent(phoneNumber, parameters);
  }

  @When("I send a request to rent the unavailable phone number {string}")
  public void rentUnavailable(String phoneNumber) {

    AvailableNumberRentRequest parameters =
        AvailableNumberRentRequest.builder()
            .setSmsConfiguration(
                SmsConfiguration.builder().setServicePlanId("SpaceMonkeySquadron").build())
            .setVoiceConfiguration(
                VoiceConfigurationRTC.builder()
                    .setAppId("sunshine-rain-drop-very-beautifulday")
                    .build())
            .build();
    try {
      service.rent(phoneNumber, parameters);
    } catch (ApiException e) {
      availabilityResponseException = e;
    }
  }

  @When("I send a request to list the phone numbers")
  public void list() {

    ActiveNumberListRequest request =
        ActiveNumberListRequest.builder().setRegionCode("US").setType(NumberType.LOCAL).build();
    activeNumberListResponse = service.list(request);
  }

  @When("I send a request to list all the phone numbers")
  public void listAll() {

    ActiveNumberListRequest request =
        ActiveNumberListRequest.builder().setRegionCode("US").setType(NumberType.LOCAL).build();
    activeNumberListAllResponse = service.list(request);
  }

  @When("I send a request to update the phone number {string}")
  public void update(String phoneNumber) {

    ActiveNumberUpdateRequest request =
        ActiveNumberUpdateRequest.builder()
            .setDisplayName("Updated description during E2E tests")
            .setSmsConfiguration(
                SmsConfiguration.builder().setServicePlanId("SingingMooseSociety").build())
            .setVoiceConfiguration(
                VoiceConfigurationFAX.builder().setServiceId("01W4FFL35P4NC4K35FAXSERVICE").build())
            .setCallbackUrl("https://my-callback-server.com/numbers")
            .build();
    updateResponse = service.update(phoneNumber, request);
  }

  @When("I send a request to retrieve the phone number {string}")
  public void get(String phoneNumber) {

    try {
      getResponse = service.get(phoneNumber);
    } catch (ApiException e) {
      getResponseException = e;
    }
  }

  @When("I send a request to release the phone number {string}")
  public void release(String phoneNumber) {

    releaseResponse = service.release(phoneNumber);
  }

  @Then("the response contains \"{int}\" available phone numbers")
  public void searchForAvailableNumbersResponse(int count) {
    Assertions.assertEquals(count, searchForAvailableNumbersResponse.stream().count());
  }

  @Then("a phone number contains all the expected properties")
  public void searchForAvailableNumbersOneItemResponse() {
    AvailableNumber expected =
        AvailableNumber.builder()
            .setPhoneNumber("+12013504948")
            .setRegionCode("US")
            .setType(NumberType.LOCAL)
            .setCapability(Arrays.asList(Capability.SMS, Capability.VOICE))
            .setSetupPrice(Money.builder().setCurrencyCode("EUR").setAmount(0.80).build())
            .setMonthlyPrice(Money.builder().setCurrencyCode("EUR").setAmount(0.80).build())
            .setPaymentIntervalMonths(1)
            .setSupportingDocumentationRequired(true)
            .build();
    Assertions.assertEquals(
        expected, searchForAvailableNumbersResponse.stream().findFirst().orElse(null));
  }

  @Then("the response displays the phone number {string} details")
  public void checkAvailabilityResponse(String phoneNumber) {

    AvailableNumber expected =
        AvailableNumber.builder()
            .setPhoneNumber(phoneNumber)
            .setRegionCode("US")
            .setType(NumberType.LOCAL)
            .setCapability(Arrays.asList(Capability.SMS, Capability.VOICE))
            .setSetupPrice(Money.builder().setCurrencyCode("EUR").setAmount(0.80).build())
            .setMonthlyPrice(Money.builder().setCurrencyCode("EUR").setAmount(0.80).build())
            .setPaymentIntervalMonths(1)
            .setSupportingDocumentationRequired(true)
            .build();
    Assertions.assertEquals(phoneNumber, checkAvailabilityResponse.getPhoneNumber());
    Assertions.assertEquals(expected, checkAvailabilityResponse);
  }

  @Then("the response contains an error about the number {string} not being available")
  public void checkAvailabilityNotAvailableResponse(String phoneNumber) {

    Assertions.assertEquals(404, availabilityResponseException.getCode());
    Assertions.assertTrue(availabilityResponseException.getMessage().contains(phoneNumber));
  }

  @Then("the response contains a rented phone number")
  public void rentAnyResponse() {

    ActiveNumber expected =
        ActiveNumber.builder()
            .setPhoneNumber("+12017654321")
            .setProjectId("123c0ffee-dada-beef-cafe-baadc0de5678")
            .setDisplayName("")
            .setRegionCode("US")
            .setType(NumberType.LOCAL)
            .setCapability(Arrays.asList(Capability.SMS, Capability.VOICE))
            .setMoney(Money.builder().setCurrencyCode("EUR").setAmount(0.80).build())
            .setPaymentIntervalMonths(1)
            .setNextChargeDate(Instant.parse("2024-06-06T14:42:42.022227Z"))
            .setExpireAt(null)
            .setSmsConfiguration(
                SmsConfiguration.builder()
                    .setServicePlanId("")
                    .setCampaignId("")
                    .setScheduledProvisioning(
                        ScheduledSmsProvisioning.builder()
                            .setServicePlanId("SpaceMonkeySquadron")
                            .setStatus(ProvisioningStatus.WAITING)
                            .setLastUpdatedTime(Instant.parse("2024-06-06T14:42:42.596223Z"))
                            .setCampaignId("")
                            .setErrorCodes(Collections.emptyList())
                            .build())
                    .build())
            .setVoiceConfiguration(
                VoiceConfigurationRTC.builder()
                    .setAppId("")
                    .setLastUpdatedTime(null)
                    .setScheduledProvisioning(
                        ScheduledVoiceProvisioningRTC.builder()
                            .setAppId("sunshine-rain-drop-very-beautifulday")
                            .setStatus(ProvisioningStatus.WAITING)
                            .setLastUpdatedTime(Instant.parse("2024-06-06T14:42:42.604092Z"))
                            .build())
                    .build())
            .setCallbackUrl("")
            .build();

    Assertions.assertEquals(expected, rentAnyResponse);
  }

  @Then("the response contains this rented phone number {string}")
  public void rentResponse(String phoneNumber) {

    ActiveNumber expected =
        ActiveNumber.builder()
            .setPhoneNumber(phoneNumber)
            .setProjectId("123c0ffee-dada-beef-cafe-baadc0de5678")
            .setDisplayName("")
            .setRegionCode("US")
            .setType(NumberType.LOCAL)
            .setCapability(Arrays.asList(Capability.SMS, Capability.VOICE))
            .setMoney(Money.builder().setCurrencyCode("EUR").setAmount(0.80).build())
            .setPaymentIntervalMonths(1)
            .setNextChargeDate(Instant.parse("2024-06-06T14:42:42.022227Z"))
            .setExpireAt(null)
            .setSmsConfiguration(
                SmsConfiguration.builder()
                    .setServicePlanId("")
                    .setCampaignId("")
                    .setScheduledProvisioning(
                        ScheduledSmsProvisioning.builder()
                            .setServicePlanId("SpaceMonkeySquadron")
                            .setStatus(ProvisioningStatus.WAITING)
                            .setLastUpdatedTime(Instant.parse("2024-06-06T14:42:42.596223Z"))
                            .setCampaignId("")
                            .setErrorCodes(Collections.emptyList())
                            .build())
                    .build())
            .setVoiceConfiguration(
                VoiceConfigurationRTC.builder()
                    .setAppId("")
                    .setLastUpdatedTime(null)
                    .setScheduledProvisioning(
                        ScheduledVoiceProvisioningRTC.builder()
                            .setAppId("sunshine-rain-drop-very-beautifulday")
                            .setStatus(ProvisioningStatus.WAITING)
                            .setLastUpdatedTime(Instant.parse("2024-06-06T14:42:42.604092Z"))
                            .build())
                    .build())
            .setCallbackUrl("")
            .build();

    Assertions.assertEquals(expected, rentResponse);
  }

  @Then("the response contains \"{int}\" phone numbers")
  public void listResult(int expected) {

    Assertions.assertEquals(expected, activeNumberListResponse.getContent().size());
  }

  @Then("the phone numbers list contains \"{int}\" phone numbers")
  public void listAllResult(int expected) {

    Assertions.assertEquals(expected, activeNumberListAllResponse.stream().count());
  }

  @Then("the response contains a phone number with updated parameters")
  public void updateResponse() {

    ActiveNumber expected =
        ActiveNumber.builder()
            .setPhoneNumber("+12015555555")
            .setProjectId("123coffee-dada-beef-cafe-baadc0de5678")
            .setDisplayName("Updated description during E2E tests")
            .setRegionCode("US")
            .setType(NumberType.LOCAL)
            .setCapability(Arrays.asList(Capability.SMS, Capability.VOICE))
            .setMoney(Money.builder().setCurrencyCode("EUR").setAmount(0.80).build())
            .setPaymentIntervalMonths(1)
            .setNextChargeDate(Instant.parse("2024-07-06T20:02:20.118246Z"))
            .setExpireAt(null)
            .setSmsConfiguration(
                SmsConfiguration.builder()
                    .setServicePlanId("SpaceMonkeySquadron")
                    .setCampaignId("")
                    .setScheduledProvisioning(
                        ScheduledSmsProvisioning.builder()
                            .setServicePlanId("SingingMooseSociety")
                            .setStatus(ProvisioningStatus.WAITING)
                            .setLastUpdatedTime(Instant.parse("2024-06-06T20:02:20.432220Z"))
                            .setCampaignId("")
                            .setErrorCodes(Collections.emptyList())
                            .build())
                    .build())
            .setVoiceConfiguration(
                VoiceConfigurationRTC.builder()
                    .setAppId("sunshine-rain-drop-very-beautifulday")
                    .setLastUpdatedTime(null)
                    .setScheduledProvisioning(
                        ScheduledVoiceProvisioningFAX.builder()
                            .setServiceId("01W4FFL35P4NC4K35FAXSERVICE")
                            .setStatus(ProvisioningStatus.WAITING)
                            .setLastUpdatedTime(Instant.parse("2024-06-06T20:02:20.437509Z"))
                            .build())
                    .build())
            .setCallbackUrl("https://my-callback-server.com/numbers")
            .build();

    Assertions.assertEquals(expected, updateResponse);
  }

  @Then("the response contains details about the phone number {string}")
  public void getResponse(String phoneNumber) {

    ActiveNumber expected =
        ActiveNumber.builder()
            .setPhoneNumber(phoneNumber)
            .setProjectId("123c0ffee-dada-beef-cafe-baadc0de5678")
            .setDisplayName("Active number #1")
            .setRegionCode("US")
            .setType(NumberType.LOCAL)
            .setCapability(Arrays.asList(Capability.SMS, Capability.VOICE))
            .setMoney(Money.builder().setCurrencyCode("EUR").setAmount(0.80).build())
            .setPaymentIntervalMonths(1)
            .setNextChargeDate(Instant.parse("2024-06-06T14:42:42.677575Z"))
            .setExpireAt(null)
            .setSmsConfiguration(
                SmsConfiguration.builder()
                    .setServicePlanId("SpaceMonkeySquadron")
                    .setCampaignId("")
                    .setScheduledProvisioning(null)
                    .build())
            .setVoiceConfiguration(
                VoiceConfigurationFAX.builder()
                    .setServiceId("01W4FFL35P4NC4K35FAXSERVICE")
                    .setLastUpdatedTime(null)
                    .setScheduledProvisioning(null)
                    .build())
            .setCallbackUrl("https://my-callback-server.com/numbers")
            .build();

    Assertions.assertEquals(expected, getResponse);
  }

  @Then(
      "the response contains details about the phone number {string} with an SMS provisioning"
          + " error")
  public void getWithSmsProvisioningErrorResponse(String phoneNumber) {

    ActiveNumber expected =
        ActiveNumber.builder()
            .setPhoneNumber(phoneNumber)
            .setProjectId("123c0ffee-dada-beef-cafe-baadc0de5678")
            .setDisplayName("Active number #1")
            .setRegionCode("US")
            .setType(NumberType.LOCAL)
            .setCapability(Arrays.asList(Capability.SMS, Capability.VOICE))
            .setMoney(Money.builder().setCurrencyCode("EUR").setAmount(0.80).build())
            .setPaymentIntervalMonths(1)
            .setNextChargeDate(Instant.parse("2024-07-06T14:42:42.677575Z"))
            .setExpireAt(null)
            .setSmsConfiguration(
                SmsConfiguration.builder()
                    .setServicePlanId("")
                    .setCampaignId("")
                    .setScheduledProvisioning(
                        ScheduledSmsProvisioning.builder()
                            .setServicePlanId("SpaceMonkeySquadron")
                            .setCampaignId("")
                            .setStatus(ProvisioningStatus.FAILED)
                            .setLastUpdatedTime(Instant.parse("2024-06-06T20:20:02.308392Z"))
                            .setErrorCodes(Arrays.asList(SmsErrorCode.SMS_PROVISIONING_FAILED))
                            .build())
                    .build())
            .setVoiceConfiguration(
                VoiceConfigurationEST.builder()
                    .setTrunkId("01W4FFL35P4NC4K35SIPTRUNK00")
                    .setLastUpdatedTime(null)
                    .setScheduledProvisioning(null)
                    .build())
            .setCallbackUrl("https://my-callback-server.com/numbers")
            .build();

    Assertions.assertEquals(expected, getResponse);
  }

  @Then("the response contains an error about the number {string} not being a rented number")
  public void getErrorResponse(String phoneNumber) {

    Assertions.assertEquals(404, getResponseException.getCode());
    Assertions.assertTrue(getResponseException.getMessage().contains(phoneNumber));
  }

  @Then("the response contains details about the phone number {string} to be released")
  public void releaseResponse(String phoneNumber) {

    ActiveNumber expected =
        ActiveNumber.builder()
            .setPhoneNumber(phoneNumber)
            .setProjectId("123c0ffee-dada-beef-cafe-baadc0de5678")
            .setDisplayName("Active number #1")
            .setRegionCode("US")
            .setType(NumberType.LOCAL)
            .setCapability(Arrays.asList(Capability.SMS, Capability.VOICE))
            .setMoney(Money.builder().setCurrencyCode("EUR").setAmount(0.80).build())
            .setPaymentIntervalMonths(1)
            .setNextChargeDate(Instant.parse("2024-06-06T14:42:42.677575Z"))
            .setExpireAt(Instant.parse("2024-06-06T14:42:42.677575Z"))
            .setSmsConfiguration(
                SmsConfiguration.builder()
                    .setServicePlanId("SpaceMonkeySquadron")
                    .setCampaignId("")
                    .setScheduledProvisioning(null)
                    .build())
            .setVoiceConfiguration(
                VoiceConfigurationFAX.builder()
                    .setServiceId("01W4FFL35P4NC4K35FAXSERVICE")
                    .setLastUpdatedTime(null)
                    .setScheduledProvisioning(null)
                    .build())
            .setCallbackUrl("https://my-callback-server.com/numbers")
            .build();

    Assertions.assertEquals(expected, releaseResponse);
  }
}
