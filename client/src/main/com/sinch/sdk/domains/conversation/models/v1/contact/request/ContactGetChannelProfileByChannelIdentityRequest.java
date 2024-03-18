package com.sinch.sdk.domains.conversation.models.v1.contact.request;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentity;
import com.sinch.sdk.domains.conversation.models.v1.GetChannelProfileConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.IdentifiedBy;
import java.util.List;

public class ContactGetChannelProfileByChannelIdentityRequest extends GetChannelProfileRequestImpl {

  ContactGetChannelProfileByChannelIdentityRequest(
      String appId,
      GetChannelProfileConversationChannel channel,
      List<ChannelRecipientIdentity> identities) {
    super(
        OptionalValue.of(appId),
        OptionalValue.of(
            GetChannelProfileRequestRecipient.builder()
                .setIdentifiedBy(IdentifiedBy.builder().setChannelIdentities(identities).build())
                .build()),
        OptionalValue.of(channel));
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "ContactGetChannelProfileByChannelIdentityRequest{" + "} " + super.toString();
  }

  public static class Builder {

    String appId;
    GetChannelProfileConversationChannel channel;
    List<ChannelRecipientIdentity> identities;

    public Builder setAppId(String appId) {
      this.appId = appId;
      return this;
    }

    public Builder setChannel(GetChannelProfileConversationChannel channel) {
      this.channel = channel;
      return this;
    }

    public Builder setChannelIdentities(List<ChannelRecipientIdentity> identities) {
      this.identities = identities;
      return this;
    }

    public ContactGetChannelProfileByChannelIdentityRequest build() {
      return new ContactGetChannelProfileByChannelIdentityRequest(appId, channel, identities);
    }
  }
}
