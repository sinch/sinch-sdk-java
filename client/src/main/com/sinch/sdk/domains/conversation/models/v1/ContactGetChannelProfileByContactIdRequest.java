package com.sinch.sdk.domains.conversation.models.v1;

import com.sinch.sdk.core.models.OptionalValue;

public class ContactGetChannelProfileByContactIdRequest extends GetChannelProfileRequestImpl {

  ContactGetChannelProfileByContactIdRequest(
      String appId, GetChannelProfileConversationChannel channel, String contactId) {
    super(
        OptionalValue.of(appId),
        OptionalValue.of(
            GetChannelProfileRequestRecipient.builder().setContactId(contactId).build()),
        OptionalValue.of(channel));
  }

  @Override
  public String toString() {
    return "ContactGetChannelProfileByContactIdRequest{" + "} " + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    String appId;
    GetChannelProfileConversationChannel channel;
    String contactId;

    public Builder setAppId(String appId) {
      this.appId = appId;
      return this;
    }

    public Builder setChannel(GetChannelProfileConversationChannel channel) {
      this.channel = channel;
      return this;
    }

    public Builder setContactId(String contactId) {
      this.contactId = contactId;
      return this;
    }

    public ContactGetChannelProfileByContactIdRequest build() {
      return new ContactGetChannelProfileByContactIdRequest(appId, channel, contactId);
    }
  }
}
