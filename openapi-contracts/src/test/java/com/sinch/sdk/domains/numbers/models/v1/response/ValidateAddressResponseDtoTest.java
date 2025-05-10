package com.sinch.sdk.domains.numbers.models.v1.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersBaseTest;
import com.sinch.sdk.domains.numbers.models.v1.EmergencyAddress;
import com.sinch.sdk.domains.numbers.models.v1.EmergencyAddressDtoTest;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ValidateAddressResponseDtoTest extends NumbersBaseTest {

  @GivenTextResource("/domains/numbers/v1/response/validate-address-response.json")
  String validateAddressResponseJson;

  @GivenTextResource("/domains/numbers/v1/response/validate-address-response-no-match.json")
  String validateAddressResponseNoMatchJson;

  public static ValidateAddressResponse validateAddressResponse =
      ValidateAddressResponse.builder()
          .setPhoneNumber("+17608137700")
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
          .setCorrectedAddress(EmergencyAddressDtoTest.emergencyAddress)
          .setCandidateAddresses(Collections.emptyList())
          .build();

  public static ValidateAddressResponse validateAddressResponseNoMatch =
      ValidateAddressResponse.builder()
          .setPhoneNumber("+17608137700")
          .setDisplayName("Validate emergency address")
          .setValidatedAddress(
              EmergencyAddress.builder()
                  .setStreetNumber("3500")
                  .setStreetInfo("Lenox Road N")
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
          .setCandidateAddresses(Arrays.asList(EmergencyAddressDtoTest.emergencyAddress))
          .build();

  @Test
  void deserialize() throws JsonProcessingException {

    ValidateAddressResponse deserializedString =
        objectMapper.readValue(validateAddressResponseJson, ValidateAddressResponse.class);

    TestHelpers.recursiveEquals(validateAddressResponse, deserializedString);
  }

  @Test
  void deserializeNoMatch() throws JsonProcessingException, JSONException {

    ValidateAddressResponse deserializedString =
        objectMapper.readValue(validateAddressResponseNoMatchJson, ValidateAddressResponse.class);

    TestHelpers.recursiveEquals(validateAddressResponseNoMatch, deserializedString);
  }
}
