package com.sinch.sdk.domains.conversation.models;

import com.sinch.sdk.domains.conversation.adapters.AppBuilders;

/**
 * This object is required for apps that subscribe to Smart Conversations features.
 *
 * <p><b>Note</b> that this functionality is available for open beta testing
 */
public interface SmartConversation {

  /**
   * Set to true to allow messages processed by this app to be analyzed by Smart Conversations.
   *
   * @return enabled value
   * @since 1.0
   */
  Boolean getEnabled();

  /**
   * Getting builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return AppBuilders.SmartConversationBuilder();
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  interface Builder {

    /**
     * see getter
     *
     * @param enabled see getter
     * @return Current builder
     * @see SmartConversation#getEnabled()
     * @since 1.0
     */
    Builder setEnabled(Boolean enabled);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    SmartConversation build();
  }
}
