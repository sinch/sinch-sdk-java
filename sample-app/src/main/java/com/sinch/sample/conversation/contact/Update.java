package com.sinch.sample.conversation.contact;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.contact.Contact;
import com.sinch.sdk.domains.conversation.models.v1.contact.ContactLanguage;
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
                        .setChannel(ConversationChannel.MESSENGER)
                        .setIdentity("+33451234567")
                        .setAppId(conversationAppId)
                        .build(),
                    ChannelIdentity.builder()
                        .setChannel(ConversationChannel.MMS)
                        .setIdentity("+33461234567")
                        .build(),
                    ChannelIdentity.builder()
                        .setChannel(ConversationChannel.KAKAOTALK)
                        .setIdentity("+33471234567")
                        .build(),
                    ChannelIdentity.builder()
                        .setChannel(ConversationChannel.INSTAGRAM)
                        .setIdentity("+3348234567")
                        .setAppId(conversationAppId)
                        .build()))
            .setChannelPriority(
                Arrays.asList(ConversationChannel.MMS, ConversationChannel.KAKAOTALK))
            .setDisplayName("updated from Java SDK")
            .setEmail("foo-toto@foo.com")
            .setExternalId("external id value updated")
            .setMetadata("metadata value updated")
            .setLanguage(ContactLanguage.BG)
            .build();

    var result = client.conversation().contact().update(contact);

    LOGGER.info("Response: " + result);
  }
}
