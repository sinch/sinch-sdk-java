package com.sinch.sample.conversation.contact;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.models.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.ChannelType;
import com.sinch.sdk.domains.conversation.models.LanguageType;
import com.sinch.sdk.domains.conversation.models.requests.ContactCreateRequestParameters;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class Create extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Create.class.getName());

  public Create() throws IOException {}

  public static void main(String[] args) {
    try {
      new Create().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Create contact");

    var contact =
        ContactCreateRequestParameters.builder()
            .setChannelIdentities(
                Arrays.asList(
                    ChannelIdentity.builder()
                        .setChannel(ChannelType.MMS)
                        .setIdentity("+33123456789")
                        .build(),
                    ChannelIdentity.builder()
                        .setChannel(ChannelType.MESSENGER)
                        .setIdentity("+33987654321")
                        .setAppId("app id")
                        .build()))
            .setChannelPriority(Arrays.asList(ChannelType.MMS, ChannelType.MESSENGER))
            .setDisplayName("created from Java SDK")
            .setEmail("foo@foo.com")
            .setExternalId("external id value")
            .setMetadata("metadata value")
            .setLanguage(LanguageType.AR)
            .build();

    var result = client.conversation().contact().create(contact);

    LOGGER.info("Response: " + result);
  }
}
