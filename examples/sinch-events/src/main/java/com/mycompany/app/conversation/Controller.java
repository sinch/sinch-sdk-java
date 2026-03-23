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
  private final ServerBusinessLogic serverBusinessLogic;

  @Value("${conversation.sinchevents.secret: }")
  private String sinchEventsSecret;

  @Autowired
  public Controller(SinchClient sinchClient, ServerBusinessLogic serverBusinessLogic) {
    this.sinchClient = sinchClient;
    this.serverBusinessLogic = serverBusinessLogic;
  }

  @PostMapping(
      value = "/ConversationEvent",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> ConversationEvent(
      @RequestHeader Map<String, String> headers, @RequestBody String body) {

    SinchEventsService sinchEvents = sinchClient.conversation().v1().sinchEvents();

    // set this value to true to validate request from Sinch servers
    // see https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Numbers-Callbacks for
    // more information
    boolean ensureValidAuthentication = false;
    if (ensureValidAuthentication) {
      // ensure valid authentication to handle request
      var validAuth = sinchEvents.validateAuthenticationHeader(sinchEventsSecret, headers, body);

      // token validation failed
      if (!validAuth) {
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
      }
    }

    // decode the request payload
    ConversationSinchEvent event = sinchEvents.parseEvent(body);

    // let business layer process the request
    switch (event) {
      case CapabilityEvent e -> serverBusinessLogic.handleCapabilityEvent(e);
      case ChannelEvent e -> serverBusinessLogic.handleChannelEvent(e);
      case ContactCreateEvent e -> serverBusinessLogic.handleContactCreateEvent(e);
      case ContactDeleteEvent e -> serverBusinessLogic.handleContactDeleteEvent(e);
      case ContactIdentitiesDuplicationEvent e ->
          serverBusinessLogic.handleContactIdentitiesDuplicationEvent(e);
      case ContactMergeEvent e -> serverBusinessLogic.handleContactMergeEvent(e);
      case ContactUpdateEvent e -> serverBusinessLogic.handleContactUpdateEvent(e);
      case ConversationDeleteEvent e -> serverBusinessLogic.handleConversationDeleteEvent(e);
      case ConversationStartEvent e -> serverBusinessLogic.handleConversationStartEvent(e);
      case ConversationStopEvent e -> serverBusinessLogic.handleConversationStopEvent(e);
      case EventDeliveryReceiptEvent e -> serverBusinessLogic.handleEventDeliveryReceiptEvent(e);
      case InboundEvent e -> serverBusinessLogic.handleInboundEvent(e);
      case MessageDeliveryReceiptEvent e ->
          serverBusinessLogic.handleMessageDeliveryReceiptEvent(e);
      case MessageInboundEvent e -> serverBusinessLogic.handleMessageInboundEvent(e);
      case MessageInboundSmartConversationRedactionEvent e ->
          serverBusinessLogic.handleMessageInboundSmartConversationRedactionEvent(e);
      case MessageSubmitEvent e -> serverBusinessLogic.handleMessageSubmitEvent(e);
      case OptInEvent e -> serverBusinessLogic.handleOptInEvent(e);
      case OptOutEvent e -> serverBusinessLogic.handleOptOutEvent(e);
      case RecordNotificationEvent e -> serverBusinessLogic.handleRecordNotificationEvent(e);
      case SmartConversationsEvent e -> serverBusinessLogic.handleSmartConversationsEvent(e);
      case UnsupportedCallbackEvent e -> serverBusinessLogic.handleUnsupportedCallbackEvent(e);
      default -> throw new IllegalStateException("Unexpected value: " + event);
    }

    return ResponseEntity.ok().build();
  }
}
