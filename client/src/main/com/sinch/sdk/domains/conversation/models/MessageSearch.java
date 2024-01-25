package com.sinch.sdk.domains.conversation.models;

public interface MessageSearch {

  public Boolean getEnabled();

  public static Builder builder() {
    return BuildersDelegation.MessageSearchBuilder();
  }
  ;

  public interface Builder {

    public Builder setEnabled(Boolean enabled);

    public MessageSearch build();
  }
}
