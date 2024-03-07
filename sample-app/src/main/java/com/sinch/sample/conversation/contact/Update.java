package com.sinch.sample.conversation.contact;

import com.sinch.sample.BaseApplication;
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

    LOGGER.info("Update contact '%s'".formatted(conversationContactId));
    throw new RuntimeException("TODO");
    /*
    var contact =
        Contact.builder()
            .setId(conversationContactId)
            .setChannelIdentities(
                Arrays.asList(
                    ChannelIdentity.builder()
                        .setChannel(ChannelType.MESSENGER)
                        .setIdentity("a MESSENGER identity")
                        .setAppId(conversationAppId)
                        .build(),
                    ChannelIdentity.builder()
                        .setChannel(ChannelType.MMS)
                        .setIdentity("a MMS identity")
                        .build(),
                    ChannelIdentity.builder()
                        .setChannel(ChannelType.KAKAO_TALK)
                        .setIdentity("a KAKAO_TALK identity")
                        .build(),
                    ChannelIdentity.builder()
                        .setChannel(ChannelType.INSTAGRAM)
                        .setIdentity("a INSTAGRAM identity")
                        .setAppId(conversationAppId)
                        .build()))
            .setChannelPriority(Arrays.asList(ChannelType.MMS, ChannelType.KAKAO_TALK))
            .setDisplayName("updated from Java SDK")
            .setEmail("foo-toto@foo.com")
            .setExternalId("external id value updated")
            .setMetadata("metadata value updated")
            .setLanguage(LanguageType.BG)
            .build();

    var result = client.conversation().contact().update(contact);

    LOGGER.info("Response: " + result);*/
  }
}
