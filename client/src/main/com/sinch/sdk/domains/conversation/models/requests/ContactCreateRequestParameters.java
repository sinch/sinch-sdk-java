package com.sinch.sdk.domains.conversation.models.requests;

import com.sinch.sdk.domains.conversation.models.BaseContact;
import com.sinch.sdk.domains.conversation.models.BuildersDelegation;

/**
 * Parameters for Contact creation
 *
 * @since 1.0
 */
public interface ContactCreateRequestParameters extends BaseContact {

  /**
   * Getting builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return BuildersDelegation.ContactCreateBuilder();
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  interface Builder extends BaseContact.Builder<Builder> {

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    ContactCreateRequestParameters build();
  }
}
