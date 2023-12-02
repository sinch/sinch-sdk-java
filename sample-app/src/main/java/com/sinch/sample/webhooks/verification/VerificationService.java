package com.sinch.sample.webhooks.verification;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationRequestEvent;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponse;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponseActionType;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResultEvent;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerificationService {

  private final SinchClient sinchClient;

  private static final Logger LOGGER = Logger.getLogger(VerificationService.class.getName());

  @Autowired
  public VerificationService(SinchClient sinchClient) {
    this.sinchClient = sinchClient;
  }

  public String verificationEvent(VerificationRequestEvent event) {

    LOGGER.info("decoded event :" + event);

    VerificationResponse.Builder<?> builder;
    var method = event.getMethod();

    if (method == VerificationMethodType.SMS) {
      builder = VerificationResponseSMS.builder().setCode(1234);
    } else if (method == VerificationMethodType.FLASH_CALL) {
      builder = VerificationResponseFlashCall.builder().setDialTimeout(12);
    } else if (method == VerificationMethodType.CALLOUT) {
      builder = VerificationResponseCallout.builder().setCode(4567)
      // only "en-US" is supported, not mandatory to set it
      // .setLocale("en-US")
      ;
    } else {
      throw new ApiException("Unexpected methode value: '" + method + "'");
    }

    builder.setAction(VerificationResponseActionType.ALLOW);

    var response =
        sinchClient.verification().webhooks().serializeVerificationResponse(builder.build());
    LOGGER.info("Response :" + response);

    return response;
  }

  public void verificationEvent(VerificationResultEvent event) {

    LOGGER.info("Handle event :" + event);
  }
}
