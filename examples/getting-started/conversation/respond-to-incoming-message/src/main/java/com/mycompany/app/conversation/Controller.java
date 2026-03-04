package com.mycompany.app.conversation;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.WebhooksService;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.ConversationWebhookEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.message.MessageInboundEvent;
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
  public ResponseEntity<Void> conversationEvent(
      @RequestHeader Map<String, String> headers, @RequestBody String body) {

    WebhooksService webhooks = sinchClient.conversation().v1().webhooks();

    // set this value to true to validate request from Sinch servers
    // see https://developers.sinch.com/docs/conversation/callbacks#authenticating-callbacks for
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
    if (event instanceof MessageInboundEvent e) {
      webhooksBusinessLogic.handleMessageInboundEvent(e);
    }

    return ResponseEntity.ok().build();
  }
}
