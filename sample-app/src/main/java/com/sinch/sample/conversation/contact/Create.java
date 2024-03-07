package com.sinch.sample.conversation.contact;

import com.sinch.sample.BaseApplication;
import java.io.IOException;
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
    throw new RuntimeException("TODO");
    /*
    var contact =
        ContactCreateRequestParameters.builder()
            .setChannelIdentities(
                Arrays.asList(
                    ChannelIdentity.builder()
                        .setChannel(ChannelType.MMS)
                        .setIdentity("a MMS identity")
                        .build(),
                    ChannelIdentity.builder()
                        .setChannel(ChannelType.MESSENGER)
                        .setIdentity("a MESSENGER identity")
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

    LOGGER.info("Response: " + result);*/
  }
}
