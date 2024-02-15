package com.sinch.sdk.domains.conversation.models.requests;

import com.sinch.sdk.domains.conversation.models.BuildersDelegation;

/** Parameters to get channel profile by the contact ID */
public interface GetChannelProfileByContactRequestParameters
    extends BaseGetChannelProfileRequestParameters {

  /**
   * The ID of the contact
   *
   * @return contact ID value
   * @since 1.0
   */
  String getContactId();

  /**
   * Getting builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return BuildersDelegation.ContactGetChannelProfileByContactRequestParametersBuilder();
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  interface Builder extends BaseGetChannelProfileRequestParameters.Builder<Builder> {

    /**
     * see getter
     *
     * @param contactId see getter
     * @return Current builder
     * @see GetChannelProfileByContactRequestParameters#getContactId()
     * @since 1.0
     */
    Builder setContactId(String contactId);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    GetChannelProfileByContactRequestParameters build();
  }
}
