package com.sinch.sample.conversation.contact;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.models.ChannelIdentityRecipient;
import com.sinch.sdk.domains.conversation.models.ChannelType;
import com.sinch.sdk.domains.conversation.models.requests.GetChannelProfileByChannelRequestParameters;
import com.sinch.sdk.domains.conversation.models.requests.GetChannelProfileByContactRequestParameters;
import java.io.IOException;
import java.util.Arrays;
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

    var parametersByContact =
        GetChannelProfileByContactRequestParameters.builder()
            .setAppId(conversationAppId)
            .setChannel(ChannelType.MESSENGER)
            .setContactId("33628254417")
            .build();

    var parametersByChannel =
        GetChannelProfileByChannelRequestParameters.builder()
            .setAppId("an app id")
            .setChannel(ChannelType.MESSENGER)
            .setChannelIdentities(
                Arrays.asList(
                    ChannelIdentityRecipient.builder()
                        .setChannel(ChannelType.MESSENGER)
                        .setIdentity("61555787796813")
                        .build()))
            .build();

    LOGGER.info("Get channel profile: " + conversationContactId);

    var result =
        // client.conversation().contact().getChannelProfileByContact(parametersByContact)
        client.conversation().contact().getChannelProfileByChannel(parametersByChannel);

    LOGGER.info("Response: " + result);
  }
}
