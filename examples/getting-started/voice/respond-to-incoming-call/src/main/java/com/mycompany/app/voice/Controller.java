package com.mycompany.app.voice;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.api.v1.WebHooksService;
import com.sinch.sdk.domains.voice.models.v1.webhooks.DisconnectedCallEvent;
import com.sinch.sdk.domains.voice.models.v1.webhooks.IncomingCallEvent;
import java.util.Map;
import java.util.logging.Logger;
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

  private final SinchClient sinchClient;
  private final ServerBusinessLogic webhooksBusinessLogic;
  private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());

  @Autowired
  public Controller(SinchClient sinchClient, ServerBusinessLogic webhooksBusinessLogic) {
    this.sinchClient = sinchClient;
    this.webhooksBusinessLogic = webhooksBusinessLogic;
  }

  @PostMapping(
      value = "/VoiceEvent",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> VoiceEvent(
      @RequestHeader Map<String, String> headers, @RequestBody String body) {

    WebHooksService webhooks = sinchClient.voice().v1().webhooks();

    // ensure valid authentication to handle request
    // see
    // https://developers.sinch.com/docs/voice/api-reference/authentication/callback-signed-request
    // for more information
    // Contact your account manager to configure your callback sending headers validation
    // set "ensureValidAuthentication" value to true to validate requests from Sinch servers
    boolean ensureValidAuthentication = false;
    if (ensureValidAuthentication) {
      // ensure valid authentication to handle request
      var validAuth =
          webhooks.validateAuthenticationHeader(
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

    // decode the payload request
    var event = webhooks.parseEvent(body);

    // let business layer process the request
    var response =
        switch (event) {
          case IncomingCallEvent e -> webhooksBusinessLogic.incoming(e);
          case DisconnectedCallEvent e -> {
            webhooksBusinessLogic.disconnect(e);
            yield null;
          }
          default -> throw new IllegalStateException("Unexpected value: " + event);
        };

    String serializedResponse = "";
    if (null != response) {
      serializedResponse = webhooks.serializeResponse(response);
    }

    LOGGER.finest("JSON response: " + serializedResponse);

    return ResponseEntity.ok().body(serializedResponse);
  }
}
