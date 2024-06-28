package com.sinch.sample.numbers.active;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.models.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateSMSConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateVoiceConfigurationRequestParameters;
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

    LOGGER.info("Update for :" + virtualPhoneNumber);

    String displayName = "my display from app sample";
    ActiveNumberUpdateSMSConfigurationRequestParameters smsConfiguration =
        ActiveNumberUpdateSMSConfigurationRequestParameters.builder()
            // .setServicePlanId()
            // .setCampaignId("foo")
            .build();
    ActiveNumberUpdateVoiceConfigurationRequestParameters voiceConfiguration =
        ActiveNumberUpdateVoiceConfigurationRequestParameters.builder()
            //.setAppId("foo")
            .build();

    ActiveNumberUpdateRequestParameters parameters =
        ActiveNumberUpdateRequestParameters.builder()
            .setDisplayName(displayName)
            // .setSmsConfiguration(smsConfiguration)
            //.setVoiceConfiguration(voiceConfiguration)
            .build();

    ActiveNumber value = client.numbers().active().update(virtualPhoneNumber, parameters);

    LOGGER.info("Response :" + value);
  }
}
