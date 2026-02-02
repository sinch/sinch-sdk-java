package com.mycompany.app.mailgun;

import com.sinch.sdk.SinchClient;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("MailGun")
public class Controller {

  private static final Logger LOGGER =
      Logger.getLogger(com.mycompany.app.verification.Controller.class.getName());

  private final SinchClient sinchClient;
  private final ServerBusinessLogic webhooksBusinessLogic;

  /**
   * The secret value used for webhook calls validation have to equals to the one configured at
   * number property (HmacSecret).
   *
   * @see <a
   *     href="https://developers.sinch.com/java-sdk/apidocs/com/sinch/sdk/domains/numbers/api/v1/CallbackConfigurationService.html#update(com.sinch.sdk.domains.numbers.models.v1.callbacks.request.CallbackConfigurationUpdateRequest)">update
   *     function Javadoc</a>
   */
  @Autowired
  public Controller(SinchClient sinchClient, ServerBusinessLogic webhooksBusinessLogic) {
    this.sinchClient = sinchClient;
    this.webhooksBusinessLogic = webhooksBusinessLogic;
  }

  @PostMapping(
      value = "/MailGunEvent",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> MailGunEvent(
      @RequestHeader Map<String, String> headers, @RequestBody String body) {

    LOGGER.info("Headers: " + headers);
    LOGGER.info("Body: " + body);
    return ResponseEntity.ok().build();
  }
}
