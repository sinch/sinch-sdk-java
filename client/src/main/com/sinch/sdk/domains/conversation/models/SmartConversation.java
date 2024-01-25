package com.sinch.sdk.domains.conversation.models;

import com.sinch.sdk.domains.conversation.adapters.AppBuilders;

public interface SmartConversation {

  Boolean getEnabled();

  static Builder builder() {
    return AppBuilders.SmartConversationBuilder();
  }

  interface Builder {

    Builder setEnabled(Boolean enabled);

    SmartConversation build();
  }
}
