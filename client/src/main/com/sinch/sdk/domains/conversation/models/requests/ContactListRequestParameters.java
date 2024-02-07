package com.sinch.sdk.domains.conversation.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.BuildersDelegation;
import com.sinch.sdk.domains.conversation.models.ChannelType;

/**
 * Parameters request to list contacts
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Contact/#tag/Contact/operation/Contact_ListContacts">https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Contact/#tag/Contact/operation/Contact_ListContacts/</a>
 * @since 1.0
 */
public interface ContactListRequestParameters {

  OptionalValue<String> getExternalId();

  OptionalValue<ChannelType> getChannel();

  OptionalValue<String> getIdentity();

  OptionalValue<Integer> getPageSize();

  OptionalValue<String> getPageToken();

  static Builder builder() {
    return builder(null);
  }

  static Builder builder(ContactListRequestParameters parameters) {
    return BuildersDelegation.ContactListRequestParametersBuilder(parameters);
  }

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
     * Specifies a channel, and must be set to one of the enum values. If set, the {@link
     * #setIdentity(String) identity} parameter must be set and {@link #setExternalId(String)
     * externalId} can't be used. Used in conjunction with {@link #setIdentity(String) identity} to
     * uniquely identify the specified channel identity.
     *
     * @param channel Channel value
     * @return Current builder
     * @since 1.0
     */
    Builder setChannel(ChannelType channel);

    /**
     * If set, the {@link #setChannel(ChannelType) channe} parameter must be set and {@link
     * #setExternalId(String) externalId} can't be used. Used in conjunction with {@link
     * #setChannel(ChannelType) channe} to uniquely identify the specified channel identity. This
     * will differ from channel to channel.
     *
     * <p>For example, a phone number for SMS, WhatsApp, and Viber Business.
     *
     * @param identity Identity value
     * @return Current builder
     * @since 1.0
     */
    Builder setIdentity(String identity);

    /**
     * The maximum number of contacts to fetch. The default is 10 and the maximum is 20.
     *
     * @param pageSize The maximum number of items to return.
     * @return Current builder
     * @since 1.0
     */
    Builder setPageSize(Integer pageSize);

    /**
     * Next page token previously returned if any
     *
     * @param pageToken The requested page token value
     * @return Current builder
     * @since 1.0
     */
    Builder setPageToken(String pageToken);

    ContactListRequestParameters build();
  }
}
