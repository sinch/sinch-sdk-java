package com.mycompany.app.verification;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.verification.api.v1.SinchEventsService;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationResultEvent;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationSmsDeliveredEvent;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationStartEvent;
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

@RestController("Verification")
public class Controller {

  private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());
  private final SinchClient sinchClient;
  private final ServerBusinessLogic serverBusinessLogic;

  @Autowired
  public Controller(SinchClient sinchClient, ServerBusinessLogic serverBusinessLogic) {
    this.sinchClient = sinchClient;
    this.serverBusinessLogic = serverBusinessLogic;
  }

  @PostMapping(
      value = "/VerificationEvent",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> VerificationEvent(
      @RequestHeader Map<String, String> headers, @RequestBody String body) {

    SinchEventsService sinchEvents = sinchClient.verification().v1().sinchEvents();

    // ensure valid authentication to handle request
    // set this value to true to validate request from Sinch servers
    // see
    // https://developers.sinch.com/docs/verification/api-reference/authentication/callback-signed-request
    // for more information
    boolean ensureValidAuthentication = false;
    if (ensureValidAuthentication) {
      var validAuth =
          sinchEvents.validateAuthenticationHeader(
              // The HTTP verb this controller is managing
              "POST",
              // The URI this controller is managing
              "/VerificationEvent",
              // request headers
              headers,
              // request payload body
              body);

      // token validation failed
      if (!validAuth) {
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
      }
    }

    // decode the request payload
    var event = sinchEvents.parseEvent(body);

    // let business layer process the request
    var response =
        switch (event) {
          case VerificationStartEvent requestEvent ->
              serverBusinessLogic.verificationEvent(requestEvent);
          case VerificationResultEvent resultEvent -> {
            serverBusinessLogic.verificationEvent(resultEvent);
            yield null;
          }
          case VerificationSmsDeliveredEvent smsEvent -> {
            serverBusinessLogic.verificationSmsDeliveredEvent(smsEvent);
            yield null;
          }
          default -> throw new IllegalStateException("Unexpected value: " + event);
        };

    ResponseEntity<String> responseEntity = ResponseEntity.ok().body(null);

    if (null != response) {
      var serializedResponse = sinchEvents.serializeResponse(response);
      LOGGER.finest("JSON response: " + serializedResponse);
      responseEntity = ResponseEntity.ok(serializedResponse);
    }
    return responseEntity;
  }
}
