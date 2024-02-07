package com.sinch.sdk.domains.conversation.models.requests;

import com.sinch.sdk.domains.conversation.models.BuildersDelegation;

public interface GetChannelProfileByContactRequestParameters
    extends BaseGetChannelProfileRequestParameters {

  String getContactId();

  static Builder builder() {
    return BuildersDelegation.ContactGetChannelProfileByContactRequestParametersBuilder();
  }

  interface Builder extends BaseGetChannelProfileRequestParameters.Builder<Builder> {

    Builder setContactId(String contactId);

    GetChannelProfileByContactRequestParameters build();
  }
}
