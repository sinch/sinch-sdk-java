package com.sinch.sdk.e2e.domains.numbers.v1;

import com.sinch.sdk.domains.numbers.api.v1.AvailableRegionService;
import com.sinch.sdk.domains.numbers.api.v1.AvailableRegionsService;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.request.AvailableRegionListRequest;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.response.AvailableRegionListResponse;
import com.sinch.sdk.domains.numbers.models.v1.regions.request.AvailableRegionsListQueryParameters;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public class AvailableRegionsSteps {

  AvailableRegionService serviceDeprecated;
  AvailableRegionsService service;

  AvailableRegionListResponse listResponseDeprecated;
  AvailableRegionListResponse listResponse;

  @Given("^the Numbers service \"Regions\" is available$")
  public void serviceAvailable() {

    serviceDeprecated = Config.getSinchClient().numbers().v1().regions();
    service = Config.getSinchClient().numbers().v1().regions();
  }

  @When("^I send a request to list all the regions$")
  public void list() {

    AvailableRegionListRequest parametersDeprecated = AvailableRegionListRequest.builder().build();
    listResponseDeprecated = serviceDeprecated.list(parametersDeprecated);

    AvailableRegionsListQueryParameters parameters =
        AvailableRegionsListQueryParameters.builder().build();
    listResponse = service.list(parameters);
  }

  @When("^I send a request to list the TOLL_FREE regions$")
  public void listTollFree() {

    AvailableRegionListRequest parametersDeprecated =
        AvailableRegionListRequest.builder().setTypes(Arrays.asList(NumberType.TOLL_FREE)).build();
    listResponseDeprecated = serviceDeprecated.list(parametersDeprecated);

    AvailableRegionsListQueryParameters parameters =
        AvailableRegionsListQueryParameters.builder()
            .setTypes(Arrays.asList(NumberType.TOLL_FREE))
            .build();
    listResponse = service.list(parameters);
  }

  @When("^I send a request to list the TOLL_FREE or MOBILE regions$")
  public void listTollOrMobileFree() {

    AvailableRegionListRequest parametersDeprecated =
        AvailableRegionListRequest.builder()
            .setTypes(Arrays.asList(NumberType.TOLL_FREE, NumberType.MOBILE))
            .build();
    listResponseDeprecated = serviceDeprecated.list(parametersDeprecated);

    AvailableRegionsListQueryParameters parameters =
        AvailableRegionsListQueryParameters.builder()
            .setTypes(Arrays.asList(NumberType.TOLL_FREE, NumberType.MOBILE))
            .build();
    listResponse = service.list(parameters);
  }

  @Then("the response contains \"{int}\" regions")
  public void listAllRegionsCountResult(int count) {

    Assertions.assertEquals(count, listResponseDeprecated.stream().count());
    Assertions.assertEquals(count, listResponse.stream().count());
  }

  @Then("the response contains \"{int}\" TOLL_FREE regions")
  public void listTollFreeRegionsCountResult(int count) {

    Assertions.assertEquals(
        count,
        listResponseDeprecated.stream()
            .filter(f -> f.getTypes().contains(NumberType.TOLL_FREE))
            .count());

    Assertions.assertEquals(
        count,
        listResponse.stream().filter(f -> f.getTypes().contains(NumberType.TOLL_FREE)).count());
  }

  @Then("the response contains \"{int}\" MOBILE regions")
  public void listMobileRegionsCountResult(int count) {

    Assertions.assertEquals(
        count,
        listResponseDeprecated.stream()
            .filter(f -> f.getTypes().contains(NumberType.MOBILE))
            .count());

    Assertions.assertEquals(
        count, listResponse.stream().filter(f -> f.getTypes().contains(NumberType.MOBILE)).count());
  }

  @Then("the response contains \"{int}\" LOCAL regions")
  public void listLocaleRegionsCountResult(int count) {

    Assertions.assertEquals(
        count,
        listResponseDeprecated.stream()
            .filter(f -> f.getTypes().contains(NumberType.LOCAL))
            .count());

    Assertions.assertEquals(
        count, listResponse.stream().filter(f -> f.getTypes().contains(NumberType.LOCAL)).count());
  }
}
