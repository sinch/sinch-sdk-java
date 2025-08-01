package com.sinch.sdk.e2e.domains.numbers.v1;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.api.v1.CallbackConfigurationService;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.request.CallbackConfigurationUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.response.CallbackConfigurationResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class WebhooksSteps {

  CallbackConfigurationService service;
  CallbackConfigurationResponse getResponse;
  CallbackConfigurationResponse updateResponse;
  ApiException updateResponseException;

  @Given("^the Numbers service \"Callback Configuration\" is available$")
  public void serviceAvailable() {

    service = Config.getSinchClient().numbers().v1().callbackConfiguration();
  }

  @When("^I send a request to retrieve the callback configuration$")
  public void get() {

    getResponse = service.get();
  }

  @When("I send a request to update the callback configuration with the secret {string}")
  public void update(String secret) {

    CallbackConfigurationUpdateRequest request =
        CallbackConfigurationUpdateRequest.builder().setHmacSecret(secret).build();
    try {
      updateResponse = service.update(request);
    } catch (ApiException e) {
      updateResponseException = e;
    }
  }

  @Then("the response contains the project's callback configuration")
  public void getResult() {

    CallbackConfigurationResponse expected =
        CallbackConfigurationResponse.builder()
            .setProjectId("12c0ffee-dada-beef-cafe-baadc0de5678")
            .setHmacSecret("0default-pass-word-*max-36characters")
            .build();
    Assertions.assertEquals(expected, getResponse);
  }

  @Then("the response contains the updated project's callback configuration")
  public void updateResult() {

    CallbackConfigurationResponse expected =
        CallbackConfigurationResponse.builder()
            .setProjectId("12c0ffee-dada-beef-cafe-baadc0de5678")
            .setHmacSecret("strongPa$$PhraseWith36CharactersMax")
            .build();
    Assertions.assertEquals(expected, updateResponse);
  }

  @Then("the response contains an error")
  public void updateErrorResult() {

    Assertions.assertEquals(404, updateResponseException.getCode());
    Assertions.assertTrue(updateResponseException.getMessage().contains("NOT_FOUND"));
  }
}
