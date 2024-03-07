package com.sinch.sample.conversation.contact;

import com.sinch.sample.BaseApplication;
import java.io.IOException;
import java.util.logging.Logger;

public class GetChannelProfile extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(GetChannelProfile.class.getName());

  public GetChannelProfile() throws IOException {}

  public static void main(String[] args) {
    try {
      new GetChannelProfile().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {
    throw new RuntimeException("TODO");
    /*
    var parametersByContactId =
        GetChannelProfileByContactRequestParameters.builder()
            .setAppId(conversationAppId)
            .setChannel(ChannelType.MESSENGER)
            .setContactId("a messenger contact identity")
            .build();

    var parametersByChannelIdentity =
        GetChannelProfileByChannelRequestParameters.builder()
            .setAppId("an app id")
            .setChannel(ChannelType.MESSENGER)
            .setChannelIdentities(
                Collections.singletonList(
                    ChannelIdentityRecipient.builder()
                        .setChannel(ChannelType.MESSENGER)
                        .setIdentity("a messenger channel identity")
                        .build()))
            .build();

    LOGGER.info("Get channel profile: " + conversationContactId);

    var result =
        // client.conversation().contact().getChannelProfileByContactId(parametersByContactId)
        client
            .conversation()
            .contact()
            .getChannelProfileByChannelIdentity(parametersByChannelIdentity);

    LOGGER.info("Response: " + result);*/
  }
}
