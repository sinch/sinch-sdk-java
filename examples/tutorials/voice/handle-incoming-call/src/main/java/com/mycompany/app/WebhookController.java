package com.mycompany.app;

import com.sinch.sdk.domains.voice.VoiceService;
import com.sinch.sdk.domains.voice.models.v1.webhooks.IncomingCallEvent;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class WebhookController {

  private final VoiceService voiceService;
  private final WebhookService webhookService;
  private final String controllerPath;

  @Autowired
  public WebhookController(
      VoiceService voiceService, WebhookService webhookService, String controllerPath) {
    this.voiceService = voiceService;
    this.webhookService = webhookService;
    this.controllerPath = controllerPath;
  }

  @PostMapping(
      value = "#{controllerPath}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String voiceEvent(@RequestHeader Map<String, String> headers, @RequestBody String body) {

    // ensure valid authentication before handling request
    var validAuth =
        voiceService
            .v1()
            .webhooks()
            .validateAuthenticationHeader(
                // The HTTP verb this controller is managing
                "POST",
                // The URI this path is managing
                controllerPath,
                // request headers
                headers,
                // request payload body
                body);

    // token validation failed
    if (!validAuth) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }

    // decode the payload request
    var event = voiceService.v1().webhooks().parseEvent(body);

    if (!(event instanceof IncomingCallEvent)) {
      return "";
    }

    // let business layer process the request
    var response = webhookService.answered((IncomingCallEvent) event);

    return voiceService.v1().webhooks().serializeResponse(response);
  }
}
