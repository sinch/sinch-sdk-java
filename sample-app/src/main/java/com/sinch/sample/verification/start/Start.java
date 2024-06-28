package com.sinch.sample.verification.start;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.verification.api.v1.VerificationStartService;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.start.request.PhoneCallSpeech;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestData;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestPhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSms;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSms.CodeTypeEnum;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class Start extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Start.class.getName());

  public Start() throws IOException {}

  public static void main(String[] args) {
    try {
      new Start().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Start verification for : " + phoneNumber);

    NumberIdentity identity = NumberIdentity.valueOf(phoneNumber);
    VerificationMethod method = VerificationMethod.FLASH_CALL;

    VerificationStartService service = client.verification().v1().verificationStart();

    VerificationStartResponse response;
    if (method == VerificationMethod.PHONE_CALL) {
      response =
          service.startPhoneCall(
              VerificationStartRequestPhoneCall.builder()
                  .setIdentity(identity)
                  .setSpeech(PhoneCallSpeech.builder().setLocale("es-ES").build())
                  .build());
    } else if (method == VerificationMethod.SMS) {
      response =
          service.startSms(
              VerificationStartRequestSms.builder()
                  .setIdentity(identity)
                  .setCodeType(CodeTypeEnum.ALPHANUMERIC)
                  .setAcceptLanguage("fr-FR")
                  .build());
    } else if (method == VerificationMethod.DATA) {
      response =
          service.startData(VerificationStartRequestData.builder().setIdentity(identity).build());
    } else if (method == VerificationMethod.FLASH_CALL) {
      response =
          service.startFlashCall(
              VerificationStartRequestFlashCall.builder().setIdentity(identity).build());
    } else {
      throw new IllegalArgumentException("Unexpected method type '%s'".formatted(method));
    }

    LOGGER.info("Response: " + response);
  }
}
