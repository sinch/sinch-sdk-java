package com.sinch.sdk.e2e.domains.voice.v2;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.api.v2.ServicesService;
import com.sinch.sdk.domains.voice.models.v2.services.request.CreateServiceRequest;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServiceResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import org.junit.jupiter.api.Assertions;

public class ServicesSteps {

  ServicesService service;
  ServiceResponse createResponse;

  @Given("^the Voice-V2 service \"Services\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().voice().v2().services();
    Assertions.assertNotNull(service, "Voice V2 Services service is not available");
  }

  @When("^I send a request to create a Voice-V2 service$")
  public void create() {
    createResponse =
        service.create(
            CreateServiceRequest.builder()
                .setName("Example service")
                .setIdempotencyKey("9e4b2c7a-1d5f-4a8e-b3c6-2f7d0a9e5b18")
                .build());
  }

  @Then("^the response contains the information about the Voice-V2 service created$")
  public void createResult() {
    ServiceResponse expected =
        ServiceResponse.builder()
            .setServiceId("1a2b3c4d-5e6f-4789-a012-b3c4d5e6f789")
            .setProjectId("c3d4e5f6-a7b8-4901-c234-d5e6f7a8b901")
            .setCreateTime(Instant.parse("2026-09-16T10:44:09Z"))
            .setUpdateTime(Instant.parse("2026-09-16T10:44:09Z"))
            .setName("Example service")
            .setDescription("")
            .setIsDefault(false)
            .build();

    TestHelpers.recursiveEquals(createResponse, expected);
  }
}
