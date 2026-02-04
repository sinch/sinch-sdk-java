package com.mycompany.app.numbers;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.numbers.api.v1.WebHooksService;
import com.sinch.sdk.domains.numbers.models.v1.webhooks.NumberEvent;
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

@RestController("Numbers")
public class Controller {

  private final SinchClient sinchClient;
  private final ServerBusinessLogic webhooksBusinessLogic;

  /**
   * The secret value used for webhook calls validation have to equals to the one configured at
   * number property (HmacSecret).
   *
   * @see <a
   *     href="https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/latest/com/sinch/sdk/domains/numbers/api/v1/CallbackConfigurationService.html#update(com.sinch.sdk.domains.numbers.models.v1.callbacks.request.CallbackConfigurationUpdateRequest)">update
   *     function Javadoc</a>
   */
  @Value("${numbers.webhooks.secret: }")
  private String webhooksSecret;

  @Autowired
  public Controller(SinchClient sinchClient, ServerBusinessLogic webhooksBusinessLogic) {
    this.sinchClient = sinchClient;
    this.webhooksBusinessLogic = webhooksBusinessLogic;
  }

  @PostMapping(
      value = "/NumbersEvent",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> NumbersEvent(
      @RequestHeader Map<String, String> headers, @RequestBody String body) {

    WebHooksService webhooks = sinchClient.numbers().v1().webhooks();

    // set this value to true to validate request from Sinch servers
    // see https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Numbers-Callbacks for
    // more information
    boolean ensureValidAuthentication = false;
    if (ensureValidAuthentication) {
      // ensure valid authentication to handle request
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
    NumberEvent event = webhooks.parseEvent(body);

    // let business layer process the request
    webhooksBusinessLogic.numbersEvent(event);

    return ResponseEntity.ok().build();
  }
}
