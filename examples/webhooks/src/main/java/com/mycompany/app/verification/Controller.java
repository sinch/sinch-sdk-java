package com.mycompany.app.verification;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.verification.api.v1.WebhooksService;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEvent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationResultEvent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationSmsDeliveredEvent;
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
  private final ServerBusinessLogic webhooksBusinessLogic;

  @Autowired
  public Controller(SinchClient sinchClient, ServerBusinessLogic webhooksBusinessLogic) {
    this.sinchClient = sinchClient;
    this.webhooksBusinessLogic = webhooksBusinessLogic;
  }

  @PostMapping(
      value = "/VerificationEvent",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> VerificationEvent(
      @RequestHeader Map<String, String> headers, @RequestBody String body) {

    WebhooksService webhooks = sinchClient.verification().v1().webhooks();

    // ensure valid authentication to handle request
    // set this value to true to validate request from Sinch servers
    // see
    // https://developers.sinch.com/docs/verification/api-reference/authentication/callback-signed-request
    // for more information
    boolean ensureValidAuthentication = false;
    if (ensureValidAuthentication) {
      var validAuth =
          webhooks.validateAuthenticationHeader(
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
    var event = webhooks.parseEvent(body);

    // let business layer process the request
    var response =
        switch (event) {
          case VerificationRequestEvent requestEvent ->
              webhooksBusinessLogic.verificationEvent(requestEvent);
          case VerificationResultEvent resultEvent -> {
            webhooksBusinessLogic.verificationEvent(resultEvent);
            yield null;
          }
          case VerificationSmsDeliveredEvent smsEvent -> {
            webhooksBusinessLogic.verificationSmsDeliveredEvent(smsEvent);
            yield null;
          }
          default -> throw new IllegalStateException("Unexpected value: " + event);
        };

    ResponseEntity<String> responseEntity = ResponseEntity.ok().body(null);

    if (null != response) {
      var serializedResponse = webhooks.serializeResponse(response);
      LOGGER.finest("JSON response: " + serializedResponse);
      responseEntity = ResponseEntity.ok(serializedResponse);
    }
    return responseEntity;
  }
}
