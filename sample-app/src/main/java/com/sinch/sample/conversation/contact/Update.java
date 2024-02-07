package com.sinch.sample.conversation.contact;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.models.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.ChannelType;
import com.sinch.sdk.domains.conversation.models.Contact;
import com.sinch.sdk.domains.conversation.models.LanguageType;
import java.io.IOException;
import java.util.Arrays;
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

    var contact =
        Contact.builder()
            .setId(conversationContactId)
            .setChannelIdentities(
                Arrays.asList(
                    ChannelIdentity.builder()
                        .setChannel(ChannelType.MESSENGER)
                        .setIdentity("+33123456789")
                        .setAppId(conversationAppId)
                        .build(),
                    ChannelIdentity.builder()
                        .setChannel(ChannelType.MMS)
                        .setIdentity("+33123456789")
                        .build(),
                    ChannelIdentity.builder()
                        .setChannel(ChannelType.KAKAO_TALK)
                        .setIdentity("+33234567890")
                        .build(),
                    ChannelIdentity.builder()
                        .setChannel(ChannelType.INSTAGRAM)
                        .setIdentity("+33234567890")
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

    LOGGER.info("Response: " + result);
  }
}
