package com.sinch.sample.conversation.contact;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactCreateRequest;
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
        ContactCreateRequest.builder()
            .setChannelIdentities(
                Arrays.asList(
                    ChannelIdentity.builder()
                        .setChannel(ConversationChannel.MMS)
                        .setIdentity("+33628254417") // phonenumber
                        .build(),
                    ChannelIdentity.builder()
                        .setChannel(ConversationChannel.MESSENGER)
                        .setIdentity("a MESSENGER identity")
                        .setAppId("01HRF157EEQ7F2F3QC2AJGYPK0")
                        .build()))
            .setChannelPriority(
                Arrays.asList(ConversationChannel.MMS, ConversationChannel.MESSENGER))
            .setDisplayName("created from Java SDK")
            .setEmail("foo@foo.com")
            .setExternalId("external id value")
            .setMetadata("metadata value")
            .setLanguage("AR")
            .build();

    var result = client.conversation().contact().create(contact);

    LOGGER.info("Response: " + result);
  }
}
