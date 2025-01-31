package com.sinch.sdk.e2e.domains.mailgun.v1;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.mailgun.api.v1.EmailsService;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendEmailHtmlInlineRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendEmailRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendMimeEmailRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.ExceededQueueQuota;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.GetStoredEmailResponse;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.QueueStatusDisabledDetails;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendEmailResponse;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendingQueuesStatusResponse;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;

public class EmailsSteps {

  EmailsService service;

  SendEmailResponse sendEmailResponse;
  SendEmailResponse sendMimeEmailResponse;
  GetStoredEmailResponse getStoredEmailResponse;
  SendingQueuesStatusResponse sendingQueuesStatusResponse;
  Boolean purgeDomainQueuesPassed;

  static final String domainName = "domainName";
  static final String storageKey = "storageKey";

  @Given("^the Mailgun service \"Emails\" is available$")
  public void serviceAvailable() {
    service = Config.getSinchClient().mailgun().v1().emails();
  }

  @When("^I send a request to send a text email$")
  public void send() {

    SendEmailRequest request =
        SendEmailHtmlInlineRequest.builder()
            .setText("Hello, this is a text message for E2E testing.")
            .setTo(Collections.singletonList("destination@e2e.tst"))
            .setFrom("Excited E2E user ✉️ <sender@e2e.tst>")
            .setSubject("E2E test text email")
            .build();

    sendEmailResponse = service.sendEmail(domainName, request);
  }

  @When("^I send a request to send a MIME email$")
  public void sendMime() {

    File tempFile = new File("MimeMessage");
    tempFile.deleteOnExit();
    try (BufferedWriter out = new BufferedWriter(new FileWriter(tempFile))) {
      out.write("\uD83D\uDCE7 Sample content \uD83D\uDCE7");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    SendMimeEmailRequest request =
        SendMimeEmailRequest.builder()
            .setTo(Collections.singletonList("destination@e2e.tst"))
            .setMessage(tempFile)
            .build();

    sendMimeEmailResponse = service.sendMimeEmail(domainName, request);
  }

  @When("^I send a request to retrieve a stored email$")
  public void getStoredEmail() {

    getStoredEmailResponse = service.getStoredEmail(domainName, storageKey);
  }

  @When("^I send a request to get the sending queue status$")
  public void getSendingQueuesStatus() {

    sendingQueuesStatusResponse = service.getSendingQueuesStatus(domainName);
  }

  @When("^I send a request to purge a sending queue$")
  public void purgeDomainQueues() {

    service.purgeSendingQueue(domainName, Config.MAILGUN_STORAGE);
    purgeDomainQueuesPassed = true;
  }

  @Then("the sendEmail response contains information about the text email")
  public void sendResult() {

    SendEmailResponse expected =
        SendEmailResponse.builder()
            .setId("<20240606154318.027ac0b5fc80da62@sandbox123.mailgun.org>")
            .setMessage("Queued. Thank you.")
            .build();

    TestHelpers.recursiveEquals(expected, sendEmailResponse);
  }

  @Then("the sendMimeEmail response contains information about the email")
  public void sendMimeResult() {

    SendEmailResponse expected =
        SendEmailResponse.builder()
            .setId("<20240606154852.a3fafd8a5230e166@sandbox123.mailgun.org>")
            .setMessage("Queued. Thank you.")
            .build();

    TestHelpers.recursiveEquals(expected, sendMimeEmailResponse);
  }

  @Then("the getEmail response contains the email details")
  public void getStoredEmailResult() {

    GetStoredEmailResponse expected =
        GetStoredEmailResponse.builder()
            .setFrom("sender@e2e.tst")
            .setSubject("Hello from mailgun")
            .setSender("postmaster@sandbox123.mailgun.org")
            .setRecipients("recipient@e2e.tst")
            .setBodyHtml(
                "<h1>Hello %recipient.name%</h1><span style=\"color:blue\">This is an HTML"
                    + " email</span>")
            .setStrippedHtml(
                "<h1>Hello %recipient.name%</h1><span style=\"color:blue\">This is an HTML"
                    + " email</span>")
            .setBodyPlain("Message text only")
            .setStrippedText("Message text only")
            .setStrippedSignature("")
            .setMessageHeaders(
                Arrays.asList(
                    Arrays.asList("Mime-Version", "1.0"),
                    Arrays.asList(
                        "Content-Type",
                        "multipart/alternative;"
                            + " boundary=\"44eea75a00c7df3bdd541c89727faec0ce8d5b09663245a35789d6b264c6\""),
                    Arrays.asList("Subject", "Hello from mailgun"),
                    Arrays.asList("From", "sender@e2e.tst"),
                    Arrays.asList("To", "%recipient%"),
                    Arrays.asList("X-Mailgun-Deliver-By", "Thu, 06 Jun 2024 07:40:00 +0000"),
                    Arrays.asList(
                        "Message-Id", "<20240606162145.5f329edde3b4ed71@sandbox123.mailgun.org>")))
            .build();

    TestHelpers.recursiveEquals(expected, getStoredEmailResponse);
  }

  @Then("the response contains the sending queues status")
  public void getSendingQueuesStatusResult() {

    SendingQueuesStatusResponse expected =
        SendingQueuesStatusResponse.builder()
            .setRegular(
                ExceededQueueQuota.builder()
                    .setIsDisabled(false)
                    .setDetails(
                        QueueStatusDisabledDetails.builder().setUntil(null).setReason("").build())
                    .build())
            .setScheduled(
                ExceededQueueQuota.builder()
                    .setIsDisabled(false)
                    .setDetails(
                        QueueStatusDisabledDetails.builder().setUntil(null).setReason("").build())
                    .build())
            .build();

    TestHelpers.recursiveEquals(expected, sendingQueuesStatusResponse);
  }

  @Then("the response indicates the purge has been done")
  public void purgeDomainQueuesValue() {
    Assertions.assertTrue(purgeDomainQueuesPassed);
  }
}
