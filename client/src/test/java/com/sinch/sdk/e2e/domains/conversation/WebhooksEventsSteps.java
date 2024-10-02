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
import com.sinch.sdk.e2e.domains.WebhooksHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
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

  static final String SECRET = "CactusKnight_SurfsWaves";

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

  Map<WebhookTrigger, String> triggerToURL =
      Stream.of(
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.CAPABILITY, WEBHOOKS_PATH + "capability-lookup"),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.CONTACT_CREATE, WEBHOOKS_PATH + "contact-create"),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.CONTACT_DELETE, WEBHOOKS_PATH + "contact-delete"),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.CONTACT_MERGE, WEBHOOKS_PATH + "contact-merge"),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.CONTACT_UPDATE, WEBHOOKS_PATH + "contact-update"),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.CONVERSATION_DELETE, WEBHOOKS_PATH + "conversation-delete"),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.CONVERSATION_START, WEBHOOKS_PATH + "conversation-start"),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.CONVERSATION_STOP, WEBHOOKS_PATH + "conversation-stop"),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.EVENT_DELIVERY, WEBHOOKS_PATH + "event-delivery-report/succeeded"),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.EVENT_INBOUND, WEBHOOKS_PATH + "event-inbound"),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.MESSAGE_DELIVERY,
                  WEBHOOKS_PATH + "message-delivery-report/succeeded"),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.MESSAGE_INBOUND, WEBHOOKS_PATH + "message-inbound"),
              new AbstractMap.SimpleEntry<>(
                  WebhookTrigger.MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION,
                  WEBHOOKS_PATH + "message-inbound/smart-conversation-redaction"))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

  WebHooksService service;

  Map<WebhookTrigger, WebhooksHelper.Response<ConversationWebhookEvent>> receivedEvents =
      new ConcurrentHashMap<>();

  WebhooksHelper.Response<ConversationWebhookEvent> eventDeliveryReceiptFailedResponse;
  WebhooksHelper.Response<ConversationWebhookEvent> messageDeliveryReceiptFailedResponse;
  WebhooksHelper.Response<ConversationWebhookEvent> messageSubmitMediaResponse;
  WebhooksHelper.Response<ConversationWebhookEvent> messageSubmitTextResponse;
  WebhooksHelper.Response<ConversationWebhookEvent> smartConversationMediaResponse;
  WebhooksHelper.Response<ConversationWebhookEvent> smartConversationTextResponse;

  @Given("^the Conversation Webhooks handler is available$")
  public void handlerAvailable() {
    service = Config.getSinchClient().conversation().v1().webhooks();
  }

  @When("^I send a request to trigger a \"CAPABILITY\" event$")
  public void triggerCAPABILITY() throws IOException {
    handleRequest(WebhookTrigger.CAPABILITY);
  }

  @When("^I send a request to trigger a \"CONTACT_CREATE\" event$")
  public void triggerCONTACT_CREATE() throws IOException {
    handleRequest(WebhookTrigger.CONTACT_CREATE);
  }

  @When("^I send a request to trigger a \"CONTACT_DELETE\" event$")
  public void triggerCONTACT_DELETE() throws IOException {
    handleRequest(WebhookTrigger.CONTACT_DELETE);
  }

  @When("^I send a request to trigger a \"CONTACT_MERGE\" event$")
  public void triggerCONTACT_MERGE() throws IOException {
    handleRequest(WebhookTrigger.CONTACT_MERGE);
  }

  @When("^I send a request to trigger a \"CONTACT_UPDATE\" event$")
  public void triggerCONTACT_UPDATE() throws IOException {
    handleRequest(WebhookTrigger.CONTACT_UPDATE);
  }

  @When("^I send a request to trigger a \"CONVERSATION_DELETE\" event$")
  public void triggerCONVERSATION_DELETE() throws IOException {
    handleRequest(WebhookTrigger.CONVERSATION_DELETE);
  }

  @When("^I send a request to trigger a \"CONVERSATION_START\" event$")
  public void triggerCONVERSATION_START() throws IOException {
    handleRequest(WebhookTrigger.CONVERSATION_START);
  }

  @When("^I send a request to trigger a \"CONVERSATION_STOP\" event$")
  public void triggerCONVERSATION_STOP() throws IOException {
    handleRequest(WebhookTrigger.CONVERSATION_STOP);
  }

  @When("^I send a request to trigger a \"EVENT_DELIVERY\" event with a \"FAILED\" status$")
  public void triggerEVENT_DELIVERY_FAILED() throws IOException {
    eventDeliveryReceiptFailedResponse =
        WebhooksHelper.callURL(
            new URL(WEBHOOKS_PATH + "event-delivery-report/failed"), service::parseEvent);
  }

  @When("^I send a request to trigger a \"EVENT_DELIVERY\" event with a \"DELIVERED\" status$")
  public void triggerEVENT_DELIVERY() throws IOException {
    handleRequest(WebhookTrigger.EVENT_DELIVERY);
  }

  @When("^I send a request to trigger a \"EVENT_INBOUND\" event$")
  public void triggerINBOUND() throws IOException {
    handleRequest(WebhookTrigger.EVENT_INBOUND);
  }

  @When("^I send a request to trigger a \"MESSAGE_DELIVERY\" event with a \"FAILED\" status$")
  public void triggerMESSAGE_DELIVERY_FAILED() throws IOException {
    messageDeliveryReceiptFailedResponse =
        WebhooksHelper.callURL(
            new URL(WEBHOOKS_PATH + "message-delivery-report/failed"), service::parseEvent);
  }

  @When(
      "^I send a request to trigger a \"MESSAGE_DELIVERY\" event with a \"QUEUED_ON_CHANNEL\""
          + " status$")
  public void triggerMESSAGE_DELIVERY() throws IOException {
    handleRequest(WebhookTrigger.MESSAGE_DELIVERY);
  }

  @When("^I send a request to trigger a \"MESSAGE_INBOUND\" event$")
  public void triggerMESSAGE_INBOUND() throws IOException {
    handleRequest(WebhookTrigger.MESSAGE_INBOUND);
  }

  @When("^I send a request to trigger a \"MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION\" event$")
  public void triggerMESSAGE_INBOUND_SMART_CONVERSATION_REDACTION() throws IOException {
    handleRequest(WebhookTrigger.MESSAGE_INBOUND_SMART_CONVERSATION_REDACTION);
  }

  @When("^I send a request to trigger a \"MESSAGE_SUBMIT\" event for a \"media\" message$")
  public void triggerMESSAGE_SUBMIT_MEDIA() throws IOException {
    messageSubmitMediaResponse =
        WebhooksHelper.callURL(
            new URL(WEBHOOKS_PATH + "message-submit/media"), service::parseEvent);
  }

  @When("^I send a request to trigger a \"MESSAGE_SUBMIT\" event for a \"text\" message$")
  public void triggerMESSAGE_SUBMIT_TEXT() throws IOException {
    messageSubmitTextResponse =
        WebhooksHelper.callURL(new URL(WEBHOOKS_PATH + "message-submit/text"), service::parseEvent);
  }

  @When("^I send a request to trigger a \"SMART_CONVERSATIONS\" event for a \"media\" message$")
  public void triggerSMART_CONVERSATIONS_MEDIA() throws IOException {
    smartConversationMediaResponse =
        WebhooksHelper.callURL(
            new URL(WEBHOOKS_PATH + "smart-conversations/media"), service::parseEvent);
  }

  @When("^I send a request to trigger a \"SMART_CONVERSATIONS\" event for a \"text\" message$")
  public void triggerSMART_CONVERSATIONS_TEXT() throws IOException {
    smartConversationTextResponse =
        WebhooksHelper.callURL(
            new URL(WEBHOOKS_PATH + "smart-conversations/text"), service::parseEvent);
  }

  @Then("the header of the Conversation event {string} contains a valid signature")
  public void validateHeader(String e2eKeyword) {

    WebhooksHelper.Response<ConversationWebhookEvent> receivedEvent =
        receivedEvents.get(WebhookTrigger.from(e2eKeyword));

    if (null != receivedEvent) {
      boolean validated =
          service.validateAuthenticationHeader(
              SECRET, receivedEvent.headers, receivedEvent.rawPayload);
      Assertions.assertTrue(validated);
    }
  }

  @Then("the Conversation event describes a {string} event type")
  public void triggerResult(String e2eKeyword) {
    WebhookTrigger trigger = WebhookTrigger.from(e2eKeyword);
    WebhooksHelper.Response<ConversationWebhookEvent> receivedEvent = receivedEvents.get(trigger);
    if (null != receivedEvent) {
      Assertions.assertInstanceOf(expectedClasses.get(trigger), receivedEvent.event);
    }
  }

  @Then(
      "the header of the Conversation event {string} with a {string} status contains a valid"
          + " signature")
  public void validateEventDeliveryFailureHeader(String e2eKeyword, String status) {

    WebhooksHelper.Response<ConversationWebhookEvent> receivedEvent = null;
    if (e2eKeyword.equals(WebhookTrigger.EVENT_DELIVERY.value())
        && status.equals(DeliveryStatus.FAILED.value())) {
      receivedEvent = eventDeliveryReceiptFailedResponse;
    } else if (e2eKeyword.equals(WebhookTrigger.EVENT_DELIVERY.value())
        && status.equals(DeliveryStatus.DELIVERED.value())) {
      receivedEvent = receivedEvents.get(WebhookTrigger.from(e2eKeyword));
    } else if (e2eKeyword.equals(WebhookTrigger.MESSAGE_DELIVERY.value())
        && status.equals(DeliveryStatus.FAILED.value())) {
      receivedEvent = messageDeliveryReceiptFailedResponse;
    } else if (e2eKeyword.equals(WebhookTrigger.MESSAGE_DELIVERY.value())
        && status.equals(DeliveryStatus.QUEUED_ON_CHANNEL.value())) {
      receivedEvent = receivedEvents.get(WebhookTrigger.from(e2eKeyword));
    } else {
      Assertions.fail();
    }
    boolean validated =
        service.validateAuthenticationHeader(
            SECRET, receivedEvent.headers, receivedEvent.rawPayload);
    Assertions.assertTrue(validated);
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

    TestHelpers.recursiveEquals(expected, eventDeliveryReceiptFailedResponse.event);
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

    TestHelpers.recursiveEquals(expected, messageDeliveryReceiptFailedResponse.event);
  }

  @Then(
      "the header of the Conversation event {string} for a {string} message contains a valid"
          + " signature")
  public void validateMessageSubmitHeader(String e2eKeyword, String messageType) {
    WebhooksHelper.Response<ConversationWebhookEvent> receivedEvent = null;
    if (e2eKeyword.equals("MESSAGE_SUBMIT") && messageType.equals("media")) {
      receivedEvent = messageSubmitMediaResponse;
    } else if (e2eKeyword.equals("MESSAGE_SUBMIT") && messageType.equals("text")) {
      receivedEvent = messageSubmitTextResponse;
    } else if (e2eKeyword.equals("SMART_CONVERSATIONS") && messageType.equals("media")) {
      receivedEvent = smartConversationMediaResponse;
    } else if (e2eKeyword.equals("SMART_CONVERSATIONS") && messageType.equals("text")) {
      receivedEvent = smartConversationTextResponse;
    } else {
      Assertions.fail();
    }
    boolean validated =
        service.validateAuthenticationHeader(
            SECRET, receivedEvent.headers, receivedEvent.rawPayload);
    Assertions.assertTrue(validated);
  }

  @Then("the Conversation event describes a {string} event type for a {string} message")
  public void messageTypeEventResult(String e2eKeyword, String messageType) {

    if (e2eKeyword.equals("MESSAGE_SUBMIT") && messageType.equals("media")) {
      MessageSubmitEvent event = (MessageSubmitEvent) messageSubmitMediaResponse.event;
      Assertions.assertInstanceOf(
          MediaMessage.class, event.getMessage().getSubmittedMessage().getBody());

    } else if (e2eKeyword.equals("MESSAGE_SUBMIT") && messageType.equals("text")) {
      MessageSubmitEvent event = (MessageSubmitEvent) messageSubmitTextResponse.event;
      Assertions.assertInstanceOf(
          TextMessage.class, event.getMessage().getSubmittedMessage().getBody());

    } else if (e2eKeyword.equals("SMART_CONVERSATIONS") && messageType.equals("media")) {
      SmartConversationsEvent event =
          (SmartConversationsEvent) smartConversationMediaResponse.event;
      Assertions.assertInstanceOf(SmartConversationsEvent.class, event);
      Assertions.assertEquals(
          event.getNotification().getAnalysisResults().getMlImageRecognitionResult().size(), 1);
      Assertions.assertEquals(
          event.getNotification().getAnalysisResults().getMlOffensiveAnalysisResult().size(), 1);

    } else if (e2eKeyword.equals("SMART_CONVERSATIONS") && messageType.equals("text")) {
      String loversText = "I ❤️ Sinch";

      SmartConversationsEvent event = (SmartConversationsEvent) smartConversationTextResponse.event;

      Assertions.assertInstanceOf(SmartConversationsEvent.class, event);
      Assertions.assertEquals(
          1, event.getNotification().getAnalysisResults().getMlSentimentResult().size());
      Assertions.assertEquals(
          loversText,
          event.getNotification().getAnalysisResults().getMlSentimentResult().get(0).getMessage());

      Assertions.assertEquals(
          1, event.getNotification().getAnalysisResults().getMlNluResult().size());
      Assertions.assertEquals(
          loversText,
          event.getNotification().getAnalysisResults().getMlNluResult().get(0).getMessage());

      Assertions.assertEquals(
          1, event.getNotification().getAnalysisResults().getMlPiiResult().size());
      Assertions.assertEquals(
          loversText,
          event.getNotification().getAnalysisResults().getMlPiiResult().get(0).getMessage());

      Assertions.assertEquals(
          1, event.getNotification().getAnalysisResults().getMlOffensiveAnalysisResult().size());
      Assertions.assertEquals(
          loversText,
          event
              .getNotification()
              .getAnalysisResults()
              .getMlOffensiveAnalysisResult()
              .get(0)
              .getMessage());
    } else {
      Assertions.fail();
    }
  }

  public void handleRequest(WebhookTrigger trigger) throws IOException {

    WebhooksHelper.Response<ConversationWebhookEvent> response =
        WebhooksHelper.callURL(new URL(triggerToURL.get(trigger)), service::parseEvent);
    receivedEvents.put(trigger, response);
  }
}
