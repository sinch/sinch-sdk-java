package com.sinch.sdk.e2e.domains.conversation;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.WebHooksService;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.Reason;
import com.sinch.sdk.domains.conversation.models.v1.ReasonCode;
import com.sinch.sdk.domains.conversation.models.v1.ReasonSubCode;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.WebhookTrigger;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.ConversationWebhookEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.capability.CapabilityEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.ContactCreateEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.ContactDeleteEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.ContactMergeEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.ContactUpdateEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.conversation.ConversationDeleteEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.conversation.ConversationStartEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.conversation.ConversationStopEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.delivery.DeliveryStatus;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.delivery.EventDeliveryReceiptEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.delivery.EventDeliveryReport;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.delivery.MessageDeliveryReceiptEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.delivery.MessageDeliveryReport;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.inbound.InboundEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.message.MessageInboundEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.message.MessageSubmitEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations.MessageInboundSmartConversationRedactionEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations.SmartConversationsEvent;
import com.sinch.sdk.e2e.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.util.AbstractMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;

public class WebhooksEventsSteps {

  static final String WEBHOOKS_PATH = Config.CONVERSATION_HOST_NAME + "/webhooks/conversation/";
  static final String E2E_KEYWORD_CAPABILITY = "CAPABILITY";
  static final String E2E_KEYWORD_CONTACT_CREATE = "CONTACT_CREATE";
  static final String E2E_KEYWORD_CONTACT_DELETE = "CONTACT_DELETE";
  static final String E2E_KEYWORD_CONTACT_MERGE = "CONTACT_MERGE";
  static final String E2E_KEYWORD_CONTACT_UPDATE = "CONTACT_UPDATE";
  static final String E2E_KEYWORD_CONVERSATION_DELETE = "CONVERSATION_DELETE";
  static final String E2E_KEYWORD_CONVERSATION_START = "CONVERSATION_START";
  static final String E2E_KEYWORD_CONVERSATION_STOP = "CONVERSATION_STOP";
  static final String E2E_KEYWORD_EVENT_DELIVERY = "EVENT_DELIVERY";
  static final String E2E_KEYWORD_EVENT_INBOUND = "EVENT_INBOUND";
  static final String E2E_KEYWORD_MESSAGE_DELIVERY = "MESSAGE_DELIVERY";
  static final String E2E_KEYWORD_MESSAGE_INBOUND = "MESSAGE_INBOUND";
  static final String E2E_KEYWORD_MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION =
      "MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION";

  Map<WebhookTrigger, Class<?>> expectedClasses =
      Stream.of(
              new AbstractMap.SimpleEntry<>(WebhookTrigger.CAPABILITY, CapabilityEvent.class),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.CONTACT_CREATE, ContactCreateEvent.class),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.CONTACT_DELETE, ContactDeleteEvent.class),
              new AbstractMap.SimpleEntry<>(WebhookTrigger.CONTACT_MERGE, ContactMergeEvent.class),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.CONTACT_UPDATE, ContactUpdateEvent.class),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.CONVERSATION_DELETE, ConversationDeleteEvent.class),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.CONVERSATION_START, ConversationStartEvent.class),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.CONVERSATION_STOP, ConversationStopEvent.class),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.EVENT_DELIVERY, EventDeliveryReceiptEvent.class),
              new AbstractMap.SimpleEntry<>(WebhookTrigger.EVENT_INBOUND, InboundEvent.class),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.MESSAGE_DELIVERY, MessageDeliveryReceiptEvent.class),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.MESSAGE_INBOUND, MessageInboundEvent.class),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION,
                  MessageInboundSmartConversationRedactionEvent.class))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

  Map<String, WebhookTrigger> e2eKeywordToTrigger =
      Stream.of(
              new AbstractMap.SimpleEntry<>(E2E_KEYWORD_CAPABILITY, WebhookTrigger.CAPABILITY),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_CONTACT_CREATE, WebhookTrigger.CONTACT_CREATE),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_CONTACT_DELETE, WebhookTrigger.CONTACT_DELETE),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_CONTACT_MERGE, WebhookTrigger.CONTACT_MERGE),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_CONTACT_UPDATE, WebhookTrigger.CONTACT_UPDATE),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_CONVERSATION_DELETE, WebhookTrigger.CONVERSATION_DELETE),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_CONVERSATION_START, WebhookTrigger.CONVERSATION_START),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_CONVERSATION_STOP, WebhookTrigger.CONVERSATION_STOP),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_EVENT_DELIVERY, WebhookTrigger.EVENT_DELIVERY),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_EVENT_INBOUND, WebhookTrigger.EVENT_INBOUND),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_MESSAGE_DELIVERY, WebhookTrigger.MESSAGE_DELIVERY),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_MESSAGE_INBOUND, WebhookTrigger.MESSAGE_INBOUND),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION,
                  WebhookTrigger.MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  Map<String, String> e2eKeywordToURL =
      Stream.of(
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_CAPABILITY, WEBHOOKS_PATH + "capability-lookup"),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_CONTACT_CREATE, WEBHOOKS_PATH + "contact-create"),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_CONTACT_DELETE, WEBHOOKS_PATH + "contact-delete"),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_CONTACT_MERGE, WEBHOOKS_PATH + "contact-merge"),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_CONTACT_UPDATE, WEBHOOKS_PATH + "contact-update"),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_CONVERSATION_DELETE, WEBHOOKS_PATH + "conversation-delete"),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_CONVERSATION_START, WEBHOOKS_PATH + "conversation-start"),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_CONVERSATION_STOP, WEBHOOKS_PATH + "conversation-stop"),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_EVENT_DELIVERY, WEBHOOKS_PATH + "event-delivery-report/succeeded"),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_EVENT_INBOUND, WEBHOOKS_PATH + "event-inbound"),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_MESSAGE_DELIVERY,
                  WEBHOOKS_PATH + "message-delivery-report/succeeded"),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_MESSAGE_INBOUND, WEBHOOKS_PATH + "message-inbound"),
              new AbstractMap.SimpleEntry<>(
                  E2E_KEYWORD_MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION,
                  WEBHOOKS_PATH + "message-inbound/smart-conversation-redaction"))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

  WebHooksService service;

  Map<WebhookTrigger, ConversationWebhookEvent> receivedEvents = new ConcurrentHashMap<>();

  ConversationWebhookEvent eventDeliveryReceiptFailedResponse;
  ConversationWebhookEvent messageDeliveryReceiptFailedResponse;
  MessageSubmitEvent messageSubmitMediaResponse;
  MessageSubmitEvent messageSubmitTextResponse;
  SmartConversationsEvent smartConversationMediaResponse;
  SmartConversationsEvent smartConversationTextResponse;

  @Given("^the Conversation Webhooks handler is available$")
  public void handlerAvailable() {
    service = Config.getSinchClient().conversation().v1().webhooks();
  }

  @When("^I send a request to trigger a \"" + E2E_KEYWORD_CAPABILITY + "\" event$")
  public void triggerCAPABILITY() throws IOException {
    handleRequest(E2E_KEYWORD_CAPABILITY);
  }

  @When("^I send a request to trigger a \"" + E2E_KEYWORD_CONTACT_CREATE + "\" event$")
  public void triggerCONTACT_CREATE() throws IOException {
    handleRequest(E2E_KEYWORD_CONTACT_CREATE);
  }

  @When("^I send a request to trigger a \"" + E2E_KEYWORD_CONTACT_DELETE + "\" event$")
  public void triggerCONTACT_DELETE() throws IOException {
    handleRequest(E2E_KEYWORD_CONTACT_DELETE);
  }

  @When("^I send a request to trigger a \"" + E2E_KEYWORD_CONTACT_MERGE + "\" event$")
  public void triggerCONTACT_MERGE() throws IOException {
    handleRequest(E2E_KEYWORD_CONTACT_MERGE);
  }

  @When("^I send a request to trigger a \"" + E2E_KEYWORD_CONTACT_UPDATE + "\" event$")
  public void triggerCONTACT_UPDATE() throws IOException {
    handleRequest(E2E_KEYWORD_CONTACT_UPDATE);
  }

  @When("^I send a request to trigger a \"" + E2E_KEYWORD_CONVERSATION_DELETE + "\" event$")
  public void triggerCONVERSATION_DELETE() throws IOException {
    handleRequest(E2E_KEYWORD_CONVERSATION_DELETE);
  }

  @When("^I send a request to trigger a \"" + E2E_KEYWORD_CONVERSATION_START + "\" event$")
  public void triggerCONVERSATION_START() throws IOException {
    handleRequest(E2E_KEYWORD_CONVERSATION_START);
  }

  @When("^I send a request to trigger a \"" + E2E_KEYWORD_CONVERSATION_STOP + "\" event$")
  public void triggerCONVERSATION_STOP() throws IOException {
    handleRequest(E2E_KEYWORD_CONVERSATION_STOP);
  }

  @When("^I send a request to trigger a \"EVENT_DELIVERY\" event with a FAILED status$")
  public void triggerEVENT_DELIVERY_FAILED() throws IOException {
    eventDeliveryReceiptFailedResponse =
        callURL(new URL(WEBHOOKS_PATH + "event-delivery-report/failed"));
  }

  @When("^I send a request to trigger a \"EVENT_DELIVERY\" event with a DELIVERED status$")
  public void triggerEVENT_DELIVERY() throws IOException {
    handleRequest(E2E_KEYWORD_EVENT_DELIVERY);
  }

  @When("^I send a request to trigger a \"" + E2E_KEYWORD_EVENT_INBOUND + "\" event$")
  public void triggerINBOUND() throws IOException {
    handleRequest(E2E_KEYWORD_EVENT_INBOUND);
  }

  @When("^I send a request to trigger a \"MESSAGE_DELIVERY\" event with a FAILED status$")
  public void triggerMESSAGE_DELIVERY_FAILED() throws IOException {
    messageDeliveryReceiptFailedResponse =
        callURL(new URL(WEBHOOKS_PATH + "message-delivery-report/failed"));
  }

  @When(
      "^I send a request to trigger a \""
          + E2E_KEYWORD_MESSAGE_DELIVERY
          + "\" event with a QUEUED status$")
  public void triggerMESSAGE_DELIVERY() throws IOException {
    handleRequest(E2E_KEYWORD_MESSAGE_DELIVERY);
  }

  @When("^I send a request to trigger a \"" + E2E_KEYWORD_MESSAGE_INBOUND + "\" event$")
  public void triggerMESSAGE_INBOUND() throws IOException {
    handleRequest(E2E_KEYWORD_MESSAGE_INBOUND);
  }

  @When(
      "^I send a request to trigger a \""
          + E2E_KEYWORD_MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION
          + "\" event$")
  public void triggerMESSAGE_INBOUND_SMART_CONVERSATION_REDACTION() throws IOException {
    handleRequest(E2E_KEYWORD_MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION);
  }

  @When("^I send a request to trigger a \"MESSAGE_SUBMIT\" event for a media message$")
  public void triggerMESSAGE_SUBMIT_MEDIA() throws IOException {
    messageSubmitMediaResponse =
        (MessageSubmitEvent) callURL(new URL(WEBHOOKS_PATH + "message-submit/media"));
  }

  @When("^I send a request to trigger a \"MESSAGE_SUBMIT\" event for a text message$")
  public void triggerMESSAGE_SUBMIT_TEXT() throws IOException {
    messageSubmitTextResponse =
        (MessageSubmitEvent) callURL(new URL(WEBHOOKS_PATH + "message-submit/text"));
  }

  @When("^I send a request to trigger a \"SMART_CONVERSATIONS\" event for a media message$")
  public void triggerSMART_CONVERSATIONS_MEDIA() throws IOException {
    smartConversationMediaResponse =
        (SmartConversationsEvent) callURL(new URL(WEBHOOKS_PATH + "smart-conversation/media"));
  }

  @When("^I send a request to trigger a \"SMART_CONVERSATIONS\" event for a text message$")
  public void triggerSMART_CONVERSATIONS_TEXT() throws IOException {
    smartConversationTextResponse =
        (SmartConversationsEvent) callURL(new URL(WEBHOOKS_PATH + "smart-conversation/text"));
  }

  @Then("the Conversation event header contains a valid signature")
  public void validateHeader() {
    // FIXME: Current cucumber description od not enable to perform validation in // and multi
    // thread mode
    // Which event is having to be validated here ?
    // Missing a parameter describing event type. Something like:
    //   "the Conversation event header contains a valid signature for {string} event type"
  }

  @Then("the Conversation event describes a {string} event type")
  public void triggerResult(String e2eKeyword) {
    WebhookTrigger trigger = e2eKeywordToTrigger.get(e2eKeyword);
    ConversationWebhookEvent receivedEvent = receivedEvents.get(trigger);
    if (null != receivedEvent) {
      Assertions.assertInstanceOf(expectedClasses.get(trigger), receivedEvent);
    }
  }

  @Then("the Conversation event describes a FAILED event delivery status and its reason")
  public void eventDeliveryFailureResult() {

    EventDeliveryReceiptEvent expected =
        EventDeliveryReceiptEvent.builder()
            .setAppId("01W4FFL35P4NC4K35CONVAPP01")
            .setProjectId(Config.PROJECT_ID)
            .setMessageMetadata("")
            .setCorrelationId("")
            .setAcceptedTime(Instant.parse("2024-06-06T14:42:42.208Z"))
            .setEventTime(Instant.parse("2024-06-06T14:42:42.251277147Z"))
            .setReport(
                EventDeliveryReport.builder()
                    .setEventId("01W4FFL35P4NC4K35EVENT0003")
                    .setStatus(DeliveryStatus.FAILED)
                    .setChannelIdentity(
                        ChannelIdentity.builder()
                            .setChannel(ConversationChannel.MESSENGER)
                            .setIdentity("7968425018576406")
                            .setAppId("01W4FFL35P4NC4K35CONVAPP01")
                            .build())
                    .setContactId("")
                    .setReason(
                        Reason.builder()
                            .setCode(ReasonCode.BAD_REQUEST)
                            .setDescription(
                                "The underlying channel reported: Message type [MESSAGE_NOT_SET]"
                                    + " not supported on Messenger")
                            .setSubCode(ReasonSubCode.UNSPECIFIED_SUB_CODE)
                            .build())
                    .setMetadata("")
                    .setProcessingMode(ProcessingMode.CONVERSATION)
                    .build())
            .build();

    TestHelpers.recursiveEquals(expected, eventDeliveryReceiptFailedResponse);
  }

  @Then("the Conversation event describes a FAILED message delivery status and its reason")
  public void messageDeliveryFailureResult() {

    MessageDeliveryReceiptEvent expected =
        MessageDeliveryReceiptEvent.builder()
            .setAppId("01W4FFL35P4NC4K35CONVAPP01")
            .setProjectId(Config.PROJECT_ID)
            .setAcceptedTime(Instant.parse("2024-06-06T14:42:42.721Z"))
            .setEventTime(Instant.parse("2024-06-06T14:42:43Z"))
            .setMessageMetadata("")
            .setCorrelationId("correlatorId")
            .setReport(
                MessageDeliveryReport.builder()
                    .setMessageId("01W4FFL35P4NC4K35MESSAGE05")
                    .setConversationId("01W4FFL35P4NC4K35CONVERS01")
                    .setStatus(DeliveryStatus.FAILED)
                    .setChannelIdentity(
                        ChannelIdentity.builder()
                            .setChannel(ConversationChannel.RCS)
                            .setIdentity("12016666666")
                            .setAppId("")
                            .build())
                    .setContactId("01W4FFL35P4NC4K35CONTACT02")
                    .setReason(
                        Reason.builder()
                            .setCode(ReasonCode.RECIPIENT_NOT_REACHABLE)
                            .setDescription(
                                "The underlying channel reported: Unable to find rcs support for"
                                    + " the given recipient")
                            .setSubCode(ReasonSubCode.UNSPECIFIED_SUB_CODE)
                            .build())
                    .setMetadata("")
                    .setProcessingMode(ProcessingMode.CONVERSATION)
                    .build())
            .build();

    TestHelpers.recursiveEquals(expected, messageDeliveryReceiptFailedResponse);
  }

  @Then("the Conversation event describes a \"MESSAGE_SUBMIT\" event type for a media message")
  public void messageSubmitMediaEventResult() {

    Assertions.assertInstanceOf(MessageSubmitEvent.class, messageSubmitMediaResponse);
    Assertions.assertInstanceOf(
        MediaMessage.class,
        messageSubmitMediaResponse.getMessage().getSubmittedMessage().getBody());
  }

  @Then("the Conversation event describes a \"MESSAGE_SUBMIT\" event type for a text message")
  public void messageSubmitTextEventResult() {

    Assertions.assertInstanceOf(MessageSubmitEvent.class, messageSubmitTextResponse);
    Assertions.assertInstanceOf(
        TextMessage.class, messageSubmitTextResponse.getMessage().getSubmittedMessage().getBody());
  }

  @Then("the Conversation event describes a \"SMART_CONVERSATIONS\" event type for a media message")
  public void smartConversationMediaResult() {

    Assertions.assertInstanceOf(SmartConversationsEvent.class, smartConversationMediaResponse);
    Assertions.assertEquals(
        smartConversationMediaResponse
            .getNotification()
            .getAnalysisResults()
            .getMlImageRecognitionResult()
            .size(),
        1);
    Assertions.assertEquals(
        smartConversationMediaResponse
            .getNotification()
            .getAnalysisResults()
            .getMlOffensiveAnalysisResult()
            .size(),
        1);
  }

  @Then("the Conversation event describes a \"SMART_CONVERSATIONS\" event type for a text message")
  public void smartConversationTextResult() {
    String loversText = "I ❤️ Sinch";

    Assertions.assertInstanceOf(SmartConversationsEvent.class, smartConversationTextResponse);
    Assertions.assertEquals(
        1,
        smartConversationTextResponse
            .getNotification()
            .getAnalysisResults()
            .getMlSentimentResult()
            .size());
    Assertions.assertEquals(
        loversText,
        smartConversationTextResponse
            .getNotification()
            .getAnalysisResults()
            .getMlSentimentResult()
            .get(0)
            .getMessage());

    Assertions.assertEquals(
        1,
        smartConversationTextResponse
            .getNotification()
            .getAnalysisResults()
            .getMlNluResult()
            .size());
    Assertions.assertEquals(
        loversText,
        smartConversationTextResponse
            .getNotification()
            .getAnalysisResults()
            .getMlNluResult()
            .get(0)
            .getMessage());

    Assertions.assertEquals(
        1,
        smartConversationTextResponse
            .getNotification()
            .getAnalysisResults()
            .getMlPiiResult()
            .size());
    Assertions.assertEquals(
        loversText,
        smartConversationTextResponse
            .getNotification()
            .getAnalysisResults()
            .getMlPiiResult()
            .get(0)
            .getMessage());

    Assertions.assertEquals(
        1,
        smartConversationTextResponse
            .getNotification()
            .getAnalysisResults()
            .getMlOffensiveAnalysisResult()
            .size());
    Assertions.assertEquals(
        loversText,
        smartConversationTextResponse
            .getNotification()
            .getAnalysisResults()
            .getMlOffensiveAnalysisResult()
            .get(0)
            .getMessage());
  }

  public void handleRequest(String e2eKeyword) throws IOException {

    ConversationWebhookEvent event = callURL(new URL(e2eKeywordToURL.get(e2eKeyword)));
    receivedEvents.put(e2eKeywordToTrigger.get(e2eKeyword), event);
  }

  public ConversationWebhookEvent callURL(URL url) throws IOException {

    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuilder content = new StringBuilder();
    while ((inputLine = in.readLine()) != null) {
      content.append(inputLine);
    }
    in.close();
    return service.parseEvent(content.toString());
  }
}
