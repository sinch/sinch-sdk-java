package com.sinch.sdk.domains.conversation.models.requests;

import com.sinch.sdk.domains.conversation.models.BaseContact;
import com.sinch.sdk.domains.conversation.models.BuildersDelegation;

public interface ContactUpdateRequestParameters extends BaseContact {

  static Builder builder() {
    return BuildersDelegation.ContactUpdateBuilder();
  }

  interface Builder extends BaseContact.Builder<Builder> {

    ContactUpdateRequestParameters build();
  }
}
