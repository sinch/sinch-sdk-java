package com.mycompany.app.voice;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.api.v2.SinchEventsService;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEvent;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventResponse;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("Voice")
public class Controller {

  private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());

  private static final String PATH = "/voice/events";

  private final SinchClient sinchClient;
  private final ServerBusinessLogic serverBusinessLogic;

  @Autowired
  public Controller(SinchClient sinchClient, ServerBusinessLogic serverBusinessLogic) {
    this.sinchClient = sinchClient;
    this.serverBusinessLogic = serverBusinessLogic;
  }

  @PostMapping(
      value = PATH,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> voiceEvent(@RequestBody String body) {

    SinchEventsService sinchEvents = sinchClient.voice().v2().sinchEvents();

    // This sample does not validate the request signature. In production, check it with
    // sinchEvents.validateAuthenticationHeader() (see the examples/sinch-events Controllers)

    // decode the payload request
    VoiceSinchEvent event = sinchEvents.parseEvent(body);

    LOGGER.info(
        String.format(
            "event=%s sessionId=%s callName=%s",
            event.getEvent(), event.getCall().getSessionId(), event.getCall().getCallName()));

    // let business layer process the request
    VoiceSinchEventResponse response = serverBusinessLogic.handle(event);

    // the Voice Platform expects a SVAML document in response to every event
    return ResponseEntity.ok(sinchEvents.serializeResponse(response));
  }
}
