package com.sinch.sample.webhooks.voice;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.webhooks.AnsweredCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.DisconnectCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.IncomingCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.NotifyEvent;
import com.sinch.sdk.domains.voice.models.webhooks.PromptInputEvent;
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
public class VoiceController {

  private final SinchClient sinchClient;
  private final VoiceService service;
  private static final Logger LOGGER = Logger.getLogger(VoiceController.class.getName());

  @Autowired
  public VoiceController(SinchClient sinchClient, VoiceService service) {
    this.sinchClient = sinchClient;
    this.service = service;
  }

  @PostMapping(
      value = "/VoiceEvent",
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
                "/VoiceEvent",
                // request headers
                headers,
                // request payload body
                body);

    // token validation failed
    if (!validAuth) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }

    // decode the payload request
    var event = sinchClient.voice().webhooks().unserializeWebhooksEvent(body);

    // let business layer process the request
    var response =
        switch (event) {
          case IncomingCallEvent e -> service.incoming(e);
          case AnsweredCallEvent e -> service.answered(e);
          case DisconnectCallEvent e -> {
            service.disconnect(e);
            yield null;
          }
          case PromptInputEvent e -> {
            service.prompt(e);
            yield null;
          }
          case NotifyEvent e -> {
            service.notify(e);
            yield null;
          }
          default -> throw new IllegalStateException("Unexpected value: " + event);
        };

    if (null == response) {
      return "";
    }

    LOGGER.finest("response: " + response);
    String responseBody = sinchClient.voice().webhooks().serializeWebhooksResponse(response);
    LOGGER.finest("payload: " + responseBody);

    return responseBody;
  }
}
