package com.sinch.sdk.domains.conversation.adapters.models.requests;

import com.sinch.sdk.domains.conversation.models.ChannelType;
import com.sinch.sdk.domains.conversation.models.requests.GetChannelProfileByContactRequestParameters;

public class GetChannelProfileByContactRequestParametersImpl
    extends BaseGetChannelProfileRequestParametersImpl
    implements GetChannelProfileByContactRequestParameters {

  private final String contactId;

  public GetChannelProfileByContactRequestParametersImpl(
      String appId, ChannelType channel, String contactId) {
    super(appId, channel);
    this.contactId = contactId;
  }

  @Override
  public String getContactId() {
    return contactId;
  }

  @Override
  public String toString() {
    return "GetChannelProfileByContactRequestParametersImpl{"
        + "contactId='"
        + contactId
        + '\''
        + "} "
        + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends BaseGetChannelProfileRequestParametersImpl.Builder<Builder>
      implements GetChannelProfileByContactRequestParameters.Builder {
    String contactId;

    public Builder setContactId(String contactId) {
      this.contactId = contactId;
      return this;
    }

    public GetChannelProfileByContactRequestParametersImpl build() {
      return new GetChannelProfileByContactRequestParametersImpl(appId, channel, contactId);
    }
  }
}
