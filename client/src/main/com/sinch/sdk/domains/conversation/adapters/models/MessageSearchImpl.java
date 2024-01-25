package com.sinch.sdk.domains.conversation.adapters.models;

import com.sinch.sdk.domains.conversation.models.MessageSearch;

public class MessageSearchImpl implements MessageSearch {

  private final Boolean enabled;

  private MessageSearchImpl(Boolean enabled) {
    this.enabled = enabled;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "MessageSearch{" + "enabled='" + enabled + '\'' + '}';
  }

  public static class Builder implements MessageSearch.Builder {

    Boolean enabled;

    public Builder setEnabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    public MessageSearchImpl build() {
      return new MessageSearchImpl(enabled);
    }
  }
}
