package com.mycompany.app.voice;

import com.sinch.sdk.domains.voice.VoiceService;
import com.sinch.sdk.domains.voice.api.v1.SinchEventsService;
import com.sinch.sdk.domains.voice.models.v1.sinchevents.AnsweredCallEvent;
import com.sinch.sdk.domains.voice.models.v1.sinchevents.PromptInputEvent;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController("Voice")
public class Controller {

  private final SinchEventsService sinchEvents;
  private final ServerBusinessLogic sinchEventsBusinessLogic;

  @Autowired
  public Controller(VoiceService voiceService, ServerBusinessLogic sinchEventsBusinessLogic) {
    this.sinchEvents = voiceService.v1().sinchEvents();
    this.sinchEventsBusinessLogic = sinchEventsBusinessLogic;
  }

  @PostMapping(
      value = "/VoiceEvent",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> VoiceEvent(
      @RequestHeader Map<String, String> headers, @RequestBody String body) {

    validateRequest(headers, body);

    // decode the request payload
    var event = sinchEvents.parseEvent(body);

    Optional<SvamlControl> response = Optional.empty();

    // let business layer process the request
    if (event instanceof AnsweredCallEvent e) {
      response = Optional.of(sinchEventsBusinessLogic.answeredCallEvent(e));
    }
    if (event instanceof PromptInputEvent e) {
      response = Optional.of(sinchEventsBusinessLogic.promptInputEvent(e));
    }

    if (response.isEmpty()) {
      return ResponseEntity.ok().body(null);
    }

    ResponseEntity<String> responseEntity = ResponseEntity.ok().body(null);

    String serializedResponse = sinchEvents.serializeResponse(response.get());

    return ResponseEntity.ok().body(serializedResponse);
  }

  void validateRequest(Map<String, String> headers, String body) {

    // ensure valid authentication to handle request
    // set this value to true to validate request from Sinch servers
    // see
    // https://developers.sinch.com/docs/voice/api-reference/authentication/callback-signed-request
    // for more information
    boolean ensureValidAuthentication = false;
    if (ensureValidAuthentication) {
      return;
    }

    var validAuth =
        sinchEvents.validateAuthenticationHeader(
            // The HTTP verb this controller is managing
            "POST",
            // The URI this controller is managing
            "/VoiceEvent",
            // request headers
            headers,
            // request payload body
            body);

    // token validation failed
    if (!validAuth) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }
  }
}
