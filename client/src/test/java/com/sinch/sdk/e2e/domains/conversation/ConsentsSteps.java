package com.sinch.sdk.e2e.domains.conversation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConsentsSteps {

  @Given("^the Conversation service \"Consents\" is available$")
  public void serviceAvailable() {
    // TODO implement conversation consents steps
  }

  @When("^I send a request to list the existing Consent Identities$")
  public void listPage() {

    // TODO implement conversation consents steps
  }

  @When("^I send a request to list all the Consent Identities$")
  public void listAll() {

    // TODO implement conversation consents steps
  }

  @When("^I iterate manually over the Consent Identities pages$")
  public void listIterateManually() {

    // TODO implement conversation consents steps
  }

  @When("^I send a request to list the Audit Records associated with an identity$")
  public void listAuditRecords() {

    // TODO implement conversation consents steps
  }

  @Then("the response contains \"{int}\" Consent Identities")
  public void listPageResult(int count) {
    // TODO implement conversation consents steps
  }

  @Then("the Consent Identities list contains \"{int}\" Consent Identities")
  public void listAllResult(int count) {
    // TODO implement conversation consents steps
  }

  @Then("the Consent Identities iteration result contains the data from \"{int}\" pages")
  public void listPageIterateResult(int count) {
    // TODO implement conversation consents steps
  }

  @Then("the response contains list of the Audit Records associated with an identity")
  public void listAuditRecordsResult() {
    // TODO implement conversation consents steps
  }
}
