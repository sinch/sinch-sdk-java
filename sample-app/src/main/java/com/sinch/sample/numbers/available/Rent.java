package com.sinch.sample.numbers.available;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.models.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberRentRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.RentSMSConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.RentVoiceConfigurationRequestParameters;
import java.io.IOException;
import java.util.logging.Logger;

public class Rent extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(Rent.class.getName());

  public Rent() throws IOException {}

  public static void main(String[] args) {
    try {
      new Rent().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Rent for :" + phoneNumber);
    try {

      RentSMSConfigurationRequestParameters rentSms =
          RentSMSConfigurationRequestParameters.builder() // .setCampaignId("campaign id")
              .build();
      RentVoiceConfigurationRequestParameters rentVoice =
          RentVoiceConfigurationRequestParameters.builder() // .setAppId("app id")
              .build();
      AvailableNumberRentRequestParameters parameters =
          new AvailableNumberRentRequestParameters(null, null, "foo callback");
      ActiveNumber value = client.numbers().available().rent(phoneNumber, parameters);

      LOGGER.info("Response :" + value);
    } catch (ApiException e) {
      LOGGER.severe("Error: " + e);
    }
  }
}
