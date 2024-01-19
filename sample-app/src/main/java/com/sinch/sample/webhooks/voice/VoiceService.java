package com.sinch.sample.webhooks.voice;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.webhooks.CallEvent;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoiceService {

  private final SinchClient sinchClient;

  private static final Logger LOGGER = Logger.getLogger(VoiceService.class.getName());

  @Autowired
  public VoiceService(SinchClient sinchClient) {
    this.sinchClient = sinchClient;
  }

  public String callEvent(CallEvent event) {

    LOGGER.info("decoded event :" + event);

    /*VerificationResponse.Builder<?> builder;
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

    return response;*/
    return "";
  }
}
