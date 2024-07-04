package com.sinch.sample.numbers.available;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.api.v1.AvailableNumberService;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.SearchPattern;
import com.sinch.sdk.domains.numbers.models.v1.SearchPosition;
import com.sinch.sdk.domains.numbers.models.v1.available.request.AvailableNumberRentAnyRequest;
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

    AvailableNumberService service = client.numbers().v1().available();

    LOGGER.info("RentAny:");

    AvailableNumberRentAnyRequest parameters =
        AvailableNumberRentAnyRequest.builder()
            .setRegionCode("US")
            .setType(NumberType.LOCAL)
            .setNumberPattern(
                SearchPattern.builder().setPattern("7769").setPosition(SearchPosition.END).build())
            .setCapabilities(Collections.singletonList(Capability.VOICE))
            // .setVoiceConfiguration(VoiceConfigurationRTC.builder().setAppId(applicationKey).build())
            .build();

    ActiveNumber value = service.rentAny(parameters);

    LOGGER.info("Response: " + value);
  }
}
