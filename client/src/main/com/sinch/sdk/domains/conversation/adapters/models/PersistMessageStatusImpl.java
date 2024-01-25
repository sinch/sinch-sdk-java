package com.sinch.sdk.domains.conversation.adapters.models;

import com.sinch.sdk.domains.conversation.models.PersistMessageStatus;

public class PersistMessageStatusImpl implements PersistMessageStatus {

  private final Boolean enabled;

  private PersistMessageStatusImpl(Boolean enabled) {
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
    return "PersistMessageStatus{" + "enabled='" + enabled + '\'' + '}';
  }

  public static class Builder implements PersistMessageStatus.Builder {

    Boolean enabled;

    public Builder setEnabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    public PersistMessageStatusImpl build() {
      return new PersistMessageStatusImpl(enabled);
    }
  }
}
