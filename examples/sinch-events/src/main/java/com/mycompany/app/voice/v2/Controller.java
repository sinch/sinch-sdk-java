package com.mycompany.app.voice.v2;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.api.v2.SinchEventsService;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.SinchEventType;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEvent;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventResponse;
import java.util.Map;
import java.util.logging.Logger;
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

@RestController("VoiceV2")
public class Controller {

  private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());

  private final SinchClient sinchClient;
  private final ServerBusinessLogic serverBusinessLogic;

  @Value("${voice.v2.sinchevents.service-id: }")
  private String serviceId;

  @Value("${voice.v2.sinchevents.service-secret: }")
  private String serviceSecret;

  @Autowired
  public Controller(SinchClient sinchClient, ServerBusinessLogic serverBusinessLogic) {
    this.sinchClient = sinchClient;
    this.serverBusinessLogic = serverBusinessLogic;
  }

  @PostMapping(
      value = "/VoiceV2Event",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> voiceV2Event(
      @RequestHeader Map<String, String> headers, @RequestBody String body) {

    // Sinch Events do not need any credentials from the client configuration
    SinchEventsService sinchEvents = sinchClient.voice().v2().sinchEvents();

    // ensure valid authentication to handle request
    // set this value to true to validate request from Sinch servers: requests are signed with the
    // secret of the service the event belongs to ("Authorization: service <serviceId>:<signature>")
    boolean ensureValidAuthentication = false;
    if (ensureValidAuthentication) {
      var validAuth =
          sinchEvents.validateAuthenticationHeader(
              // The service the events are sent for
              serviceId,
              // The secret of this service
              serviceSecret,
              // The HTTP verb this controller is managing
              "POST",
              // The URI this controller is managing
              "/VoiceV2Event",
              // request headers
              headers,
              // request payload body
              body);

      // signature validation failed
      if (!validAuth) {
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
      }

      // The SDK does not protect against replayed requests: reject here any request whose
      // "x-timestamp" header is outside the clock-skew window your application accepts
    }

    // decode the payload request
    VoiceSinchEvent event = sinchEvents.parseEvent(body);

    // let business layer process the request
    SinchEventType type = event.getEvent();
    VoiceSinchEventResponse response;
    if (SinchEventType.CALL_INCOMING.equals(type)) {
      response = serverBusinessLogic.incoming(event);
    } else if (SinchEventType.CALL_ANSWERED.equals(type)) {
      response = serverBusinessLogic.answered(event);
    } else if (SinchEventType.CALL_MENU.equals(type)) {
      response = serverBusinessLogic.menu(event);
    } else if (SinchEventType.valueOf(type).startsWith("call.customEvent.")) {
      // dynamic events, triggered by the "customEvent" SVAML command
      response = serverBusinessLogic.customEvent(event);
    } else {
      response = serverBusinessLogic.other(event);
    }

    // the Voice Platform expects a SVAML document in response to every event
    var serializedResponse = sinchEvents.serializeResponse(response);
    LOGGER.finest("JSON response: " + serializedResponse);
    return ResponseEntity.ok(serializedResponse);
  }
}
