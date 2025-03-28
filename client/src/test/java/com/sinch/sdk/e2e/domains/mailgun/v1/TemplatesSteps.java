package com.sinch.sdk.e2e.domains.mailgun.v1;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.mailgun.api.v1.TemplatesService;
import com.sinch.sdk.domains.mailgun.models.v1.templates.Template;
import com.sinch.sdk.domains.mailgun.models.v1.templates.VersionDetails;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.CopyVersionQueryParameters;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.CreateTemplateRequest;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.CreateVersionRequest;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.ListTemplatesQueryParameters;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.ListVersionsQueryParameters;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.UpdateTemplateRequest;
import com.sinch.sdk.domains.mailgun.models.v1.templates.request.UpdateVersionRequest;
import com.sinch.sdk.domains.mailgun.models.v1.templates.response.ListTemplatesResponse;
import com.sinch.sdk.domains.mailgun.models.v1.templates.response.ListVersionsResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;

public class TemplatesSteps {

  TemplatesService service;

  Template createResponse;
  Pair<Template, VersionDetails> createWithActiveVersionResponse;
  Boolean deleteAllPassed;
  Boolean deletePassed;
  Template getResponse;
  VersionDetails getActiveVersionResponse;
  Boolean updatePassed;
  ListTemplatesResponse listOnePageResponse;
  ListTemplatesResponse listAllResponse;
  ListTemplatesResponse listAllManuallyResponse;
  VersionDetails createVersionResponse;
  VersionDetails getVersionResponse;
  Boolean updateVersionPassed;
  VersionDetails copyVersionResponse;
  Boolean deleteVersionPassed;
  ListVersionsResponse listVersionsOnePageResponse;
  ListVersionsResponse listAllVersionsResponse;
  ListVersionsResponse listAllVersionsManuallyResponse;
  static final String domainName = "domainName";
  static final String templateName = "🔥 / Template on fire";
  static final String versionName = "✉️ Version name";

  // workaround template name based onto a simple value usage due to backend issue with paginated
  // URLs returned not URL encoded
  static final String simpleTemplateName = "TemplateName";

  Template expectedTemplate =
      Template.builder()
          .setName(templateName.toLowerCase())
          .setDescription("my description value")
          .setCreatedAt(Instant.parse("2025-03-27T16:01:46Z"))
          .setCreatedBy("html")
          .setId("0057bac3-1846-49d0-ba8b-bbbbbbbbbbbb")
          .build();
  VersionDetails expectedVersionDetails =
      VersionDetails.builder()
          .setTag(versionName.toLowerCase())
          .setTemplate("<p>{{firstname}} {{lastname}}</p>")
          .setEngine("handlebars")
          .setMjml("")
          .setCreatedAt(Instant.parse("2025-03-27T16:01:46Z"))
          .setComment("a comment value")
          .setActive(true)
          .setId("2ecaa2cf-2159-4b36-8f60-cccccccccccc")
          .setHeaders(
              Stream.of(new String[][] {{"From", "from@domain.tld"}, {"Subject", "my subject"}})
                  .collect(Collectors.toMap(data -> data[0], data -> data[1])))
          .build();

  @Given("^the Mailgun service \"Templates\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().mailgun().v1().templates();
  }

  @When("^I send a request to create a Template$")
  public void create() {

    CreateTemplateRequest request =
        CreateTemplateRequest.builder()
            .setName(templateName)
            .setDescription("A template description")
            .build();

    createResponse = service.create(domainName, request);
  }

  @When("^I send a request to create a Template with an active version$")
  public void createWithActiveVersion() {

    CreateTemplateRequest templateRequest =
        CreateTemplateRequest.builder()
            .setName(templateName)
            .setDescription("A template description")
            .setCreatedBy("html")
            .build();

    CreateVersionRequest versionRequest =
        CreateVersionRequest.builder()
            .setTag(versionName)
            .setTemplate("<p>Hello</p>")
            .setComment("")
            .setHeaders(Arrays.asList(Pair.of("From", "foo@foo.com")))
            .build();
    createWithActiveVersionResponse =
        service.createWithActiveVersion(domainName, templateRequest, versionRequest);
  }

  @When("^I send a request to delete all Templates$")
  public void deleteAll() {

    service.deleteAll(domainName);
    deleteAllPassed = true;
  }

  @When("^I send a request to delete a Template$")
  public void delete() {

    service.delete(domainName, templateName);
    deletePassed = true;
  }

  @When("^I send a request to get a Template$")
  public void get() {

    getResponse = service.get(domainName, templateName);
  }

  @When("^I send a request to get a Template's active version$")
  public void getActiveVersion() {

    getActiveVersionResponse = service.getActiveVersion(domainName, templateName);
  }

  @When("^I send a request to update a template description$")
  public void update() {

    UpdateTemplateRequest request =
        UpdateTemplateRequest.builder().setDescription("new description value").build();

    service.update(domainName, templateName, request);
    updatePassed = true;
  }

  @When("^I send a request to list the Templates$")
  public void listOnePage() {
    ListTemplatesQueryParameters request =
        ListTemplatesQueryParameters.builder().setLimit(2).build();

    listOnePageResponse = service.list(domainName, request);
  }

  @When("^I send a request to list all the Templates$")
  public void listAll() {
    ListTemplatesQueryParameters request =
        ListTemplatesQueryParameters.builder().setLimit(2).build();

    listAllResponse = service.list(domainName, request);
  }

  @When("^I iterate manually over the Templates pages$")
  public void listAllByPage() {
    ListTemplatesQueryParameters request =
        ListTemplatesQueryParameters.builder().setLimit(2).build();

    listAllManuallyResponse = service.list(domainName, request);
  }

  @When("^I send a request to create a version$")
  public void createVersion() {

    CreateVersionRequest versionRequest =
        CreateVersionRequest.builder()
            .setTag(versionName)
            .setTemplate("<p>Hello</p>")
            .setComment("")
            .setHeaders(Arrays.asList(Pair.of("From", "foo@foo.com")))
            .build();

    createVersionResponse = service.createVersion(domainName, templateName, versionRequest);
  }

  @When("^I send a request to get a version$")
  public void getVersion() {

    getVersionResponse = service.getVersion(domainName, templateName, versionName);
  }

  @When("^I send a request to update a version$")
  public void updateVersion() {

    UpdateVersionRequest request = UpdateVersionRequest.builder().setTemplate("new value").build();
    service.updateVersion(domainName, templateName, versionName, request);
    updateVersionPassed = true;
  }

  @When("^I send a request to copy a version$")
  public void copyVersion() {

    CopyVersionQueryParameters request =
        CopyVersionQueryParameters.builder().setComment("a comment value from copy").build();
    copyVersionResponse =
        service.copyVersion(domainName, templateName, versionName, "new version name", request);
  }

  @When("^I send a request to delete a Version")
  public void deleteVersion() {

    service.deleteVersion(domainName, templateName, versionName);
    deleteVersionPassed = true;
  }

  @When("^I send a request to list the Versions$")
  public void listVersionsOnePage() {
    ListVersionsQueryParameters request = ListVersionsQueryParameters.builder().setLimit(2).build();

    listVersionsOnePageResponse = service.listVersions(domainName, simpleTemplateName, request);
  }

  @When("^I send a request to list all the Versions$")
  public void listVersionsAll() {
    ListVersionsQueryParameters request = ListVersionsQueryParameters.builder().setLimit(2).build();

    listAllVersionsResponse = service.listVersions(domainName, simpleTemplateName, request);
  }

  @When("^I iterate manually over the Versions pages$")
  public void listVersionsAllByPage() {
    ListVersionsQueryParameters request = ListVersionsQueryParameters.builder().setLimit(2).build();

    listAllVersionsManuallyResponse = service.listVersions(domainName, simpleTemplateName, request);
  }

  @Then("the create template response contains information about the Template")
  public void createResult() {

    TestHelpers.recursiveEquals(expectedTemplate, createResponse);
  }

  @Then(
      "the create template with version response contains information about the Template and"
          + " Version Details")
  public void createWithVersionResult() {

    // cannot use recursion due to trick to have "version" hidden inside "template"
    // test field by field
    compareTemplateField(expectedTemplate, createWithActiveVersionResponse.getLeft());

    TestHelpers.recursiveEquals(expectedVersionDetails, createWithActiveVersionResponse.getRight());
  }

  @Then("the delete all Templates response contains no data")
  public void deleteAllValue() {
    Assertions.assertTrue(deleteAllPassed);
  }

  @Then("the delete Template response contains no data")
  public void deleteValue() {
    Assertions.assertTrue(deletePassed);
  }

  @Then("the get Template response contains Template information")
  public void getResult() {

    // cannot use recursion due to trick to have "version" hidden inside "template"
    // test field by field
    compareTemplateField(expectedTemplate, getResponse);
  }

  @Then("the get Template response contains information about active Version details")
  public void getActiveVersionResult() {

    TestHelpers.recursiveEquals(expectedVersionDetails, getActiveVersionResponse);
  }

  @Then("the update Template response contains no data")
  public void updateValue() {
    Assertions.assertTrue(updatePassed);
  }

  @Then("the page response contains \"{int}\" Templates")
  public void onePageResult(int expected) {

    Assertions.assertEquals(listOnePageResponse.getContent().size(), expected);
  }

  @Then("the list all response contains \"{int}\" Templates")
  public void listAllResult(int expected) {

    checkExpectedCount(listAllResponse, expected);
  }

  @Then("the list all response manually contains \"{int}\" Templates")
  public void listAllManuallyResult(int expected) {

    checkExpectedCount(listAllManuallyResponse, expected);
  }

  @Then("the Templates iteration result contains the data from \"{int}\" pages")
  public void listAllByPageResult(int expected) {

    int count = listAllManuallyResponse.getContent().isEmpty() ? 0 : 1;
    while (listAllManuallyResponse.hasNextPage()) {
      count++;
      listAllManuallyResponse = listAllManuallyResponse.nextPage();
    }
    Assertions.assertEquals(count, expected);
  }

  @Then("the create version response contains information about the Version details")
  public void createVersionResult() {

    TestHelpers.recursiveEquals(expectedVersionDetails, createVersionResponse);
  }

  @Then("the get version response contains information about the Version details")
  public void getVersionResult() {

    TestHelpers.recursiveEquals(expectedVersionDetails, getVersionResponse);
  }

  @Then("the update Version response contains no data")
  public void updateVersionResult() {
    Assertions.assertTrue(updateVersionPassed);
  }

  @Then("the result of the copy contains information about the Version details")
  public void copyVersionResult() {

    VersionDetails expectedCopyVersionDetails =
        VersionDetails.builder()
            .setActive(false)
            .setId("aaaaaaaa-bbbb-cccc-dddd-zzzzzzzzzzzz")
            .setTag(expectedVersionDetails.getTag())
            .setTemplate(expectedVersionDetails.getTemplate())
            .setEngine(expectedVersionDetails.getEngine())
            .setMjml(expectedVersionDetails.getMjml())
            .setCreatedAt(expectedVersionDetails.getCreatedAt())
            .setComment(expectedVersionDetails.getComment())
            .setHeaders(expectedVersionDetails.getHeaders())
            .build();
    TestHelpers.recursiveEquals(expectedCopyVersionDetails, copyVersionResponse);
  }

  @Then("the delete Version response contains no data")
  public void deleteVersionResult() {
    Assertions.assertTrue(deleteVersionPassed);
  }

  @Then("the page response contains \"{int}\" Versions")
  public void listVersionsOnePageResult(int expected) {

    Assertions.assertEquals(listVersionsOnePageResponse.getContent().size(), expected);
  }

  @Then("the list all response contains \"{int}\" Versions")
  public void listVersionsAllResult(int expected) {

    checkExpectedCount(listAllVersionsResponse, expected);
  }

  @Then("the list all response manually contains \"{int}\" Versions")
  public void listAllVersionsByPageResult(int expected) {

    checkExpectedCount(listAllVersionsManuallyResponse, expected);
  }

  @Then("the Versions iteration result contains the data from \"{int}\" pages")
  public void listVersionsAllByPageResult(int expected) {

    int count = listAllVersionsManuallyResponse.getContent().isEmpty() ? 0 : 1;
    while (listAllVersionsManuallyResponse.hasNextPage()) {
      count++;
      listAllVersionsManuallyResponse = listAllVersionsManuallyResponse.nextPage();
    }
    Assertions.assertEquals(count, expected);
  }

  void checkExpectedCount(ListResponse<?> response, int expected) {

    AtomicInteger count = new AtomicInteger();
    response.iterator().forEachRemaining(_unused -> count.getAndIncrement());

    Assertions.assertEquals(count.get(), expected);
  }

  private static void compareTemplateField(Template actual, Template expected) {
    TestHelpers.recursiveEquals(expected.getName(), actual.getName());
    TestHelpers.recursiveEquals(expected.getDescription(), actual.getDescription());
    TestHelpers.recursiveEquals(expected.getCreatedAt(), actual.getCreatedAt());
    TestHelpers.recursiveEquals(expected.getCreatedBy(), actual.getCreatedBy());
    TestHelpers.recursiveEquals(expected.getId(), actual.getId());
  }
}
