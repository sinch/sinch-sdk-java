package com.mycompany.app.sms;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.sms.api.v1.WebHooksService;
import com.sinch.sdk.domains.sms.models.v1.inbounds.TextMessage;
import com.sinch.sdk.domains.sms.models.v1.webhooks.SmsEvent;
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
  private final ServerBusinessLogic webhooksBusinessLogic;

  @Value("${sms.webhooks.secret: }")
  private String webhooksSecret;

  @Autowired
  public Controller(SinchClient sinchClient, ServerBusinessLogic webhooksBusinessLogic) {
    this.sinchClient = sinchClient;
    this.webhooksBusinessLogic = webhooksBusinessLogic;
  }

  @PostMapping(
      value = "/SmsEvent",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> smsDeliveryEvent(
      @RequestHeader Map<String, String> headers, @RequestBody String body) {

    WebHooksService webhooks = sinchClient.sms().v1().webhooks();

    // ensure valid authentication to handle request
    // See
    // https://developers.sinch.com/docs/sms/api-reference/sms/tag/Webhooks/#tag/Webhooks/section/Callbacks
    // Contact your account manager to configure your callback sending headers validation
    // set "ensureValidAuthentication" value to true to validate requests from Sinch servers
    boolean ensureValidAuthentication = false;
    if (ensureValidAuthentication) {
      var validAuth =
          webhooks.validateAuthenticationHeader(
              webhooksSecret,
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
    SmsEvent event = webhooks.parseEvent(body);

    // let business layer process the request
    switch (event) {
      case TextMessage e -> webhooksBusinessLogic.processInboundEvent(e);
      default -> throw new IllegalStateException("Unexpected value: " + event);
    }

    return ResponseEntity.ok().build();
  }
}
