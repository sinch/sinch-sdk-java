package com.sinch.sample.numbers.active;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationRTC;
import com.sinch.sdk.domains.numbers.models.v1.active.request.ActiveNumberUpdateRequest;
import java.io.IOException;
import java.util.logging.Logger;

public class Update extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public Update() throws IOException {}

  public static void main(String[] args) {
    try {
      new Update().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    NumbersService service = client.numbers().v1();

    LOGGER.info("Update for :" + virtualPhoneNumber);

    String displayName = "my display from app sample";
    SmsConfiguration smsConfiguration =
        SmsConfiguration.builder()
            // .setServicePlanId()
            // .setCampaignId()
            .build();
    VoiceConfiguration voiceConfiguration =
        VoiceConfigurationRTC.builder().setAppId(applicationKey).build();

    ActiveNumberUpdateRequest parameters =
        ActiveNumberUpdateRequest.builder()
            .setDisplayName(displayName)
            // .setSmsConfiguration(smsConfiguration)
            .setVoiceConfiguration(voiceConfiguration)
            .build();

    ActiveNumber value = service.update(virtualPhoneNumber, parameters);

    LOGGER.info("Response :" + value);
  }
}
