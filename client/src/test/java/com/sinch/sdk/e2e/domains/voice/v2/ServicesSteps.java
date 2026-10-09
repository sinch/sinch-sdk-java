package com.sinch.sdk.e2e.domains.voice.v2;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.api.v2.ServicesService;
import com.sinch.sdk.domains.voice.models.v2.services.EventDestinationCallBehavior;
import com.sinch.sdk.domains.voice.models.v2.services.EventDestinationConfiguration;
import com.sinch.sdk.domains.voice.models.v2.services.NoneCallBehavior;
import com.sinch.sdk.domains.voice.models.v2.services.request.CreateServiceRequest;
import com.sinch.sdk.domains.voice.models.v2.services.request.ListServicesQueryParameters;
import com.sinch.sdk.domains.voice.models.v2.services.request.UpdateServiceRequest;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServiceResponse;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServicesListResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Assertions;

public class ServicesSteps {

  ServicesService service;
  ServiceResponse createResponse;
  ServiceResponse getResponse;
  ServiceResponse updateResponse;
  Boolean deletePassed;
  ServicesListResponse listOnePageResponse;

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

  @When("^I send a request to get Voice-V2 service details$")
  public void get() {
    getResponse = service.get("3c4d5e6f-7a8b-4901-c234-d5e6f7a8b901");
  }

  @Then("^the response contains the Voice-V2 service details$")
  public void getResult() {
    ServiceResponse expected =
        ServiceResponse.builder()
            .setServiceId("3c4d5e6f-7a8b-4901-c234-d5e6f7a8b901")
            .setProjectId("c3d4e5f6-a7b8-4901-c234-d5e6f7a8b901")
            .setCreateTime(Instant.parse("2026-09-16T10:47:36Z"))
            .setUpdateTime(Instant.parse("2026-09-16T10:47:36Z"))
            .setName("Example service 2")
            .setDescription("")
            .setIsDefault(false)
            .setCallBehavior(NoneCallBehavior.NONE_CALL_BEHAVIOR)
            .build();

    TestHelpers.recursiveEquals(getResponse, expected);
  }

  @When("^I send a request to update a Voice-V2 service$")
  public void update() {
    updateResponse =
        service.update(
            "3c4d5e6f-7a8b-4901-c234-d5e6f7a8b901",
            UpdateServiceRequest.builder()
                .setDescription("Service with webhooks")
                .setCallBehavior(webhookCallBehavior())
                .setIdempotencyKey("5d8a1f3c-6e2b-4c9d-a7f0-3b1e8c4d2a96")
                .build());
  }

  @Then("^the response contains the information about the Voice-V2 service updated$")
  public void updateResult() {
    ServiceResponse expected =
        ServiceResponse.builder()
            .setServiceId("3c4d5e6f-7a8b-4901-c234-d5e6f7a8b901")
            .setProjectId("c3d4e5f6-a7b8-4901-c234-d5e6f7a8b901")
            .setCreateTime(Instant.parse("2026-09-16T10:47:36Z"))
            .setUpdateTime(Instant.parse("2026-09-16T10:51:55Z"))
            .setName("Example service 2")
            .setDescription("Service with webhooks")
            .setIsDefault(false)
            .setCallBehavior(webhookCallBehavior())
            .build();

    TestHelpers.recursiveEquals(updateResponse, expected);
  }

  @When("^I send a request to delete a Voice-V2 service$")
  public void delete() {
    service.delete("3c4d5e6f-7a8b-4901-c234-d5e6f7a8b901");
    deletePassed = true;
  }

  @Then("^the response confirms the Voice-V2 service was deleted$")
  public void deleteResult() {
    Assertions.assertTrue(deletePassed);
  }

  private static EventDestinationCallBehavior webhookCallBehavior() {
    return EventDestinationCallBehavior.builder()
        .setEventDestination(
            EventDestinationConfiguration.builder()
                .setUrl("https://example.com/webhook")
                .setFallbackUrl("https://example.com/fallback")
                .build())
        .build();
  }

  @When("^I send a request to list Voice-V2 services$")
  public void listOnePage() {
    listOnePageResponse =
        service.list(ListServicesQueryParameters.builder().setPageSize(2).build());
  }

  @When("^I send a request to list all the Voice-V2 services$")
  public void listAll() {
    listOnePageResponse =
        service.list(ListServicesQueryParameters.builder().setPageSize(2).build());
  }

  @When("^I iterate manually over the Voice-V2 services pages$")
  public void listAllByPage() {
    listOnePageResponse =
        service.list(ListServicesQueryParameters.builder().setPageSize(2).build());
  }

  @Then("the response contains \"{int}\" Voice-V2 services")
  public void onePageResult(int expected) {

    Assertions.assertEquals(expected, listOnePageResponse.getContent().size());
  }

  @Then("the services list contains \"{int}\" Voice-V2 services")
  public void listAllResult(int expected) {

    AtomicInteger count = new AtomicInteger();
    listOnePageResponse.iterator().forEachRemaining(_unused -> count.getAndIncrement());

    Assertions.assertEquals(expected, count.get());
  }

  @Then("the services iteration result contains the data from \"{int}\" Voice-V2 service pages")
  public void listAllByPageResult(int expected) {

    int count = listOnePageResponse.getContent().isEmpty() ? 0 : 1;
    ServicesListResponse currentPage = listOnePageResponse;
    while (currentPage.hasNextPage()) {
      count++;
      currentPage = currentPage.nextPage();
    }
    Assertions.assertEquals(expected, count);
  }
}
