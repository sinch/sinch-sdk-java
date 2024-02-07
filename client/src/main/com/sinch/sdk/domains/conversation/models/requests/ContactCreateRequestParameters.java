package com.sinch.sdk.domains.conversation.models.requests;

import com.sinch.sdk.domains.conversation.models.BaseContact;
import com.sinch.sdk.domains.conversation.models.BuildersDelegation;

public interface ContactCreateRequestParameters extends BaseContact {

  static Builder builder() {
    return BuildersDelegation.ContactCreateBuilder();
  }

  interface Builder extends BaseContact.Builder<Builder> {

    ContactCreateRequestParameters build();
  }
}
