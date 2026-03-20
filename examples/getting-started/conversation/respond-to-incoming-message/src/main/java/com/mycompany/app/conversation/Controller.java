package com.mycompany.app.conversation;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.SinchEventsService;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.ConversationSinchEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.message.MessageInboundEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("Conversation")
public class Controller {

  private final SinchClient sinchClient;
  private final ServerBusinessLogic serverBusinessLogic;

  @Autowired
  public Controller(SinchClient sinchClient, ServerBusinessLogic serverBusinessLogic) {
    this.sinchClient = sinchClient;
    this.serverBusinessLogic = serverBusinessLogic;
  }

  @PostMapping(
      value = "/ConversationEvent",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> conversationEvent(@RequestBody String body) {

    SinchEventsService sinchEvents = sinchClient.conversation().v1().sinchEvents();

    // decode the request payload
    ConversationSinchEvent event = sinchEvents.parseEvent(body);

    // let business layer process the request
    if (event instanceof MessageInboundEvent e) {
      serverBusinessLogic.handleMessageInboundEvent(e);
    }

    return ResponseEntity.ok().build();
  }
}
