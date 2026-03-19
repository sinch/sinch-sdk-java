package com.mycompany.app.verification;

import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationResultEvent;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationSmsDeliveredEvent;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationStartEvent;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationStartEventAction;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationStartEventResponse;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationStartEventResponseSms;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component("VerificationServerBusinessLogic")
public class ServerBusinessLogic {

  private static final Logger LOGGER = Logger.getLogger(ServerBusinessLogic.class.getName());

  public VerificationStartEventResponse verificationEvent(VerificationStartEvent event) {

    LOGGER.info("Handle event :" + event);

    // add your logic here according to SMS, FlashCall, PhoneCall, ... verification
    return VerificationStartEventResponseSms.builder()
        .setAction(VerificationStartEventAction.ALLOW)
        .build();
  }

  public void verificationEvent(VerificationResultEvent event) {

    LOGGER.info("Handle event: " + event);
  }

  public void verificationSmsDeliveredEvent(VerificationSmsDeliveredEvent event) {

    LOGGER.info("Handle event: " + event);
  }
}
