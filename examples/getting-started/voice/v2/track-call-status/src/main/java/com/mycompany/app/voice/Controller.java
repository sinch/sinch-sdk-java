package com.mycompany.app.voice;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.voice.api.v2.SinchEventsService;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.SinchEventType;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEvent;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventResponse;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
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

  private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());

  private static final String PATH = "/voice/events";

  private final SinchClient sinchClient;
  private final ServerBusinessLogic serverBusinessLogic;

  @Value("${SINCH_SERVICE_ID:}")
  private String serviceId;

  @Value("${SINCH_SERVICE_SECRET:}")
  private String serviceSecret;

  @Autowired
  public Controller(SinchClient sinchClient, ServerBusinessLogic serverBusinessLogic) {
    this.sinchClient = sinchClient;
    this.serverBusinessLogic = serverBusinessLogic;
  }

  @PostMapping(
      value = PATH,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> voiceEvent(
      @RequestHeader HttpHeaders headers, @RequestBody String body) {

    SinchEventsService sinchEvents = sinchClient.voice().v2().sinchEvents();

    // Requests from Sinch are signed with the secret of the service the event belongs to.
    // Set SINCH_SERVICE_ID and SINCH_SERVICE_SECRET to reject any request that is not
    if (StringUtil.isEmpty(serviceSecret)) {
      LOGGER.warning("SINCH_SERVICE_SECRET is not set: the request signature is not validated");
    } else if (!sinchEvents.validateAuthenticationHeader(
        serviceId, serviceSecret, "POST", PATH, headers.toSingleValueMap(), body)) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }

    // decode the payload request
    VoiceSinchEvent event = sinchEvents.parseEvent(body);

    // Every event also carries CloudEvents metadata as "ce-*" headers
    LOGGER.info(
        String.format(
            "ce={type=%s, source=%s, id=%s, time=%s, specversion=%s}",
            headers.getFirst("ce-type"),
            headers.getFirst("ce-source"),
            headers.getFirst("ce-id"),
            headers.getFirst("ce-time"),
            headers.getFirst("ce-specversion")));
    LOGGER.info("event=" + event.getEvent());
    LOGGER.info("call=" + event.getCall());

    // let business layer process the request
    VoiceSinchEventResponse response =
        SinchEventType.CALL_INCOMING.equals(event.getEvent())
            ? serverBusinessLogic.incoming(event)
            : serverBusinessLogic.other(event);

    // the Voice Platform expects a SVAML document in response to every event
    return ResponseEntity.ok(sinchEvents.serializeResponse(response));
  }
}
