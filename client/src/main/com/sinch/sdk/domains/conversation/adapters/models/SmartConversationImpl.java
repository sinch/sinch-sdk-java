package com.sinch.sdk.domains.conversation.adapters.models;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.SmartConversation;

public class SmartConversationImpl implements SmartConversation {

  private final OptionalValue<Boolean> enabled;

  private SmartConversationImpl(OptionalValue<Boolean> enabled) {
    this.enabled = enabled;
  }

  public Boolean getEnabled() {
    return enabled.orElse(null);
  }

  public OptionalValue<Boolean> enabled() {
    return enabled;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SmartConversation{" + "enabled='" + enabled + '\'' + '}';
  }

  public static class Builder implements SmartConversation.Builder {

    OptionalValue<Boolean> enabled = OptionalValue.empty();

    public Builder setEnabled(Boolean enabled) {
      this.enabled = OptionalValue.of(enabled);
      return this;
    }

    public SmartConversationImpl build() {
      return new SmartConversationImpl(enabled);
    }
  }
}
