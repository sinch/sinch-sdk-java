package com.mycompany.app.conversation;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.WebhooksService;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.ConversationWebhookEvent;
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
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController("Conversation")
public class Controller {

  private final SinchClient sinchClient;
  private final ServerBusinessLogic webhooksBusinessLogic;

  @Value("${conversation.webhooks.secret: }")
  private String webhooksSecret;

  @Autowired
  public Controller(SinchClient sinchClient, ServerBusinessLogic webhooksBusinessLogic) {
    this.sinchClient = sinchClient;
    this.webhooksBusinessLogic = webhooksBusinessLogic;
  }

  @PostMapping(
      value = "/ConversationEvent",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> ConversationEvent(
      @RequestHeader Map<String, String> headers, @RequestBody String body) {

    WebhooksService webhooks = sinchClient.conversation().v1().webhooks();

    // set this value to true to validate request from Sinch servers
    // see https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Numbers-Callbacks for
    // more information
    boolean ensureValidAuthentication = false;
    if (ensureValidAuthentication) {
      // ensure valid authentication to handle request
      var validAuth = webhooks.validateAuthenticationHeader(webhooksSecret, headers, body);

      // token validation failed
      if (!validAuth) {
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
      }
    }

    // decode the request payload
    ConversationWebhookEvent event = webhooks.parseEvent(body);

    // let business layer process the request
    switch (event) {
      case CapabilityEvent e -> webhooksBusinessLogic.handleCapabilityEvent(e);
      case ChannelEvent e -> webhooksBusinessLogic.handleChannelEvent(e);
      case ContactCreateEvent e -> webhooksBusinessLogic.handleContactCreateEvent(e);
      case ContactDeleteEvent e -> webhooksBusinessLogic.handleContactDeleteEvent(e);
      case ContactIdentitiesDuplicationEvent e ->
          webhooksBusinessLogic.handleContactIdentitiesDuplicationEvent(e);
      case ContactMergeEvent e -> webhooksBusinessLogic.handleContactMergeEvent(e);
      case ContactUpdateEvent e -> webhooksBusinessLogic.handleContactUpdateEvent(e);
      case ConversationDeleteEvent e -> webhooksBusinessLogic.handleConversationDeleteEvent(e);
      case ConversationStartEvent e -> webhooksBusinessLogic.handleConversationStartEvent(e);
      case ConversationStopEvent e -> webhooksBusinessLogic.handleConversationStopEvent(e);
      case EventDeliveryReceiptEvent e -> webhooksBusinessLogic.handleEventDeliveryReceiptEvent(e);
      case InboundEvent e -> webhooksBusinessLogic.handleInboundEvent(e);
      case MessageDeliveryReceiptEvent e ->
          webhooksBusinessLogic.handleMessageDeliveryReceiptEvent(e);
      case MessageInboundEvent e -> webhooksBusinessLogic.handleMessageInboundEvent(e);
      case MessageInboundSmartConversationRedactionEvent e ->
          webhooksBusinessLogic.handleMessageInboundSmartConversationRedactionEvent(e);
      case MessageSubmitEvent e -> webhooksBusinessLogic.handleMessageSubmitEvent(e);
      case OptInEvent e -> webhooksBusinessLogic.handleOptInEvent(e);
      case OptOutEvent e -> webhooksBusinessLogic.handleOptOutEvent(e);
      case RecordNotificationEvent e -> webhooksBusinessLogic.handleRecordNotificationEvent(e);
      case SmartConversationsEvent e -> webhooksBusinessLogic.handleSmartConversationsEvent(e);
      case UnsupportedCallbackEvent e -> webhooksBusinessLogic.handleUnsupportedCallbackEvent(e);
      default -> throw new IllegalStateException("Unexpected value: " + event);
    }

    return ResponseEntity.ok().build();
  }
}
