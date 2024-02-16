package com.sinch.sdk.domains.conversation.models;

public interface Contact extends BaseContact {

  String getId();

  static Builder builder() {
    return BuildersDelegation.ContactBuilder();
  }

  interface Builder extends BaseContact.Builder<Builder> {

    Builder setId(String id);

    Contact build();
  }
}
