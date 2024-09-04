package com.sinch.sample.webhooks.verification;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEventResponseAction;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEvent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEvent.MethodEnum;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponse;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponseSms;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationResultEvent;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component
public class VerificationService {

  private static final Logger LOGGER = Logger.getLogger(VerificationService.class.getName());

  public VerificationService() {}

  public VerificationRequestEventResponse verificationEvent(VerificationRequestEvent event) {

    LOGGER.info("decoded event: " + event);

    VerificationRequestEventResponse.Builder builder;
    var method = event.getMethod();

    if (MethodEnum.SMS.equals(method)) {
      builder = VerificationRequestEventResponseSms.builder();
    } else if (MethodEnum.FLASH_CALL.equals(method)) {
      builder = VerificationRequestEventResponseFlashCall.builder().setDialTimeout(12);
    } else if (MethodEnum.PHONE_CALL.equals(method)) {
      builder = VerificationRequestEventResponsePhoneCall.builder().setCode("4567");
    } else {
      throw new ApiException("Unexpected methode value: '" + method + "'");
    }

    builder.setAction(VerificationEventResponseAction.ALLOW);

    var response = builder.build();
    LOGGER.info("Response: " + response);
    return response;
  }

  public void verificationEvent(VerificationResultEvent event) {

    LOGGER.info("Handle event: " + event);
  }
}
