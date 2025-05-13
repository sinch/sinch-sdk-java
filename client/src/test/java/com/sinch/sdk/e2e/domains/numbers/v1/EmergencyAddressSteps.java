package com.sinch.sdk.e2e.domains.numbers.v1;

import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.EmergencyAddress;
import com.sinch.sdk.domains.numbers.models.v1.request.EmergencyAddressRequest;
import com.sinch.sdk.domains.numbers.models.v1.response.AddressValidationResultCode;
import com.sinch.sdk.domains.numbers.models.v1.response.ValidateAddressResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;

public class EmergencyAddressSteps {

  static final String PHONE_NUMBER = "+12015555555";
  NumbersService service;

  ValidateAddressResponse validateAddressResponse;
  EmergencyAddress provisioningEmergencyAddressResponse;
  Boolean deprovisionEmergencyAddressPassed;
  EmergencyAddress getEmergencyAddressResponse;

  @Given("^the Numbers service is available to handle emergency addresses")
  public void serviceAvailable() {

    service = Config.getSinchClient().numbers().v1();
  }

  @When("^I send a request to validate an emergency address$")
  public void validateEmergencyAddress() {
    EmergencyAddress emergencyAddress =
        EmergencyAddress.builder()
            .setStreetNumber("3500")
            .setStreetInfo("Lenox Road NE")
            .setCity("Atlanta")
            .setState("GA")
            .setPostalCode("30326")
            .build();

    EmergencyAddressRequest request =
        EmergencyAddressRequest.builder()
            .setDisplayName("Validate emergency address")
            .setAddress(emergencyAddress)
            .build();
    validateAddressResponse = service.validateEmergencyAddress(PHONE_NUMBER, request);
  }

  @When("^I send a request to validate an approximate emergency address$")
  public void validateApproximateEmergencyAddress() {
    EmergencyAddress emergencyAddress =
        EmergencyAddress.builder()
            .setStreetNumber("3500")
            .setStreetInfo("Lenox Road")
            .setCity("Atlanta")
            .setState("GA")
            .setPostalCode("30326")
            .build();

    EmergencyAddressRequest request =
        EmergencyAddressRequest.builder()
            .setDisplayName("Validate emergency address")
            .setAddress(emergencyAddress)
            .build();
    validateAddressResponse = service.validateEmergencyAddress(PHONE_NUMBER, request);
  }

  @When("^I send a request to provision an emergency address$")
  public void provisionEmergencyAddress() {
    EmergencyAddress emergencyAddress =
        EmergencyAddress.builder()
            .setStreetNumber("3500")
            .setStreetInfo("Lenox Rd NE")
            .setCity("Atlanta")
            .setState("GA")
            .setPostalCode("30326")
            .build();

    EmergencyAddressRequest request =
        EmergencyAddressRequest.builder()
            .setDisplayName("Set emergency address")
            .setAddress(emergencyAddress)
            .build();
    provisioningEmergencyAddressResponse = service.provisionEmergencyAddress(PHONE_NUMBER, request);
  }

  @When("^I send a request to deprovision an emergency address$")
  public void deprovisionEmergencyAddress() {

    service.deprovisionEmergencyAddress(PHONE_NUMBER);
    deprovisionEmergencyAddressPassed = true;
  }

  @When("^I send a request to get the emergency address for a number$")
  public void getEmergencyAddress() {

    getEmergencyAddressResponse = service.getEmergencyAddress(PHONE_NUMBER);
  }

  @Then("the response contains the corrected address")
  public void validateEmergencyAddressResult() {

    ValidateAddressResponse expected =
        ValidateAddressResponse.builder()
            .setPhoneNumber(PHONE_NUMBER)
            .setDisplayName("Validate emergency address")
            .setValidatedAddress(
                EmergencyAddress.builder()
                    .setStreetNumber("3500")
                    .setStreetInfo("Lenox Road NE")
                    .setLocation("")
                    .setCity("Atlanta")
                    .setState("GA")
                    .setPostalCode("30326")
                    .setPostalCodePlusFour("")
                    .build())
            .setValidationResult(AddressValidationResultCode.NEAR_MATCH)
            .setValidationMessage("Corrected to valid address|Corrected address abbreviations")
            .setCorrectedAddress(
                EmergencyAddress.builder()
                    .setStreetNumber("3500")
                    .setStreetInfo("Lenox Rd NE")
                    .setLocation("")
                    .setCity("Atlanta")
                    .setState("GA")
                    .setPostalCode("30326")
                    .setPostalCodePlusFour("")
                    .build())
            .setCandidateAddresses(Collections.emptyList())
            .build();

    Assertions.assertEquals(expected, validateAddressResponse);
  }

  @Then("the response contains the candidate address")
  public void validateEmergencyAddressCandidateResult() {

    ValidateAddressResponse expected =
        ValidateAddressResponse.builder()
            .setPhoneNumber(PHONE_NUMBER)
            .setDisplayName("Validate emergency address")
            .setValidatedAddress(
                EmergencyAddress.builder()
                    .setStreetNumber("3500")
                    .setStreetInfo("Lenox Road")
                    .setLocation("")
                    .setCity("Atlanta")
                    .setState("GA")
                    .setPostalCode("30326")
                    .setPostalCodePlusFour("")
                    .build())
            .setValidationResult(AddressValidationResultCode.NO_MATCH)
            .setValidationMessage(
                "Invalid address - no correction found|Changed address component|Corrected address"
                    + " abbreviations|Address is Invalid")
            .setCorrectedAddress(
                EmergencyAddress.builder()
                    .setStreetNumber("")
                    .setStreetInfo("")
                    .setLocation("")
                    .setCity("")
                    .setState("")
                    .setPostalCode("")
                    .setPostalCodePlusFour("")
                    .build())
            .setCandidateAddresses(
                Arrays.asList(
                    EmergencyAddress.builder()
                        .setStreetNumber("3500")
                        .setStreetInfo("Lenox Rd NE")
                        .setLocation("")
                        .setCity("Atlanta")
                        .setState("GA")
                        .setPostalCode("30326")
                        .setPostalCodePlusFour("")
                        .build()))
            .build();

    Assertions.assertEquals(expected, validateAddressResponse);
  }

  @Then("the response contains the provisioned emergency address")
  public void provisionEmergencyAddressResult() {

    EmergencyAddress expected =
        EmergencyAddress.builder()
            .setStreetNumber("3500")
            .setStreetInfo("Lenox Rd NE")
            .setLocation("")
            .setCity("Atlanta")
            .setState("GA")
            .setPostalCode("30326")
            .setPostalCodePlusFour("")
            .build();

    Assertions.assertEquals(expected, provisioningEmergencyAddressResponse);
  }

  @Then("^the response indicates successful deprovisioning$")
  public void deprovisionEmergencyAddressResult() {

    Assertions.assertTrue(deprovisionEmergencyAddressPassed);
  }

  @Then("^the response contains the provisioned emergency address for the phone number$")
  public void getEmergencyAddressResult() {

    EmergencyAddress expected =
        EmergencyAddress.builder()
            .setStreetNumber("3500")
            .setStreetInfo("Lenox Rd NE")
            .setLocation("")
            .setCity("Atlanta")
            .setState("GA")
            .setPostalCode("30326")
            .setPostalCodePlusFour("")
            .build();
    Assertions.assertEquals(expected, getEmergencyAddressResponse);
  }
}
