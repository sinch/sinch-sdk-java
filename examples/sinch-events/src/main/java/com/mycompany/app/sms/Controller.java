package com.mycompany.app.sms;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.sms.api.v1.SinchEventsService;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryReport;
import com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessage;
import com.sinch.sdk.domains.sms.models.v1.sinchevents.SmsSinchEvent;
import java.util.Map;
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

@RestController("SMS")
public class Controller {

  private final SinchClient sinchClient;
  private final ServerBusinessLogic serverBusinessLogic;

  @Value("${sms.sinchevents.secret: }")
  private String sinchEventsSecret;

  @Autowired
  public Controller(SinchClient sinchClient, ServerBusinessLogic serverBusinessLogic) {
    this.sinchClient = sinchClient;
    this.serverBusinessLogic = serverBusinessLogic;
  }

  @PostMapping(
      value = "/SmsEvent",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> smsEvent(
      @RequestHeader Map<String, String> headers, @RequestBody String body) {

    SinchEventsService sinchEvents = sinchClient.sms().v1().sinchEvents();

    // ensure valid authentication to handle request
    // See
    // https://developers.sinch.com/docs/sms/api-reference/sms/tag/Webhooks/#tag/Webhooks/section/Callbacks
    // Contact your account manager to configure your callback sending headers validation or comment
    // following line
    // set this value to true to validate request from Sinch servers
    // see https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Numbers-Callbacks for
    // more information
    boolean ensureValidAuthentication = false;
    if (ensureValidAuthentication) {
      var validAuth =
          sinchEvents.validateAuthenticationHeader(
              sinchEventsSecret,
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
    SmsSinchEvent event = sinchEvents.parseEvent(body);

    // let business layer process the request
    switch (event) {
      case InboundMessage e -> serverBusinessLogic.processInboundEvent(e);
      case DeliveryReport e -> serverBusinessLogic.processDeliveryReportEvent(e);
      default -> throw new IllegalStateException("Unexpected value: " + event);
    }

    return ResponseEntity.ok().build();
  }
}
