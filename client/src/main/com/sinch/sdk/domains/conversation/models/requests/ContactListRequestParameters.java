package com.sinch.sdk.domains.conversation.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.BuildersDelegation;
import com.sinch.sdk.domains.conversation.models.ChannelType;

/**
 * Parameters request to list contacts
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Contact/#tag/Contact/operation/Contact_ListContacts">https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Contact/#tag/Contact/operation/Contact_ListContacts</a>
 * @since 1.0
 */
public interface ContactListRequestParameters {

  /**
   * Contact identifier in an external system. If used, {@link #getChannel() channel} and {@link
   * #getIdentity() identity} query parameters can't be used.
   *
   * @return Contact identifier
   * @since 1.0
   */
  OptionalValue<String> getExternalId();

  /**
   * Specifies a channel, and must be set to one of the enum values.
   *
   * <p>If set, the identity parameter must be set and external_id can't be used.
   *
   * <p>Used in conjunction with identity to uniquely identify the specified channel identity.
   *
   * @return channel type
   * @since 1.0
   */
  OptionalValue<ChannelType> getChannel();

  /**
   * If set, the {@link #getChannel() channel} parameter must be set and {@link #getExternalId()
   * externalId} can't be used. Used in conjunction with {@link #getChannel() channel} to uniquely
   * identify the specified channel identity. This will differ from channel to channel.
   *
   * <p>For example, a phone number for SMS, WhatsApp, and Viber Business.
   *
   * @return Identity
   * @since 1.0
   */
  OptionalValue<String> getIdentity();

  /**
   * The maximum number of contacts to fetch by page
   *
   * <p>The default is 10 and the maximum is 20.
   *
   * @return Page size
   * @since 1.0
   */
  OptionalValue<Integer> getPageSize();

  /**
   * Next page token previously returned if any.
   *
   * @return Page token
   * @since 1.0
   */
  OptionalValue<String> getPageToken();

  /**
   * Getting builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return builder(null);
  }

  /**
   * Getting builder
   *
   * @param parameters When reading multiple page, to be used for pagination
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder(ContactListRequestParameters parameters) {
    return BuildersDelegation.ContactListRequestParametersBuilder(parameters);
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  interface Builder {

    /**
     * Contact identifier in an external system. If used, {@link #setChannel(ChannelType) channe}
     * and {@link #setIdentity(String) identity} query parameters can't be used.
     *
     * @param externalId Contact identifier
     * @return Current builder
     * @since 1.0
     */
    Builder setExternalId(String externalId);

    /**
     * see getter
     *
     * @param channel see getter
     * @return Current builder
     * @see #getChannel()
     * @since 1.0
     */
    Builder setChannel(ChannelType channel);

    /**
     * see getter
     *
     * @param identity see getter
     * @return Current builder
     * @see #getIdentity()
     * @since 1.0
     */
    Builder setIdentity(String identity);

    /**
     * see getter
     *
     * @param pageSize see getter
     * @return Current builder
     * @see #getPageSize()
     * @since 1.0
     */
    Builder setPageSize(Integer pageSize);

    /**
     * see getter
     *
     * @param pageToken see getter
     * @return Current builder
     * @see #getPageToken()
     * @since 1.0
     */
    Builder setPageToken(String pageToken);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    ContactListRequestParameters build();
  }
}
