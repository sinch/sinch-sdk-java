package com.sinch.sdk.domains.conversation.models.v1.contact.request;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentities;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentity;
import java.util.Collection;

public class ContactGetChannelProfileByChannelIdentityRequest extends GetChannelProfileRequestImpl {

  ContactGetChannelProfileByChannelIdentityRequest(
      String appId,
      GetChannelProfileConversationChannel channel,
      ChannelRecipientIdentities identities) {
    super(OptionalValue.of(appId), OptionalValue.of(identities), OptionalValue.of(channel));
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
    ChannelRecipientIdentities identities;

    public Builder setAppId(String appId) {
      this.appId = appId;
      return this;
    }

    public Builder setChannel(GetChannelProfileConversationChannel channel) {
      this.channel = channel;
      return this;
    }

    public Builder setChannelIdentities(ChannelRecipientIdentities identities) {
      this.identities = identities;
      return this;
    }

    public Builder setChannelIdentities(Collection<ChannelRecipientIdentity> identities) {
      this.identities = new ChannelRecipientIdentities(identities);
      return this;
    }

    public ContactGetChannelProfileByChannelIdentityRequest build() {
      return new ContactGetChannelProfileByChannelIdentityRequest(appId, channel, identities);
    }
  }
}
