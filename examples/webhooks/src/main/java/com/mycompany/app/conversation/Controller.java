package com.mycompany.app.conversation;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.SinchEventsService;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.ConversationSinchEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.capability.CapabilityEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.channel.ChannelEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.contact.ContactCreateEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.contact.ContactDeleteEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.contact.ContactIdentitiesDuplicationEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.contact.ContactMergeEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.contact.ContactUpdateEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.conversation.ConversationDeleteEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.conversation.ConversationStartEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.conversation.ConversationStopEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.delivery.EventDeliveryReceiptEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.delivery.MessageDeliveryReceiptEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.inbound.InboundEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.message.MessageInboundEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.message.MessageSubmitEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.opting.OptInEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.opting.OptOutEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.record.RecordNotificationEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.smartconversations.MessageInboundSmartConversationRedactionEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.smartconversations.SmartConversationsEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.unsupported.UnsupportedCallbackEvent;
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

  @Value("${conversation.sinchevents.secret: }")
  private String sinchEventsSecret;

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

    SinchEventsService webhooks = sinchClient.conversation().v1().sinchEvents();

    // set this value to true to validate request from Sinch servers
    // see https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Numbers-Callbacks for
    // more information
    boolean ensureValidAuthentication = false;
    if (ensureValidAuthentication) {
      // ensure valid authentication to handle request
      var validAuth = webhooks.validateAuthenticationHeader(sinchEventsSecret, headers, body);

      // token validation failed
      if (!validAuth) {
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
      }
    }

    // decode the request payload
    ConversationSinchEvent event = webhooks.parseEvent(body);

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
