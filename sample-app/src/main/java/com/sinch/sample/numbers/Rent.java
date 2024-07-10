package com.sinch.sample.numbers;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationRTC;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentRequest;
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

    NumbersService service = client.numbers().v1();

    LOGGER.info("Rent for: " + virtualPhoneNumber);
    try {

      SmsConfiguration rentSms =
          SmsConfiguration.builder()
              // .setCampaignId("campaign id")
              .build();

      VoiceConfiguration rentVoice =
          VoiceConfigurationRTC.builder().setAppId(applicationKey).build();

      AvailableNumberRentRequest parameters =
          AvailableNumberRentRequest.builder()
              // .setSmsConfiguration(rentSms)
              .setVoiceConfiguration(rentVoice)
              // .setCallbackUrl("foo callback")
              .build();
      ActiveNumber value = service.rent(virtualPhoneNumber, parameters);

      LOGGER.info("Response: " + value);
    } catch (ApiException e) {
      LOGGER.severe("Error: " + e);
    }
  }
}
