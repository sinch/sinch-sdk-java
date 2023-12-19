package com.sinch.sample.webhooks.verification;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationRequestEvent;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResultEvent;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class VerificationController {

  private final SinchClient sinchClient;
  private final VerificationService service;
  private static final Logger LOGGER = Logger.getLogger(VerificationController.class.getName());

  @Autowired
  public VerificationController(SinchClient sinchClient, VerificationService service) {
    this.sinchClient = sinchClient;
    this.service = service;
  }

  @PostMapping(
      value = "/VerificationEvent",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String VerificationEvent(
      @RequestHeader Map<String, String> headers, @RequestBody String body) {

    LOGGER.finest("Received body:" + body);
    LOGGER.finest("Received headers: " + headers);

    // ensure valid authentication to handle request
    var validAuth =
        sinchClient
            .verification()
            .webhooks()
            .validateAuthenticatedRequest(
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

    // decode the request payload
    var event = sinchClient.verification().webhooks().unserializeVerificationEvent(body);

    // let business layer process the request
    var response = switch (event) {
      case VerificationRequestEvent e -> service.verificationEvent(e);
      case VerificationResultEvent e -> {
        service.verificationEvent(e);
        yield null;
      }
      default -> throw new IllegalStateException("Unexpected value: " + event);
    };

    LOGGER.finest("response: " + response);

    return response;
  }
}
