package com.sinch.sdk.domains.conversation.adapters;

import com.sinch.sdk.domains.conversation.adapters.models.ChannelIdentityImpl;
import com.sinch.sdk.domains.conversation.adapters.models.ChannelIdentityRecipientImpl;
import com.sinch.sdk.domains.conversation.adapters.models.ContactImpl;
import com.sinch.sdk.domains.conversation.adapters.models.requests.ContactCreateRequestParametersImpl;
import com.sinch.sdk.domains.conversation.adapters.models.requests.ContactListRequestParametersImpl;
import com.sinch.sdk.domains.conversation.adapters.models.requests.ContactUpdateRequestParametersImpl;
import com.sinch.sdk.domains.conversation.adapters.models.requests.GetChannelProfileByChannelRequestParametersImpl;
import com.sinch.sdk.domains.conversation.adapters.models.requests.GetChannelProfileByContactRequestParametersImpl;
import com.sinch.sdk.domains.conversation.models.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.ChannelIdentityRecipient;
import com.sinch.sdk.domains.conversation.models.Contact;
import com.sinch.sdk.domains.conversation.models.requests.ContactCreateRequestParameters;
import com.sinch.sdk.domains.conversation.models.requests.ContactListRequestParameters;
import com.sinch.sdk.domains.conversation.models.requests.ContactUpdateRequestParameters;
import com.sinch.sdk.domains.conversation.models.requests.GetChannelProfileByChannelRequestParameters;
import com.sinch.sdk.domains.conversation.models.requests.GetChannelProfileByContactRequestParameters;

public class ContactBuilders {

  public static ContactListRequestParameters.Builder ContactListRequestParametersBuilder(
      ContactListRequestParameters parameters) {
    return ContactListRequestParametersImpl.builder(parameters);
  }

  public static Contact.Builder ContactBuilder() {
    return ContactImpl.builder();
  }

  public static ContactCreateRequestParameters.Builder ContactCreateBuilder() {
    return ContactCreateRequestParametersImpl.builder();
  }

  public static ChannelIdentity.Builder<?, ?> ChannelIdentityBuilder() {
    return ChannelIdentityImpl.builder();
  }

  public static ChannelIdentityRecipient.Builder<?> ChannelIdentityRecipientBuilder() {
    return ChannelIdentityRecipientImpl.builder();
  }

  public static ContactUpdateRequestParameters.Builder ContactUpdateBuilder() {
    return ContactUpdateRequestParametersImpl.builder();
  }

  public static GetChannelProfileByContactRequestParameters.Builder
      ContactGetChannelProfileByContactRequestParametersBuilder() {
    return GetChannelProfileByContactRequestParametersImpl.builder();
  }

  public static GetChannelProfileByChannelRequestParameters.Builder
      ContactGetChannelProfileByChannelRequestParametersBuilder() {
    return GetChannelProfileByChannelRequestParametersImpl.builder();
  }
}
