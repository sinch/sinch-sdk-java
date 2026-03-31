package com.sinch.sdk.e2e.domains.numbers.v1;

import com.sinch.sdk.domains.numbers.api.v1.AvailableRegionsService;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.regions.request.AvailableRegionsListQueryParameters;
import com.sinch.sdk.domains.numbers.models.v1.regions.response.AvailableRegionsListResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public class AvailableRegionsSteps {

  AvailableRegionsService service;

  AvailableRegionsListResponse listResponse;

  @Given("^the Numbers service \"Regions\" is available$")
  public void serviceAvailable() {

    service = Config.getSinchClient().numbers().v1().regions();
  }

  @When("^I send a request to list all the regions$")
  public void list() {

    AvailableRegionsListQueryParameters parameters =
        AvailableRegionsListQueryParameters.builder().build();
    listResponse = service.list(parameters);
  }

  @When("^I send a request to list the TOLL_FREE regions$")
  public void listTollFree() {

    AvailableRegionsListQueryParameters parameters =
        AvailableRegionsListQueryParameters.builder()
            .setTypes(Arrays.asList(NumberType.TOLL_FREE))
            .build();
    listResponse = service.list(parameters);
  }

  @When("^I send a request to list the TOLL_FREE or MOBILE regions$")
  public void listTollOrMobileFree() {

    AvailableRegionsListQueryParameters parameters =
        AvailableRegionsListQueryParameters.builder()
            .setTypes(Arrays.asList(NumberType.TOLL_FREE, NumberType.MOBILE))
            .build();
    listResponse = service.list(parameters);
  }

  @Then("the response contains \"{int}\" regions")
  public void listAllRegionsCountResult(int count) {

    Assertions.assertEquals(count, listResponse.stream().count());
  }

  @Then("the response contains \"{int}\" TOLL_FREE regions")
  public void listTollFreeRegionsCountResult(int count) {

    Assertions.assertEquals(
        count,
        listResponse.stream().filter(f -> f.getTypes().contains(NumberType.TOLL_FREE)).count());
  }

  @Then("the response contains \"{int}\" MOBILE regions")
  public void listMobileRegionsCountResult(int count) {

    Assertions.assertEquals(
        count, listResponse.stream().filter(f -> f.getTypes().contains(NumberType.MOBILE)).count());
  }

  @Then("the response contains \"{int}\" LOCAL regions")
  public void listLocaleRegionsCountResult(int count) {

    Assertions.assertEquals(
        count, listResponse.stream().filter(f -> f.getTypes().contains(NumberType.LOCAL)).count());
  }
}
