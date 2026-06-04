package com.sinch.sdk.e2e.domains.numberlookup.v2;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numberlookup.api.v2.NumberLookupV2Service;
import com.sinch.sdk.domains.numberlookup.models.v2.errors.LookupError;
import com.sinch.sdk.domains.numberlookup.models.v2.request.LookupFeatureType;
import com.sinch.sdk.domains.numberlookup.models.v2.request.NumberLookupRequest;
import com.sinch.sdk.domains.numberlookup.models.v2.request.RndFeatureOptions;
import com.sinch.sdk.domains.numberlookup.models.v2.response.Line;
import com.sinch.sdk.domains.numberlookup.models.v2.response.LineType;
import com.sinch.sdk.domains.numberlookup.models.v2.response.NumberLookupResponse;
import com.sinch.sdk.domains.numberlookup.models.v2.response.Rnd;
import com.sinch.sdk.domains.numberlookup.models.v2.response.SimSwap;
import com.sinch.sdk.domains.numberlookup.models.v2.response.VoIPDetection;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public class LookupsSteps {

  NumberLookupV2Service service;
  NumberLookupResponse lookupNoFeaturesResponse;
  NumberLookupResponse lookupAllFeaturesResponse;

  @Given("the Number Lookup service is available")
  public void serviceAvailable() {
    service = Config.getSinchClient().lookup().lookup();
    Assertions.assertNotNull(service, "Number Lookup service is not available");
  }

  @When("I send a request to lookup for a phone number with no additional features")
  public void lookupNoFeatures() {
    NumberLookupRequest request = NumberLookupRequest.builder().setNumber("+12016666666").build();
    lookupNoFeaturesResponse = service.lookup(request);
  }

  @Then("the response contains the details of the phone number lookup with line details only")
  public void lookupNoFeaturesResult() {

    NumberLookupResponse expected =
        NumberLookupResponse.builder()
            .setNumber("+12016666666")
            .setCountryCode("US")
            .setTraceId("84c1fd4063c38d9f3900d06e56542d48")
            .setLine(
                Line.builder()
                    .setCarrier("T-Mobile USA")
                    .setType(LineType.MOBILE)
                    .setMobileCountryCode("310")
                    .setMobileNetworkCode("260")
                    .build())
            .build();

    TestHelpers.recursiveEquals(lookupNoFeaturesResponse, expected);
  }

  @When("I send a request to lookup for a phone number with all the features")
  public void lookupAllFeatures() {
    NumberLookupRequest request =
        NumberLookupRequest.builder()
            .setNumber("+12015555555")
            .setFeatures(
                Arrays.asList(
                    LookupFeatureType.LINE_TYPE,
                    LookupFeatureType.RND,
                    LookupFeatureType.SIM_SWAP,
                    LookupFeatureType.VO_IP_DETECTION))
            .setRndFeatureOptions(
                RndFeatureOptions.builder().setContactDate(LocalDate.parse("2025-09-09")).build())
            .build();
    lookupAllFeaturesResponse = service.lookup(request);
  }

  @Then("the response contains the details of the phone number lookup with all the features")
  public void lookupAllFeaturesResult() {

    LookupError simSwapError =
        LookupError.builder()
            .setStatus(100)
            .setTitle("Feature Disabled")
            .setDetail("SimSwap feature is currently disabled.")
            .build();

    LookupError voIPDetectionError =
        LookupError.builder()
            .setStatus(100)
            .setTitle("Feature Disabled")
            .setDetail("VoIPDetection feature is currently disabled.")
            .build();

    LookupError rndError =
        LookupError.builder()
            .setStatus(100)
            .setTitle("Feature Disabled")
            .setDetail("RND feature is currently disabled.")
            .build();

    NumberLookupResponse expected =
        NumberLookupResponse.builder()
            .setNumber("+12015555555")
            .setCountryCode("US")
            .setTraceId("5c817a6b7351d80a6b1d8007e5c145b8")
            .setLine(
                Line.builder()
                    .setCarrier("AT&T")
                    .setType(LineType.MOBILE)
                    .setMobileCountryCode("310")
                    .setMobileNetworkCode("070")
                    .setPorted(true)
                    .setPortingDate(Instant.parse("2010-08-07T23:45:49Z"))
                    .build())
            .setSimSwap(SimSwap.builder().setError(simSwapError).build())
            .setVoIPDetection(VoIPDetection.builder().setError(voIPDetectionError).build())
            .setRnd(Rnd.builder().setError(rndError).build())
            .build();

    TestHelpers.recursiveEquals(lookupAllFeaturesResponse, expected);
  }
}
