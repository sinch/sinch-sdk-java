package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.capability.CapabilityEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.channel.ChannelEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.ContactCreateEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.ContactDeleteEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.ContactIdentitiesDuplicationEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.ContactMergeEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.ContactUpdateEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.conversation.ConversationDeleteEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.conversation.ConversationStartEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.conversation.ConversationStopEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.delivery.EventDeliveryReceiptEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.delivery.MessageDeliveryReceiptEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.inbound.InboundEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.message.MessageInboundEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.message.MessageSubmitEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.opting.OptInEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.opting.OptOutEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.record.RecordNotificationEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations.MessageInboundSmartConversationRedactionEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations.SmartConversationsEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.unsupported.UnsupportedCallbackEvent;
import com.sinch.sdk.models.Configuration;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@TestWithResources
public class WebHooksServiceTest extends ConversationBaseTest {

  com.sinch.sdk.domains.conversation.api.v1.WebHooksService serverService;

  @GivenTextResource("domains/conversation/v1/webhooks/events/capability/CapabilityEventDto.json")
  String jsonCapabilityEvent;

  @GivenTextResource("domains/conversation/v1/webhooks/events/channel/ChannelEventDto.json")
  String jsonChannelEvent;

  @GivenTextResource("domains/conversation/v1/webhooks/events/contact/ContactCreateEventDto.json")
  String jsonContactCreateEvent;

  @GivenTextResource("domains/conversation/v1/webhooks/events/contact/ContactDeleteEventDto.json")
  String jsonContactDeleteEvent;

  @GivenTextResource(
      "domains/conversation/v1/webhooks/events/contact/ContactIdentitiesDuplicationEventDto.json")
  String jsonContactIdentitiesDuplicationEvent;

  @GivenTextResource("domains/conversation/v1/webhooks/events/contact/ContactMergeEventDto.json")
  String jsonContactMergeEvent;

  @GivenTextResource("domains/conversation/v1/webhooks/events/contact/ContactUpdateEventDto.json")
  String jsonContactUpdateEvent;

  @GivenTextResource(
      "domains/conversation/v1/webhooks/events/conversation/ConversationDeleteEventDto.json")
  String jsonConversationDeleteEvent;

  @GivenTextResource(
      "domains/conversation/v1/webhooks/events/conversation/ConversationStartEventDto.json")
  String jsonConversationStartEvent;

  @GivenTextResource(
      "domains/conversation/v1/webhooks/events/conversation/ConversationStopEventDto.json")
  String jsonConversationStopEvent;

  @GivenTextResource(
      "domains/conversation/v1/webhooks/events/delivery/EventDeliveryReceiptEventDto.json")
  String jsonEventDeliveryReport;

  @GivenTextResource(
      "domains/conversation/v1/webhooks/events/delivery/MessageDeliveryReceiptEventDto.json")
  String jsonMessageDeliveryReceiptEvent;

  @GivenTextResource("domains/conversation/v1/webhooks/events/inbound/InboundContactEventDto.json")
  String jsonInboundEvent;

  @GivenTextResource("domains/conversation/v1/webhooks/events/message/MessageInboundEventDto.json")
  String jsonMessageInboundEvent;

  @GivenTextResource("domains/conversation/v1/webhooks/events/message/MessageSubmitEventDto.json")
  String jsonMessageSubmitEvent;

  @GivenTextResource("domains/conversation/v1/webhooks/events/opting/OptInEventDto.json")
  String jsonOptInEvent;

  @GivenTextResource("domains/conversation/v1/webhooks/events/opting/OptOutEventDto.json")
  String jsonOptOutEvent;

  @GivenTextResource(
      "domains/conversation/v1/webhooks/events/record/RecordNotificationEventDto.json")
  String jsonRecordNotificationEvent;

  @GivenTextResource(
      "domains/conversation/v1/webhooks/events/smartconversations/MessageInboundSmartConversationRedactionEventDto.json")
  String jsonMessageInboundSmartConversationRedactionEvent;

  @GivenTextResource(
      "domains/conversation/v1/webhooks/events/smartconversations/SmartConversationsEventDto.json")
  String jsonSmartConversationsEvent;

  @GivenTextResource(
      "domains/conversation/v1/webhooks/events/unsupported/UnsupportedCallbackEventDto.json")
  String jsonUnsupportedCallbackEvent;

  @Test
  void checkApplicationAuthentication() throws ApiException {

    Map<String, String> headers =
        Stream.of(
                new AbstractMap.SimpleEntry<>(
                    ConversationWebhooksAuthenticationValidation.SIGNATURE_HEADER,
                    "6bpJoRmFoXVjfJIVglMoJzYXxnoxRujzR4k2GOXewOE="),
                new AbstractMap.SimpleEntry<>(
                    ConversationWebhooksAuthenticationValidation.ALGORITHM_HEADER, "HmacSHA256"),
                new AbstractMap.SimpleEntry<>(
                    ConversationWebhooksAuthenticationValidation.NONCE_HEADER,
                    "01FJA8B4A7BM43YGWSG9GBV067"),
                new AbstractMap.SimpleEntry<>(
                    ConversationWebhooksAuthenticationValidation.TIMESTAMP_HEADER, "1634579353"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    boolean authenticationResult =
        serverService.validateAuthenticationHeader(
            "foo_secret1234",
            headers,
            "{\"app_id\":\"\",\"accepted_time\":\"2021-10-18T17:49:13.813615Z\",\"project_id\":\"e2df3a34-a71b-4448-9db5-a8d2baad28e4\",\"contact_create_notification\":{\"contact\":{\"id\":\"01FJA8B466Y0R2GNXD78MD9SM1\",\"channel_identities\":[{\"channel\":\"SMS\",\"identity\":\"48123456789\",\"app_id\":\"\"}],\"display_name\":\"New"
                + " Test"
                + " Contact\",\"email\":\"new.contact@email.com\",\"external_id\":\"\",\"metadata\":\"\",\"language\":\"EN_US\"}},\"message_metadata\":\"\"}");

    assertTrue(authenticationResult);
  }

  @Test
  void checkParsedCapabilityEventDto() throws ApiException {
    assertTrue(serverService.parseEvent(jsonCapabilityEvent) instanceof CapabilityEvent);
  }

  @Test
  void checkParsedChannelEventDto() throws ApiException {
    assertTrue(serverService.parseEvent(jsonChannelEvent) instanceof ChannelEvent);
  }

  @Test
  void checkParsedContactCreateEventDto() throws ApiException {
    assertTrue(serverService.parseEvent(jsonContactCreateEvent) instanceof ContactCreateEvent);
  }

  @Test
  void checkParsedContactDeleteEventEventDto() throws ApiException {
    assertTrue(serverService.parseEvent(jsonContactDeleteEvent) instanceof ContactDeleteEvent);
  }

  @Test
  void checkParsedContactIdentitiesDuplicationEventDto() throws ApiException {
    assertTrue(
        serverService.parseEvent(jsonContactIdentitiesDuplicationEvent)
            instanceof ContactIdentitiesDuplicationEvent);
  }

  @Test
  void checkParsedContactMergeEventDto() throws ApiException {
    assertTrue(serverService.parseEvent(jsonContactMergeEvent) instanceof ContactMergeEvent);
  }

  @Test
  void checkParsedContactUpdateEventEventDto() throws ApiException {
    assertTrue(serverService.parseEvent(jsonContactUpdateEvent) instanceof ContactUpdateEvent);
  }

  @Test
  void checkParsedConversationDeleteEventDto() throws ApiException {
    assertTrue(
        serverService.parseEvent(jsonConversationDeleteEvent) instanceof ConversationDeleteEvent);
  }

  @Test
  void checkParsedConversationStartEventDto() throws ApiException {
    assertTrue(
        serverService.parseEvent(jsonConversationStartEvent) instanceof ConversationStartEvent);
  }

  @Test
  void checkParsedConversationStopEventDto() throws ApiException {
    assertTrue(
        serverService.parseEvent(jsonConversationStopEvent) instanceof ConversationStopEvent);
  }

  @Test
  void checkParsedEventDeliveryReportDto() throws ApiException {
    assertTrue(
        serverService.parseEvent(jsonEventDeliveryReport) instanceof EventDeliveryReceiptEvent);
  }

  @Test
  void checkParsedMessageDeliveryReceiptEventDto() throws ApiException {
    assertTrue(
        serverService.parseEvent(jsonMessageDeliveryReceiptEvent)
            instanceof MessageDeliveryReceiptEvent);
  }

  @Test
  void checkParsedInboundEventDto() throws ApiException {
    assertTrue(serverService.parseEvent(jsonInboundEvent) instanceof InboundEvent);
  }

  @Test
  void checkMessageInboundEventDto() throws ApiException {
    assertTrue(serverService.parseEvent(jsonMessageInboundEvent) instanceof MessageInboundEvent);
  }

  @Test
  void checkMessageSubmitEventDto() throws ApiException {
    assertTrue(serverService.parseEvent(jsonMessageSubmitEvent) instanceof MessageSubmitEvent);
  }

  @Test
  void checkOptInEventDto() throws ApiException {
    assertTrue(serverService.parseEvent(jsonOptInEvent) instanceof OptInEvent);
  }

  @Test
  void checkOptOutEventDto() throws ApiException {
    assertTrue(serverService.parseEvent(jsonOptOutEvent) instanceof OptOutEvent);
  }

  @Test
  void checkRecordNotificationEventDto() throws ApiException {
    assertTrue(
        serverService.parseEvent(jsonRecordNotificationEvent) instanceof RecordNotificationEvent);
  }

  @Test
  void checkMessageInboundSmartConversationRedactionEventDto() throws ApiException {
    assertTrue(
        serverService.parseEvent(jsonMessageInboundSmartConversationRedactionEvent)
            instanceof MessageInboundSmartConversationRedactionEvent);
  }

  @Test
  void checkSmartConversationsEventDto() throws ApiException {
    assertTrue(
        serverService.parseEvent(jsonSmartConversationsEvent) instanceof SmartConversationsEvent);
  }

  @Test
  void checkUnsupportedCallbackEventDto() throws ApiException {
    assertTrue(
        serverService.parseEvent(jsonUnsupportedCallbackEvent) instanceof UnsupportedCallbackEvent);
  }

  @BeforeEach
  public void setUp() {

    Configuration configuration =
        Configuration.builder()
            .setProjectId("unused")
            .setKeyId("unused")
            .setKeySecret("unused")
            .build();
    serverService = new SinchClient(configuration).conversation().v1().webhooks();
  }
}
