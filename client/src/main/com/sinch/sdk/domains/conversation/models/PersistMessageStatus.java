package com.sinch.sdk.domains.conversation.models;

public interface PersistMessageStatus {

  Boolean getEnabled();

  static Builder builder() {
    return BuildersDelegation.PersistMessageStatusBuilder();
  }

  interface Builder {

    Builder setEnabled(Boolean enabled);

    PersistMessageStatus build();
  }
}
