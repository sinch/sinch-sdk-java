package com.sinch.sample.conversation.contact;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.ContactService;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactGetChannelProfileByChannelIdentityRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactGetChannelProfileByContactIdRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.GetChannelProfileConversationChannel;
import java.io.IOException;
import java.util.Collections;
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

    ContactService service = client.conversation().v1().contact();

    var parametersByContactId =
        ContactGetChannelProfileByContactIdRequest.builder()
            .setAppId(conversationAppId)
            .setChannel(GetChannelProfileConversationChannel.MESSENGER)
            .setContactId("+33123456789")
            .build();

    var parametersByChannelIdentity =
        ContactGetChannelProfileByChannelIdentityRequest.builder()
            .setAppId(conversationAppId)
            .setChannel(GetChannelProfileConversationChannel.MESSENGER)
            .setChannelIdentities(
                Collections.singletonList(
                    ChannelRecipientIdentity.builder()
                        .setChannel(ConversationChannel.MESSENGER)
                        .setIdentity("+33123456789")
                        .build()))
            .build();

    LOGGER.info("Get channel profile: " + conversationContactId);

    var result =
        service
            // .getChannelProfileByContactId(parametersByContactId)
            .getChannelProfileByChannelIdentity(parametersByChannelIdentity);

    LOGGER.info("Response: " + result);
  }
}
