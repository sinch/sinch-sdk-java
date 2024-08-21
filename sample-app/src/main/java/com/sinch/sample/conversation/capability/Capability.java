package com.sinch.sample.conversation.capability;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.CapabilityService;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentities;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ContactId;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.Recipient;
import com.sinch.sdk.domains.conversation.models.v1.capability.request.QueryCapabilityRequest;
import com.sinch.sdk.domains.conversation.models.v1.capability.response.QueryCapabilityResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class Capability extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Capability.class.getName());

  public Capability() throws IOException {}

  public static void main(String[] args) {
    try {
      new Capability().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    CapabilityService service = client.conversation().v1().capability();

    ContactId contactIdRecipient = ContactId.builder().setContactId(conversationContactId).build();
    ChannelRecipientIdentities channelRecipients =
        ChannelRecipientIdentities.of(
            ChannelRecipientIdentity.builder()
                .setChannel(ConversationChannel.MMS)
                .setIdentity(phoneNumber)
                .build());

    Recipient recipient = channelRecipients;

    QueryCapabilityRequest request =
        QueryCapabilityRequest.builder()
            .setAppId(conversationAppId)
            .setRecipient(recipient)
            .build();

    LOGGER.info("Capability request: " + request);

    QueryCapabilityResponse response = service.lookup(request);

    LOGGER.info("Capability response: " + response);
  }
}
