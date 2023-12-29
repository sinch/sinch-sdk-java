package com.sinch.sample.numbers.available;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.models.*;
import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberRentAnyRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.RentVoiceConfigurationRequestParameters;
import java.io.IOException;
import java.util.Collections;
import java.util.logging.Logger;

public class RentAny extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(RentAny.class.getName());

  public RentAny() throws IOException {}

  public static void main(String[] args) {
    try {
      new RentAny().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("RentAny:");

    AvailableNumberRentAnyRequestParameters parameters =
        AvailableNumberRentAnyRequestParameters.builder()
            .setRegionCode("US")
            .setType(NumberType.LOCAL)
            .setNumberPattern(
                NumberPattern.builder()
                    .setPattern("2067387769")
                    .setSearchPattern(SearchPattern.END)
                    .build())
            .setCapabilities(Collections.singletonList(Capability.VOICE))
            /* .setSmsConfiguration(
            RentSMSConfigurationRequestParameters.builder()
                .setServicePlanId("foo service plan")
                .setCampaignId("campaign id")
                .build())*/
            .setVoiceConfiguration(
                RentVoiceConfigurationRequestParameters.builder().setAppId("app id").build())
            .setCallbackUrl("https://callback")
            .build();

    ActiveNumber value = client.numbers().available().rentAny(parameters);

    LOGGER.info("Response: " + value);
  }
}
